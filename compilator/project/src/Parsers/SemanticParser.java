package Parsers;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.xml.internal.ws.server.sei.SEIInvokerTube;
import org.antlr.runtime.tree.Tree;

import TDSPackage.*;

import javax.xml.transform.sax.SAXSource;

public class SemanticParser {

    private ArrayList<TDS> tdsList = new ArrayList<TDS>();
    private Stack<TDS> pileRegionOuvertes = new Stack<TDS>();
    private int tdsCounter = 0;

    public final static String TYPE_BOOL= "bool";
    public final static String TYPE_I32= "i32";
    public final static String TYPE_VEC= "vec";
    public final static String TYPE_VEC_DECL= "vec_decl";
    public final static String TYPE_ERROR= "TYPE_ERROR";
    public final static String TYPE_NULL= "TYPE_NULL";
    public final static String TYPE_ADDR= "TYPE_ADDR";
    public static boolean DEBUGING = false;

	public static void printDebugging(String str) {
		if(SemanticParser.DEBUGING) {
			System.out.println(str);
		}
	}

	public Object parseTree(Tree currentTree){
		String current;
		String fgType;
		String fdType;
		String typeTest;
		Symbol s;
		Var v;
		Tree test, bloc;
		switch(currentTree.getText()){
			case "ROOT":
				SemanticParser.printDebugging("Entrée dans le bloc ROOT");
				// Création de la première TDS
				this.createNewTDS();

				for(int i= 0; i<currentTree.getChildCount(); i++){
					current= currentTree.getChild(i).getText();
					this.parseTree(currentTree.getChild(i));
				}
				return this.tdsList; // On retourne la tds (pour qu'elle puisse etre utilisee lors de la mise en place du code assembleur)
			case "FUN":
				SemanticParser.printDebugging("Entrée dans le bloc FUN");
				/*
				 * 1 - Vérifier que le nom n'est pas déjà dans la TDS (O : erreur | N : ajouter)
				 * 2 - Parcourir la liste des arguments, créer le symbole associé et l'ajouter à la liste des symboles
				 * 3 - Prendre en compte le type de retour et l'associer à la fonction
				 * 4 - Quand on arrive sur le BLOC, créer la nouvelle TDS du bloc et y ajouter les paramètres formels de la fonction
				 */

				String name = currentTree.getChild(0).getText();
				s = getSymbolFromIdf(name);
				if(s != null) {
					this.printError(currentTree, "Semantic Error: Function has already been declared.");
				} else {
					ArrayList<Var> args = (ArrayList<Var>)this.parseTree(currentTree.getChild(1));

					Tree nextChild = currentTree.getChild(2);
					String type = SemanticParser.TYPE_NULL;
					bloc = null;

					if(!nextChild.getText().equals("BLOC")) {

						switch(nextChild.getText()) {
							case "TYPE_VEC":
							    type=SemanticParser.TYPE_VEC;
							    //System.out.println(nextChild.getChild(0));
								break;
							case "TYPE_ADDR":
								type=SemanticParser.TYPE_ADDR;
								break;
							default:
								type = nextChild.getText();
						}
						bloc = currentTree.getChild(3);
					} else {
						bloc = nextChild;
					}

					// On ajoute la fonction à la TDS et on commence la création de la TDS pour le bloc qui arrive.
					Function fun = new Function(name,type);
					fun.addParameters(args);
					TDS t = this.pileRegionOuvertes.peek();
					t.addSymbol(fun);

					// Création de la nouvelle table des symboles.
					this.createNewTDS();
					t = this.pileRegionOuvertes.peek(); // On récupère la nouvelle TDS et on y ajoute les paramètres de la fonction.
					for(int i = 0; i < args.size(); i++) {
						t.addSymbol(args.get(i));
					}

					// Récursivité sur le bloc
					String blocReturnValue= (String)this.parseTree(bloc);

					if(!fun.getType().equals(blocReturnValue)){
						this.printError(currentTree, "Semantic Error: Wrong return type between function bloc and declared return type");
					}
                    //System.out.println(blocReturnValue);

				}

				break;
			case "FUN_ARGS":
				SemanticParser.printDebugging("Entrée dans le bloc FUN_ARGS");
				ArrayList<Var> args = new ArrayList<Var>();
				v = null;
				for(int i = 0; i < currentTree.getChildCount() ; i++) {
					v = (Var)this.parseTree(currentTree.getChild(i));
					args.add(v);
				}

                return args;

            case "ARG":
                SemanticParser.printDebugging("Entrée dans le bloc ARGS");
                // TODO Compléter avec les autres types possibles comme Vec <Data> ou les struct.
                String idfname = currentTree.getChild(0).getText();
                String typeargs = currentTree.getChild(1).getText();
                v=null;
                switch(typeargs) {
                    case "TYPE_VEC":
                        v=new Vec(idfname,true);
                        break;
                    case SemanticParser.TYPE_I32 :
                        v = new IntVar(idfname, true);
                        break;
                    case SemanticParser.TYPE_BOOL :
                        v = new BoolVar(idfname, true);
                        break;
                    case SemanticParser.TYPE_ADDR :
                        v = new PtrVar(idfname, currentTree.getChild(1).getChild(0).getText());
                        break;
                    default:
                        //On met le test des structures dans le défaut
                        if (this.pileRegionOuvertes.peek().containsSymbol(typeargs) instanceof Structure){
                            v = new StructVar(idfname, true,typeargs);
                            ((StructVar)v).setStructure((Structure) this.pileRegionOuvertes.peek().containsSymbol(typeargs));
                        }
                        else {
                            System.out.println(currentTree.getLine() + " : Semantic error : " + idfname + " : " + typeargs
                                    + " - type not understood\n");
                        }
                        break;
                }
                return v;

            case "BLOC":
                SemanticParser.printDebugging("Entrée dans le bloc BLOC");
                // Toujours créer la TDS du nouveau bloc avant l'appel récursif sur BLOC dans le noeud précédent.
                String returnValue= SemanticParser.TYPE_NULL, temp;
                for(int i = 0; i < currentTree.getChildCount() ; i++) {
                    if(currentTree.getChild(i).getText().equals("BLOC") && currentTree.getChild(i).getChild(0).getChildCount()!=0) {
                        // TODO: pour le moment on suppose qu'on ne peut pas avoir de bloc vide
                        this.createNewTDS();
                    }
                    temp = (String)this.parseTree(currentTree.getChild(i));
                    if(currentTree.getChild(i).getText().equals("RETOUR_BLOC") || currentTree.getChild(i).getText().equals("RETURN"))
                        returnValue= temp;
                }
                this.unstackTDS();
                return returnValue;

            case "AFF":
                SemanticParser.printDebugging("Entrée dans le bloc AFF");
                Symbol leftIdf= null; // pour stocker l'idf de L_VALUE dans le cas d'une premiere declaration
                String rightType="null"; // pour differencier si les 2 sont des NULL apres appel de parseTree
                boolean isMutable= false;
                Symbol leftSymbol= null, rightSymbol= null; // pour stocker si existe deja dans tds de la pile des regions ouvertes

                // Variables utilisées pour les affectations d'access
                boolean access = false;
                Tree accessTree = null;
                //Variables utilisées pour les affectations de pointeurs
                boolean ptr_content_access = false;


                for(int i= 0; i<currentTree.getChildCount(); i++){
                    current= currentTree.getChild(i).getText();
                    switch(current){
                        case "mut":
                            SemanticParser.printDebugging("Entrée dans le bloc AFF-mut");
                            isMutable= true;
                            break;
                        case "L_VALUE":
                            SemanticParser.printDebugging("Entrée dans le case AFF-L_VALUE");
                            if (currentTree.getChild(i).getChild(0).getText().equals("ACCESS") ){
                                access = true;
                                accessTree = currentTree.getChild(i).getChild(0);
                            }
                            else if (currentTree.getChild(i).getChild(0).getText().equals("PTR_CONTENT_ACCESS")){
                                ptr_content_access = true;
                                leftIdf = isIdfSymbol(currentTree.getChild(i).getChild(0), false); // pour stocker symbole vide dans leftIdf si creation new var
                                leftSymbol = isIdfSymbol(currentTree.getChild(i).getChild(0), true);
                            }
                            else {
                                leftIdf = isIdfSymbol(currentTree.getChild(i), false); // pour stocker symbole vide dans leftIdf si creation new var
                                leftSymbol = isIdfSymbol(currentTree.getChild(i), true);
                            }
                            break;
                        case "R_VALUE":
                            SemanticParser.printDebugging("Entrée dans le case AFF-R-VALUE");
                            if (currentTree.getChild(i).getChild(0).getText().equals("VAR_ADDRESS_ACCESS")){
                                // TODO Ajouter des vérifications si on a le temps
                                String pointedTo =  currentTree.getChild(i).getChild(0).getChild(0).getText();
                                PtrVar p = new PtrVar(leftIdf.getIdf(), isMutable, pointedTo);
                                this.pileRegionOuvertes.peek().addSymbol(p);
                                return "";
                            }
                            else {
                                rightType = (String) parseTree(currentTree.getChild(i));
                                rightSymbol = isIdfSymbol(currentTree.getChild(i), true); // En parametre: node R_VALUE
                            }
                            break;
                    }
                }
                /*
                 * si(left existe et pas mutable)
                 * 	ERREUR
                 * si(left existe et est mutable){
                 * 		si(letf a le meme type que right){
                 * 			if(right est idf)
                 * 				changement de proprietaire
                 * 		}sinon{
                 * 			ERREUR
                 * 		}
                 * 	}sinon si(left n'existe pas){
                 * 		ajout a la tds
                 * 		if(right est idf)
                 * 			changement de proprietaire
                 * }
                 */
                if (access){
                    // Les access sont toujours mutables d'après la prof !
                    //System.out.println("Affectation access");
                    String leftType = getTypeFromAccess(accessTree);
                    if (!(leftType.equals(rightType))){
                        this.printError(currentTree, "Semantic Error: affectation with incorrect type" );
                    }
                    return "";
                }
                if (ptr_content_access){
                    //Affectation pointeur
                    if (leftSymbol == null) {
                        this.printError(currentTree, "Semantic Error: affectation to non-allocated memory place");
                        return "";
                    }
                    else {
                        //int indice = (isMutable) ? 0 : 1;
                        //System.out.println("PTR_CONTENT_ACCESS lors d'une AFF");
                        String type = getTypeFromPtrAcces(currentTree.getChild(0).getChild(0));
                        if(type.equals(rightType) && !(type.equals(SemanticParser.TYPE_ERROR))){
                            if(rightSymbol!=null && !rightSymbol.getType().equals(SemanticParser.TYPE_ERROR) && rightSymbol instanceof OwnableVar){
                                ((OwnableVar)rightSymbol).setOwner(leftSymbol.getIdf());
                            }
                        } else{
                                this.printError(currentTree, "Semantic Error: affectation with incorrect type");
                        }
                        return "";
                    }
                }
                if(!ptr_content_access && leftSymbol instanceof Var) {
                    if(((Var)leftSymbol).getMut())
                        isMutable = true;
                }
                if(!ptr_content_access && !(leftSymbol==null) && !isMutable)
                    this.printError(currentTree, "Semantic Error: affectation to non-mutable existing value");
                if(!ptr_content_access && !(leftSymbol==null) && isMutable){
                    if(leftSymbol.getType().equals(rightType) && !(leftSymbol.getType().equals(SemanticParser.TYPE_ERROR))){
                        if(rightSymbol!=null && !rightSymbol.getType().equals(SemanticParser.TYPE_ERROR) && rightSymbol instanceof OwnableVar){
                            ((OwnableVar)rightSymbol).setOwner(leftSymbol.getIdf());
                        }
                    }else{
                        this.printError(currentTree, "Semantic Error: affectation with incorrect type");
                    }
                }else if(leftSymbol==null){
                    TDS t = this.pileRegionOuvertes.peek();
                    s = null;
                    // TODO : Ajouter les autres types pour le cas de l'ajout a la TDS.
                    if(rightType!=null){
                        switch(rightType) {
                            case SemanticParser.TYPE_ADDR:
                                try {
                                    s = new PtrVar(leftIdf.getIdf(), isMutable, ((PtrVar) rightSymbol).getPointedVar());
                                }
                                catch (Exception e){
                                    // Dans le cas d'un pointeur parametre de fonction
                                    s = new PtrVar(leftIdf.getIdf(), rightSymbol.getType());
                                }
                                //TODO Gérer l'ownership si besoin
                                //((OwnableVar)getSymbolFromIdf(((PtrVar)s).getPointedVar())).setOwner(s.getIdf()); // nouvel owner pour la valeur pointéut
                                break;
                            case SemanticParser.TYPE_VEC_DECL:
                                return"";
                            case SemanticParser.TYPE_VEC:
                                s=new Vec(leftIdf.getIdf(), isMutable);
                                break;
                            case SemanticParser.TYPE_I32:
                                s = new IntVar(leftIdf.getIdf(), isMutable);
                                break;
                            case SemanticParser.TYPE_BOOL:
                                s = new BoolVar(leftIdf.getIdf(), isMutable);
                                break;
                            case SemanticParser.TYPE_ERROR:
                                s = new SymbolUnknownType(leftIdf.getIdf());
                                this.printError(currentTree, "Semantic Error: expression impossible to evaluate");
                                break;

                            default :
                                if (t.containsSymbol(rightType) instanceof Structure) {
                                    s = new StructVar(leftIdf.getIdf(), isMutable, rightType);
                                    ((StructVar)s).setStructure((Structure) t.containsSymbol(rightType));
                                }
                        }
                        t.addSymbol(s);
                        if(rightSymbol!=null && rightSymbol instanceof OwnableVar){
                            ((OwnableVar)rightSymbol).setOwner(s.getIdf());
                        }
                    }
                }
                return "";

            // L_VALUE: reccuperer le type pour effectuer comparaison avec R_VALUE (et eventuellement ajout nouveau symbole a TDS courante)
            case "L_VALUE":
                SemanticParser.printDebugging("Entrée dans le bloc L_VALUE");
                // TODO: completer cf autres cas (adresse)
                switch (currentTree.getChild(0).getText()){
                    // Cas particulier des structures
                    case "ACCESS" : getTypeFromAccess(currentTree.getChild(0));
                    default : return this.getTypeFromIdf(currentTree.getChild(0).getText());
                }
                // R_VALUE: reccuperer le type pour effectuer comparaison avec L_VALUE (et eventuellement ajout nouveau symbole a TDS courante)
            case "R_VALUE":
                SemanticParser.printDebugging("Entrée dans le bloc R_VALUE");
                if(currentTree.getChild(0).getText().equals("BLOC") && currentTree.getChild(0).getChildCount()!=0) {
                    // TODO: pour le moment on suppose qu'on ne peut pas avoir de bloc vide
                    this.createNewTDS();
                }
                // On a toujours un seul child sous R_VALUE
                return	parseTree(currentTree.getChild(0));
            case ">=":
            case "==":
            case "<=":
            case ">":
            case "<":
            case "!=":
                SemanticParser.printDebugging("Entrée dans le bloc TESTI32");
                fgType=	(String)parseTree(currentTree.getChild(0));
                fdType=	(String)parseTree(currentTree.getChild(1));
                if(fgType.equals(fdType) && fgType.equals(SemanticParser.TYPE_I32)){
                    return SemanticParser.TYPE_BOOL;
                }else{
                    return 	SemanticParser.TYPE_ERROR;
                }
            case "+":
            case "-":
            case "*":
            case "/":
                SemanticParser.printDebugging("Entrée dans le bloc TESTI32");
                fgType=	(String)parseTree(currentTree.getChild(0));
                fdType=	(String)parseTree(currentTree.getChild(1));
                if(fgType.equals(fdType) && fgType.equals(SemanticParser.TYPE_I32)){
                    return fgType;
                }else{
                    return 	SemanticParser.TYPE_ERROR;
                }
            case "&&":
            case "||":
                SemanticParser.printDebugging("Entrée dans le bloc TESTBOOL");
                fgType=	(String)parseTree(currentTree.getChild(0));
                fdType=	(String)parseTree(currentTree.getChild(1));
                if(fgType.equals(fdType) && fgType.equals(SemanticParser.TYPE_BOOL)){
                    return fgType;
                }else{
                    return 	SemanticParser.TYPE_ERROR;
                }
            case "OPPOSE_BOOL":
                SemanticParser.printDebugging("Entrée dans le bloc OPPOSE_BOOL");
                Symbol opp_bool = getSymbolFromIdf(currentTree.getChild(0).getText());
                if(opp_bool.getType().equals(SemanticParser.TYPE_BOOL)){
                    return SemanticParser.TYPE_BOOL;
                }else{
                    System.out.println(currentTree.getLine()+ " : "+ "Semantic error " + opp_bool.getIdf() + " should be of type bool");
                }
                break;
            case "WHILE":
                SemanticParser.printDebugging("Entrée dans le bloc WHILE");
                test = currentTree.getChild(0); // Tester s'il s'agit bien d'un booléen.
                bloc = currentTree.getChild(1);

                typeTest = (String)this.parseTree(test);

                if(!typeTest.equals(SemanticParser.TYPE_BOOL)) {
                    this.printError(currentTree, "Semantic Error: Invalid predicat in while test");
                }
                this.createNewTDS();
                this.parseTree(bloc);
                break;
            case "IF":
                SemanticParser.printDebugging("Entrée dans le bloc IF");
                test = currentTree.getChild(0); // Tester s'il s'agit bien d'un booléen.
                bloc = currentTree.getChild(1);

                typeTest = (String)this.parseTree(test);

                if(!typeTest.equals(SemanticParser.TYPE_BOOL)) {
                    this.printError(currentTree, "Semantic Error: Invalid predicat in if test");
                }
                this.createNewTDS();
                this.parseTree(bloc);
                // Si un noeud else existe
                if(currentTree.getChildCount()==3){
                    // TODO: noeud else pas encore implemente
                    this.parseTree(currentTree.getChild(2));
                }
                break;
            case "ELSE":
            	this.createNewTDS();
            	this.parseTree(currentTree.getChild(0));
            	break;
            case "RETOUR_BLOC":
                SemanticParser.printDebugging("Entrée dans le bloc RETOUR_BLOC");
                // TODO: peut etre plusieurs childs
                return this.parseTree(currentTree.getChild(0));
            case "PRINT":
                SemanticParser.printDebugging("Entrée dans le bloc PRINT");
                String typeval = (String)this.parseTree(currentTree.getChild(0));
                System.out.println("");
                if(typeval.equals(SemanticParser.TYPE_NULL)) {
                    this.printError(currentTree, "Semantic Error : Undeclared identifier used in print.");
                }
                if(typeval.equals(SemanticParser.TYPE_ERROR)) {
                    this.printError(currentTree, "Semantic Error : unknown value type used in print.");
                }
                break;
            // -----------------------------------------

            //------------------------------------------
            // DEBUT - CAS DES ADDRESSES

            case "PTR_CONTENT_ACCESS":
                //System.out.println(currentTree.getText());
                return getTypeFromPtrAcces(currentTree);

            case "VAR_ADDRESS_ACCESS":
                return SemanticParser.TYPE_ADDR;

            //------------------------------------------

            //------------------------------------------
            // DEBUT - CAS DES STRUCTURES
            // TODO voir en profondeur les pointeurs vers les structures
            case "STRUCT":
                name = currentTree.getChild(0).getText();
                s = getSymbolFromIdf(name);
                //System.out.println("Nom de la struct :" + name);
                if (s != null) {
                    System.out.println("Semantic Error: " + name + "has already been given");
                }else {
                    //Création de la structure
                    Structure struct = new Structure(name);
                    //On ajoute les champs à la structure
                    ArrayList<Var> fields = new ArrayList<>(currentTree.getChildCount()-1);
                    TDS t = this.pileRegionOuvertes.peek();
                    int stackvalue = 0;
                    for (int i = 1; i < currentTree.getChildCount(); i++) {
                        Tree son = currentTree.getChild(i);
                        String idf = son.getChild(0).getText(); //nom du champ
                        String type = son.getChild(1).getText(); //type du champ
                        //Verifions que le nom du champ n'ait pas déjà été donné
                        for (Var field : fields){
                            if (field.getIdf().equals(idf)){
                                printError(son, idf + " - name already given to another field");
                            }
                        }
                        //Verifions le type
                        switch (type) {
                            case SemanticParser.TYPE_VEC:
                                fields.add(new Vec(idf,true));
                                break;
                            case SemanticParser.TYPE_BOOL:
                                fields.add(new BoolVar(idf, true));
                                break;
                            case SemanticParser.TYPE_I32:
                                fields.add(new IntVar(idf, true));
                                break;
                            case SemanticParser.TYPE_ADDR:
                                fields.add(new PtrVar(idf, son.getChild(1).getChild(0).getText(),true ));
                                break;

                            default:
                                //On met le test des structures dans le défaut
                                if (t.containsSymbol(type) instanceof Structure){
                                    StructVar structToAdd = new StructVar(idf, true,type);
                                    structToAdd.setStructure((Structure) t.containsSymbol(type));
                                    fields.add(structToAdd);
                                }
                                else {
                                    System.out.println(son.getLine() + " : Semantic error : " + idf + " : " + type
                                            + " - type not understood\n");
                                }
                                break;
                        }
                        fields.get(i-1).setStackValue(stackvalue);
                        stackvalue += fields.get(i-1).getSize()/2;
                    }
                    struct.addFields(fields);
                    t.addSymbol(struct);
                }
                break;

            case "ACCESS":
                    return getTypeFromAccess(currentTree);

            case "AFF_STRUCT": {
                SemanticParser.printDebugging("Entree dans le bloc AFF_STRUCT");
                boolean mut = false;
                boolean structAccess = false;
                int ini = 2; //Index du premiet STRUCT_ELT
                String idf,type;
                if (currentTree.getChild(0).getText().equals("mut")){
                    idf = currentTree.getChild(1).getChild(0).getText();
                    type = currentTree.getChild(2).getChild(0).getText();
                    ini = 3;
                    mut = true;
                }
                else {
                    idf = currentTree.getChild(0).getChild(0).getText();
                    type = currentTree.getChild(1).getChild(0).getText();
                }

                if (idf.equals("PTR_CONTENT_ACCESS")){
                    return "";
                }

                Symbol symbolType = getSymbolFromIdf(type);
                if (idf.equals("ACCESS")){
                    structAccess = true;
                    Tree structAccessTree;
                    if(mut){
                        structAccessTree = currentTree.getChild(1).getChild(0);
                    }
                    else{
                        structAccessTree = currentTree.getChild(0).getChild(0);
                    }
                    idf = getTypeFromAccess(structAccessTree);
                    if (!idf.equals(type)){
                        this.printError(structAccessTree,idf + " doesn't match type " + type);
                        return "";
                    }
                }
                else {
                    Symbol symbolIdf = getSymbolFromIdf(idf);
                    symbolType = getSymbolFromIdf(type);
                    //Verifier que le type existe et que ce soit une Structure
                    if (symbolType == null) {
                        printError(currentTree, type + " - type doesn't exist");
                        return "";
                    } else {
                        if (!(symbolType instanceof Structure)) {
                            printError(currentTree, type + " - type isn't a Structure");
                            return "";
                        }
                    }
                    //Verifier que idf n'existe pas deja
                    //S'il existe regarder s'il est mutable et s'il est du bon type
                    if (symbolIdf != null) {
                        //Cas d'un symbole variable
                        if (symbolIdf instanceof Var) {
                            //S'il n'est pas mutable
                            if (!(((Var) symbolIdf).getMut())) {
                                printError(currentTree, idf + " - is not mutable");
                                return "";
                            }
                            //S'il n'est pas du bon type
                            if (!(((Var) symbolIdf).getType().equals(type))) {
                                printError(currentTree, idf + " - is mutable but "
                                        + type + " is not the correct type");
                            }
                        }
                        //Cas d'un symbole non variable
                        else {
                            printError(currentTree, idf + " name has already been given ");
                            return "";
                        }
                    }

                }
                //Verifier champ par champ les type

                HashMap<String, Boolean> renseignedFields = new HashMap<>();
                for (Var field : ((Structure) symbolType).getFields()) {
                    renseignedFields.put(field.getIdf(), false);
                }
                for (int i = ini; i < currentTree.getChildCount(); i++) {
                    Tree son = currentTree.getChild(i); //AFF_STRUCT_ELT
                    String field = son.getChild(0).getText();
                    // Champ existant ?
                    if (((Structure) symbolType).getField(field) == null) {
                        printError(son, field + " - nonExistant field");
                        return "";
                    }
                    String left_type = ((Structure) symbolType).getField(field).getType();
                    String right_type = (String) parseTree(son.getChild(1));
                    // Champ déjà écrit ?
                    if (renseignedFields.get(field)) {
                        printError(son, field + " - already written");
                        return "";
                    }
                    // Mauvais type droite et gauche ?
                    if (!(left_type.equals(right_type))) {
                        printError(son, field + " - bad type of right operand");
                        return "";
                    }

                    //Structure non initialisée
                    if (getSymbolFromIdf(son.getChild(1).getText()) instanceof Structure
                        && !son.getChild(2).getText().equals("SS_ACCOLADE")){
                        printError(son.getChild(1), field + " - not initialized");
                    }

                    //SS_ACCOLADE
                    if (son.getChild(2).getText().equals("SS_ACCOLADE")){
                        if (!this.ss_accoladeAnalyze(right_type, son.getChild(2) )){
                            printError(son.getChild(2), field + " - not initialized correctly");
                        }
                    }

                    renseignedFields.remove(field);
                    renseignedFields.put(field, true);
                }
                //Verifier que tous les champs soient renseignés
                for (Boolean b : renseignedFields.values()) {
                    if (!b) {
                        printError(currentTree, idf + " - missingFields");
                        return "";
                    }
                }
                if (!structAccess) {
                    StructVar toAdd = new StructVar(idf, mut, type);
                    TDS t = this.pileRegionOuvertes.peek();
                    toAdd.setStructure((Structure) this.getSymbolFromIdf(type));
                    t.addSymbol(toAdd);
                }
                break;
                }
            //FIN - CAS DES STRUCTURES


			case "OPPOSE":
			    Symbol oppose = getSymbolFromIdf(currentTree.getChild(0).getText());
			    if(oppose.getType().equals(SemanticParser.TYPE_I32)){
			        return SemanticParser.TYPE_I32;
                }else{
			        printError(currentTree,"Semantic error : "+oppose.getIdf()+" should be of type i32.");
                }
				break;
			/*
			case "VAR_ADDRESS_ACCESS":
				break;
			case "PTR_CONTENT_ACCESS":
				break;*/
			case "VEC_DECL":

				Tree parent = currentTree.getParent().getParent();
				name=null;
				String vectype=null;

				for(int i=0 ; i < parent.getChildCount() ; i++){
					if(parent.getChild(i).getText().equals("L_VALUE")){
						name=parent.getChild(i).getChild(0).getText();
						leftIdf= getSymbolFromIdf(name);
						//System.out.println(name);
					}
					if(parent.getChild(i).getText().equals("R_VALUE")){
						vectype=parent.getChild(i).getChild(0).getChild(0).getText();
						//System.out.println(vectype);
					}
				}

				//System.out.println(name);


				s=getSymbolFromIdf(name);
				//System.out.println(currentTree.getParent().getParent().getChild(0));


				if(s != null){
					System.out.println("Semantinc Error" + name + "already used for an other field");
				}else {
                    //Création du vecteur

                    Vec vec = new Vec(name, false);

                    vec.setNumberOfComp(currentTree.getChildCount());

					TDS t = this.pileRegionOuvertes.peek();

                    int stackValue =0;
                    //Set de l'attribut mutable ou non
                    Tree aff = currentTree.getParent().getParent();

                    for(int i=0 ; i<aff.getChildCount() ; i++){
                        if(aff.getChild(i).getText().equals("mut")){
                            vec.setMut(true);
                            //System.out.println(vec.getMut());
                        }

                    }

                    for(int i=0 ; i < currentTree.getChildCount() ; i++){
                        Tree son = currentTree.getChild(i);
                        String idf = son.getChild(0).getText();
                        String type = getTypeFromIdf(idf);

                        if(vec.getComptype()==null){
                            vec.setComptype(type);
                        }

                        switch (type){

                            case SemanticParser.TYPE_BOOL:
                                vec.addComponent(new BoolVar(idf,true));
                                break;

                            case SemanticParser.TYPE_I32:
                                vec.addComponent(new IntVar(idf,true));
                                break;

                            default:
                                if (t.containsSymbol(idf) instanceof Vec){
                                    //System.out.println(getSymbolFromIdf(idf).toString());
                                    Vec vec1= (Vec) getSymbolFromIdf(idf);
                                    vec1.setOwner(vec.toString());
                                    vec.addComponent(vec1);
                                    break;
                                }

                                if(t.containsSymbol(idf) instanceof StructVar){ // à l'intérieur d'un vecteur il ne peut y avoir que des StructVar
                                    //System.out.println(getSymbolFromIdf(idf));
                                    StructVar struct = (StructVar) getSymbolFromIdf(idf);
                                    vec.addComponent(struct);
                                    break;
                                }
                                else{
                                    System.out.println(son.getLine() + " : Semantic error :"
                                            + idf + " : " + type + "type not understood\n");
                                }
                                break;
                        }

                        vec.getComponent(i).setStackValue(stackValue);
                        stackValue += vec.getComponent(i).getSize()/2;

                    }

                    t.addSymbol(vec);
					return SemanticParser.TYPE_VEC_DECL;

                }

				//return null;
				break;

			case "VEC_ELT":

				break;

			case "FUN_CALL":
				/**
				 * 1 - Vérifier que la fonction est bien définie et récupérer son type si elle existe
				 * 2 - Pour chaque argument, vérifier que le type est cohérent avec la signature de la fonction
				 */
				String funname = currentTree.getChild(0).getText();
				Symbol funsymb = this.getSymbolFromIdf(funname);
				if(funsymb == null){
					this.printError(currentTree, "Semantic Error : call to an undeclared function");
				} else {
					if(funsymb instanceof Function){
						Function funs = (Function)funsymb;
						ArrayList<Var> arglist = funs.getParameters();

                        if(arglist.size() != currentTree.getChildCount()-1){
                            this.printError(currentTree, "Semantic Error : invalid number of arguments in function call.");
                        } else {
                            for(int i = 1; i < currentTree.getChildCount(); i++){
                                String type = (String) this.parseTree(currentTree.getChild(i));
                                if(!funs.getParameters().get(i-1).getType().equals(type)){
                                    this.printError(currentTree, "Semantic Error : incompatible type for arg no " + i + " in function call.");
                                }
                            }
                        }
                        return funsymb.getType();
                    }else{
                        this.printError(currentTree, "Semantic Error : use of a non-function idf as a function idf");
                    }
                }
                return null;
            case "RETURN":

            case "FUN_CALL_ELT":
                return this.parseTree(currentTree.getChild(0));

            default:
                SemanticParser.printDebugging("Entrée dans le bloc DEFAULT");
                if(SemanticParser.testIsI32Regex(currentTree.getText())){
                    SemanticParser.printDebugging("Entrée dans le bloc DEFAULT-I32");
                    return SemanticParser.TYPE_I32;
                }else if(currentTree.getText().equals("true") || currentTree.getText().equals("false")){
                    SemanticParser.printDebugging("Entrée dans le bloc DEFAULT-BOOL");
                    return SemanticParser.TYPE_BOOL;
                }else if(SemanticParser.testIsIdfRegex(currentTree.getText())){
                    SemanticParser.printDebugging("Entrée dans le bloc DEFAULT-IDF");
                    // Cas d'un idf seul (si acces a tableau)
                    String returnType= this.getTypeFromIdf(currentTree.getText());
                    if(returnType.equals(SemanticParser.TYPE_NULL))
                        this.printError(currentTree, "Semantic Error: idf referring to undeclared value");
                    return returnType;
                }
        }

        return "";
    }

    // -----------------------------------------------------

    /**
     * Etape 1: pour verifier si la variable est deja declaree ou non
     */
    public String getTypeFromIdf(String idf){
        TDS current;
        String s= SemanticParser.TYPE_NULL;
        // Quand on tombe sur un idf, il faut savoir si elle deja declaree ou non
        // 1: on verifie si elle est deja declaree dans la tds courante
        //    -> si oui elle doit etre mutable et on doit avoir un let sans mut
        // 2: on descend dans la PRO, on regarde si la variable existe
        //    -> si oui elle doit etre mutable et on doit avoir un let sans mut
        for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
            current= this.pileRegionOuvertes.get(i);
            // On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
            Symbol sym = current.containsSymbol(idf);
            if(sym!=null){
                s= sym.getType();
                break;
            }
        }
        return s;
    }

    /***
     * Recupere le type d'un element a partir d'un noeud ACCESS
     * @param access le noeud ACCESS en question
     * @return type du noeud
     */
    private String getTypeFromAccess(Tree access) {
        //System.out.println("TYPE FROM ACCESS");
        String idf = access.getChild(0).getText();
        Tree point_access = access.getChild(1);
        switch (point_access.getText()) {

            case "LENGTH_ACCESS":
                Symbol s = getSymbolFromIdf(access.getChild(0).getText());
                if (s instanceof Vec){
                    return SemanticParser.TYPE_I32;
                }else{
                    this.printError(access.getChild(0),"The subject of a LENGTH_ACCESS must be a vector");
                    return SemanticParser.TYPE_ERROR;
                }

            case "BRACKET_ACCESS":
                //System.out.println(access.getParent().getParent().getChild(0).getChild(0).getText()); //on a un noeud aff où R_VALUE est un BRACKET_ACCESS
                //System.out.println(getSymbolFromIdf(idf).toString());//on a bien l'idf du vecteur
                //System.out.println(access.getChild(1).getChild(0));

                 s = getSymbolFromIdf(idf);
                if(s instanceof Vec){
                    int indice = Integer.parseInt(access.getChild(1).getChild(0).toString());
                    //System.out.println(indice);

                    //System.out.println(access.getChild(1).getChild(0));

                    Var component= ((Vec) s).getComponent(indice);
                    if(component == null){
                        this.printError(point_access,"the indice"+point_access.getChild(0).getText()+"is not reachable");
                        return SemanticParser.TYPE_ERROR;
                    }

                    //System.out.println(component.getType());

                    if(point_access.getChildCount() == 1) {
                        return component.getType();
                    }

                    else{
                        if(component instanceof Vec){
                            return getTypeFromAccess(point_access.getChild(1), (Vec) component);
                        }

                        if(component instanceof StructVar){
                            return getTypeFromAccess(point_access.getChild(1),(StructVar) component);
                        }

                        else{
                            this.printError(point_access, "the component is not a vector");
                            return SemanticParser.TYPE_ERROR;
                        }
                    }

                } else {
                    this.printError(point_access, idf + " must be declared first");
                    return SemanticParser.TYPE_ERROR;
                }

            case "POINT_ACCESS":
                 s = getSymbolFromIdf(getTypeFromIdf(idf));
                if (s instanceof Structure) {
                    Var field = ((Structure) s).getField(point_access.getChild(0).getText());
                    if (field == null) {
                        this.printError(point_access,"the field " + point_access.getChild(0).getText()
                                + " doesn't exist for the structure " + getTypeFromIdf(idf));
                        return SemanticParser.TYPE_ERROR;
                    }
                    //Cas d'un champ normal
                    if (point_access.getChildCount() == 1) {
                        return field.getType();
                    }
                    //Cas d'un point_access imbrique
                    else {
                        if (field instanceof StructVar ){
                            return getTypeFromAccess(point_access.getChild(1), (StructVar) field);
                        }
                        else {
                            this.printError(point_access, " the field isn't a structure.");
                            return SemanticParser.TYPE_ERROR;
                        }
                    }
                } else {
                    this.printError(point_access, idf + " must be declared first");
                    return SemanticParser.TYPE_ERROR;
                }
            default:
                //Cas ou le type d'acces n'est pas implemente
                printError(point_access, point_access.getText() + "is not implemented yet");
                return SemanticParser.TYPE_ERROR;
        }
    }

    /***
     * Recupere le type d'un element a partir d'un noeud ACCESS
     * @param point_access le noeud ACCESS en question
     * @return type du noeud
     */
    private String getTypeFromAccess(Tree point_access, Symbol struct) {
        //System.out.println("TYPE FROM ACCESS");
        String idf = struct.getType();
        switch (point_access.getText()) {
            case "LENGTH_ACCESS":
                Symbol s = getSymbolFromIdf(point_access.getChild(0).getText());
                if (s instanceof Vec){
                    return SemanticParser.TYPE_I32;
                }else{
                    this.printError(point_access.getChild(0),"The subject of a LENGTH_ACCESS must be a vector");
                    return SemanticParser.TYPE_ERROR;
                }


            case "BRACKET_ACCESS":
                //System.out.println(access.getParent().getParent().getChild(0).getChild(0).getText()); on a un noeud aff où R_VALUE est un BRACKET_ACCESS
                //System.out.println(getSymbolFromIdf(idf).toString());//on a bien l'idf du vecteur
                //System.out.println(access.getChild(1).getChild(0));

                s = getSymbolFromIdf(idf);
                if(s instanceof Vec){
                    int indice = Integer.parseInt(point_access.getChild(1).getChild(0).toString());
                    //System.out.println(indice);

                    Var component= ((Vec) s).getComponent(indice);
                    if(component == null){
                        this.printError(point_access,"the indice"+point_access.getChild(0).getText()+"is not reachable");
                        return SemanticParser.TYPE_ERROR;
                    }

                    if(point_access.getChildCount() == 1){
                        return component.getType();
                    }

                    else{
                        if(component instanceof Vec){
                            return getTypeFromAccess(point_access.getChild(1),(Vec) component);
                        }

                        if(component instanceof StructVar){
                            return getTypeFromAccess(point_access.getChild(1),(StructVar) component);
                        }

                        else{
                            this.printError(point_access, "the component is not a vector");
                            return SemanticParser.TYPE_ERROR;
                        }
                    }

                } else {
                    this.printError(point_access, idf + " must be declared first");
                    return SemanticParser.TYPE_ERROR;
                }


            case "POINT_ACCESS":
                 s = getSymbolFromIdf(getTypeFromIdf(idf));
                if (s instanceof Structure) {
                    Var field = ((Structure) s).getField(point_access.getChild(0).getText());
                    if (field == null) {
                        this.printError(point_access,"the field " + point_access.getChild(0).getText()
                                + " doesn't exist for the structure " + getTypeFromIdf(idf));
                        return SemanticParser.TYPE_ERROR;
                    }
                    //Cas d'un champ normal
                    if (point_access.getChildCount() == 1) {
                        return field.getType();
                    }
                    //Cas d'un point_access imbrique
                    else {
                        if (field instanceof StructVar ){
                            return getTypeFromAccess(point_access.getChild(1), (StructVar) field);
                        }
                        else {
                            this.printError(point_access, " the field isn't a structure.");
                            return SemanticParser.TYPE_ERROR;
                        }
                    }
                } else {
                    this.printError(point_access, idf + " must be declared first");
                    return SemanticParser.TYPE_ERROR;
                }
            default:
                //Cas ou le type d'acces n'est pas implemente
                printError(point_access, point_access.getText() + "is not implemented yet");
                return SemanticParser.TYPE_ERROR;
        }
    }



    /**
     * Etape 1: pour verifier si la variable est deja declaree ou non
     */
    public Symbol getSymbolFromIdf(String idf){
        TDS current;
        Symbol s= null;
        for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
            current= this.pileRegionOuvertes.get(i);
            // On regarde si la table des symboles au rang i dans la pile contient le symbole recherche
            s = current.containsSymbol(idf);
            if(s!=null){
                return s;
            }
        }
        return null;
    }

    // TODO: ADAPTER DANS LE CAS OU APPEL A CASE DE TABLEAU
    public Symbol isIdfSymbol(Tree currentTree, boolean recursiveSearch){
        Symbol res= null;
        String possibleIDF= currentTree.getChild(0).getText();
        if(SemanticParser.testIsIdfRegex(possibleIDF)){
            // Dans le cas ou l'idf detecte est un node (par exemple AFF)
            if(currentTree.getChild(0).getChildCount()==0){
                if(recursiveSearch){
                    res= this.getSymbolFromIdf(possibleIDF);
                }else{
                    res= new SymbolUnknownType(possibleIDF);
                }

            }
        }
        return res;
    }

    public static boolean testIsI32Regex(String str) {
        boolean res = false;
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher match = pattern.matcher(str);
        while(match.find()) {
            res = true;
        }

        return res;
    }

    /**
     * Test si un idf est valide et ne correspond pas à un mot clé du langage (if, while, etc...)
     * @param str
     * @return
     */
    public static boolean testIsValidIDFRegex(String str) {
        boolean res = false;
        Pattern pattern = Pattern.compile("^(while|if|else|let|mut|fn|struct|i32|bool|vec|return|print|true|false)$", Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(str);
        while(match.find()) {
            res = true;
        }

        return !res;
    }

    /**
     * Test si un string est bien un idf.
     * @param str
     * @return
     */
    public static boolean testIsIdfRegex(String str) {
        boolean res = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*$");
        Matcher match = pattern.matcher(str);
        while(match.find()) {
            res = true;
        }

        return res;
    }

	/**
	 * Test si le fichier a une fonction Main()
	 * @return
	 */
	public boolean hasMain(Tree currentTree){
		int i;
		TDS tds = this.pileRegionOuvertes.peek();
		ArrayList<Symbol> list = tds.getArrayListSymbols();
		boolean has=false;

		for(i=0;i<list.size();i++){ //Recherche d'une fonction main parmi les symboles de la TDS principale
			Symbol s= list.get(i);
			if (s.getIdf().equals("main")){
				has=true;
			}else{

			}
		}

		if(!has){ // affichage en fonction de la présence ou non de la fonction main
			this.printError(currentTree, "Semantic Error: there is not any reference to a main function.");
		}
		return has;
	}

	public void checkAffectation(Symbol s){

	}

	public void identify(Symbol s){
		TDS current;
		/*for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
			current= this.pileRegionOuvertes.get(i);
			// On regarde si
			if(current.containsSymbol(s)){
				break;
			}
		}*/
	}


	private void createNewTDS() {
		TDS t = new TDS(this.tdsCounter++);
		this.tdsList.add(t);
		this.pileRegionOuvertes.push(t);
	}

	private void unstackTDS() {
		TDS tdsBlocCourant = this.pileRegionOuvertes.pop();
		/*
		 * Pour chaque élément de la TDS courante, il faut regarder dans chaque TDS du dessus si les élements de la TDS
		 * sont linkés à ce symbole et du coup faut set le lien à nul
		 */

		for(int i=this.pileRegionOuvertes.size()-1 ; i>=0; i--){
			TDS current = this.pileRegionOuvertes.get(i);
			Symbol s, symbolcourant;
			for(int j = 0; j < current.getArrayListSymbols().size(); j++) {
				s = current.getArrayListSymbols().get(j);
				if(s instanceof OwnableVar){
					String owner = ((OwnableVar)s).getOwner();
					if(!owner.equals(Symbol.NULL_OWNER)) {
						symbolcourant = tdsBlocCourant.containsSymbol(owner);
						if(symbolcourant != null) {
							((OwnableVar)s).setOwner(Symbol.NULL_OWNER);
						}
					}
				}
			}
		}


		for(int i =0; i < tdsBlocCourant.getArrayListSymbols().size(); i++) {

			if(tdsBlocCourant.getArrayListSymbols().get(i) instanceof OwnableVar)
				((OwnableVar)tdsBlocCourant.getArrayListSymbols().get(i)).setOwner(Symbol.NULL_OWNER);
		}

	}

	public void printError(Tree currentTree, String error){
		System.out.println(error);
		System.out.println("-> error occured at line "+currentTree.getLine());
	}


	public void printTDS() {
		for(TDS t : this.tdsList) {
			System.out.println(t);
		}
	}

    private boolean ss_accoladeAnalyze(String typeIdf, Tree ss_accolade){
        //System.out.println("DEBUT SS_ACCOLADE");
        Symbol symbolType = getSymbolFromIdf(typeIdf);
        HashMap<String, Boolean> renseignedFields = new HashMap<>();
        for (Var field : ((Structure) symbolType).getFields()) {
            renseignedFields.put(field.getIdf(), false);
        }

        //System.out.println("Nombre d'enfants : " + ss_accolade.getChildCount());
        for (int i = 0; i < ss_accolade.getChildCount(); i++) {
            Tree son = ss_accolade.getChild(i); //AFF_STRUCT_ELT
            String field = son.getChild(0).getText();
            // Champ existant ?
            if (((Structure) symbolType).getField(field) == null) {
                printError(son, field + " - nonExistant field");
                return false;
            }
            String left_type = ((Structure) symbolType).getField(field).getType();
            String right_type = (String) parseTree(son.getChild(1));
            // Champ déjà écrit ?
            if (renseignedFields.get(field)) {
                printError(son, field + " - already written");
                return false;
            }
            // Mauvais type droite et gauche ?
            if (!(left_type.equals(right_type))) {
                printError(son, field + " - bad type of right operand");
                return false;
            }

            if (getSymbolFromIdf(son.getChild(1).getText()) instanceof Structure
                    && !son.getChild(2).getText().equals("SS_ACCOLADE")){
                printError(son.getChild(1), field + " - not initialized");
                return false;
            }

            //SS_ACCOLADE
            if (son.getChild(2).getText().equals("SS_ACCOLADE")){
                if (!this.ss_accoladeAnalyze(right_type, son.getChild(2) )){
                    printError(son.getChild(2), field + " - not initialized correctly");
                    return false;
                }
            }
            renseignedFields.remove(field);
            renseignedFields.put(field, true);
        }

        //Verifier que tous les champs soient renseignés
        for (Boolean b : renseignedFields.values()) {
            if (!b) {
                printError(ss_accolade, typeIdf + " - missingFields");
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param tree
     * @return
     */
    private String getTypeFromPtrAcces(Tree tree){
        Tree currentTree = tree;
        int number_of_access = 1;
        String lastPtr = "";
        String beforeLastPtr = "";

        while (currentTree.getChild(0).getText().equals("PTR_CONTENT_ACCESS")){
            currentTree = currentTree.getChild(0);
            number_of_access += 1;
        }
        lastPtr = currentTree.getChild(0).getText();
        if (currentTree.getChild(0).getText().equals("ACCESS")){
            System.out.println("Controle sémantique non posé pour un pointeur dans une structure");
            return SemanticParser.TYPE_I32;
        }
        for (int i=0; i<number_of_access;i++){
            beforeLastPtr = lastPtr;
            lastPtr = ((PtrVar)getSymbolFromIdf(lastPtr)).getPointedVar();
        }
        if (lastPtr == null){ //Dans le cas d'un pointeur ne pointant pas vers une variable
            //System.out.println(beforeLastPtr + ": " + ((PtrVar)getSymbolFromIdf(beforeLastPtr)).getPointedType());
            return ((PtrVar)getSymbolFromIdf(beforeLastPtr)).getPointedType();
        }
        return getSymbolFromIdf(lastPtr).getType();
    }
}
