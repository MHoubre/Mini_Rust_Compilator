package Parsers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Struct;
import java.util.*;

import TDSPackage.*;
import org.antlr.runtime.tree.Tree;

public class AssemblyParser {

	private ArrayList<TDS> tdsList = new ArrayList<TDS>();
	private Stack<TDS> pileRegionOuvertes = new Stack<TDS>();
	private int currentTdsId;
	private String assemblyCode;
	public static int CURRENTJMPID= 0;
	private boolean isMainAttainedFirstTime;
	private Function fnToDeclare = null;
	private boolean newDeclaredVar;
	private boolean address; // Utilisé pour savoir si on a besoin de l'addresse donnée par SP, et pas du mot pointé par l'addresse

	public AssemblyParser(ArrayList<TDS> tdsList){
		this.tdsList= tdsList;
		this.assemblyCode = "";
		this.isMainAttainedFirstTime= false;
		this.newDeclaredVar= false;
		this.address = false;
	}

	public void getAssemblyCode(Tree currentTree, int registry_number){
		Tree bloc;
		TDS courante;
		Symbol s;
		switch(currentTree.getText()){
			case "ROOT":
				this.currentTdsId= 0;
				this.pileRegionOuvertes.push(this.tdsList.get(this.currentTdsId));
				this.currentTdsId++;
				this.assemblyCode+= "SP EQU R15 			// alias pour R15, pointeur de pile\n"
						+"WR EQU R14 			// Work Register (registre de travail)\n"
						+"BP EQU R13 			// frame Base Pointer (pointage environnement)\n"
						+"EXIT_EXC   EQU   64    // n� d'exception de EXIT\n"
						+"READ_EXC   EQU   65    // n� d'exception de READ  (lit 1 ligne)\n"
						+"WRITE_EXC  EQU   66    // n� d'exception de WRITE (affiche texte)\n"
						+"NUL         equ  0     // caract�re NUL qui doit terminer une cha�ne de caract�res\n"
						+"NULL        equ  0     // pointeur nul\n"
						+"NIL         equ  0     // fin de liste cha�n�e\n"

						+"STACK_ADRS  equ 0x1000 // adresse de base de pile\n"
						+"LOAD_ADRS   equ 0xE000 // adresse de chargement du programme\n"

						+           "ORG LOAD_ADRS\n"
						+           "START main_\n";

				this.assemblyCode += PredefinedAssemblyCode.CODE_PREDEFINI;
				this.assemblyCode += PredefinedAssemblyCode.RECURSIVE_IDF_FIND;
				AssemblyParser.CURRENTJMPID+=2; // cf on a ajoute 2 jmp dans le code assembleur a cause des 2 jmp dans la routine RECURSIVE_IDF_FIND

				for(int i= 0; i<currentTree.getChildCount(); i++){
					this.getAssemblyCode(currentTree.getChild(i), -1);
				}

				this.genererFichier(this.assemblyCode, "code.src");
				break;

			case "FUN":
				//this.jmpToEndOfFunction= AssemblyParser.CURRENTJMPID;
				//AssemblyParser.CURRENTJMPID++;

				String name = currentTree.getChild(0).getText();

				this.assemblyCode += "\n//--<Debut de la fonction : \"" + name + "\">--\n";

				this.assemblyCode += name + "_ "; // pas de \n ici pour qu'on puisse écrire la prochaine instruction sur la même ligne


				// On récupère le symbole de la fonction dans la TDS
				courante = this.pileRegionOuvertes.peek();
				this.fnToDeclare = (Function)courante.containsSymbol(name);  // On stock la fonction à déclarer pour pouvoir générer le code de
				// déplacement des paramètres dans le corps de la fonction (Cf le code de bloc)
				if(name.equals("main")) {
					this.isMainAttainedFirstTime= true;
					this.assemblyCode += "LDW SP, #STACK_ADRS // pile sera au dessus de STACK_ADRS\n" +
							"LDW BP, #NIL        // BP initial (fin de liste chaînée d'environnements)\n"
							+"LDW R12, #0\n";
					this.fnToDeclare = null; // Dans le cas du main, pas besoin de récupérer les paramètres etc..
				}

				Tree nextChild = currentTree.getChild(2);
				bloc = null;

				if(!nextChild.getText().equals("BLOC")) {
					bloc = currentTree.getChild(3);
				} else {
					bloc = nextChild;
				}

				// Récursivité sur le bloc
				this.getAssemblyCode(bloc, 0);


				//this.assemblyCode+="jmp"+this.jmpToEndOfFunction+" NOP //return atteint, on va a la fin du bloc fonction\n";
				if(name.equals("main")) {
					this.assemblyCode += "trp #EXIT_EXC     // lance trappe EXIT\n" +
							"	jea @main_        // revient au début du main \n" +
							"					  // si on relance la simulation après EXIT\n";
				} else {
					this.assemblyCode += "RTS\n";
				}

				this.assemblyCode += "//--<Fin de la fonction : \"" + name + "\">--\n";
				break;

			case "BLOC":
				int jmpToEndOfBloc= AssemblyParser.CURRENTJMPID;
				AssemblyParser.CURRENTJMPID++;

				this.pileRegionOuvertes.push(this.tdsList.get(this.currentTdsId));
				this.currentTdsId++;

				boolean registerStack= true;
				// Comme le main est la procedure de depart, ca ne sert a rien d'empiler les 11 registres dans la pile
				if(!this.isMainAttainedFirstTime){
					this.assemblyCode += PredefinedAssemblyCode.BEGIN_FN;
				}else{
					this.isMainAttainedFirstTime= false;
					registerStack= false;
				}

				// Dans le cas où on déclare une fonction, on va faire la zone de chargement et de recopiage des paramètres dans la pile du bloc courant.
				if(this.fnToDeclare != null) {
					ArrayList<Var> params = this.fnToDeclare.getParameters();
					int nbparam = params.size();

					// On calcul la taille totale nécessaire
					int tailleTotale = this.fnToDeclare.getSize();

					if(nbparam != 0) {
						this.assemblyCode += "ADQ -"+ tailleTotale + ", SP\n"; // On réserve l'espace en pile.
						int dep = 26; // 28 car RTS(2) + 11_REGISTRES(24) + BASEPILE(2)

						for(int i = (nbparam-1); i >=0 ; i--) {

							int depl = (-params.get(i).getStackValue() * 2) - 2;

							// Si le paramètre empilé est un booléan ou un INT (on a besoin que de 2 octets pour les stocker
							// TODO : Pour els strucs ou les tableaux par exemple la taille sera plus conséquente et il faut faire autrement. (stock chaque champs de la struct, etc...
							if (params.get(i).getType().equals(SemanticParser.TYPE_I32) || params.get(i).getType().equals(SemanticParser.TYPE_BOOL)
									|| params.get(i).getType().equals(SemanticParser.TYPE_ADDR)) {
								this.assemblyCode += "LDW R1, (BP)" + dep + "\n"; // On stock param dans R1
								this.assemblyCode += "STW R1, (BP)" + depl + "\n";        // On stock le param dans l'adresse où il doit être dans le programme.
								dep += 2;
							} else {
								int fun_elt_size = params.get(i).getSize();
								for (int a = 0; a < fun_elt_size / 2; a++) {
									this.assemblyCode += "LDW R1, (BP)" + dep + "\n";
									this.assemblyCode += "STW R1, (BP)" + (depl - a * 2) + "\n";
									dep += 2;
								}
							}
						}
					}
					this.fnToDeclare= null; // cf si il y a des ss blocs dans la fonction, on ne va pas re-recopier les arguments en debut de pile
				}

				String returnValue= SemanticParser.TYPE_NULL, temp;
				for(int i = 0; i < currentTree.getChildCount() ; i++) {
					int returnNumber= registry_number;
					/**
					 *  IMPORTANT
					 *
					 *  //TODO PENSER A GERER ICI RETOUR BLOC ET RETOUR DE BLOC IMPLICITE
					 *
					 *
					 *
					 *
					 */
					if(currentTree.getChild(i).getText().equals("RETURN") || currentTree.getChild(i).getText().equals("RETOUR_BLOC"))
						returnNumber= 0;
					this.getAssemblyCode(currentTree.getChild(i), returnNumber);
					// La valeur du return est stockee dans R0, on va a la fin de la fonction
					if(currentTree.getChild(i).getText().equals("BLOC") || currentTree.getChild(i).getText().equals("IF")
							|| currentTree.getChild(i).getText().equals("ELSE") || currentTree.getChild(i).getText().equals("WHILE")){
						this.assemblyCode+="LDW R7, #1\n"
								+"CMP R7, R12 \n";
						this.assemblyCode+="JEQ #jmp"+jmpToEndOfBloc+"-$-2 // JMP vers fin du bloc \n";
					}
				}


				this.pileRegionOuvertes.pop();
				this.fnToDeclare = null;

				this.assemblyCode+="jmp"+jmpToEndOfBloc+" NOP //return atteint, on va a la fin du bloc\n";
				if(registerStack)
					this.assemblyCode += PredefinedAssemblyCode.END_FN;

				break;

			case "AFF":
				this.assemblyCode += "//--<Start of an affectation process>--\n";
				boolean ptr_access = false;
				int targetRegister= 2;
				int cpt_ptr_access = 0;
				for(int i= currentTree.getChildCount()-1; i>=0; i--){
					String current= currentTree.getChild(i).getText();
					switch(current){
						case "L_VALUE":
							ptr_access = currentTree.getChild(i).getChild(0).getText().equals("PTR_CONTENT_ACCESS");
							//Si accès pointeur
							if (ptr_access) {
								this.newDeclaredVar = false;
								if (currentTree.getChild(i).getChild(0).getChild(0).getText().equals("ACCESS")){
									this.getAssemblyCode(currentTree.getChild(i).getChild(0), 1);
								}
								else {
									Tree tree_ptr_access = currentTree.getChild(i).getChild(0);
									while (tree_ptr_access.getChildCount() > 0) {
										cpt_ptr_access += 1;
										tree_ptr_access = tree_ptr_access.getChild(0);
									}
									this.getAssemblyCode(tree_ptr_access, 1);
								}
							}
							else{
								this.getAssemblyCode(currentTree.getChild(i), 1);
							}
							// Ajout
							this.assemblyCode += "LDW " + this.getRegistryStringFromId(targetRegister) + ", (SP)\n";
							this.assemblyCode += "ADQ 2, SP\n";
							if(this.newDeclaredVar){
								this.assemblyCode+= "// VARIABLE DECLAREE POUR LA PREMIERE FOIS\n"
										+"ADQ -2, SP\n";
								this.newDeclaredVar= false;
							}
							break;
						case "R_VALUE":
							targetRegister= 2;
							if(currentTree.getChild(i).getChild(0).getText().equals("BLOC"))
								targetRegister = 0;
                            	/*if(currentTree.getChild(i).getChildCount()==1){
                            		if(currentTree.getChild(i).getChild(0).getText()=="BLOC"){
                            			targetRegister= 0;
                            		}
                            	}*/
							this.getAssemblyCode(currentTree.getChild(i), targetRegister);
							this.address = false;
							this.assemblyCode+="STW "+this.getRegistryStringFromId(targetRegister)+", -(SP)\n";
							break;
					}
				}
				if (ptr_access){
					for (int i = 0; i<cpt_ptr_access; i++) {
						this.assemblyCode += "LDW R3,(R3)\n";
					}
				}
				this.assemblyCode+="STW "+this.getRegistryStringFromId(targetRegister) + ", (R3)\n";
				this.assemblyCode += "//--<End of an affectation process>-- \n";
				break;

			case "L_VALUE":
				this.getAssemblyCode(currentTree.getChild(0), registry_number);
				break;

			case "R_VALUE":
				this.getAssemblyCode(currentTree.getChild(0), registry_number);
				break;
			case ">=":
			case "==":
			case "<=":
			case ">":
			case "<":
			case "!=":
			case "&&":
			case "||":
				this.assemblyCode+="//DEBUT < ------------------------------------------------------\n";
				this.getAssemblyCode(currentTree.getChild(0), 1);
				this.assemblyCode+="STW R1, -(SP)\n";
				this.getAssemblyCode(currentTree.getChild(1), 2);
				this.assemblyCode+="LDW R1, (SP)\n"
						+"ADQ 2, SP\n";
				switch(currentTree.getText()){
					case "&&":
						this.assemblyCode+="//DEBUT &&\n";
						this.assemblyCode+="AND R1, R2, R1 // On compare R1-R2 avec 0\n"
								+"LDW R2, #0\n";
						break;
					case "||":
						this.assemblyCode+="//DEBUT ||\n";
						this.assemblyCode+="OR R1, R2, R1 // On compare R1-R2 avec 0\n"
								+"LDW R2, #0\n";
						break;
				}
				this.assemblyCode+="CMP R1, R2 // On compare R1-R2 avec 0\n";
				String selectedJmp= "";
				switch(currentTree.getText()){
					case ">=":
						selectedJmp= "JGE";
						break;
					case "==":
						selectedJmp= "JEQ";
						break;
					case "<=":
						selectedJmp= "JLE";
						break;
					case ">":
						selectedJmp= "JGT";
						break;
					case "<":
						selectedJmp= "JLW";
						break;
					case "!=":
						selectedJmp= "JNE";
						break;
					default:
						selectedJmp= "JGT";
				}
				this.assemblyCode+=selectedJmp+" #jmp"+AssemblyParser.CURRENTJMPID+"-$-2 // Si ==0, alors on va sur JMP 1\n"
						+"LDW "+this.getRegistryStringFromId(registry_number)+", #0 // Sinon, on stocke 0 dans le registre\n"
						+"JMP #jmp"+(AssemblyParser.CURRENTJMPID+1)+"-$-2 // et on va sur JMP 2\n"
						+"jmp"+AssemblyParser.CURRENTJMPID+" NOP // JMP 1\n"
						+"LDW "+this.getRegistryStringFromId(registry_number)+", #1 // cas ==0, on stocke 1 dans le registre\n"
						+"jmp"+(AssemblyParser.CURRENTJMPID+1)+" NOP // JMP 2\n";
				AssemblyParser.CURRENTJMPID+=2;
				this.assemblyCode+="//FIN < ------------------------------------------------------\n";
				break;
			case "+":
			case "-":
			case "*":
			case "/":
				this.getAssemblyCode(currentTree.getChild(0), 1);
				this.assemblyCode+="STW R1, -(SP)\n";
				this.getAssemblyCode(currentTree.getChild(1), 2);
				this.assemblyCode+="LDW R1, (SP)\n"
						+"ADQ 2, SP\n";
				String selectedOperation= "";
				switch(currentTree.getText()){
					case "+":
						selectedOperation= "ADD";
						break;
					case "-":
						selectedOperation= "SUB";
						break;
					case "*":
						selectedOperation= "MUL";
						break;
					case "/":
						selectedOperation= "DIV";
						break;
				}
				this.assemblyCode+=selectedOperation+" R1, R2, "+this.getRegistryStringFromId(registry_number)+"\n";
				break;
			case "OPPOSE_BOOL":

				break;
			case "IF":
				// On charge le resultat du if dans R1
				this.getAssemblyCode(currentTree.getChild(0), 1); // Child0= "IF_EXPR", Child1= "BLOCK", Child2= "ELSE" (si present)
				this.assemblyCode+="LDW R2, #0 \n"
						+"CMP R1, R2\n"
						+"JEQ #jmp"+AssemblyParser.CURRENTJMPID+"-$-2 // Si resultat du IF ==0, alors on JMP\n";
				int savedJMPValue1= AssemblyParser.CURRENTJMPID;
				int savedJMPValue2= AssemblyParser.CURRENTJMPID+1;
				AssemblyParser.CURRENTJMPID+=2;
				this.assemblyCode+="//DEBUT DU BLOC DU IF\n";
				this.getAssemblyCode(currentTree.getChild(1), 1);

				this.assemblyCode+="JMP #jmp"+savedJMPValue2+"-$-2 // Si on est entre dans le IF, il ne faut pas aller dans le else\n";

				this.assemblyCode+="jmp"+savedJMPValue1+" NOP\n";

				if(currentTree.getChildCount()==3){
					this.getAssemblyCode(currentTree.getChild(2),1);
				}
				this.assemblyCode+="jmp"+savedJMPValue2+" NOP\n";
				break;
			case "ELSE":
				this.getAssemblyCode(currentTree.getChild(0),1);
				break;
			case "WHILE":
				this.assemblyCode+="//DEBUT WHILE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
				this.assemblyCode+="//ON ENTRE DANS LE WHILE\n";
				int jmpWhileLoop= AssemblyParser.CURRENTJMPID;
				int jmpWhileExit= AssemblyParser.CURRENTJMPID+1;
				AssemblyParser.CURRENTJMPID+=2;
				this.assemblyCode+="jmp"+jmpWhileLoop+" NOP\n";
				this.getAssemblyCode(currentTree.getChild(0), 1);
				this.assemblyCode+="LDW R2, #1 \n"
						+"CMP R1, R2\n"
						+"JNE #jmp"+jmpWhileExit+"-$-2 // Si resultat de WHILE !=1, alors on JMP\n";
				this.assemblyCode+="//DEBUT BLOC ............................................................\n";
				this.getAssemblyCode(currentTree.getChild(1), 2);
				this.assemblyCode+="//FIN BLOC ............................................................\n";
				this.assemblyCode+="JMP #jmp"+jmpWhileLoop+"-$-2 \n";
				this.assemblyCode+="jmp"+jmpWhileExit+" NOP\n";
				this.assemblyCode+="//FIN WHILE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
				break;
			case "RETOUR_BLOC":
				this.assemblyCode+="// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: RETOUR BLOC DEBUT \n";
				this.getAssemblyCode(currentTree.getChild(0), registry_number);
				//oqzdjoqzjd this.assemblyCode+="LDW R12, #1 \n";
				this.assemblyCode+="// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: RETOUR BLOC FIN \n";
				break;
			case "PRINT":
				//
				this.assemblyCode+= "//	print !();\n"
						+"// ON VEUT PRINT ICI DONC ON DOIT CREER UN TABLEAU DE CHAR POUR STOCKER LE INT DANS UN CHAR GRACE A CONVERSION\n"
						+"// On reserve 12 cases en pile pour faire large adresse\n"
						+"ADQ -12, SP\n"
						+"ldw r0, #10       // charge 10 (pour base decimale) dans r0\n"
						+"stw r0, -(SP)     // empile contenu de r0 (parametre b)\n"
						+"adi SP, r0, #2	// mettre debut de tableau char dans R0\n"
						+"STW r0, -(SP)     // empile contenu de r0 (parametre p)\n";

				this.getAssemblyCode(currentTree.getChild(0),1);

				this.assemblyCode+= "stw r1, -(SP)     // empile contenu de r1 (parametre i)\n"
						+"jsr @itoa_        // appelle fonction itoa d'adresse itoa_\n"
						+"ADQ 6, SP    // nettoie la pile des parametres\n"
						+" // de taille totale 6 octets (3*2)\n"
						+"// On empile le parametre p de print qui est le tableau qu'on vient de creer\n"
						+"LDW R0,	SP	// mettre debut de tableau char dans R0\n"
						+"STW R0, -(SP)     // empile contenu de r0 (parametre p)\n"

						+"jsr @print_       // appelle fonction print d'adresse print_\n"

						+"ADQ 2, SP    // nettoie la pile des parametres\n"
						+"				  // de taille totale 2 octets\n"

						+"// On nettoie la pile du tableau de char qu'on vient de creer de 12 cases\n"
						+"ADQ 12, SP\n";
				break;
			case "STRUCT":
				// normalement rien à faire
				this.assemblyCode += "\n//--La structure \"" + currentTree.getChild(0).getText() + "\" est chargée dans la TDS\n";
				break;
			case "ACCESS":
				Tree bracket_access = currentTree.getChild(1);
				String code ="";
				switch(bracket_access.getText()){
					case "LENGTH_ACCESS":
						String idf= bracket_access.getParent().getChild(0).getText();
						TDS current_tds= this.pileRegionOuvertes.peek();

						Symbol symbol=current_tds.containsSymbol(idf);
						if(symbol instanceof Vec){
							this.assemblyCode+= "LDW " + getRegistryStringFromId(registry_number) + " ,#"+((Vec) symbol).getComponents().size()+"\n";
						}

						break;

					case "POINT_ACCESS":
						Tree cureentTreePA = currentTree;
					    String structName = currentTree.getChild(0).getText();
					    cureentTreePA = currentTree.getChild(1);
                        Deque<String> fields = new ArrayDeque<>();

					    while (cureentTreePA.getChildCount() == 2){
					        fields.add(cureentTreePA.getChild(0).getText());
					        cureentTreePA = cureentTreePA.getChild(1);
                        }
                        fields.add(cureentTreePA.getChild(0).getText());

                        TDS currentTdsPointAccess;
						Symbol symPointAccess=null;
						for(int i = this.pileRegionOuvertes.size()-1 ; i>=0 ; i--){
							currentTdsPointAccess = this.pileRegionOuvertes.get(i);
							symPointAccess=currentTdsPointAccess.containsSymbol(structName);
							if(symPointAccess!=null){
								this.getDisplacementFromStruct(structName, fields,registry_number);
								break;
							}
						}
						break;



					case "BRACKET_ACCESS":
						String VecName = currentTree.getChild(0).getText();
						int indice = Integer.parseInt(bracket_access.getChild(0).getText());
						TDS current;

						Symbol sym=null;
						for(int i = this.pileRegionOuvertes.size()-1 ; i>=0 ; i--){
							current = this.pileRegionOuvertes.get(i);

							s=current.containsSymbol(VecName);
							if(s!=null){
								if(!((Var)s).getDeclaredStatus()){
									this.newDeclaredVar=true;
									((Var) s).setIsDeclared();
								}
								this.getDisplacementFromIndice(VecName,registry_number,indice);
								break;
							}
						}

					default:
						break;

				}
				break;

			// DEBUT : STRUCTURES

			case "AFF_STRUCT":
				// Affectation de la structure
				if (this.assemblyCode.lastIndexOf("\n\n") != this.assemblyCode.length()-2){
					this.assemblyCode+="\n";
				}
				this.assemblyCode += "//--<Debut affectation d'une structure>--\n";
				int targetRegisterAS=2;
				String nomStructure = currentTree.getChild(0).getChild(0).getText();
				String typeStructure = currentTree.getChild(1).getChild(0).getText();
				this.assemblyCode += "//nom de la structure : \"" + nomStructure + "\"\n";
				this.assemblyCode += "//type de la structure : \"" + typeStructure +"\"\n";
				TDS currentAS;
				s= null;
				for(int j=this.pileRegionOuvertes.size()-1 ; j>=0; j--){
					currentAS= this.pileRegionOuvertes.get(j);
					// On regarde si la table des symboles au rang j dans la pile contient le symbole recherche
					s = currentAS.containsSymbol(nomStructure);
					if(s!=null){
						if(!((Var)s).getDeclaredStatus()){
							this.newDeclaredVar= true;
							this.assemblyCode+="//Première affectation\n";
							((Var)s).setIsDeclared();
						}
						break;
					}
				}
				for (int i = 2; i<currentTree.getChildCount(); i++){
					/* On récupère les données */
					Tree childAS = currentTree.getChild(i);
					/* Cas normal */
					if (childAS.getChild(2).getText().equals("FIN_AFF")) {
						this.newDeclaredVar = false;
                        String fieldName = childAS.getChild(0).getText(); // Nom du champ affecté
                        Tree fieldValue = childAS.getChild(1); // Arbre de la valeur : peut être une opération :/
                        this.assemblyCode += "//--affectation du champ :\"" + fieldName + "\"\n";
                        /* On travaille d'abord sur le membre droit */
                        this.getAssemblyCode(fieldValue, targetRegisterAS);
                        this.assemblyCode += "STW " + this.getRegistryStringFromId(targetRegisterAS) + ", -(SP)\n";
                        /* Ensuite le membre gauche */
                        /* Dans le cas où la structure à gauche est en réalité membre d'une autre structure */
                        if (nomStructure.equals("ACCESS")){
                        	String nom = currentTree.getChild(0).getChild(0).getChild(0).getText();
                        	Deque<String> field = new ArrayDeque<>();
							Tree fieldtree = currentTree.getChild(0).getChild(0).getChild(1);
							while (fieldtree.getChildCount()>1){
								field.add(fieldtree.getChild(0).getText());
								fieldtree = fieldtree.getChild(1);
							}
							field.add(fieldtree.getChild(0).getText());
                        	field.add(fieldName);
							this.getDisplacementFromStruct(nom,field,1);
						}
						/* Affectation par pointeur */
						else if (nomStructure.equals("PTR_CONTENT_ACCESS")){
							this.newDeclaredVar = false;
                        	String nomPtr = currentTree.getChild(0).getChild(0).getChild(0).getText();
							Deque<String> field = new ArrayDeque<>();
							field.add(fieldName);
                        	this.getDisplacementFromStructPtr(nomPtr, field, 1);
						}
						/* Dans le cas traditionnel */
						else{
							this.getDisplacementFromStruct(nomStructure, fieldName, 1);
						}
                        this.assemblyCode += "LDW " + this.getRegistryStringFromId(targetRegisterAS) + ", (SP)\n";
                        this.assemblyCode += "ADQ 2, SP\n";
                        if (this.newDeclaredVar) {
                            this.assemblyCode += "// VARIABLE DECLAREE POUR LA PREMIERE FOIS\n"
                                    + "ADQ -2, SP\n";
                        }
                        this.assemblyCode += "STW " + this.getRegistryStringFromId(targetRegisterAS) + ", (R3)\n";
                    }
                    /* Cas d'une structure dans une structure */
                    else {
                    	if (nomStructure.equals("ACCESS")){
							String nom = currentTree.getChild(0).getChild(0).getChild(0).getText();
							Deque<String> field = new ArrayDeque<>();
							Tree fieldtree = currentTree.getChild(0).getChild(0).getChild(1);
							while (fieldtree.getChildCount()>1){
								field.add(fieldtree.getChild(0).getText());
								fieldtree = fieldtree.getChild(1);
							}
							field.add(fieldtree.getChild(0).getText());
							String fieldName = childAS.getChild(0).getText();
							field.add(fieldName);
							this.recursiveStructAff(nom, field, targetRegisterAS, childAS);
						}
						else if (nomStructure.equals("PTR_CONTENT_ACCESS")){
                    		//TODO
							String nomPtr = currentTree.getChild(0).getChild(0).getChild(0).getText();
							Deque<String> fields = new ArrayDeque<>();
							String fieldName = childAS.getChild(0).getText(); // Nom du champ affecté
							fields.add(fieldName);
							this.recursiveStructAffPtr(nomPtr, fields, targetRegisterAS, childAS);
						}
						else {
							Deque<String> fields = new ArrayDeque<>();
							String fieldName = childAS.getChild(0).getText(); // Nom du champ affecté
							fields.add(fieldName);
							this.recursiveStructAff(nomStructure, fields, targetRegisterAS, childAS);
						}
                    }
				}
				if(this.newDeclaredVar){
					this.newDeclaredVar = false;
				}
				this.assemblyCode += "//--<Fin affectation d'une structure>--\n\n";
				break;

			// FIN : STRUCTURES

			case "VEC_DECL":
				String Vecname = null ;
				s=null;

				Tree parent = currentTree.getParent().getParent();

				if(parent.getChild(0).getText().equals("mut")){
					Vecname = parent.getChild(1).getChild(0).getText();
				}else{
					Vecname = parent.getChild(0).getChild(0).getText();
				}

				//this.assemblyCode += "//Nom du vecteur :\"" + Vecname + "\"\n";

				for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
					courante= this.pileRegionOuvertes.get(i);

					// on recherche le symbol de nom correspondant
					s = courante.containsSymbol(Vecname);
					if(s!=null){
						if(!((Var)s).getDeclaredStatus()){
							this.newDeclaredVar=true;
							//this.assemblyCode+= "//Première affect\n";
							((Var)s).setIsDeclared();
						}
						break;
					}
				}

				courante = this.pileRegionOuvertes.peek();

				Vec vec = (Vec)s;

				int tailleVec=((Vec) s).getSize();

				this.assemblyCode += "//Le Vecteur " + Vecname + " a ete ajoute \n";

				int affectRegister = 2;

				for(int i = 0 ; i< ((Vec) s).getComponents().size();i++){
					Tree son=currentTree.getChild(i);
					Var v= (Var) ((Vec) s).getComponent(i);
					this.assemblyCode += "//affectation composant d'identifiant " + v.getIdf() + "\n";
					this.getAssemblyCode(son.getChild(0), affectRegister);
					this.assemblyCode+="STW "+this.getRegistryStringFromId(affectRegister)+", -(SP)\n";

					this.getDisplacementFromIndice(Vecname, 1,i);

					this.assemblyCode += "LDW " + this.getRegistryStringFromId(affectRegister) + ", (SP)\n";
					this.assemblyCode += "ADQ 2, SP\n";
					if(this.newDeclaredVar){
						this.assemblyCode+= "// VARIABLE DECLAREE POUR LA PREMIERE FOIS\n"
								+"ADQ -2, SP\n";
					}
					this.assemblyCode+="STW "+this.getRegistryStringFromId(affectRegister) + ", (R3)\n";
				}
				if(this.newDeclaredVar){
					this.newDeclaredVar = false;
				}
				this.assemblyCode += "//--<Fin de declaration du vecteur>--\n\n";
				break;

			case "VEC_ELT":
				break;

			case "FUN_CALL":
				/*
				 * 1 - Récupérer le nom pour pouvoir faire le jsr @nom_
				 * 2 - Récupérer les paramètres et les empiler
				 * 3 - Garder la taille des paramètres pour pouvoir nettoyer la pile au retour.
				 */
				String funname = currentTree.getChild(0).getText();
				this.assemblyCode += "\n//--<Appel de la fonction : \"" + funname + "\">--\n";

				// On récupère le symbole de la fonction dans la TDS
				s= null;
				int nbStack= 0;
				for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
					courante= this.pileRegionOuvertes.get(i);
					// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
					s = courante.containsSymbol(funname);
					if(s!=null){
						break;
					}
				}
				courante = this.pileRegionOuvertes.peek();
				Function fn = (Function)s;  // On stock la fonction à déclarer pour pouvoir avoir la taille des paramètres.
				int tailleTotale = fn.getSize();
				//System.out.println("Taille de la fonction : " + tailleTotale);

				// On va parcourir nos argument et calculer leur valeur pour pouvoir les passer en paramètres de fonction.
				for(int i = 0; i < fn.getParameters().size(); i++) {
					int tailleArg = fn.getParameters().get(i).getSize();
					// Si ce sont des entiers à stocker en pile
					if(fn.getParameters().get(i).getType().equals(SemanticParser.TYPE_BOOL) || fn.getParameters().get(i).getType().equals(SemanticParser.TYPE_I32)
							|| fn.getParameters().get(i).getType().equals(SemanticParser.TYPE_ADDR)){
						this.assemblyCode += "//Parametre : \"" + fn.getParameters().get(i).getIdf()+ "\"\n";
						this.getAssemblyCode(currentTree.getChild(1+i), 0); // On stock le résultat dans R0
						this.assemblyCode += "STW R0, -(SP)\n\n"; // On stock en pile.
					}
					else{
						//Pour les structures et vecteurs
						/* Le principe : on a l'adresse du premier et la taille et on a besoin que de ça */
						this.assemblyCode += "//Parametre : \"" + fn.getParameters().get(i).getIdf()+ "\"\n";
						this.assemblyCode += "//----Début : Structure ou vecteur entier\n";
						String elt_name = currentTree.getChild(1+i).getChild(0).getText();
                        System.out.println("Paramètre "+elt_name);
						int elt_size = fn.getParameters().get(i).getSize();

						/* Pour trouver l'addresse du premier élément */
						TDS current;
						Symbol fn_s= null;
						int fn_nbStack= 0;
						for(int fn_i=this.pileRegionOuvertes.size()-1 ; fn_i>=0; fn_i--){
							current= this.pileRegionOuvertes.get(fn_i);
							// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
							fn_s = current.containsSymbol(elt_name);
							if(fn_s==null){
								fn_nbStack++;
							} else {
								if(fn_s.getType().equals(SemanticParser.TYPE_VEC)){
									elt_size= ((Vec)fn_s).getSize();
								}
								break;
							}
						}
						/* Fin : pour trouver l'adresse */
						// Code � call pour appeller la subroutine accessVal
						if(fn_nbStack>0){
							this.assemblyCode+="LDW R3,#"+fn_nbStack+"\n" // On empile le nombre de sauts a effectuer pour atteindre la bonne base\n"
									+"STW R3, -(SP)     // On empile nbStack\n"
									+"JSR @findBase_ // appelle fonction d'adresse findBase_\n"
									+"ADQ 2, SP // nettoie la pile des parametres\n";
						}else{
							// Parce qu'on ne va pas appeller la subroutine si on sait que la variable est dans la pile courante... (sinon == calculs pour rien)
							this.assemblyCode+="LDW R6, BP\n // on charge l'adresse de la base courante dans R6\n";
						}
						/* Alors la tactique c'est qu'une structure ou vecteur est écrit en une traite, donc il suffi d'avoir le déplacement du premier élement
						   et la taille totale de la structure/du vecteur pour le copier */
                        System.out.println(fn_s);
                        System.out.println(elt_size);
						int stackValue = ((Var) fn_s).getStackValue();
						for (int j = elt_size/2 - 1; j>=0; j--){ // Dans l'ordre inverse pour l'empilement
							this.assemblyCode += "LDW " + this.getRegistryStringFromId(0)
									+ ", (R6)" + (-(stackValue+j) * 2 - 2) + "\n";
							this.assemblyCode += "STW R0, -(SP)\n"; // On stocke en pile
						}
						this.assemblyCode+=("//----Fin : Structure ou vecteur entier\n");

					}
				}

				this.assemblyCode += "JSR @" + funname + "_\n";
				this.assemblyCode += "ADQ "+ tailleTotale +", SP\n";
				// A ce stade, on sait que le retour de la fonction a été placé dans R0, on met donc R0 dans le registry number.
				this.assemblyCode += "LDW R"+registry_number+", R0\n";
				this.assemblyCode+="LDW R12, #0 \n";
				this.assemblyCode += "\n//--<Fin appel de la fonction : \"" + funname + "\">--\n\n";

				break;
			case "RETURN":
				this.getAssemblyCode(currentTree.getChild(0), registry_number);
				this.assemblyCode+="LDW R12, #1 \n";
				break;
			case "FUN_CALL_ELT":
				this.getAssemblyCode(currentTree.getChild(0), registry_number);
				break;

			// ----
			// DEBUT : POINTEURS

			case "VAR_ADDRESS_ACCESS":
				//System.out.println("Acces address variable");
				String varName = currentTree.getChild(0).getText();
				//System.out.println("Nom de la variable : " + varName);
				TDS current_ptr;
				s= null;
				for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
					current_ptr= this.pileRegionOuvertes.get(i);
					// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
					s = current_ptr.containsSymbol(varName);
					if(s!=null){
						if(!((Var)s).getDeclaredStatus()){
							this.newDeclaredVar= true;
							((Var)s).setIsDeclared();
						}
						this.getDisplacementFromIdf(varName, registry_number, true);
						break;
					}
				}
				break;

			case "PTR_CONTENT_ACCESS":
				this.assemblyCode += "//DEBUT---ptr_content_access : \"" + currentTree.getChild(0).getText() + "\"\n";
				int ptr_content_access_cpt = 1;
				while (currentTree.getChild(0).getText().equals("PTR_CONTENT_ACCESS")){
					currentTree = currentTree.getChild(0);
					ptr_content_access_cpt += 1;
				}
				if (currentTree.getChild(0).getText().equals("ACCESS")){
					Tree currentTreePA = currentTree.getChild(0);
					String structName = currentTreePA.getChild(0).getText();
					Tree cureentTreePA = currentTreePA.getChild(1);
					Deque<String> fields = new ArrayDeque<>();

					while (cureentTreePA.getChildCount() == 2){
						fields.add(cureentTreePA.getChild(0).getText());
						cureentTreePA = cureentTreePA.getChild(1);
					}
					fields.add(cureentTreePA.getChild(0).getText());
					TDS currentTdsPointAccess;
					Symbol symPointAccess=null;
					for(int i = this.pileRegionOuvertes.size()-1 ; i>=0 ; i--){
						currentTdsPointAccess = this.pileRegionOuvertes.get(i);
						symPointAccess=currentTdsPointAccess.containsSymbol(structName);
						if(symPointAccess!=null){
							this.getDisplacementFromStructPtr(structName, fields,registry_number);
							break;
						}
					}
				}
				else {
					this.getAssemblyCode(currentTree.getChild(0), registry_number);
				}
				for (int i=0;i<ptr_content_access_cpt;i++) {
					this.assemblyCode += "LDW " + getRegistryStringFromId(registry_number) + ",(" + getRegistryStringFromId(registry_number) + ")\n";
				}
				this.assemblyCode += "//FIN---ptr_content_access : \"" + currentTree.getChild(0).getText() + "\"\n";
				break;
			// FIN : POINTEURS
			// ----

			default:
				// Si on souhaite placer l'element dans un registre
				if(registry_number!=-1){
					if(SemanticParser.testIsI32Regex(currentTree.getText())){
						this.assemblyCode+= "ldw "+this.getRegistryStringFromId(registry_number)+", #"+currentTree.getText()+"\n";
					}else if(currentTree.getText().equals("true") || currentTree.getText().equals("false")){
						// Normalement en assembleur le traitement des booleens est le meme que pour les entiers
						int resValue= 0;
						if(currentTree.getText().equals("true"))
							resValue= 1;
						this.assemblyCode+= "ldw "+this.getRegistryStringFromId(registry_number)+", #"+resValue+"\n";
					}else if(SemanticParser.testIsIdfRegex(currentTree.getText())){

						TDS current;
						s= null;
						for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
							current= this.pileRegionOuvertes.get(i);
							// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
							s = current.containsSymbol(currentTree.getText());
							if(s!=null){
								if(!((Var)s).getDeclaredStatus()){
									this.newDeclaredVar= true;
									((Var)s).setIsDeclared();
								}
								this.getDisplacementFromIdf(currentTree.getText(), registry_number);
								break;
							}
						}
					}
					break;
				}
		}
	}

	private void recursiveStructAff(String nomStructure, Deque<String> fields, int targetRegisterAS, Tree childAS){
        Tree ssAcolade = childAS.getChild(2);

        for(int k=0; k<ssAcolade.getChildCount();k++){
            Tree ssAcoladeSon = ssAcolade.getChild(k);
            fields.add(ssAcoladeSon.getChild(0).getText());
            /* affichage */
            this.assemblyCode += "//--affectation du champ :\"";
            for (String field : fields){
                this.assemblyCode += "." + field;
            }
            this.assemblyCode += "\n";

            if (ssAcoladeSon.getChild(2).getText().equals("FIN_AFF")){
                // Finis, affectation normale
                /* membre droit */
                this.getAssemblyCode(ssAcoladeSon.getChild(1), targetRegisterAS);
                this.assemblyCode += "STW " + this.getRegistryStringFromId(targetRegisterAS) + ", -(SP)\n";
                /* Ensuite le membre gauche */
                this.getDisplacementFromStruct(nomStructure, fields, 1);
                this.assemblyCode += "LDW " + this.getRegistryStringFromId(targetRegisterAS) + ", (SP)\n";
                this.assemblyCode += "ADQ 2, SP\n";
                if (this.newDeclaredVar) {
                    this.assemblyCode += "// VARIABLE DECLAREE POUR LA PREMIERE FOIS\n"
                            + "ADQ -2, SP\n";
                }
                this.assemblyCode += "STW " + this.getRegistryStringFromId(targetRegisterAS) + ", (R3)\n";
            }
            else{
                // Récursivité du code
                //fields.add(ssAcoladeSon.getChild(0).getText());
                this.recursiveStructAff(nomStructure, fields,targetRegisterAS, ssAcoladeSon);
            }
            fields.removeLast();
        }
    }

	private void recursiveStructAffPtr(String ptr, Deque<String> fields,  int targetRegisterAS, Tree childAS){
		Tree ssAcolade = childAS.getChild(2);

		for(int k=0; k<ssAcolade.getChildCount();k++){
			Tree ssAcoladeSon = ssAcolade.getChild(k);
			fields.add(ssAcoladeSon.getChild(0).getText());
			/* affichage */
			this.assemblyCode += "//--affectation du champ :\"";
			for (String field : fields){
				this.assemblyCode += "." + field;
			}
			this.assemblyCode += "\n";

			if (ssAcoladeSon.getChild(2).getText().equals("FIN_AFF")){
				// Finis, affectation normale
				/* membre droit */
				this.getAssemblyCode(ssAcoladeSon.getChild(1), targetRegisterAS);
				this.assemblyCode += "STW " + this.getRegistryStringFromId(targetRegisterAS) + ", -(SP)\n";
				/* Ensuite le membre gauche */
				this.getDisplacementFromStructPtr(ptr, fields, 1);
				this.assemblyCode += "LDW " + this.getRegistryStringFromId(targetRegisterAS) + ", (SP)\n";
				this.assemblyCode += "ADQ 2, SP\n";
				this.assemblyCode += "STW " + this.getRegistryStringFromId(targetRegisterAS) + ", (R3)\n";
			}
			else{
				// Récursivité du code
				//fields.add(ssAcoladeSon.getChild(0).getText());
				this.recursiveStructAff(ptr, fields,targetRegisterAS, ssAcoladeSon);
			}
			fields.removeLast();
		}
	}

	private void getDisplacementFromStruct(String idf, Deque<String> fields, int registry_number){
        this.assemblyCode+="\n//On cherche à mettre le champ \"" + idf ;
        for (String field : fields) {
            this.assemblyCode += "." + field ;
        }
        this.assemblyCode += "\" dans R"+registry_number+"\n";

        /* Pour trouver l'addresse */
        TDS current;
        Symbol s= null;
        int nbStack= 0;
        for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
            current= this.pileRegionOuvertes.get(i);
            // On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
            s = current.containsSymbol(idf);
            if(s==null){
                nbStack++;
            } else {
                break;
            }
        }
        /* Fin : pour trouver l'adresse */

        // Code � call pour appeller la subroutine accessVal
        if(nbStack>0){
            this.assemblyCode+="LDW R3,#"+nbStack+"\n" // On empile le nombre de sauts a effectuer pour atteindre la bonne base\n"
                    +"STW R3, -(SP)     // On empile nbStack\n"
                    +"JSR @findBase_ // appelle fonction d'adresse findBase_\n"
                    +"ADQ 2, SP // nettoie la pile des parametres\n";
        }else{
            // Parce qu'on ne va pas appeller la subroutine si on sait que la variable est dans la pile courante... (sinon == calculs pour rien)
            this.assemblyCode+="LDW R6, BP\n // on charge l'adresse de la base courante dans R6\n";
        }

        int stackValue = ((Var) s).getStackValue();
        Var lastField = (StructVar)s;
        for (String field: fields){
            try{
                stackValue += ((StructVar)lastField).getStructure().getField(field).getStackValue();
                lastField = ((StructVar) lastField).getStructure().getField(field);
            }
            catch (Exception e){
                this.assemblyCode += "// Dernier champ " + field;
            }
        }
        this.assemblyCode += "//----Stockage de la valeur dans " + this.getRegistryStringFromId(registry_number) + "\n";
        this.assemblyCode += "LDW " + this.getRegistryStringFromId(registry_number)
                + ", (R6)" + (-stackValue * 2 - 2) + "\n";
        this.assemblyCode += "//----Stockage de l'addresse dans R3 pour affectation (si nécessaire)\n";
        this.assemblyCode += "LDW R3, #"+(-stackValue*2-2)+"\n" // On stocke l'adresse de la variable, pour le cas d'une affectation
                +"ADD R6, R3, R3\n";

    }

	private void getDisplacementFromStructPtr(String idf, Deque<String> fields, int registry_number) {
		this.assemblyCode+= "\n//Affectation structre via pointeur\n";
		this.assemblyCode+="\n//On cherche à mettre le champ \"*" + idf ;
		for (String field : fields) {
			this.assemblyCode += "." + field ;
		}
		this.assemblyCode += "\" dans R"+registry_number+"\n";

		/* Pour trouver l'addresse */
		TDS current;
		Symbol s= null;
		int nbStack= 0;
		for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
			current= this.pileRegionOuvertes.get(i);
			// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
			s = current.containsSymbol(idf);
			if(s==null){
				nbStack++;
			} else {
				break;
			}
		}
		/* Fin : pour trouver l'adresse */

		// Code � call pour appeller la subroutine accessVal
		if(nbStack>0){
			this.assemblyCode+="LDW R3,#"+nbStack+"\n" // On empile le nombre de sauts a effectuer pour atteindre la bonne base\n"
					+"STW R3, -(SP)     // On empile nbStack\n"
					+"JSR @findBase_ // appelle fonction d'adresse findBase_\n"
					+"ADQ 2, SP // nettoie la pile des parametres\n";
		}else{
			// Parce qu'on ne va pas appeller la subroutine si on sait que la variable est dans la pile courante... (sinon == calculs pour rien)
			this.assemblyCode+="LDW R6, BP\n // on charge l'adresse de la base courante dans R6\n";
		}

		//this.assemblyCode += "LDW R3, (R3)"; // C'EST UN POINTEUR !

		int stackValue = ((Var) s).getStackValue();

		/* POINTEUR */
		this.assemblyCode += "//----Stockage de la valeur dans " + this.getRegistryStringFromId(registry_number) + "\n";
		this.assemblyCode += "LDW " + this.getRegistryStringFromId(registry_number)
				+ ", (R6)" + (-stackValue * 2 - 2) + "\n";
		this.assemblyCode += "//----Stockage de l'addresse dans R3 pour affectation (si nécessaire)\n";
		this.assemblyCode += "LDW R3, #"+(-stackValue*2-2)+"\n" // On stocke l'adresse de la variable, pour le cas d'une affectation
				+"ADD R6, R3, R3\n";
		this.assemblyCode += "LDW R3, (R3)" + "\n";
		this.assemblyCode += "LDW R6, R3" + "\n";


		stackValue = 0;
		Symbol lastField = (PtrVar)s;

		// DANS le cas ou le pointeur pointe vers une structure
		if (((PtrVar) s).getPointedVar() != null){
			/* Pour trouver l'addresse */
			TDS current_;
			Symbol s_= null;
			int nbStack_= 0;
			for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
				current_= this.pileRegionOuvertes.get(i);
				// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
				s_ = current_.containsSymbol(((PtrVar) s).getPointedVar());
				if(s_==null){
					nbStack_++;
				} else {
					break;
				}
			}
			lastField = (StructVar)s_;
		}
		//Cas d'un pointeur pointant
		else {
			TDS current_;
			Symbol s_ = null;
			int nbStack_ = 0;
			for (int i = this.pileRegionOuvertes.size() - 1; i >= 0; i--) {
				current_ = this.pileRegionOuvertes.get(i);
				// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
				s_ = current_.containsSymbol(((PtrVar) s).getPointedType());
				if (s_ == null) {
					nbStack_++;
				} else {
					break;
				}
			}
			lastField = (Structure) s_;
		}
		for (String field: fields){
			try{
				if (lastField instanceof  Structure){
					stackValue += ((Structure)lastField).getField(field).getStackValue();
					lastField = ((Structure) lastField).getField(field);
				}
				else {
					stackValue += ((StructVar) lastField).getStructure().getField(field).getStackValue();
					lastField = ((StructVar) lastField).getStructure().getField(field);
				}
			}
			catch (Exception e){
				this.assemblyCode += "// Dernier champ " + field;
			}
		}

		this.assemblyCode += "//----Stockage de la valeur dans " + this.getRegistryStringFromId(registry_number) + "\n";
		//this.assemblyCode += "LDW " + this.getRegistryStringFromId(registry_number)
		//		+ ", ("+  this.getRegistryStringFromId(registry_number) + ")+\n";
		//this.assemblyCode +=  "LDW " + this.getRegistryStringFromId(registry_number) + ", (R6)" + (-stackValue * 2) + "\n";
		this.assemblyCode += "//----Stockage de l'addresse dans R3 pour affectation (si nécessaire)\n";
		//this.assemblyCode += "LDW R10, (R3)" + "\n";
		this.assemblyCode += "LDW R10, #" + (-stackValue*2) + "\n"; // R10 ??
		this.assemblyCode += "ADD R3, R10, R3 "+"\n"; // On stocke l'adresse de la variable, pour le cas d'une affectatio
		this.assemblyCode +=  "LDW " + this.getRegistryStringFromId(registry_number) + ", R3\n";
	}

    private void getDisplacementFromStruct(String idf, String field, int registry_number) {
	    Deque<String> a = new ArrayDeque<>(1);
	    a.add(field);
		getDisplacementFromStruct(idf, a, registry_number);
	}

	public void getDisplacementFromIndice(String Vecname, int registry_number, int indice){
		this.assemblyCode+="\n//On cherche à mettre le composant de \"" + Vecname + " d'indice "
				+ indice + " dans R"+registry_number+"\n";

		/* Pour trouver l'addresse */
		TDS current;
		Symbol s= null;
		int nbStack= 0;
		for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
			current= this.pileRegionOuvertes.get(i);
			// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
			s = current.containsSymbol(Vecname);
			if(s==null){
				nbStack++;
			} else {
				break;
			}
		}

		//On a l'adresse.

		// Code � call pour appeller la subroutine accessVal
		if(nbStack>0){
			this.assemblyCode+="LDW R3,#"+nbStack+"\n" // On empile le nombre de sauts a effectuer pour atteindre la bonne base\n"
					+"STW R3, -(SP)     // On empile nbStack\n"
					+"JSR @findBase_ // appelle fonction d'adresse findBase_\n"
					+"ADQ 2, SP // nettoie la pile des parametres\n";
		}else{
			// Parce qu'on ne va pas appeller la subroutine si on sait que la variable est dans la pile courante... (sinon == calculs pour rien)
			this.assemblyCode+="LDW R6, BP\n // on charge l'adresse de la base courante dans R6\n";
		}

		int stackValue = ((Var) s).getStackValue();
		stackValue += ((Vec)s).getComponent(indice).getStackValue();
		this.assemblyCode += "//----Stockage de la valeur dans " + this.getRegistryStringFromId(registry_number) + "\n";
		this.assemblyCode += "LDW " + this.getRegistryStringFromId(registry_number)
				+ ", (R6)" + (-stackValue * 2 - 2) + "\n";
		this.assemblyCode += "//----Stockage de l'addresse dans R3 pour affectation (si nécessaire)\n";
		this.assemblyCode += "LDW R3, #"+(-stackValue*2-2)+"\n" // On stocke l'adresse de la variable, pour le cas d'une affectation
				+"ADD R6, R3, R3\n";

	}

	// TODO: eventuellement changer �a en subroutine qu'on charge en debut de programme
	public void getDisplacementFromIdf(String idf, int registry_number){
		getDisplacementFromIdf(idf, registry_number, false);
	}

	public void getDisplacementFromIdf(String idf, int registry_number, boolean isAddress){
		this.assemblyCode+= "\n//----Looking to put ";
		if (isAddress){
			this.assemblyCode+="address of \"";
		}
		else{
			this.assemblyCode+="value of \"";
		}
		this.assemblyCode += idf + "\" in R"+registry_number +"\n";

		TDS current;
		Symbol s= null;
		int nbStack= 0;
		for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
			current= this.pileRegionOuvertes.get(i);
			// On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
			s = current.containsSymbol(idf);
			if(s==null){
				nbStack++;
			} else {
				break;
			}
		}

		/**************************************************************************/

		// Code � call pour appeller la subroutine accessVal
		if(nbStack>0){
			this.assemblyCode+="LDW R3,#"+nbStack+"\n" // On empile le nombre de sauts a effectuer pour atteindre la bonne base\n"
					+"STW R3, -(SP)     // On empile nbStack\n"
					+"JSR @findBase_ // appelle fonction d'adresse findBase_\n"
					+"ADQ 2, SP // nettoie la pile des parametres\n";
		}else{
			// Parce qu'on ne va pas appeller la subroutine si on sait que la variable est dans la pile courante... (sinon == calculs pour rien)
			this.assemblyCode+="LDW R6, BP\n // on charge l'adresse de la base courante dans R6\n";
		}

		// Maintenant qu'on a la base, on calcule le deplacement par rapport a la pile courante: BP - ( ((Var)s).getStackValue() )*2 - 2
		if (isAddress) {
			//Dans le cas d'une affectation de registre
			this.assemblyCode += "//----Stockage de l'addresse dans " + this.getRegistryStringFromId(registry_number) + "\n";
			this.assemblyCode += "LDW " + this.getRegistryStringFromId(registry_number)
					+ ", #"+(-((Var)s).getStackValue()*2-2)+"\n" // On stocke l'adresse de la variable, pour le cas d'une affectation
					+"ADD R6, " + this.getRegistryStringFromId(registry_number) +  ", "
					+ this.getRegistryStringFromId(registry_number) +  "\n";
		}
		else {
			this.assemblyCode += "//----Stockage de la valeur dans " + this.getRegistryStringFromId(registry_number) + "\n";
			this.assemblyCode += "LDW " + this.getRegistryStringFromId(registry_number)
					+ ", (R6)" + (-((Var) s).getStackValue() * 2 - 2) + "\n";
		}
		this.assemblyCode += "//----Stockage de l'addresse dans R3 pour affectation (si nécessaire)\n";
		this.assemblyCode += "LDW R3, #"+(-((Var)s).getStackValue()*2-2)+"\n" // On stocke l'adresse de la variable, pour le cas d'une affectation
				+"ADD R6, R3, R3\n";


		/**************************************************************************/

       /* // Calcul du deplacement pour arriver a la BP de la tds contenant idf
        this.assemblyCode+= "LDW R3,#"+nbStack+"\n"
        			+"LDW R4, #0\n"
        			+"LDW R6, BP\n"
        			+"jmp"+this.currentJmpId+" CMP R3, R4 // pour boucler tant que l'on est pas sur la bonne base\n"
        			+"JEQ #jmp"+(this.currentJmpId+1)+"-$-2\n"
        			+"LDW R5, R6\n"
        			+"LDW R6, (R5) // lorsque R3 contiendra 0, R6 contiendra l'adresse de la base de la variable recherchee\n"
        			+"ADQ -1, R3\n"
        			+"JMP #jmp"+this.currentJmpId+"-$-2\n"
        			// Maintenant qu'on a la base, on calcule le deplacement par rapport a la pile courante: BP - ( ((Var)s).getStackValue() )*2 - 2
        			+"jmp"+(this.currentJmpId+1)+" LDW "+this.getRegistryStringFromId(registry_number)+", (R6)"+(-((Var)s).getStackValue()*2-2)+"\n"
        			+"LDW R3, #"+(-((Var)s).getStackValue()*2-2)+"\n" // On stocke l'adresse de la variable, pour le cas d'une affectation
        			+"ADD R6, R3, R3\n";
        this.assemblyCode+= "//------------- END LOOKING FOR \n";
        this.currentJmpId+=2; // cf on a ajoute 2 jmp dans le code assembleur*/
	}

	public String getRegistryStringFromId(int registry_number){
		return "R"+registry_number;
	}

	/**
	 *
	 * R1: utilise pour stocker resultat d'operande gauche
	 * R2: utilise pour stocker resulter d'operande droite
	 * R3: pour stocker nb de sauts a effectuer pour arriver jusqu'a base contenant idf recherche
	 * R4: pour stocker valeur de test lors d'une boucle
	 * R5 et R6: pour iterer de fa�on recursive sur les adresses de base de pile
	 */


	/**
	 * Fonction permettant d'écrire un fichier
	 * @param s Chaine à écrire dans le fichier
	 * @param filename nom du fichier
	 */
	public void genererFichier(String s, String filename){


		File fichier = new File (filename);

		try
		{
			PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (fichier)));

			pw.print(s);

			pw.close();
		}

		catch (IOException e)
		{
			System.out.println ("Erreur de lecture : " + e.getMessage());
		}
	}


}
