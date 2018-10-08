package Parsers;

import TDSPackage.Var;

public class PredefinedAssemblyCode {
	
	public static String CODE_PREDEFINI = "// char *itoa(int i, char *p, int b);\n" + 
			"//\n" + 
			"// i entier à convertir\n" + 
			"// p pointeur du tampon déjà alloué en mémoire où copier la chaîne de caractères\n" + 
			"// b base de numération utilisée (de 2 à 36 inclus car il n'y a que 36 chiffres; par exemple: 2, 4, 8, 10, 16)	\n" + 
			"	\n" + 
			"ITOA_I      equ 4      // offset du paramètre i\n" + 
			"ITOA_P      equ 6      // offset du paramètre p\n" + 
			"ITOA_B      equ 8      // offset du paramètre b\n" + 
			"\n" + 
			"ASCII_MINUS equ 45     // code ASCII de -\n" + 
			"ASCII_PLUS  equ 43     // code ASCII de +\n" + 
			"ASCII_SP    equ 32     // code ASCII d'espace SP\n" + 
			"ASCII_0     equ 48     // code ASCII de zéro (les autres chiffres jusqu'à 9 suivent dans l'ordre)\n" + 
			"ASCII_A     equ 65     // code ASCII de A (les autres lettres jusqu'à Z suivent dans l'ordre alphabétique)\n" + 
			"\n" + 
			"// LNK: crée environnement du main pour permettre des variables locales \n" + 
			"// mais sans encore les réserver\n" + 
			"itoa_   stw BP, -(SP)\n" + 
			"        ldw BP, SP\n" + 
			"\n" + 
			"// récupération des paramètres depuis pile vers registres\n" + 
			"        ldw r0, (BP)ITOA_I    // r0 = i    \n" + 
			"        ldw r1, (BP)ITOA_B    // r1 = b\n" + 
			"        \n" + 
			"// gère le signe: normalement itoa gère des int c'est à dire des entiers signés, \n" + 
			"// mais en fait seulement pour b=10;\n" + 
			"// dans ce cas calcule le signe dans r3 et charge r0 avec la valeur absolue de i\n" + 
			"        ldq ASCII_SP, r3      // code ASCII de espace (SPace) -> r3\n" + 
			"        ldq 10, WR            // 10 -> WR\n" + 
			"        cmp r1, WR            // charge les indicateurs de b - 10\n" + 
			"        bne NOSIGN-$-2        // si non égal (donc si b != 10) saute en NOSIGN, sinon calcule signe\n" + 
			"        ldq ASCII_PLUS, r3    // charge le code ASCII du signe plus + dans r3\n" + 
			"        tst r0                // charge les indicateurs de r0 et donc de i\n" + 
			"        bge POSIT-$-2         // saute en POSIT si i >= 0\n" + 
			"        neg r0, r0            // change le signe de r0\n" + 
			"        ldq ASCII_MINUS, r3   // charge le code ASCII du signe moins - dans r3\n" + 
			"POSIT   NOP                   // r3 = code ASCII de signe: SP pour aucun, - ou +\n" + 
			"\n" + 
			"\n" + 
			"// convertit l'entier i en chiffres et les empile de droite à gauche\n" + 
			"NOSIGN  ldw r2, r0            // r2 <- r0\n" + 
			"CNVLOOP ldw r0, r2            // r0 <- r2\n" + 
			"   \n" + 
			"   // effectue \"créativement\" la division par b supposé pair (car l'instruction div est hélas signée ...)\n" + 
			"   // d=2*d' , D = d * q + r  , D = 2*D'+r\" , D' = d' * q + r' => r = 2*r'+r\"\n" + 
			"   // un bug apparaît avec SRL R0, R0 avec R0 = 2 : met CF à 1 !!\n" + 
			"        srl r1, r1            // r1 = b/2\n" + 
			"        ani r0, r4, #1        // ANd Immédiate entre r0 et 00...01 vers r4:\n" + 
			"                              // bit n°0 de r0 -> r4; r4 = reste\" de r0/2\n" + 
			"        srl r0, r0            // r0 / 2 -> r0\n" + 
			"        div r0, r1, r2        // quotient = r0 / r1 -> r2, reste' = r0 % r1 -> r0\n" + 
			"        shl r0, r0            // r0 = 2 * reste'\n" + 
			"        add r0, r4, r0        // r0 = reste = 2 * reste' + reste\" => r0 = chiffre\n" + 
			"        shl r1, r1            // r1 = b\n" + 
			"\n" + 
			"        adq -10, r0           // chiffre - 10 -> r0 \n" + 
			"        bge LETTER-$-2        // saute en LETTER si chiffre >= 10\n" + 
			"        adq 10+ASCII_0, r0    // ajoute 10 => r0 = chiffre, ajoute code ASCII de 0 \n" + 
			"                              // => r0 = code ASCII de chiffre\n" + 
			"        bmp STKCHR-$-2        // saute en STKCHR \n" + 
			"\n" + 
			"LETTER  adq ASCII_A, r0       // r0 = ASCII(A) pour chiffre = 10, ASCII(B) pour 11 ...\n" + 
			"                              // ajoute code ASCII de A => r = code ASCII de chiffre\n" + 
			"STKCHR  stw r0, -(SP)         // empile code ASCII du chiffre \n" + 
			"                              // (sur un mot complet pour pas désaligner pile)\n" + 
			"        tst r2                // charge les indicateurs en fonction du quotient ds r2)\n" + 
			"        bne CNVLOOP-$-2       // boucle si quotient non nul; sinon sort\n" + 
			"\n" + 
			"// les caractères sont maintenant empilés : gauche en haut et droit en bas\n" + 
			"\n" + 
			"// recopie les caractères dans le tampon dans le bon ordre: de gauche à droite\n" + 
			"        ldw r1, (BP)ITOA_P    // r1 pointe sur le début du tampon déjà alloué \n" + 
			"        stb r3, (r1)+         // copie le signe dans le tampon\n" + 
			"CPYLOOP ldw r0, (SP)+         // dépile code du chiffre gauche (sur un mot) dans r0\n" + 
			"        stb r0, (r1)+         // copie code du chiffre dans un Byte du tampon de gauche à droite\n" + 
			"        cmp SP, BP            // compare SP et sa valeur avant empilement des caractères qui était BP\n" + 
			"        bne CPYLOOP-$-2       // boucle s'il reste au moins un chiffre sur la pile\n" + 
			"        ldq NUL, r0           // charge le code du caractère NUL dans r0\n" + 
			"        stb r0, (r1)+         // sauve code NUL pour terminer la chaîne de caractères\n" + 
			"\n" + 
			"// termine\n" + 
			"        ldw r0, (BP)ITOA_P    // retourne le pointeur sur la chaîne de caractères\n" + 
			"\n" + 
			"    // UNLINK: fermeture de l'environnement de la fonction itoa\n" + 
			"        ldw SP, BP            // SP <- BP : abandonne infos locales; SP pointe sur ancinne valeur de BP\n" + 
			"        ldw BP, (SP)+         // dépile ancienne valeur de BP dans BP; SP pointe sur adresse de retour\n" + 
			"\n" + 
			"        rts                   // retourne au programme appelant\n" + 
			"\n" + 
			"//-----------------------------------------------------------------------------------------------------	\n" + 
			"	\n" + 
			"	\n" + 
			"// void print(char* p)     // imprime le texte pointé par paramètre p	\n" + 
			"	\n" + 
			"print_ STW BP, -(SP)  // empile le contenu du registre BP pour chaine dynamique\n" + 
			"\n" + 
			"	\n" + 
			"	\n" + 
			"	LDW BP, SP     // charge contenu SP dans BP qui est au dessus des sauvegardes de registres\n" + 
			"\n" + 
			"// charge R0 avec le paramètre p de déplacement 4+ taille parametre saved\n" + 
			"	LDW R0, BP // R0 = BP\n" + 
			"	ADQ 4, R0 // R0 pointe sur p (on arrive sur parametre quon a empile avant)\n" + 
			"	LDW R0, (R0) // R0 = p = adresse du début du texte à afficher\n" + 
			"\n" + 
			"// affiche texte pointé par R0\n" + 
			"	TRP #WRITE_EXC // lance trappe n° WRITE_EXC: affiche texte d'adresse R0\n" + 
			"\n" + 
			"// fin de la fonction (épilogue) :\n" + 
			"    // UNLINK \n" + 
			"	LDW SP, BP // charge SP avec contenu de BP: abandon infos locales\n" + 
			"	\n" + 
			"	LDW BP, (SP) // charge BP avec ancien BP\n" + 
			"	ADQ 2, SP // ancien BP supprimé de la pile\n" + 
			"\n" + 
			"	RTS  // retour au programme appelant\n";
	
	
	public static String BEGIN_FN = "	// 		Sauvegarde des registes\n" + 
			"	STW R1, -(SP)	// On sauvegarde R1 en prédécrémentant SP.\n" + 
			"	STW R2, -(SP)\n" + 
			"	STW R3, -(SP)\n" + 
			"	STW R4, -(SP)\n" + 
			"	STW R5, -(SP)\n" + 
			"	STW R6, -(SP)\n" + 
			"	STW R7, -(SP)\n" + 
			"	STW R8, -(SP)\n" + 
			"	STW R9, -(SP)\n" + 
			"	STW R10, -(SP)\n" + 
			"	STW R11, -(SP)\n" + 
			"STW BP, -(SP)  // empile le contenu du registre BP pour chaine dynamique\n" + 
			"\n" + 
			"	LDW BP, SP     // charge contenu SP dans BP qui est au dessus des sauvegardes de registres\n";
	
	
	public static String END_FN = "	LDW SP, BP // charge SP avec contenu de BP: abandon infos locales\n" + 
			"	\n" + 
			"	// 		On rétablit les anciens registres\n" + 
			"	LDW BP, (SP)+ // charge BP avec ancien BP\n" + 
			
			"	LDW R11, (SP)+	// On reprend R11 puis on incrémente le sommet de pile.\n" + 
			"	LDW R10, (SP)+\n" + 
			"	LDW R9, (SP)+\n" + 
			"	LDW R8, (SP)+\n" + 
			"	LDW R7, (SP)+\n" + 
			"	LDW R6, (SP)+\n" + 
			"	LDW R5, (SP)+\n" + 
			"	LDW R4, (SP)+\n" + 
			"	LDW R3, (SP)+\n" + 
			"	LDW R2, (SP)+\n" + 
			"	LDW R1, (SP)+\n";
			
			
	
	// Code subroutine:
	public static String RECURSIVE_IDF_FIND = "findBase_ STW BP, -(SP) // empile le contenu du registre BP pour chaine dynamique\n"
    		+"LDW BP, SP     // charge contenu SP dans BP qui est au dessus des sauvegardes de registres\n"
    		+"LDW R3, (BP)4 // on charge nbStack dans R3\n"
    		+"LDW R4, #0\n"
			+"LDW R6, (BP)\n // on charge l'adresse de la base appellante dans R6\n"
			+"jmp"+AssemblyParser.CURRENTJMPID+" CMP R3, R4 // pour boucler tant que l'on est pas sur la bonne base\n"
			+"JEQ #jmp"+(AssemblyParser.CURRENTJMPID+1)+"-$-2\n"
			+"LDW R5, R6\n"
			+"LDW R6, (R5) // lorsque R3 contiendra 0, R6 contiendra l'adresse de la base de la variable recherchee\n"
			+"ADQ -1, R3\n"
			+"JMP #jmp"+AssemblyParser.CURRENTJMPID+"-$-2\n"
			+"jmp"+(AssemblyParser.CURRENTJMPID+1)+" NOP\n"
			+"// fin de la fonction (�pilogue) :\n"
			+"// UNLINK \n"
			+"LDW SP, BP // charge SP avec contenu de BP: abandon infos locales\n"
			+"LDW BP, (SP) // charge BP avec ancien BP\n"
			+"ADQ 2, SP // ancien BP supprim� de la pile\n"
			+"RTS  // retour au programme appelant\n";
	

}
