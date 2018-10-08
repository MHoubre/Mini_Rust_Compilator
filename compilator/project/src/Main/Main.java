package Main;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import Parsers.AssemblyParser;
import Parsers.RUSTWITHRULESLexer;
import Parsers.RUSTWITHRULESParser;
import Parsers.SemanticParser;
import TDSPackage.TDS;
import antlr.ParseTree;

public class Main {
    public static void main(String[] args) throws RecognitionException {
        //System.out.println("File to load: " + args[0]);

        //To load the file use the following code
        
        ANTLRFileStream input = null;
        RUSTWITHRULESLexer lexer;
        CommonTokenStream tokens;
        RUSTWITHRULESParser parser;
        
		try
        {
			/*************************************************************************************/
			// EXEMPLES RUST (doit marcher en assembleur)
			// MARCHE
			// doit afficher +5+385
			input = new ANTLRFileStream("SourceCodeAssemblyExamples/ex1.rs");
			// MARCHE
			// doit afficher +27+120
			//input = new ANTLRFileStream("SourceCodeAssemblyExamples/ex2.rs");
			// MARCHE
			// doit afficher +144
			//input = new ANTLRFileStream("SourceCodeAssemblyExamples/ex3.rs");
			// /!\ NE MARCHE PAS /!\
			//input = new ANTLRFileStream("SourceCodeAssemblyExamples/ex4.rs");
			/*************************************************************************************/
			//DEMO PERSO
			//input = new ANTLRFileStream("sourceCodeToValidate/struct");
			//input = new ANTLRFileStream("sourceCodeToValidate/ptr");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/vec_struct.rs");


			// TEST POUR ASSEMBLEUR (a verifier que ca marche en + des exemples rust) -> pour le moment les 5 marchent
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_1_Complete.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_1_While_test.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_1_Mult_test.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_1_Aff_test.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_5.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_ptr.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Simple_str.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/vec2.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/arg_vec.rs");
			//input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/length.rs");
            //input = new ANTLRFileStream("SourceCodeAssemblyTestsBase/Complicated_str.rs");



			// FICHIERS QUI DOIVENT MARCHER
			//input = new ANTLRFileStream("sourceCodeValidated/ex1Upgraded.rs");
			//input = new ANTLRFileStream("sourceCodeValidated/funCallTest.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/vec.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/return_vec.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/arg_vec.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/vec2.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/bracket.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/bracket_2.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/vec_struct.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/ex3.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/oppose_bool.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/oppose.rs");

			// FICHIER QUI DOIVENT LEVER UNE OU DES ERREURS
			//input = new ANTLRFileStream("sourceCodeDetectedError/test_error_vec.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/test_error_arg_vec.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/test_error_return_vec.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/test_error_oppose_bool.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/test_error_oppose.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/struct_simple.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/testProgWithoutMain.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testError2FunDecl.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorNonMutableAff.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorTypeAff.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorTypeAffExpression.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorIncorrectWhilePredicat.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorIncorrectIfPredicat.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorPrintNull.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorAffectationUndeclaredValue.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorUndeclaredFunction.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorFunCallWithVarIdf.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorFunCallWithoutProperArgNumber.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorFunCallWithoutProperArgTypes.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/testErrorFunCallIncorrectReturnTypeAsReturnBloc.rs");
			//input = new ANTLRFileStream("sourceCodeDetectedError/test_error_fun_struct_notgoodtype.rs");

            //FICHIERS TESTS AURELIEN
            //COOL
            //input = new ANTLRFileStream("sourceCodeValidated/test_cool_struct.rs");
            //input = new ANTLRFileStream("sourceCodeValidated/test_cool_access.rs");
			//input = new ANTLRFileStream("sourceCodeToValidate/ptr_test1.rs");

			//ERREUR
            //input = new ANTLRFileStream("sourceCodeDetectedError/test_error_struct_nonmutaff.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/tets_error_struct_emptyfield.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/test_error_struct_badtype.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/test_error_access_norighttype.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/test_error_access_noexistent.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/test_error_access_noexistentfield.rs");
            //input = new ANTLRFileStream("sourceCodeDetectedError/test_error_struct_recursivestructerror.rs"); //3 lignes fausses !
			//input = new ANTLRFileStream("sourceCodeValidated/funCallStruct.rs");


	        lexer = new RUSTWITHRULESLexer(input);
	        tokens = new CommonTokenStream(lexer);
	        parser = new RUSTWITHRULESParser(tokens);
	        // Analyse Semantique
	        Main.syntaxicAnalysis(parser.fichier());
		}
		catch (IOException e)
        {
            e.printStackTrace();
        }
        

        // If everything is OK while compiling
        System.exit(0);
        // If there is an error
        //System.exit(-1);
    }
    
    public static void syntaxicAnalysis(RUSTWITHRULESParser.fichier_return fr){
    	SemanticParser sp = new SemanticParser();
    	SemanticParser.DEBUGING = false;
    	CommonTree rootTree= (CommonTree )fr.getTree();
    	ArrayList<TDS> tdsList= (ArrayList<TDS>)sp.parseTree(rootTree);
    	sp.hasMain(rootTree);
    	sp.printTDS();
    	AssemblyParser ap= new AssemblyParser(tdsList);
    	ap.getAssemblyCode(rootTree, -1);
    }
}
