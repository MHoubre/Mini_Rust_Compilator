package Parsers;
// $ANTLR 3.3 Nov 30, 2010 12:50:56 RUSTWITHRULES.g 2018-02-27 15:18:38

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class RUSTWITHRULESParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ROOT", "STRUCT", "STRUCT_ELTS", "STRUCT_ELT", "FUN", "FUN_ARGS", "ARG", "TYPE_VEC", "TYPE_ADDR", "BLOC", "EXPR", "RETOUR_BLOC", "AFF", "WHILE", "RETURN", "FUN_CALL", "FUN_CALL_ELT", "AFF_STRUCT", "AFF_STRUCT_ELT", "IF", "ELSE", "VEC_DECL", "VEC_ELT", "PRINT", "EXPR_PARENTHESEE", "POINT_ACCESS", "BRACKET_ACCESS", "LENGTH_ACCESS", "OPPOSE", "PTR_CONTENT_ACCESS", "VAR_ADDRESS_ACCESS", "OPPOSE_BOOL", "AFF_STRUCT_SS_ACCOLADE", "SS_ACCOLADE", "FIN_AFF", "L_VALUE", "R_VALUE", "ACCESS", "IDF", "CSTE_ENT", "WS", "COMMENT", "'struct'", "'{'", "':'", "','", "'}'", "'fn'", "'('", "')'", "'->'", "'&'", "'i32'", "'bool'", "'vec'", "'<'", "'>'", "';'", "'let'", "'mut'", "'='", "'while'", "'return'", "'if'", "'else'", "'print'", "'!'", "'['", "']'", "'||'", "'.'", "'len'", "'-'", "'*'", "'&&'", "'=='", "'!='", "'<='", "'>='", "'+'", "'/'", "'true'", "'false'"
    };
    public static final int EOF=-1;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int ROOT=4;
    public static final int STRUCT=5;
    public static final int STRUCT_ELTS=6;
    public static final int STRUCT_ELT=7;
    public static final int FUN=8;
    public static final int FUN_ARGS=9;
    public static final int ARG=10;
    public static final int TYPE_VEC=11;
    public static final int TYPE_ADDR=12;
    public static final int BLOC=13;
    public static final int EXPR=14;
    public static final int RETOUR_BLOC=15;
    public static final int AFF=16;
    public static final int WHILE=17;
    public static final int RETURN=18;
    public static final int FUN_CALL=19;
    public static final int FUN_CALL_ELT=20;
    public static final int AFF_STRUCT=21;
    public static final int AFF_STRUCT_ELT=22;
    public static final int IF=23;
    public static final int ELSE=24;
    public static final int VEC_DECL=25;
    public static final int VEC_ELT=26;
    public static final int PRINT=27;
    public static final int EXPR_PARENTHESEE=28;
    public static final int POINT_ACCESS=29;
    public static final int BRACKET_ACCESS=30;
    public static final int LENGTH_ACCESS=31;
    public static final int OPPOSE=32;
    public static final int PTR_CONTENT_ACCESS=33;
    public static final int VAR_ADDRESS_ACCESS=34;
    public static final int OPPOSE_BOOL=35;
    public static final int AFF_STRUCT_SS_ACCOLADE=36;
    public static final int SS_ACCOLADE=37;
    public static final int FIN_AFF=38;
    public static final int L_VALUE=39;
    public static final int R_VALUE=40;
    public static final int ACCESS=41;
    public static final int IDF=42;
    public static final int CSTE_ENT=43;
    public static final int WS=44;
    public static final int COMMENT=45;

    // delegates
    // delegators


        public RUSTWITHRULESParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public RUSTWITHRULESParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return RUSTWITHRULESParser.tokenNames; }
    public String getGrammarFileName() { return "RUSTWITHRULES.g"; }


    public static class fichier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fichier"
    // RUSTWITHRULES.g:52:1: fichier : ( decl )* -> ^( ROOT ( decl )* ) ;
    public final RUSTWITHRULESParser.fichier_return fichier() throws RecognitionException {
        RUSTWITHRULESParser.fichier_return retval = new RUSTWITHRULESParser.fichier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RUSTWITHRULESParser.decl_return decl1 = null;


        RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");
        try {
            // RUSTWITHRULES.g:52:9: ( ( decl )* -> ^( ROOT ( decl )* ) )
            // RUSTWITHRULES.g:52:11: ( decl )*
            {
            // RUSTWITHRULES.g:52:11: ( decl )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==46||LA1_0==51) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // RUSTWITHRULES.g:52:11: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_fichier195);
            	    decl1=decl();

            	    state._fsp--;

            	    stream_decl.add(decl1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);



            // AST REWRITE
            // elements: decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 52:18: -> ^( ROOT ( decl )* )
            {
                // RUSTWITHRULES.g:52:21: ^( ROOT ( decl )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ROOT, "ROOT"), root_1);

                // RUSTWITHRULES.g:52:28: ( decl )*
                while ( stream_decl.hasNext() ) {
                    adaptor.addChild(root_1, stream_decl.nextTree());

                }
                stream_decl.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fichier"

    public static class decl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decl"
    // RUSTWITHRULES.g:55:1: decl : ( decl_struct | decl_fun );
    public final RUSTWITHRULESParser.decl_return decl() throws RecognitionException {
        RUSTWITHRULESParser.decl_return retval = new RUSTWITHRULESParser.decl_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RUSTWITHRULESParser.decl_struct_return decl_struct2 = null;

        RUSTWITHRULESParser.decl_fun_return decl_fun3 = null;



        try {
            // RUSTWITHRULES.g:55:7: ( decl_struct | decl_fun )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==46) ) {
                alt2=1;
            }
            else if ( (LA2_0==51) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // RUSTWITHRULES.g:55:9: decl_struct
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decl_struct_in_decl219);
                    decl_struct2=decl_struct();

                    state._fsp--;

                    adaptor.addChild(root_0, decl_struct2.getTree());

                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:56:4: decl_fun
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_decl_fun_in_decl224);
                    decl_fun3=decl_fun();

                    state._fsp--;

                    adaptor.addChild(root_0, decl_fun3.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decl"

    public static class decl_struct_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decl_struct"
    // RUSTWITHRULES.g:58:1: decl_struct : ( 'struct' IDF -> IDF ) ( '{' ( IDF ':' type ( ',' IDF ':' type )* )? '}' -> ^( STRUCT $decl_struct ( ^( STRUCT_ELT IDF type ) )* ) ) ;
    public final RUSTWITHRULESParser.decl_struct_return decl_struct() throws RecognitionException {
        RUSTWITHRULESParser.decl_struct_return retval = new RUSTWITHRULESParser.decl_struct_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal4=null;
        Token IDF5=null;
        Token char_literal6=null;
        Token IDF7=null;
        Token char_literal8=null;
        Token char_literal10=null;
        Token IDF11=null;
        Token char_literal12=null;
        Token char_literal14=null;
        RUSTWITHRULESParser.type_return type9 = null;

        RUSTWITHRULESParser.type_return type13 = null;


        Object string_literal4_tree=null;
        Object IDF5_tree=null;
        Object char_literal6_tree=null;
        Object IDF7_tree=null;
        Object char_literal8_tree=null;
        Object char_literal10_tree=null;
        Object IDF11_tree=null;
        Object char_literal12_tree=null;
        Object char_literal14_tree=null;
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // RUSTWITHRULES.g:59:2: ( ( 'struct' IDF -> IDF ) ( '{' ( IDF ':' type ( ',' IDF ':' type )* )? '}' -> ^( STRUCT $decl_struct ( ^( STRUCT_ELT IDF type ) )* ) ) )
            // RUSTWITHRULES.g:59:4: ( 'struct' IDF -> IDF ) ( '{' ( IDF ':' type ( ',' IDF ':' type )* )? '}' -> ^( STRUCT $decl_struct ( ^( STRUCT_ELT IDF type ) )* ) )
            {
            // RUSTWITHRULES.g:59:4: ( 'struct' IDF -> IDF )
            // RUSTWITHRULES.g:59:5: 'struct' IDF
            {
            string_literal4=(Token)match(input,46,FOLLOW_46_in_decl_struct237);  
            stream_46.add(string_literal4);

            IDF5=(Token)match(input,IDF,FOLLOW_IDF_in_decl_struct239);  
            stream_IDF.add(IDF5);



            // AST REWRITE
            // elements: IDF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 59:18: -> IDF
            {
                adaptor.addChild(root_0, stream_IDF.nextNode());

            }

            retval.tree = root_0;
            }

            // RUSTWITHRULES.g:59:26: ( '{' ( IDF ':' type ( ',' IDF ':' type )* )? '}' -> ^( STRUCT $decl_struct ( ^( STRUCT_ELT IDF type ) )* ) )
            // RUSTWITHRULES.g:59:29: '{' ( IDF ':' type ( ',' IDF ':' type )* )? '}'
            {
            char_literal6=(Token)match(input,47,FOLLOW_47_in_decl_struct249);  
            stream_47.add(char_literal6);

            // RUSTWITHRULES.g:59:33: ( IDF ':' type ( ',' IDF ':' type )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDF) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // RUSTWITHRULES.g:59:34: IDF ':' type ( ',' IDF ':' type )*
                    {
                    IDF7=(Token)match(input,IDF,FOLLOW_IDF_in_decl_struct252);  
                    stream_IDF.add(IDF7);

                    char_literal8=(Token)match(input,48,FOLLOW_48_in_decl_struct254);  
                    stream_48.add(char_literal8);

                    pushFollow(FOLLOW_type_in_decl_struct256);
                    type9=type();

                    state._fsp--;

                    stream_type.add(type9.getTree());
                    // RUSTWITHRULES.g:59:47: ( ',' IDF ':' type )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==49) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // RUSTWITHRULES.g:59:48: ',' IDF ':' type
                    	    {
                    	    char_literal10=(Token)match(input,49,FOLLOW_49_in_decl_struct259);  
                    	    stream_49.add(char_literal10);

                    	    IDF11=(Token)match(input,IDF,FOLLOW_IDF_in_decl_struct261);  
                    	    stream_IDF.add(IDF11);

                    	    char_literal12=(Token)match(input,48,FOLLOW_48_in_decl_struct263);  
                    	    stream_48.add(char_literal12);

                    	    pushFollow(FOLLOW_type_in_decl_struct265);
                    	    type13=type();

                    	    state._fsp--;

                    	    stream_type.add(type13.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal14=(Token)match(input,50,FOLLOW_50_in_decl_struct271);  
            stream_50.add(char_literal14);



            // AST REWRITE
            // elements: decl_struct, type, IDF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 59:73: -> ^( STRUCT $decl_struct ( ^( STRUCT_ELT IDF type ) )* )
            {
                // RUSTWITHRULES.g:59:76: ^( STRUCT $decl_struct ( ^( STRUCT_ELT IDF type ) )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT, "STRUCT"), root_1);

                adaptor.addChild(root_1, stream_retval.nextTree());
                // RUSTWITHRULES.g:59:99: ( ^( STRUCT_ELT IDF type ) )*
                while ( stream_type.hasNext()||stream_IDF.hasNext() ) {
                    // RUSTWITHRULES.g:59:99: ^( STRUCT_ELT IDF type )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRUCT_ELT, "STRUCT_ELT"), root_2);

                    adaptor.addChild(root_2, stream_IDF.nextNode());
                    adaptor.addChild(root_2, stream_type.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_type.reset();
                stream_IDF.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decl_struct"

    public static class decl_fun_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decl_fun"
    // RUSTWITHRULES.g:62:1: decl_fun : 'fn' IDF '(' ( argument ( ',' argument )* )? ')' ( '->' type )? bloc -> ^( FUN IDF ^( FUN_ARGS ( argument )* ) ( type )? bloc ) ;
    public final RUSTWITHRULESParser.decl_fun_return decl_fun() throws RecognitionException {
        RUSTWITHRULESParser.decl_fun_return retval = new RUSTWITHRULESParser.decl_fun_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal15=null;
        Token IDF16=null;
        Token char_literal17=null;
        Token char_literal19=null;
        Token char_literal21=null;
        Token string_literal22=null;
        RUSTWITHRULESParser.argument_return argument18 = null;

        RUSTWITHRULESParser.argument_return argument20 = null;

        RUSTWITHRULESParser.type_return type23 = null;

        RUSTWITHRULESParser.bloc_return bloc24 = null;


        Object string_literal15_tree=null;
        Object IDF16_tree=null;
        Object char_literal17_tree=null;
        Object char_literal19_tree=null;
        Object char_literal21_tree=null;
        Object string_literal22_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // RUSTWITHRULES.g:62:9: ( 'fn' IDF '(' ( argument ( ',' argument )* )? ')' ( '->' type )? bloc -> ^( FUN IDF ^( FUN_ARGS ( argument )* ) ( type )? bloc ) )
            // RUSTWITHRULES.g:62:11: 'fn' IDF '(' ( argument ( ',' argument )* )? ')' ( '->' type )? bloc
            {
            string_literal15=(Token)match(input,51,FOLLOW_51_in_decl_fun305);  
            stream_51.add(string_literal15);

            IDF16=(Token)match(input,IDF,FOLLOW_IDF_in_decl_fun307);  
            stream_IDF.add(IDF16);

            char_literal17=(Token)match(input,52,FOLLOW_52_in_decl_fun309);  
            stream_52.add(char_literal17);

            // RUSTWITHRULES.g:62:24: ( argument ( ',' argument )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==IDF) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // RUSTWITHRULES.g:62:26: argument ( ',' argument )*
                    {
                    pushFollow(FOLLOW_argument_in_decl_fun313);
                    argument18=argument();

                    state._fsp--;

                    stream_argument.add(argument18.getTree());
                    // RUSTWITHRULES.g:62:35: ( ',' argument )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==49) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // RUSTWITHRULES.g:62:37: ',' argument
                    	    {
                    	    char_literal19=(Token)match(input,49,FOLLOW_49_in_decl_fun317);  
                    	    stream_49.add(char_literal19);

                    	    pushFollow(FOLLOW_argument_in_decl_fun319);
                    	    argument20=argument();

                    	    state._fsp--;

                    	    stream_argument.add(argument20.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal21=(Token)match(input,53,FOLLOW_53_in_decl_fun326);  
            stream_53.add(char_literal21);

            // RUSTWITHRULES.g:62:59: ( '->' type )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==54) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // RUSTWITHRULES.g:62:60: '->' type
                    {
                    string_literal22=(Token)match(input,54,FOLLOW_54_in_decl_fun329);  
                    stream_54.add(string_literal22);

                    pushFollow(FOLLOW_type_in_decl_fun331);
                    type23=type();

                    state._fsp--;

                    stream_type.add(type23.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_bloc_in_decl_fun335);
            bloc24=bloc();

            state._fsp--;

            stream_bloc.add(bloc24.getTree());


            // AST REWRITE
            // elements: IDF, type, bloc, argument
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 62:77: -> ^( FUN IDF ^( FUN_ARGS ( argument )* ) ( type )? bloc )
            {
                // RUSTWITHRULES.g:62:80: ^( FUN IDF ^( FUN_ARGS ( argument )* ) ( type )? bloc )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUN, "FUN"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                // RUSTWITHRULES.g:62:90: ^( FUN_ARGS ( argument )* )
                {
                Object root_2 = (Object)adaptor.nil();
                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUN_ARGS, "FUN_ARGS"), root_2);

                // RUSTWITHRULES.g:62:101: ( argument )*
                while ( stream_argument.hasNext() ) {
                    adaptor.addChild(root_2, stream_argument.nextTree());

                }
                stream_argument.reset();

                adaptor.addChild(root_1, root_2);
                }
                // RUSTWITHRULES.g:62:112: ( type )?
                if ( stream_type.hasNext() ) {
                    adaptor.addChild(root_1, stream_type.nextTree());

                }
                stream_type.reset();
                adaptor.addChild(root_1, stream_bloc.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decl_fun"

    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type"
    // RUSTWITHRULES.g:65:1: type : ( IDF | '&' type -> ^( TYPE_ADDR type ) | 'i32' | 'bool' | 'vec' '<' type '>' -> ^( TYPE_VEC type ) );
    public final RUSTWITHRULESParser.type_return type() throws RecognitionException {
        RUSTWITHRULESParser.type_return retval = new RUSTWITHRULESParser.type_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDF25=null;
        Token char_literal26=null;
        Token string_literal28=null;
        Token string_literal29=null;
        Token string_literal30=null;
        Token char_literal31=null;
        Token char_literal33=null;
        RUSTWITHRULESParser.type_return type27 = null;

        RUSTWITHRULESParser.type_return type32 = null;


        Object IDF25_tree=null;
        Object char_literal26_tree=null;
        Object string_literal28_tree=null;
        Object string_literal29_tree=null;
        Object string_literal30_tree=null;
        Object char_literal31_tree=null;
        Object char_literal33_tree=null;
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // RUSTWITHRULES.g:65:6: ( IDF | '&' type -> ^( TYPE_ADDR type ) | 'i32' | 'bool' | 'vec' '<' type '>' -> ^( TYPE_VEC type ) )
            int alt8=5;
            switch ( input.LA(1) ) {
            case IDF:
                {
                alt8=1;
                }
                break;
            case 55:
                {
                alt8=2;
                }
                break;
            case 56:
                {
                alt8=3;
                }
                break;
            case 57:
                {
                alt8=4;
                }
                break;
            case 58:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // RUSTWITHRULES.g:65:12: IDF
                    {
                    root_0 = (Object)adaptor.nil();

                    IDF25=(Token)match(input,IDF,FOLLOW_IDF_in_type369); 
                    IDF25_tree = (Object)adaptor.create(IDF25);
                    adaptor.addChild(root_0, IDF25_tree);


                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:66:5: '&' type
                    {
                    char_literal26=(Token)match(input,55,FOLLOW_55_in_type375);  
                    stream_55.add(char_literal26);

                    pushFollow(FOLLOW_type_in_type377);
                    type27=type();

                    state._fsp--;

                    stream_type.add(type27.getTree());


                    // AST REWRITE
                    // elements: type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 66:14: -> ^( TYPE_ADDR type )
                    {
                        // RUSTWITHRULES.g:66:17: ^( TYPE_ADDR type )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPE_ADDR, "TYPE_ADDR"), root_1);

                        adaptor.addChild(root_1, stream_type.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // RUSTWITHRULES.g:67:5: 'i32'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal28=(Token)match(input,56,FOLLOW_56_in_type391); 
                    string_literal28_tree = (Object)adaptor.create(string_literal28);
                    adaptor.addChild(root_0, string_literal28_tree);


                    }
                    break;
                case 4 :
                    // RUSTWITHRULES.g:68:5: 'bool'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal29=(Token)match(input,57,FOLLOW_57_in_type397); 
                    string_literal29_tree = (Object)adaptor.create(string_literal29);
                    adaptor.addChild(root_0, string_literal29_tree);


                    }
                    break;
                case 5 :
                    // RUSTWITHRULES.g:69:12: 'vec' '<' type '>'
                    {
                    string_literal30=(Token)match(input,58,FOLLOW_58_in_type410);  
                    stream_58.add(string_literal30);

                    char_literal31=(Token)match(input,59,FOLLOW_59_in_type412);  
                    stream_59.add(char_literal31);

                    pushFollow(FOLLOW_type_in_type414);
                    type32=type();

                    state._fsp--;

                    stream_type.add(type32.getTree());
                    char_literal33=(Token)match(input,60,FOLLOW_60_in_type416);  
                    stream_60.add(char_literal33);



                    // AST REWRITE
                    // elements: type
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 69:31: -> ^( TYPE_VEC type )
                    {
                        // RUSTWITHRULES.g:69:34: ^( TYPE_VEC type )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPE_VEC, "TYPE_VEC"), root_1);

                        adaptor.addChild(root_1, stream_type.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class argument_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // RUSTWITHRULES.g:72:1: argument : IDF ':' type -> ^( ARG IDF type ) ;
    public final RUSTWITHRULESParser.argument_return argument() throws RecognitionException {
        RUSTWITHRULESParser.argument_return retval = new RUSTWITHRULESParser.argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token IDF34=null;
        Token char_literal35=null;
        RUSTWITHRULESParser.type_return type36 = null;


        Object IDF34_tree=null;
        Object char_literal35_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // RUSTWITHRULES.g:73:2: ( IDF ':' type -> ^( ARG IDF type ) )
            // RUSTWITHRULES.g:73:4: IDF ':' type
            {
            IDF34=(Token)match(input,IDF,FOLLOW_IDF_in_argument437);  
            stream_IDF.add(IDF34);

            char_literal35=(Token)match(input,48,FOLLOW_48_in_argument439);  
            stream_48.add(char_literal35);

            pushFollow(FOLLOW_type_in_argument441);
            type36=type();

            state._fsp--;

            stream_type.add(type36.getTree());


            // AST REWRITE
            // elements: IDF, type
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 73:17: -> ^( ARG IDF type )
            {
                // RUSTWITHRULES.g:73:20: ^( ARG IDF type )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARG, "ARG"), root_1);

                adaptor.addChild(root_1, stream_IDF.nextNode());
                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argument"

    public static class bloc_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bloc"
    // RUSTWITHRULES.g:76:1: bloc : '{' ( instruction )? '}' -> ^( BLOC ( instruction )? ) ;
    public final RUSTWITHRULESParser.bloc_return bloc() throws RecognitionException {
        RUSTWITHRULESParser.bloc_return retval = new RUSTWITHRULESParser.bloc_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal37=null;
        Token char_literal39=null;
        RUSTWITHRULESParser.instruction_return instruction38 = null;


        Object char_literal37_tree=null;
        Object char_literal39_tree=null;
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_instruction=new RewriteRuleSubtreeStream(adaptor,"rule instruction");
        try {
            // RUSTWITHRULES.g:77:2: ( '{' ( instruction )? '}' -> ^( BLOC ( instruction )? ) )
            // RUSTWITHRULES.g:77:4: '{' ( instruction )? '}'
            {
            char_literal37=(Token)match(input,47,FOLLOW_47_in_bloc464);  
            stream_47.add(char_literal37);

            // RUSTWITHRULES.g:77:8: ( instruction )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=IDF && LA9_0<=CSTE_ENT)||LA9_0==47||LA9_0==52||LA9_0==55||LA9_0==58||(LA9_0>=61 && LA9_0<=62)||(LA9_0>=65 && LA9_0<=67)||(LA9_0>=69 && LA9_0<=70)||(LA9_0>=76 && LA9_0<=77)||(LA9_0>=85 && LA9_0<=86)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // RUSTWITHRULES.g:77:8: instruction
                    {
                    pushFollow(FOLLOW_instruction_in_bloc466);
                    instruction38=instruction();

                    state._fsp--;

                    stream_instruction.add(instruction38.getTree());

                    }
                    break;

            }

            char_literal39=(Token)match(input,50,FOLLOW_50_in_bloc469);  
            stream_50.add(char_literal39);



            // AST REWRITE
            // elements: instruction
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 77:25: -> ^( BLOC ( instruction )? )
            {
                // RUSTWITHRULES.g:77:28: ^( BLOC ( instruction )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BLOC, "BLOC"), root_1);

                // RUSTWITHRULES.g:77:35: ( instruction )?
                if ( stream_instruction.hasNext() ) {
                    adaptor.addChild(root_1, stream_instruction.nextTree());

                }
                stream_instruction.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bloc"

    public static class instruction_inter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instruction_inter"
    // RUSTWITHRULES.g:80:1: instruction_inter : instruction ;
    public final RUSTWITHRULESParser.instruction_inter_return instruction_inter() throws RecognitionException {
        RUSTWITHRULESParser.instruction_inter_return retval = new RUSTWITHRULESParser.instruction_inter_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RUSTWITHRULESParser.instruction_return instruction40 = null;



        try {
            // RUSTWITHRULES.g:81:2: ( instruction )
            // RUSTWITHRULES.g:81:4: instruction
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_instruction_in_instruction_inter490);
            instruction40=instruction();

            state._fsp--;

            adaptor.addChild(root_0, instruction40.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instruction_inter"

    public static class instruction_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "instruction"
    // RUSTWITHRULES.g:84:1: instruction : ( ';' ( instruction_inter )? -> ( instruction_inter )? | expr ( -> ^( RETOUR_BLOC expr ) | ( ';' ( instruction_inter )? ) -> expr ( instruction_inter )? ) | ( 'let' ( 'mut' )? name= expr '=' res= expr -> ^( L_VALUE $name) ^( R_VALUE $res) ) ( ';' ( instruction_inter )? -> ^( AFF ( 'mut' )? $instruction) ( instruction_inter )? | accolade ( expr_prime )? ';' ( instruction_inter )? -> ^( AFF_STRUCT ( 'mut' )? $instruction accolade ) ( expr_prime )? ( instruction_inter )? ) | 'while' expr bloc ( instruction_inter )? -> ^( WHILE expr bloc ) ( instruction_inter )? | 'return' ( expr )? ';' ( instruction_inter )? -> ^( RETURN ( expr )? ) ( instruction_inter )? | if_expr ( instruction_inter )? );
    public final RUSTWITHRULESParser.instruction_return instruction() throws RecognitionException {
        RUSTWITHRULESParser.instruction_return retval = new RUSTWITHRULESParser.instruction_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal41=null;
        Token char_literal44=null;
        Token string_literal46=null;
        Token string_literal47=null;
        Token char_literal48=null;
        Token char_literal49=null;
        Token char_literal53=null;
        Token string_literal55=null;
        Token string_literal59=null;
        Token char_literal61=null;
        RUSTWITHRULESParser.expr_return name = null;

        RUSTWITHRULESParser.expr_return res = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter42 = null;

        RUSTWITHRULESParser.expr_return expr43 = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter45 = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter50 = null;

        RUSTWITHRULESParser.accolade_return accolade51 = null;

        RUSTWITHRULESParser.expr_prime_return expr_prime52 = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter54 = null;

        RUSTWITHRULESParser.expr_return expr56 = null;

        RUSTWITHRULESParser.bloc_return bloc57 = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter58 = null;

        RUSTWITHRULESParser.expr_return expr60 = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter62 = null;

        RUSTWITHRULESParser.if_expr_return if_expr63 = null;

        RUSTWITHRULESParser.instruction_inter_return instruction_inter64 = null;


        Object char_literal41_tree=null;
        Object char_literal44_tree=null;
        Object string_literal46_tree=null;
        Object string_literal47_tree=null;
        Object char_literal48_tree=null;
        Object char_literal49_tree=null;
        Object char_literal53_tree=null;
        Object string_literal55_tree=null;
        Object string_literal59_tree=null;
        Object char_literal61_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
        RewriteRuleSubtreeStream stream_expr_prime=new RewriteRuleSubtreeStream(adaptor,"rule expr_prime");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_accolade=new RewriteRuleSubtreeStream(adaptor,"rule accolade");
        RewriteRuleSubtreeStream stream_instruction_inter=new RewriteRuleSubtreeStream(adaptor,"rule instruction_inter");
        try {
            // RUSTWITHRULES.g:85:2: ( ';' ( instruction_inter )? -> ( instruction_inter )? | expr ( -> ^( RETOUR_BLOC expr ) | ( ';' ( instruction_inter )? ) -> expr ( instruction_inter )? ) | ( 'let' ( 'mut' )? name= expr '=' res= expr -> ^( L_VALUE $name) ^( R_VALUE $res) ) ( ';' ( instruction_inter )? -> ^( AFF ( 'mut' )? $instruction) ( instruction_inter )? | accolade ( expr_prime )? ';' ( instruction_inter )? -> ^( AFF_STRUCT ( 'mut' )? $instruction accolade ) ( expr_prime )? ( instruction_inter )? ) | 'while' expr bloc ( instruction_inter )? -> ^( WHILE expr bloc ) ( instruction_inter )? | 'return' ( expr )? ';' ( instruction_inter )? -> ^( RETURN ( expr )? ) ( instruction_inter )? | if_expr ( instruction_inter )? )
            int alt22=6;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt22=1;
                }
                break;
            case IDF:
            case CSTE_ENT:
            case 47:
            case 52:
            case 55:
            case 58:
            case 69:
            case 70:
            case 76:
            case 77:
            case 85:
            case 86:
                {
                alt22=2;
                }
                break;
            case 62:
                {
                alt22=3;
                }
                break;
            case 65:
                {
                alt22=4;
                }
                break;
            case 66:
                {
                alt22=5;
                }
                break;
            case 67:
                {
                alt22=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // RUSTWITHRULES.g:85:4: ';' ( instruction_inter )?
                    {
                    char_literal41=(Token)match(input,61,FOLLOW_61_in_instruction504);  
                    stream_61.add(char_literal41);

                    // RUSTWITHRULES.g:85:8: ( instruction_inter )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( ((LA10_0>=IDF && LA10_0<=CSTE_ENT)||LA10_0==47||LA10_0==52||LA10_0==55||LA10_0==58||(LA10_0>=61 && LA10_0<=62)||(LA10_0>=65 && LA10_0<=67)||(LA10_0>=69 && LA10_0<=70)||(LA10_0>=76 && LA10_0<=77)||(LA10_0>=85 && LA10_0<=86)) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // RUSTWITHRULES.g:85:8: instruction_inter
                            {
                            pushFollow(FOLLOW_instruction_inter_in_instruction506);
                            instruction_inter42=instruction_inter();

                            state._fsp--;

                            stream_instruction_inter.add(instruction_inter42.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: instruction_inter
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:27: -> ( instruction_inter )?
                    {
                        // RUSTWITHRULES.g:85:30: ( instruction_inter )?
                        if ( stream_instruction_inter.hasNext() ) {
                            adaptor.addChild(root_0, stream_instruction_inter.nextTree());

                        }
                        stream_instruction_inter.reset();

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:86:5: expr ( -> ^( RETOUR_BLOC expr ) | ( ';' ( instruction_inter )? ) -> expr ( instruction_inter )? )
                    {
                    pushFollow(FOLLOW_expr_in_instruction518);
                    expr43=expr();

                    state._fsp--;

                    stream_expr.add(expr43.getTree());
                    // RUSTWITHRULES.g:86:10: ( -> ^( RETOUR_BLOC expr ) | ( ';' ( instruction_inter )? ) -> expr ( instruction_inter )? )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==50) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==61) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // RUSTWITHRULES.g:86:12: 
                            {

                            // AST REWRITE
                            // elements: expr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 86:12: -> ^( RETOUR_BLOC expr )
                            {
                                // RUSTWITHRULES.g:86:15: ^( RETOUR_BLOC expr )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETOUR_BLOC, "RETOUR_BLOC"), root_1);

                                adaptor.addChild(root_1, stream_expr.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 2 :
                            // RUSTWITHRULES.g:86:37: ( ';' ( instruction_inter )? )
                            {
                            // RUSTWITHRULES.g:86:37: ( ';' ( instruction_inter )? )
                            // RUSTWITHRULES.g:86:38: ';' ( instruction_inter )?
                            {
                            char_literal44=(Token)match(input,61,FOLLOW_61_in_instruction533);  
                            stream_61.add(char_literal44);

                            // RUSTWITHRULES.g:86:42: ( instruction_inter )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( ((LA11_0>=IDF && LA11_0<=CSTE_ENT)||LA11_0==47||LA11_0==52||LA11_0==55||LA11_0==58||(LA11_0>=61 && LA11_0<=62)||(LA11_0>=65 && LA11_0<=67)||(LA11_0>=69 && LA11_0<=70)||(LA11_0>=76 && LA11_0<=77)||(LA11_0>=85 && LA11_0<=86)) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // RUSTWITHRULES.g:86:42: instruction_inter
                                    {
                                    pushFollow(FOLLOW_instruction_inter_in_instruction535);
                                    instruction_inter45=instruction_inter();

                                    state._fsp--;

                                    stream_instruction_inter.add(instruction_inter45.getTree());

                                    }
                                    break;

                            }


                            }



                            // AST REWRITE
                            // elements: instruction_inter, expr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 86:62: -> expr ( instruction_inter )?
                            {
                                adaptor.addChild(root_0, stream_expr.nextTree());
                                // RUSTWITHRULES.g:86:70: ( instruction_inter )?
                                if ( stream_instruction_inter.hasNext() ) {
                                    adaptor.addChild(root_0, stream_instruction_inter.nextTree());

                                }
                                stream_instruction_inter.reset();

                            }

                            retval.tree = root_0;
                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // RUSTWITHRULES.g:88:4: ( 'let' ( 'mut' )? name= expr '=' res= expr -> ^( L_VALUE $name) ^( R_VALUE $res) ) ( ';' ( instruction_inter )? -> ^( AFF ( 'mut' )? $instruction) ( instruction_inter )? | accolade ( expr_prime )? ';' ( instruction_inter )? -> ^( AFF_STRUCT ( 'mut' )? $instruction accolade ) ( expr_prime )? ( instruction_inter )? )
                    {
                    // RUSTWITHRULES.g:88:4: ( 'let' ( 'mut' )? name= expr '=' res= expr -> ^( L_VALUE $name) ^( R_VALUE $res) )
                    // RUSTWITHRULES.g:88:5: 'let' ( 'mut' )? name= expr '=' res= expr
                    {
                    string_literal46=(Token)match(input,62,FOLLOW_62_in_instruction554);  
                    stream_62.add(string_literal46);

                    // RUSTWITHRULES.g:88:11: ( 'mut' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==63) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // RUSTWITHRULES.g:88:11: 'mut'
                            {
                            string_literal47=(Token)match(input,63,FOLLOW_63_in_instruction556);  
                            stream_63.add(string_literal47);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_expr_in_instruction561);
                    name=expr();

                    state._fsp--;

                    stream_expr.add(name.getTree());
                    char_literal48=(Token)match(input,64,FOLLOW_64_in_instruction563);  
                    stream_64.add(char_literal48);

                    pushFollow(FOLLOW_expr_in_instruction567);
                    res=expr();

                    state._fsp--;

                    stream_expr.add(res.getTree());


                    // AST REWRITE
                    // elements: name, res
                    // token labels: 
                    // rule labels: res, name, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_res=new RewriteRuleSubtreeStream(adaptor,"rule res",res!=null?res.tree:null);
                    RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 88:41: -> ^( L_VALUE $name) ^( R_VALUE $res)
                    {
                        // RUSTWITHRULES.g:88:44: ^( L_VALUE $name)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(L_VALUE, "L_VALUE"), root_1);

                        adaptor.addChild(root_1, stream_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }
                        // RUSTWITHRULES.g:88:61: ^( R_VALUE $res)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(R_VALUE, "R_VALUE"), root_1);

                        adaptor.addChild(root_1, stream_res.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }

                    // RUSTWITHRULES.g:88:78: ( ';' ( instruction_inter )? -> ^( AFF ( 'mut' )? $instruction) ( instruction_inter )? | accolade ( expr_prime )? ';' ( instruction_inter )? -> ^( AFF_STRUCT ( 'mut' )? $instruction accolade ) ( expr_prime )? ( instruction_inter )? )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==61) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==47) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // RUSTWITHRULES.g:88:81: ';' ( instruction_inter )?
                            {
                            char_literal49=(Token)match(input,61,FOLLOW_61_in_instruction589);  
                            stream_61.add(char_literal49);

                            // RUSTWITHRULES.g:88:85: ( instruction_inter )?
                            int alt14=2;
                            int LA14_0 = input.LA(1);

                            if ( ((LA14_0>=IDF && LA14_0<=CSTE_ENT)||LA14_0==47||LA14_0==52||LA14_0==55||LA14_0==58||(LA14_0>=61 && LA14_0<=62)||(LA14_0>=65 && LA14_0<=67)||(LA14_0>=69 && LA14_0<=70)||(LA14_0>=76 && LA14_0<=77)||(LA14_0>=85 && LA14_0<=86)) ) {
                                alt14=1;
                            }
                            switch (alt14) {
                                case 1 :
                                    // RUSTWITHRULES.g:88:85: instruction_inter
                                    {
                                    pushFollow(FOLLOW_instruction_inter_in_instruction591);
                                    instruction_inter50=instruction_inter();

                                    state._fsp--;

                                    stream_instruction_inter.add(instruction_inter50.getTree());

                                    }
                                    break;

                            }



                            // AST REWRITE
                            // elements: 63, instruction, instruction_inter
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 88:104: -> ^( AFF ( 'mut' )? $instruction) ( instruction_inter )?
                            {
                                // RUSTWITHRULES.g:88:107: ^( AFF ( 'mut' )? $instruction)
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFF, "AFF"), root_1);

                                // RUSTWITHRULES.g:88:113: ( 'mut' )?
                                if ( stream_63.hasNext() ) {
                                    adaptor.addChild(root_1, stream_63.nextNode());

                                }
                                stream_63.reset();
                                adaptor.addChild(root_1, stream_retval.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }
                                // RUSTWITHRULES.g:88:134: ( instruction_inter )?
                                if ( stream_instruction_inter.hasNext() ) {
                                    adaptor.addChild(root_0, stream_instruction_inter.nextTree());

                                }
                                stream_instruction_inter.reset();

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 2 :
                            // RUSTWITHRULES.g:89:13: accolade ( expr_prime )? ';' ( instruction_inter )?
                            {
                            pushFollow(FOLLOW_accolade_in_instruction621);
                            accolade51=accolade();

                            state._fsp--;

                            stream_accolade.add(accolade51.getTree());
                            // RUSTWITHRULES.g:89:70: ( expr_prime )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0==71||LA15_0==74) ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // RUSTWITHRULES.g:89:70: expr_prime
                                    {
                                    pushFollow(FOLLOW_expr_prime_in_instruction624);
                                    expr_prime52=expr_prime();

                                    state._fsp--;

                                    stream_expr_prime.add(expr_prime52.getTree());

                                    }
                                    break;

                            }

                            char_literal53=(Token)match(input,61,FOLLOW_61_in_instruction627);  
                            stream_61.add(char_literal53);

                            // RUSTWITHRULES.g:89:86: ( instruction_inter )?
                            int alt16=2;
                            int LA16_0 = input.LA(1);

                            if ( ((LA16_0>=IDF && LA16_0<=CSTE_ENT)||LA16_0==47||LA16_0==52||LA16_0==55||LA16_0==58||(LA16_0>=61 && LA16_0<=62)||(LA16_0>=65 && LA16_0<=67)||(LA16_0>=69 && LA16_0<=70)||(LA16_0>=76 && LA16_0<=77)||(LA16_0>=85 && LA16_0<=86)) ) {
                                alt16=1;
                            }
                            switch (alt16) {
                                case 1 :
                                    // RUSTWITHRULES.g:89:86: instruction_inter
                                    {
                                    pushFollow(FOLLOW_instruction_inter_in_instruction629);
                                    instruction_inter54=instruction_inter();

                                    state._fsp--;

                                    stream_instruction_inter.add(instruction_inter54.getTree());

                                    }
                                    break;

                            }



                            // AST REWRITE
                            // elements: 63, instruction_inter, accolade, instruction, expr_prime
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 89:105: -> ^( AFF_STRUCT ( 'mut' )? $instruction accolade ) ( expr_prime )? ( instruction_inter )?
                            {
                                // RUSTWITHRULES.g:89:108: ^( AFF_STRUCT ( 'mut' )? $instruction accolade )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFF_STRUCT, "AFF_STRUCT"), root_1);

                                // RUSTWITHRULES.g:89:121: ( 'mut' )?
                                if ( stream_63.hasNext() ) {
                                    adaptor.addChild(root_1, stream_63.nextNode());

                                }
                                stream_63.reset();
                                adaptor.addChild(root_1, stream_retval.nextTree());
                                adaptor.addChild(root_1, stream_accolade.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }
                                // RUSTWITHRULES.g:89:151: ( expr_prime )?
                                if ( stream_expr_prime.hasNext() ) {
                                    adaptor.addChild(root_0, stream_expr_prime.nextTree());

                                }
                                stream_expr_prime.reset();
                                // RUSTWITHRULES.g:89:163: ( instruction_inter )?
                                if ( stream_instruction_inter.hasNext() ) {
                                    adaptor.addChild(root_0, stream_instruction_inter.nextTree());

                                }
                                stream_instruction_inter.reset();

                            }

                            retval.tree = root_0;
                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // RUSTWITHRULES.g:91:4: 'while' expr bloc ( instruction_inter )?
                    {
                    string_literal55=(Token)match(input,65,FOLLOW_65_in_instruction666);  
                    stream_65.add(string_literal55);

                    pushFollow(FOLLOW_expr_in_instruction669);
                    expr56=expr();

                    state._fsp--;

                    stream_expr.add(expr56.getTree());
                    pushFollow(FOLLOW_bloc_in_instruction672);
                    bloc57=bloc();

                    state._fsp--;

                    stream_bloc.add(bloc57.getTree());
                    // RUSTWITHRULES.g:91:24: ( instruction_inter )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( ((LA18_0>=IDF && LA18_0<=CSTE_ENT)||LA18_0==47||LA18_0==52||LA18_0==55||LA18_0==58||(LA18_0>=61 && LA18_0<=62)||(LA18_0>=65 && LA18_0<=67)||(LA18_0>=69 && LA18_0<=70)||(LA18_0>=76 && LA18_0<=77)||(LA18_0>=85 && LA18_0<=86)) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // RUSTWITHRULES.g:91:24: instruction_inter
                            {
                            pushFollow(FOLLOW_instruction_inter_in_instruction674);
                            instruction_inter58=instruction_inter();

                            state._fsp--;

                            stream_instruction_inter.add(instruction_inter58.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: expr, bloc, instruction_inter
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 91:43: -> ^( WHILE expr bloc ) ( instruction_inter )?
                    {
                        // RUSTWITHRULES.g:91:46: ^( WHILE expr bloc )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());
                        adaptor.addChild(root_1, stream_bloc.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }
                        // RUSTWITHRULES.g:91:65: ( instruction_inter )?
                        if ( stream_instruction_inter.hasNext() ) {
                            adaptor.addChild(root_0, stream_instruction_inter.nextTree());

                        }
                        stream_instruction_inter.reset();

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // RUSTWITHRULES.g:92:4: 'return' ( expr )? ';' ( instruction_inter )?
                    {
                    string_literal59=(Token)match(input,66,FOLLOW_66_in_instruction693);  
                    stream_66.add(string_literal59);

                    // RUSTWITHRULES.g:92:13: ( expr )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0>=IDF && LA19_0<=CSTE_ENT)||LA19_0==47||LA19_0==52||LA19_0==55||LA19_0==58||(LA19_0>=69 && LA19_0<=70)||(LA19_0>=76 && LA19_0<=77)||(LA19_0>=85 && LA19_0<=86)) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // RUSTWITHRULES.g:92:13: expr
                            {
                            pushFollow(FOLLOW_expr_in_instruction695);
                            expr60=expr();

                            state._fsp--;

                            stream_expr.add(expr60.getTree());

                            }
                            break;

                    }

                    char_literal61=(Token)match(input,61,FOLLOW_61_in_instruction698);  
                    stream_61.add(char_literal61);

                    // RUSTWITHRULES.g:92:23: ( instruction_inter )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=IDF && LA20_0<=CSTE_ENT)||LA20_0==47||LA20_0==52||LA20_0==55||LA20_0==58||(LA20_0>=61 && LA20_0<=62)||(LA20_0>=65 && LA20_0<=67)||(LA20_0>=69 && LA20_0<=70)||(LA20_0>=76 && LA20_0<=77)||(LA20_0>=85 && LA20_0<=86)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // RUSTWITHRULES.g:92:23: instruction_inter
                            {
                            pushFollow(FOLLOW_instruction_inter_in_instruction700);
                            instruction_inter62=instruction_inter();

                            state._fsp--;

                            stream_instruction_inter.add(instruction_inter62.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: instruction_inter, expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 92:42: -> ^( RETURN ( expr )? ) ( instruction_inter )?
                    {
                        // RUSTWITHRULES.g:92:45: ^( RETURN ( expr )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(RETURN, "RETURN"), root_1);

                        // RUSTWITHRULES.g:92:54: ( expr )?
                        if ( stream_expr.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr.nextTree());

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }
                        // RUSTWITHRULES.g:92:61: ( instruction_inter )?
                        if ( stream_instruction_inter.hasNext() ) {
                            adaptor.addChild(root_0, stream_instruction_inter.nextTree());

                        }
                        stream_instruction_inter.reset();

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // RUSTWITHRULES.g:93:4: if_expr ( instruction_inter )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_if_expr_in_instruction718);
                    if_expr63=if_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, if_expr63.getTree());
                    // RUSTWITHRULES.g:93:12: ( instruction_inter )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=IDF && LA21_0<=CSTE_ENT)||LA21_0==47||LA21_0==52||LA21_0==55||LA21_0==58||(LA21_0>=61 && LA21_0<=62)||(LA21_0>=65 && LA21_0<=67)||(LA21_0>=69 && LA21_0<=70)||(LA21_0>=76 && LA21_0<=77)||(LA21_0>=85 && LA21_0<=86)) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // RUSTWITHRULES.g:93:12: instruction_inter
                            {
                            pushFollow(FOLLOW_instruction_inter_in_instruction720);
                            instruction_inter64=instruction_inter();

                            state._fsp--;

                            adaptor.addChild(root_0, instruction_inter64.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "instruction"

    public static class accolade_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "accolade"
    // RUSTWITHRULES.g:96:1: accolade : '{' ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )? '}' -> ( ^( AFF_STRUCT_ELT IDF expr ss_accolade ) )* ;
    public final RUSTWITHRULESParser.accolade_return accolade() throws RecognitionException {
        RUSTWITHRULESParser.accolade_return retval = new RUSTWITHRULESParser.accolade_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal65=null;
        Token IDF66=null;
        Token char_literal67=null;
        Token char_literal70=null;
        Token IDF71=null;
        Token char_literal72=null;
        Token char_literal75=null;
        RUSTWITHRULESParser.expr_return expr68 = null;

        RUSTWITHRULESParser.ss_accolade_return ss_accolade69 = null;

        RUSTWITHRULESParser.expr_return expr73 = null;

        RUSTWITHRULESParser.ss_accolade_return ss_accolade74 = null;


        Object char_literal65_tree=null;
        Object IDF66_tree=null;
        Object char_literal67_tree=null;
        Object char_literal70_tree=null;
        Object IDF71_tree=null;
        Object char_literal72_tree=null;
        Object char_literal75_tree=null;
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_ss_accolade=new RewriteRuleSubtreeStream(adaptor,"rule ss_accolade");
        try {
            // RUSTWITHRULES.g:97:2: ( '{' ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )? '}' -> ( ^( AFF_STRUCT_ELT IDF expr ss_accolade ) )* )
            // RUSTWITHRULES.g:97:4: '{' ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )? '}'
            {
            char_literal65=(Token)match(input,47,FOLLOW_47_in_accolade734);  
            stream_47.add(char_literal65);

            // RUSTWITHRULES.g:97:8: ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IDF) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // RUSTWITHRULES.g:97:9: IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )*
                    {
                    IDF66=(Token)match(input,IDF,FOLLOW_IDF_in_accolade737);  
                    stream_IDF.add(IDF66);

                    char_literal67=(Token)match(input,48,FOLLOW_48_in_accolade739);  
                    stream_48.add(char_literal67);

                    pushFollow(FOLLOW_expr_in_accolade741);
                    expr68=expr();

                    state._fsp--;

                    stream_expr.add(expr68.getTree());
                    pushFollow(FOLLOW_ss_accolade_in_accolade743);
                    ss_accolade69=ss_accolade();

                    state._fsp--;

                    stream_ss_accolade.add(ss_accolade69.getTree());
                    // RUSTWITHRULES.g:97:34: ( ',' IDF ':' expr ss_accolade )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==49) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // RUSTWITHRULES.g:97:35: ',' IDF ':' expr ss_accolade
                    	    {
                    	    char_literal70=(Token)match(input,49,FOLLOW_49_in_accolade746);  
                    	    stream_49.add(char_literal70);

                    	    IDF71=(Token)match(input,IDF,FOLLOW_IDF_in_accolade748);  
                    	    stream_IDF.add(IDF71);

                    	    char_literal72=(Token)match(input,48,FOLLOW_48_in_accolade750);  
                    	    stream_48.add(char_literal72);

                    	    pushFollow(FOLLOW_expr_in_accolade752);
                    	    expr73=expr();

                    	    state._fsp--;

                    	    stream_expr.add(expr73.getTree());
                    	    pushFollow(FOLLOW_ss_accolade_in_accolade754);
                    	    ss_accolade74=ss_accolade();

                    	    state._fsp--;

                    	    stream_ss_accolade.add(ss_accolade74.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            char_literal75=(Token)match(input,50,FOLLOW_50_in_accolade761);  
            stream_50.add(char_literal75);



            // AST REWRITE
            // elements: IDF, expr, ss_accolade
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 97:73: -> ( ^( AFF_STRUCT_ELT IDF expr ss_accolade ) )*
            {
                // RUSTWITHRULES.g:97:76: ( ^( AFF_STRUCT_ELT IDF expr ss_accolade ) )*
                while ( stream_IDF.hasNext()||stream_expr.hasNext()||stream_ss_accolade.hasNext() ) {
                    // RUSTWITHRULES.g:97:76: ^( AFF_STRUCT_ELT IDF expr ss_accolade )
                    {
                    Object root_1 = (Object)adaptor.nil();
                    root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFF_STRUCT_ELT, "AFF_STRUCT_ELT"), root_1);

                    adaptor.addChild(root_1, stream_IDF.nextNode());
                    adaptor.addChild(root_1, stream_expr.nextTree());
                    adaptor.addChild(root_1, stream_ss_accolade.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_IDF.reset();
                stream_expr.reset();
                stream_ss_accolade.reset();

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "accolade"

    public static class ss_accolade_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ss_accolade"
    // RUSTWITHRULES.g:100:1: ss_accolade : ( '{' ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )? '}' -> ^( SS_ACCOLADE ( ^( AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade ) )* ) | -> ^( FIN_AFF ) );
    public final RUSTWITHRULESParser.ss_accolade_return ss_accolade() throws RecognitionException {
        RUSTWITHRULESParser.ss_accolade_return retval = new RUSTWITHRULESParser.ss_accolade_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal76=null;
        Token IDF77=null;
        Token char_literal78=null;
        Token char_literal81=null;
        Token IDF82=null;
        Token char_literal83=null;
        Token char_literal86=null;
        RUSTWITHRULESParser.expr_return expr79 = null;

        RUSTWITHRULESParser.ss_accolade_return ss_accolade80 = null;

        RUSTWITHRULESParser.expr_return expr84 = null;

        RUSTWITHRULESParser.ss_accolade_return ss_accolade85 = null;


        Object char_literal76_tree=null;
        Object IDF77_tree=null;
        Object char_literal78_tree=null;
        Object char_literal81_tree=null;
        Object IDF82_tree=null;
        Object char_literal83_tree=null;
        Object char_literal86_tree=null;
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_ss_accolade=new RewriteRuleSubtreeStream(adaptor,"rule ss_accolade");
        try {
            // RUSTWITHRULES.g:101:2: ( '{' ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )? '}' -> ^( SS_ACCOLADE ( ^( AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade ) )* ) | -> ^( FIN_AFF ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==47) ) {
                alt27=1;
            }
            else if ( ((LA27_0>=49 && LA27_0<=50)) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // RUSTWITHRULES.g:101:4: '{' ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )? '}'
                    {
                    char_literal76=(Token)match(input,47,FOLLOW_47_in_ss_accolade786);  
                    stream_47.add(char_literal76);

                    // RUSTWITHRULES.g:101:8: ( IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==IDF) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // RUSTWITHRULES.g:101:9: IDF ':' expr ss_accolade ( ',' IDF ':' expr ss_accolade )*
                            {
                            IDF77=(Token)match(input,IDF,FOLLOW_IDF_in_ss_accolade789);  
                            stream_IDF.add(IDF77);

                            char_literal78=(Token)match(input,48,FOLLOW_48_in_ss_accolade791);  
                            stream_48.add(char_literal78);

                            pushFollow(FOLLOW_expr_in_ss_accolade793);
                            expr79=expr();

                            state._fsp--;

                            stream_expr.add(expr79.getTree());
                            pushFollow(FOLLOW_ss_accolade_in_ss_accolade795);
                            ss_accolade80=ss_accolade();

                            state._fsp--;

                            stream_ss_accolade.add(ss_accolade80.getTree());
                            // RUSTWITHRULES.g:101:34: ( ',' IDF ':' expr ss_accolade )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==49) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // RUSTWITHRULES.g:101:35: ',' IDF ':' expr ss_accolade
                            	    {
                            	    char_literal81=(Token)match(input,49,FOLLOW_49_in_ss_accolade798);  
                            	    stream_49.add(char_literal81);

                            	    IDF82=(Token)match(input,IDF,FOLLOW_IDF_in_ss_accolade800);  
                            	    stream_IDF.add(IDF82);

                            	    char_literal83=(Token)match(input,48,FOLLOW_48_in_ss_accolade802);  
                            	    stream_48.add(char_literal83);

                            	    pushFollow(FOLLOW_expr_in_ss_accolade804);
                            	    expr84=expr();

                            	    state._fsp--;

                            	    stream_expr.add(expr84.getTree());
                            	    pushFollow(FOLLOW_ss_accolade_in_ss_accolade806);
                            	    ss_accolade85=ss_accolade();

                            	    state._fsp--;

                            	    stream_ss_accolade.add(ss_accolade85.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal86=(Token)match(input,50,FOLLOW_50_in_ss_accolade813);  
                    stream_50.add(char_literal86);



                    // AST REWRITE
                    // elements: ss_accolade, expr, IDF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 101:73: -> ^( SS_ACCOLADE ( ^( AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade ) )* )
                    {
                        // RUSTWITHRULES.g:101:76: ^( SS_ACCOLADE ( ^( AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade ) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SS_ACCOLADE, "SS_ACCOLADE"), root_1);

                        // RUSTWITHRULES.g:101:90: ( ^( AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade ) )*
                        while ( stream_ss_accolade.hasNext()||stream_expr.hasNext()||stream_IDF.hasNext() ) {
                            // RUSTWITHRULES.g:101:90: ^( AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(AFF_STRUCT_SS_ACCOLADE, "AFF_STRUCT_SS_ACCOLADE"), root_2);

                            adaptor.addChild(root_2, stream_IDF.nextNode());
                            adaptor.addChild(root_2, stream_expr.nextTree());
                            adaptor.addChild(root_2, stream_ss_accolade.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_ss_accolade.reset();
                        stream_expr.reset();
                        stream_IDF.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:102:4: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 102:4: -> ^( FIN_AFF )
                    {
                        // RUSTWITHRULES.g:102:7: ^( FIN_AFF )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FIN_AFF, "FIN_AFF"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ss_accolade"

    public static class if_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_expr"
    // RUSTWITHRULES.g:120:1: if_expr : 'if' expr bloc ( 'else' ( if_test ) )? -> ^( IF expr bloc ( ^( ELSE if_test ) )? ) ;
    public final RUSTWITHRULESParser.if_expr_return if_expr() throws RecognitionException {
        RUSTWITHRULESParser.if_expr_return retval = new RUSTWITHRULESParser.if_expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal87=null;
        Token string_literal90=null;
        RUSTWITHRULESParser.expr_return expr88 = null;

        RUSTWITHRULESParser.bloc_return bloc89 = null;

        RUSTWITHRULESParser.if_test_return if_test91 = null;


        Object string_literal87_tree=null;
        Object string_literal90_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleSubtreeStream stream_bloc=new RewriteRuleSubtreeStream(adaptor,"rule bloc");
        RewriteRuleSubtreeStream stream_if_test=new RewriteRuleSubtreeStream(adaptor,"rule if_test");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // RUSTWITHRULES.g:120:9: ( 'if' expr bloc ( 'else' ( if_test ) )? -> ^( IF expr bloc ( ^( ELSE if_test ) )? ) )
            // RUSTWITHRULES.g:120:11: 'if' expr bloc ( 'else' ( if_test ) )?
            {
            string_literal87=(Token)match(input,67,FOLLOW_67_in_if_expr852);  
            stream_67.add(string_literal87);

            pushFollow(FOLLOW_expr_in_if_expr854);
            expr88=expr();

            state._fsp--;

            stream_expr.add(expr88.getTree());
            pushFollow(FOLLOW_bloc_in_if_expr856);
            bloc89=bloc();

            state._fsp--;

            stream_bloc.add(bloc89.getTree());
            // RUSTWITHRULES.g:120:26: ( 'else' ( if_test ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==68) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // RUSTWITHRULES.g:120:27: 'else' ( if_test )
                    {
                    string_literal90=(Token)match(input,68,FOLLOW_68_in_if_expr859);  
                    stream_68.add(string_literal90);

                    // RUSTWITHRULES.g:120:34: ( if_test )
                    // RUSTWITHRULES.g:120:35: if_test
                    {
                    pushFollow(FOLLOW_if_test_in_if_expr862);
                    if_test91=if_test();

                    state._fsp--;

                    stream_if_test.add(if_test91.getTree());

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: expr, if_test, bloc
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 120:46: -> ^( IF expr bloc ( ^( ELSE if_test ) )? )
            {
                // RUSTWITHRULES.g:120:49: ^( IF expr bloc ( ^( ELSE if_test ) )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);

                adaptor.addChild(root_1, stream_expr.nextTree());
                adaptor.addChild(root_1, stream_bloc.nextTree());
                // RUSTWITHRULES.g:120:64: ( ^( ELSE if_test ) )?
                if ( stream_if_test.hasNext() ) {
                    // RUSTWITHRULES.g:120:64: ^( ELSE if_test )
                    {
                    Object root_2 = (Object)adaptor.nil();
                    root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSE, "ELSE"), root_2);

                    adaptor.addChild(root_2, stream_if_test.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_if_test.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_expr"

    public static class if_test_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_test"
    // RUSTWITHRULES.g:123:1: if_test : ( bloc | if_expr );
    public final RUSTWITHRULESParser.if_test_return if_test() throws RecognitionException {
        RUSTWITHRULESParser.if_test_return retval = new RUSTWITHRULESParser.if_test_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        RUSTWITHRULESParser.bloc_return bloc92 = null;

        RUSTWITHRULESParser.if_expr_return if_expr93 = null;



        try {
            // RUSTWITHRULES.g:123:10: ( bloc | if_expr )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==47) ) {
                alt29=1;
            }
            else if ( (LA29_0==67) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // RUSTWITHRULES.g:123:12: bloc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_bloc_in_if_test895);
                    bloc92=bloc();

                    state._fsp--;

                    adaptor.addChild(root_0, bloc92.getTree());

                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:124:4: if_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_if_expr_in_if_test900);
                    if_expr93=if_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, if_expr93.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_test"

    public static class expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // RUSTWITHRULES.g:141:1: expr : ( 'print' '!' '(' expr ')' -> ^( PRINT expr ) | 'vec' '!' '[' ( expr ( ',' expr )* )? ']' -> ^( VEC_DECL ( ^( VEC_ELT expr ) )* ) | bloc | level2 ( '||' level2 )* );
    public final RUSTWITHRULESParser.expr_return expr() throws RecognitionException {
        RUSTWITHRULESParser.expr_return retval = new RUSTWITHRULESParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal94=null;
        Token char_literal95=null;
        Token char_literal96=null;
        Token char_literal98=null;
        Token string_literal99=null;
        Token char_literal100=null;
        Token char_literal101=null;
        Token char_literal103=null;
        Token char_literal105=null;
        Token string_literal108=null;
        RUSTWITHRULESParser.expr_return expr97 = null;

        RUSTWITHRULESParser.expr_return expr102 = null;

        RUSTWITHRULESParser.expr_return expr104 = null;

        RUSTWITHRULESParser.bloc_return bloc106 = null;

        RUSTWITHRULESParser.level2_return level2107 = null;

        RUSTWITHRULESParser.level2_return level2109 = null;


        Object string_literal94_tree=null;
        Object char_literal95_tree=null;
        Object char_literal96_tree=null;
        Object char_literal98_tree=null;
        Object string_literal99_tree=null;
        Object char_literal100_tree=null;
        Object char_literal101_tree=null;
        Object char_literal103_tree=null;
        Object char_literal105_tree=null;
        Object string_literal108_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // RUSTWITHRULES.g:142:5: ( 'print' '!' '(' expr ')' -> ^( PRINT expr ) | 'vec' '!' '[' ( expr ( ',' expr )* )? ']' -> ^( VEC_DECL ( ^( VEC_ELT expr ) )* ) | bloc | level2 ( '||' level2 )* )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt33=1;
                }
                break;
            case 58:
                {
                alt33=2;
                }
                break;
            case 47:
                {
                alt33=3;
                }
                break;
            case IDF:
            case CSTE_ENT:
            case 52:
            case 55:
            case 70:
            case 76:
            case 77:
            case 85:
            case 86:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // RUSTWITHRULES.g:142:7: 'print' '!' '(' expr ')'
                    {
                    string_literal94=(Token)match(input,69,FOLLOW_69_in_expr922);  
                    stream_69.add(string_literal94);

                    char_literal95=(Token)match(input,70,FOLLOW_70_in_expr924);  
                    stream_70.add(char_literal95);

                    char_literal96=(Token)match(input,52,FOLLOW_52_in_expr926);  
                    stream_52.add(char_literal96);

                    pushFollow(FOLLOW_expr_in_expr928);
                    expr97=expr();

                    state._fsp--;

                    stream_expr.add(expr97.getTree());
                    char_literal98=(Token)match(input,53,FOLLOW_53_in_expr930);  
                    stream_53.add(char_literal98);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 142:32: -> ^( PRINT expr )
                    {
                        // RUSTWITHRULES.g:142:35: ^( PRINT expr )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PRINT, "PRINT"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:143:7: 'vec' '!' '[' ( expr ( ',' expr )* )? ']'
                    {
                    string_literal99=(Token)match(input,58,FOLLOW_58_in_expr946);  
                    stream_58.add(string_literal99);

                    char_literal100=(Token)match(input,70,FOLLOW_70_in_expr948);  
                    stream_70.add(char_literal100);

                    char_literal101=(Token)match(input,71,FOLLOW_71_in_expr950);  
                    stream_71.add(char_literal101);

                    // RUSTWITHRULES.g:143:21: ( expr ( ',' expr )* )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( ((LA31_0>=IDF && LA31_0<=CSTE_ENT)||LA31_0==47||LA31_0==52||LA31_0==55||LA31_0==58||(LA31_0>=69 && LA31_0<=70)||(LA31_0>=76 && LA31_0<=77)||(LA31_0>=85 && LA31_0<=86)) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // RUSTWITHRULES.g:143:22: expr ( ',' expr )*
                            {
                            pushFollow(FOLLOW_expr_in_expr953);
                            expr102=expr();

                            state._fsp--;

                            stream_expr.add(expr102.getTree());
                            // RUSTWITHRULES.g:143:26: ( ',' expr )*
                            loop30:
                            do {
                                int alt30=2;
                                int LA30_0 = input.LA(1);

                                if ( (LA30_0==49) ) {
                                    alt30=1;
                                }


                                switch (alt30) {
                            	case 1 :
                            	    // RUSTWITHRULES.g:143:27: ',' expr
                            	    {
                            	    char_literal103=(Token)match(input,49,FOLLOW_49_in_expr955);  
                            	    stream_49.add(char_literal103);

                            	    pushFollow(FOLLOW_expr_in_expr957);
                            	    expr104=expr();

                            	    state._fsp--;

                            	    stream_expr.add(expr104.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop30;
                                }
                            } while (true);


                            }
                            break;

                    }

                    char_literal105=(Token)match(input,72,FOLLOW_72_in_expr964);  
                    stream_72.add(char_literal105);



                    // AST REWRITE
                    // elements: expr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 143:45: -> ^( VEC_DECL ( ^( VEC_ELT expr ) )* )
                    {
                        // RUSTWITHRULES.g:143:48: ^( VEC_DECL ( ^( VEC_ELT expr ) )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VEC_DECL, "VEC_DECL"), root_1);

                        // RUSTWITHRULES.g:143:59: ( ^( VEC_ELT expr ) )*
                        while ( stream_expr.hasNext() ) {
                            // RUSTWITHRULES.g:143:59: ^( VEC_ELT expr )
                            {
                            Object root_2 = (Object)adaptor.nil();
                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(VEC_ELT, "VEC_ELT"), root_2);

                            adaptor.addChild(root_2, stream_expr.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_expr.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // RUSTWITHRULES.g:144:7: bloc
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_bloc_in_expr986);
                    bloc106=bloc();

                    state._fsp--;

                    adaptor.addChild(root_0, bloc106.getTree());

                    }
                    break;
                case 4 :
                    // RUSTWITHRULES.g:145:7: level2 ( '||' level2 )*
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_level2_in_expr994);
                    level2107=level2();

                    state._fsp--;

                    adaptor.addChild(root_0, level2107.getTree());
                    // RUSTWITHRULES.g:145:14: ( '||' level2 )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==73) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // RUSTWITHRULES.g:145:15: '||' level2
                    	    {
                    	    string_literal108=(Token)match(input,73,FOLLOW_73_in_expr997); 
                    	    string_literal108_tree = (Object)adaptor.create(string_literal108);
                    	    root_0 = (Object)adaptor.becomeRoot(string_literal108_tree, root_0);

                    	    pushFollow(FOLLOW_level2_in_expr1000);
                    	    level2109=level2();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, level2109.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class expr_prime_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr_prime"
    // RUSTWITHRULES.g:156:1: expr_prime : ( '.' ( 'len' '(' ')' -> ^( LENGTH_ACCESS ) | IDF ( expr_prime )? -> ^( POINT_ACCESS IDF ( expr_prime )? ) ) | '[' expr ']' ( expr_prime )? -> ^( BRACKET_ACCESS expr ( expr_prime )? ) );
    public final RUSTWITHRULESParser.expr_prime_return expr_prime() throws RecognitionException {
        RUSTWITHRULESParser.expr_prime_return retval = new RUSTWITHRULESParser.expr_prime_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal110=null;
        Token string_literal111=null;
        Token char_literal112=null;
        Token char_literal113=null;
        Token IDF114=null;
        Token char_literal116=null;
        Token char_literal118=null;
        RUSTWITHRULESParser.expr_prime_return expr_prime115 = null;

        RUSTWITHRULESParser.expr_return expr117 = null;

        RUSTWITHRULESParser.expr_prime_return expr_prime119 = null;


        Object char_literal110_tree=null;
        Object string_literal111_tree=null;
        Object char_literal112_tree=null;
        Object char_literal113_tree=null;
        Object IDF114_tree=null;
        Object char_literal116_tree=null;
        Object char_literal118_tree=null;
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_expr_prime=new RewriteRuleSubtreeStream(adaptor,"rule expr_prime");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // RUSTWITHRULES.g:157:2: ( '.' ( 'len' '(' ')' -> ^( LENGTH_ACCESS ) | IDF ( expr_prime )? -> ^( POINT_ACCESS IDF ( expr_prime )? ) ) | '[' expr ']' ( expr_prime )? -> ^( BRACKET_ACCESS expr ( expr_prime )? ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==74) ) {
                alt37=1;
            }
            else if ( (LA37_0==71) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // RUSTWITHRULES.g:157:3: '.' ( 'len' '(' ')' -> ^( LENGTH_ACCESS ) | IDF ( expr_prime )? -> ^( POINT_ACCESS IDF ( expr_prime )? ) )
                    {
                    char_literal110=(Token)match(input,74,FOLLOW_74_in_expr_prime1033);  
                    stream_74.add(char_literal110);

                    // RUSTWITHRULES.g:157:8: ( 'len' '(' ')' -> ^( LENGTH_ACCESS ) | IDF ( expr_prime )? -> ^( POINT_ACCESS IDF ( expr_prime )? ) )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==75) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==IDF) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // RUSTWITHRULES.g:157:10: 'len' '(' ')'
                            {
                            string_literal111=(Token)match(input,75,FOLLOW_75_in_expr_prime1038);  
                            stream_75.add(string_literal111);

                            char_literal112=(Token)match(input,52,FOLLOW_52_in_expr_prime1040);  
                            stream_52.add(char_literal112);

                            char_literal113=(Token)match(input,53,FOLLOW_53_in_expr_prime1042);  
                            stream_53.add(char_literal113);



                            // AST REWRITE
                            // elements: 
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 157:24: -> ^( LENGTH_ACCESS )
                            {
                                // RUSTWITHRULES.g:157:27: ^( LENGTH_ACCESS )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LENGTH_ACCESS, "LENGTH_ACCESS"), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 2 :
                            // RUSTWITHRULES.g:158:6: IDF ( expr_prime )?
                            {
                            IDF114=(Token)match(input,IDF,FOLLOW_IDF_in_expr_prime1056);  
                            stream_IDF.add(IDF114);

                            // RUSTWITHRULES.g:158:10: ( expr_prime )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==71||LA34_0==74) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // RUSTWITHRULES.g:158:10: expr_prime
                                    {
                                    pushFollow(FOLLOW_expr_prime_in_expr_prime1058);
                                    expr_prime115=expr_prime();

                                    state._fsp--;

                                    stream_expr_prime.add(expr_prime115.getTree());

                                    }
                                    break;

                            }



                            // AST REWRITE
                            // elements: IDF, expr_prime
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 158:23: -> ^( POINT_ACCESS IDF ( expr_prime )? )
                            {
                                // RUSTWITHRULES.g:158:26: ^( POINT_ACCESS IDF ( expr_prime )? )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(POINT_ACCESS, "POINT_ACCESS"), root_1);

                                adaptor.addChild(root_1, stream_IDF.nextNode());
                                // RUSTWITHRULES.g:158:45: ( expr_prime )?
                                if ( stream_expr_prime.hasNext() ) {
                                    adaptor.addChild(root_1, stream_expr_prime.nextTree());

                                }
                                stream_expr_prime.reset();

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:160:3: '[' expr ']' ( expr_prime )?
                    {
                    char_literal116=(Token)match(input,71,FOLLOW_71_in_expr_prime1080);  
                    stream_71.add(char_literal116);

                    pushFollow(FOLLOW_expr_in_expr_prime1082);
                    expr117=expr();

                    state._fsp--;

                    stream_expr.add(expr117.getTree());
                    char_literal118=(Token)match(input,72,FOLLOW_72_in_expr_prime1084);  
                    stream_72.add(char_literal118);

                    // RUSTWITHRULES.g:160:16: ( expr_prime )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==71||LA36_0==74) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // RUSTWITHRULES.g:160:16: expr_prime
                            {
                            pushFollow(FOLLOW_expr_prime_in_expr_prime1086);
                            expr_prime119=expr_prime();

                            state._fsp--;

                            stream_expr_prime.add(expr_prime119.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: expr, expr_prime
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 160:28: -> ^( BRACKET_ACCESS expr ( expr_prime )? )
                    {
                        // RUSTWITHRULES.g:160:31: ^( BRACKET_ACCESS expr ( expr_prime )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BRACKET_ACCESS, "BRACKET_ACCESS"), root_1);

                        adaptor.addChild(root_1, stream_expr.nextTree());
                        // RUSTWITHRULES.g:160:53: ( expr_prime )?
                        if ( stream_expr_prime.hasNext() ) {
                            adaptor.addChild(root_1, stream_expr_prime.nextTree());

                        }
                        stream_expr_prime.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr_prime"

    public static class facto_unaire_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "facto_unaire"
    // RUSTWITHRULES.g:163:1: facto_unaire : ( '-' atom -> ^( OPPOSE atom ) | '*' atom -> ^( PTR_CONTENT_ACCESS atom ) | '&' atom -> ^( VAR_ADDRESS_ACCESS atom ) | '!' atom -> ^( OPPOSE_BOOL atom ) );
    public final RUSTWITHRULESParser.facto_unaire_return facto_unaire() throws RecognitionException {
        RUSTWITHRULESParser.facto_unaire_return retval = new RUSTWITHRULESParser.facto_unaire_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal120=null;
        Token char_literal122=null;
        Token char_literal124=null;
        Token char_literal126=null;
        RUSTWITHRULESParser.atom_return atom121 = null;

        RUSTWITHRULESParser.atom_return atom123 = null;

        RUSTWITHRULESParser.atom_return atom125 = null;

        RUSTWITHRULESParser.atom_return atom127 = null;


        Object char_literal120_tree=null;
        Object char_literal122_tree=null;
        Object char_literal124_tree=null;
        Object char_literal126_tree=null;
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // RUSTWITHRULES.g:164:2: ( '-' atom -> ^( OPPOSE atom ) | '*' atom -> ^( PTR_CONTENT_ACCESS atom ) | '&' atom -> ^( VAR_ADDRESS_ACCESS atom ) | '!' atom -> ^( OPPOSE_BOOL atom ) )
            int alt38=4;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt38=1;
                }
                break;
            case 77:
                {
                alt38=2;
                }
                break;
            case 55:
                {
                alt38=3;
                }
                break;
            case 70:
                {
                alt38=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // RUSTWITHRULES.g:164:4: '-' atom
                    {
                    char_literal120=(Token)match(input,76,FOLLOW_76_in_facto_unaire1115);  
                    stream_76.add(char_literal120);

                    pushFollow(FOLLOW_atom_in_facto_unaire1117);
                    atom121=atom();

                    state._fsp--;

                    stream_atom.add(atom121.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 164:13: -> ^( OPPOSE atom )
                    {
                        // RUSTWITHRULES.g:164:16: ^( OPPOSE atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPPOSE, "OPPOSE"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:165:4: '*' atom
                    {
                    char_literal122=(Token)match(input,77,FOLLOW_77_in_facto_unaire1130);  
                    stream_77.add(char_literal122);

                    pushFollow(FOLLOW_atom_in_facto_unaire1132);
                    atom123=atom();

                    state._fsp--;

                    stream_atom.add(atom123.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 165:13: -> ^( PTR_CONTENT_ACCESS atom )
                    {
                        // RUSTWITHRULES.g:165:16: ^( PTR_CONTENT_ACCESS atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PTR_CONTENT_ACCESS, "PTR_CONTENT_ACCESS"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // RUSTWITHRULES.g:166:4: '&' atom
                    {
                    char_literal124=(Token)match(input,55,FOLLOW_55_in_facto_unaire1145);  
                    stream_55.add(char_literal124);

                    pushFollow(FOLLOW_atom_in_facto_unaire1147);
                    atom125=atom();

                    state._fsp--;

                    stream_atom.add(atom125.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 166:13: -> ^( VAR_ADDRESS_ACCESS atom )
                    {
                        // RUSTWITHRULES.g:166:16: ^( VAR_ADDRESS_ACCESS atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR_ADDRESS_ACCESS, "VAR_ADDRESS_ACCESS"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // RUSTWITHRULES.g:167:4: '!' atom
                    {
                    char_literal126=(Token)match(input,70,FOLLOW_70_in_facto_unaire1160);  
                    stream_70.add(char_literal126);

                    pushFollow(FOLLOW_atom_in_facto_unaire1162);
                    atom127=atom();

                    state._fsp--;

                    stream_atom.add(atom127.getTree());


                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 167:13: -> ^( OPPOSE_BOOL atom )
                    {
                        // RUSTWITHRULES.g:167:16: ^( OPPOSE_BOOL atom )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OPPOSE_BOOL, "OPPOSE_BOOL"), root_1);

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "facto_unaire"

    public static class level2_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "level2"
    // RUSTWITHRULES.g:170:1: level2 : level3 ( '&&' level3 )* ;
    public final RUSTWITHRULESParser.level2_return level2() throws RecognitionException {
        RUSTWITHRULESParser.level2_return retval = new RUSTWITHRULESParser.level2_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal129=null;
        RUSTWITHRULESParser.level3_return level3128 = null;

        RUSTWITHRULESParser.level3_return level3130 = null;


        Object string_literal129_tree=null;

        try {
            // RUSTWITHRULES.g:170:7: ( level3 ( '&&' level3 )* )
            // RUSTWITHRULES.g:170:9: level3 ( '&&' level3 )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_level3_in_level21181);
            level3128=level3();

            state._fsp--;

            adaptor.addChild(root_0, level3128.getTree());
            // RUSTWITHRULES.g:170:16: ( '&&' level3 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==78) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // RUSTWITHRULES.g:170:17: '&&' level3
            	    {
            	    string_literal129=(Token)match(input,78,FOLLOW_78_in_level21184); 
            	    string_literal129_tree = (Object)adaptor.create(string_literal129);
            	    root_0 = (Object)adaptor.becomeRoot(string_literal129_tree, root_0);

            	    pushFollow(FOLLOW_level3_in_level21187);
            	    level3130=level3();

            	    state._fsp--;

            	    adaptor.addChild(root_0, level3130.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "level2"

    public static class level3_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "level3"
    // RUSTWITHRULES.g:173:1: level3 : level4 ( ( '==' | '!=' | '<' | '<=' | '>' | '>=' ) level4 )* ;
    public final RUSTWITHRULESParser.level3_return level3() throws RecognitionException {
        RUSTWITHRULESParser.level3_return retval = new RUSTWITHRULESParser.level3_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token string_literal132=null;
        Token string_literal133=null;
        Token char_literal134=null;
        Token string_literal135=null;
        Token char_literal136=null;
        Token string_literal137=null;
        RUSTWITHRULESParser.level4_return level4131 = null;

        RUSTWITHRULESParser.level4_return level4138 = null;


        Object string_literal132_tree=null;
        Object string_literal133_tree=null;
        Object char_literal134_tree=null;
        Object string_literal135_tree=null;
        Object char_literal136_tree=null;
        Object string_literal137_tree=null;

        try {
            // RUSTWITHRULES.g:173:7: ( level4 ( ( '==' | '!=' | '<' | '<=' | '>' | '>=' ) level4 )* )
            // RUSTWITHRULES.g:173:9: level4 ( ( '==' | '!=' | '<' | '<=' | '>' | '>=' ) level4 )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_level4_in_level31200);
            level4131=level4();

            state._fsp--;

            adaptor.addChild(root_0, level4131.getTree());
            // RUSTWITHRULES.g:173:16: ( ( '==' | '!=' | '<' | '<=' | '>' | '>=' ) level4 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=59 && LA41_0<=60)||(LA41_0>=79 && LA41_0<=82)) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // RUSTWITHRULES.g:173:17: ( '==' | '!=' | '<' | '<=' | '>' | '>=' ) level4
            	    {
            	    // RUSTWITHRULES.g:173:17: ( '==' | '!=' | '<' | '<=' | '>' | '>=' )
            	    int alt40=6;
            	    switch ( input.LA(1) ) {
            	    case 79:
            	        {
            	        alt40=1;
            	        }
            	        break;
            	    case 80:
            	        {
            	        alt40=2;
            	        }
            	        break;
            	    case 59:
            	        {
            	        alt40=3;
            	        }
            	        break;
            	    case 81:
            	        {
            	        alt40=4;
            	        }
            	        break;
            	    case 60:
            	        {
            	        alt40=5;
            	        }
            	        break;
            	    case 82:
            	        {
            	        alt40=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 40, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt40) {
            	        case 1 :
            	            // RUSTWITHRULES.g:173:18: '=='
            	            {
            	            string_literal132=(Token)match(input,79,FOLLOW_79_in_level31204); 
            	            string_literal132_tree = (Object)adaptor.create(string_literal132);
            	            root_0 = (Object)adaptor.becomeRoot(string_literal132_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // RUSTWITHRULES.g:173:26: '!='
            	            {
            	            string_literal133=(Token)match(input,80,FOLLOW_80_in_level31209); 
            	            string_literal133_tree = (Object)adaptor.create(string_literal133);
            	            root_0 = (Object)adaptor.becomeRoot(string_literal133_tree, root_0);


            	            }
            	            break;
            	        case 3 :
            	            // RUSTWITHRULES.g:173:34: '<'
            	            {
            	            char_literal134=(Token)match(input,59,FOLLOW_59_in_level31214); 
            	            char_literal134_tree = (Object)adaptor.create(char_literal134);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal134_tree, root_0);


            	            }
            	            break;
            	        case 4 :
            	            // RUSTWITHRULES.g:173:41: '<='
            	            {
            	            string_literal135=(Token)match(input,81,FOLLOW_81_in_level31219); 
            	            string_literal135_tree = (Object)adaptor.create(string_literal135);
            	            root_0 = (Object)adaptor.becomeRoot(string_literal135_tree, root_0);


            	            }
            	            break;
            	        case 5 :
            	            // RUSTWITHRULES.g:173:49: '>'
            	            {
            	            char_literal136=(Token)match(input,60,FOLLOW_60_in_level31224); 
            	            char_literal136_tree = (Object)adaptor.create(char_literal136);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal136_tree, root_0);


            	            }
            	            break;
            	        case 6 :
            	            // RUSTWITHRULES.g:173:56: '>='
            	            {
            	            string_literal137=(Token)match(input,82,FOLLOW_82_in_level31229); 
            	            string_literal137_tree = (Object)adaptor.create(string_literal137);
            	            root_0 = (Object)adaptor.becomeRoot(string_literal137_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_level4_in_level31233);
            	    level4138=level4();

            	    state._fsp--;

            	    adaptor.addChild(root_0, level4138.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "level3"

    public static class level4_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "level4"
    // RUSTWITHRULES.g:176:1: level4 : level5 ( ( '+' | '-' ) level5 )* ;
    public final RUSTWITHRULESParser.level4_return level4() throws RecognitionException {
        RUSTWITHRULESParser.level4_return retval = new RUSTWITHRULESParser.level4_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal140=null;
        Token char_literal141=null;
        RUSTWITHRULESParser.level5_return level5139 = null;

        RUSTWITHRULESParser.level5_return level5142 = null;


        Object char_literal140_tree=null;
        Object char_literal141_tree=null;

        try {
            // RUSTWITHRULES.g:176:7: ( level5 ( ( '+' | '-' ) level5 )* )
            // RUSTWITHRULES.g:176:9: level5 ( ( '+' | '-' ) level5 )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_level5_in_level41246);
            level5139=level5();

            state._fsp--;

            adaptor.addChild(root_0, level5139.getTree());
            // RUSTWITHRULES.g:176:16: ( ( '+' | '-' ) level5 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==76||LA43_0==83) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // RUSTWITHRULES.g:176:17: ( '+' | '-' ) level5
            	    {
            	    // RUSTWITHRULES.g:176:17: ( '+' | '-' )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==83) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==76) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // RUSTWITHRULES.g:176:18: '+'
            	            {
            	            char_literal140=(Token)match(input,83,FOLLOW_83_in_level41250); 
            	            char_literal140_tree = (Object)adaptor.create(char_literal140);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal140_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // RUSTWITHRULES.g:176:25: '-'
            	            {
            	            char_literal141=(Token)match(input,76,FOLLOW_76_in_level41255); 
            	            char_literal141_tree = (Object)adaptor.create(char_literal141);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal141_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_level5_in_level41260);
            	    level5142=level5();

            	    state._fsp--;

            	    adaptor.addChild(root_0, level5142.getTree());

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "level4"

    public static class level5_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "level5"
    // RUSTWITHRULES.g:179:1: level5 : atom ( ( '*' | '/' ) atom )* ;
    public final RUSTWITHRULESParser.level5_return level5() throws RecognitionException {
        RUSTWITHRULESParser.level5_return retval = new RUSTWITHRULESParser.level5_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal144=null;
        Token char_literal145=null;
        RUSTWITHRULESParser.atom_return atom143 = null;

        RUSTWITHRULESParser.atom_return atom146 = null;


        Object char_literal144_tree=null;
        Object char_literal145_tree=null;

        try {
            // RUSTWITHRULES.g:179:7: ( atom ( ( '*' | '/' ) atom )* )
            // RUSTWITHRULES.g:179:9: atom ( ( '*' | '/' ) atom )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_atom_in_level51274);
            atom143=atom();

            state._fsp--;

            adaptor.addChild(root_0, atom143.getTree());
            // RUSTWITHRULES.g:179:14: ( ( '*' | '/' ) atom )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==77||LA45_0==84) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // RUSTWITHRULES.g:179:15: ( '*' | '/' ) atom
            	    {
            	    // RUSTWITHRULES.g:179:15: ( '*' | '/' )
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==77) ) {
            	        alt44=1;
            	    }
            	    else if ( (LA44_0==84) ) {
            	        alt44=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 44, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // RUSTWITHRULES.g:179:16: '*'
            	            {
            	            char_literal144=(Token)match(input,77,FOLLOW_77_in_level51278); 
            	            char_literal144_tree = (Object)adaptor.create(char_literal144);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal144_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // RUSTWITHRULES.g:179:23: '/'
            	            {
            	            char_literal145=(Token)match(input,84,FOLLOW_84_in_level51283); 
            	            char_literal145_tree = (Object)adaptor.create(char_literal145);
            	            root_0 = (Object)adaptor.becomeRoot(char_literal145_tree, root_0);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_atom_in_level51288);
            	    atom146=atom();

            	    state._fsp--;

            	    adaptor.addChild(root_0, atom146.getTree());

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "level5"

    public static class atom_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // RUSTWITHRULES.g:195:1: atom : ( CSTE_ENT | '(' expr ')' ( expr_prime -> ^( ACCESS ^( EXPR_PARENTHESEE expr ) expr_prime ) | -> ^( EXPR_PARENTHESEE expr ) ) | 'true' | 'false' | facto_unaire | IDF ( '(' ( expr ( ',' expr )* )? ')' ( expr_prime -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime ) | -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) ) | expr_prime -> ^( ACCESS IDF expr_prime ) | -> IDF ) );
    public final RUSTWITHRULESParser.atom_return atom() throws RecognitionException {
        RUSTWITHRULESParser.atom_return retval = new RUSTWITHRULESParser.atom_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token CSTE_ENT147=null;
        Token char_literal148=null;
        Token char_literal150=null;
        Token string_literal152=null;
        Token string_literal153=null;
        Token IDF155=null;
        Token char_literal156=null;
        Token char_literal158=null;
        Token char_literal160=null;
        RUSTWITHRULESParser.expr_return expr149 = null;

        RUSTWITHRULESParser.expr_prime_return expr_prime151 = null;

        RUSTWITHRULESParser.facto_unaire_return facto_unaire154 = null;

        RUSTWITHRULESParser.expr_return expr157 = null;

        RUSTWITHRULESParser.expr_return expr159 = null;

        RUSTWITHRULESParser.expr_prime_return expr_prime161 = null;

        RUSTWITHRULESParser.expr_prime_return expr_prime162 = null;


        Object CSTE_ENT147_tree=null;
        Object char_literal148_tree=null;
        Object char_literal150_tree=null;
        Object string_literal152_tree=null;
        Object string_literal153_tree=null;
        Object IDF155_tree=null;
        Object char_literal156_tree=null;
        Object char_literal158_tree=null;
        Object char_literal160_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_IDF=new RewriteRuleTokenStream(adaptor,"token IDF");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_expr_prime=new RewriteRuleSubtreeStream(adaptor,"rule expr_prime");
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        try {
            // RUSTWITHRULES.g:196:2: ( CSTE_ENT | '(' expr ')' ( expr_prime -> ^( ACCESS ^( EXPR_PARENTHESEE expr ) expr_prime ) | -> ^( EXPR_PARENTHESEE expr ) ) | 'true' | 'false' | facto_unaire | IDF ( '(' ( expr ( ',' expr )* )? ')' ( expr_prime -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime ) | -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) ) | expr_prime -> ^( ACCESS IDF expr_prime ) | -> IDF ) )
            int alt51=6;
            switch ( input.LA(1) ) {
            case CSTE_ENT:
                {
                alt51=1;
                }
                break;
            case 52:
                {
                alt51=2;
                }
                break;
            case 85:
                {
                alt51=3;
                }
                break;
            case 86:
                {
                alt51=4;
                }
                break;
            case 55:
            case 70:
            case 76:
            case 77:
                {
                alt51=5;
                }
                break;
            case IDF:
                {
                alt51=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // RUSTWITHRULES.g:196:4: CSTE_ENT
                    {
                    root_0 = (Object)adaptor.nil();

                    CSTE_ENT147=(Token)match(input,CSTE_ENT,FOLLOW_CSTE_ENT_in_atom1309); 
                    CSTE_ENT147_tree = (Object)adaptor.create(CSTE_ENT147);
                    adaptor.addChild(root_0, CSTE_ENT147_tree);


                    }
                    break;
                case 2 :
                    // RUSTWITHRULES.g:197:4: '(' expr ')' ( expr_prime -> ^( ACCESS ^( EXPR_PARENTHESEE expr ) expr_prime ) | -> ^( EXPR_PARENTHESEE expr ) )
                    {
                    char_literal148=(Token)match(input,52,FOLLOW_52_in_atom1315);  
                    stream_52.add(char_literal148);

                    pushFollow(FOLLOW_expr_in_atom1317);
                    expr149=expr();

                    state._fsp--;

                    stream_expr.add(expr149.getTree());
                    char_literal150=(Token)match(input,53,FOLLOW_53_in_atom1319);  
                    stream_53.add(char_literal150);

                    // RUSTWITHRULES.g:197:17: ( expr_prime -> ^( ACCESS ^( EXPR_PARENTHESEE expr ) expr_prime ) | -> ^( EXPR_PARENTHESEE expr ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==71||LA46_0==74) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==47||(LA46_0>=49 && LA46_0<=50)||LA46_0==53||(LA46_0>=59 && LA46_0<=61)||LA46_0==64||(LA46_0>=72 && LA46_0<=73)||(LA46_0>=76 && LA46_0<=84)) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // RUSTWITHRULES.g:197:18: expr_prime
                            {
                            pushFollow(FOLLOW_expr_prime_in_atom1322);
                            expr_prime151=expr_prime();

                            state._fsp--;

                            stream_expr_prime.add(expr_prime151.getTree());


                            // AST REWRITE
                            // elements: expr_prime, expr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 197:29: -> ^( ACCESS ^( EXPR_PARENTHESEE expr ) expr_prime )
                            {
                                // RUSTWITHRULES.g:197:32: ^( ACCESS ^( EXPR_PARENTHESEE expr ) expr_prime )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACCESS, "ACCESS"), root_1);

                                // RUSTWITHRULES.g:197:41: ^( EXPR_PARENTHESEE expr )
                                {
                                Object root_2 = (Object)adaptor.nil();
                                root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_PARENTHESEE, "EXPR_PARENTHESEE"), root_2);

                                adaptor.addChild(root_2, stream_expr.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }
                                adaptor.addChild(root_1, stream_expr_prime.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 2 :
                            // RUSTWITHRULES.g:198:20: 
                            {

                            // AST REWRITE
                            // elements: expr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 198:20: -> ^( EXPR_PARENTHESEE expr )
                            {
                                // RUSTWITHRULES.g:198:23: ^( EXPR_PARENTHESEE expr )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_PARENTHESEE, "EXPR_PARENTHESEE"), root_1);

                                adaptor.addChild(root_1, stream_expr.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // RUSTWITHRULES.g:199:4: 'true'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal152=(Token)match(input,85,FOLLOW_85_in_atom1372); 
                    string_literal152_tree = (Object)adaptor.create(string_literal152);
                    adaptor.addChild(root_0, string_literal152_tree);


                    }
                    break;
                case 4 :
                    // RUSTWITHRULES.g:200:8: 'false'
                    {
                    root_0 = (Object)adaptor.nil();

                    string_literal153=(Token)match(input,86,FOLLOW_86_in_atom1382); 
                    string_literal153_tree = (Object)adaptor.create(string_literal153);
                    adaptor.addChild(root_0, string_literal153_tree);


                    }
                    break;
                case 5 :
                    // RUSTWITHRULES.g:201:9: facto_unaire
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_facto_unaire_in_atom1393);
                    facto_unaire154=facto_unaire();

                    state._fsp--;

                    adaptor.addChild(root_0, facto_unaire154.getTree());

                    }
                    break;
                case 6 :
                    // RUSTWITHRULES.g:202:8: IDF ( '(' ( expr ( ',' expr )* )? ')' ( expr_prime -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime ) | -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) ) | expr_prime -> ^( ACCESS IDF expr_prime ) | -> IDF )
                    {
                    IDF155=(Token)match(input,IDF,FOLLOW_IDF_in_atom1402);  
                    stream_IDF.add(IDF155);

                    // RUSTWITHRULES.g:202:12: ( '(' ( expr ( ',' expr )* )? ')' ( expr_prime -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime ) | -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) ) | expr_prime -> ^( ACCESS IDF expr_prime ) | -> IDF )
                    int alt50=3;
                    switch ( input.LA(1) ) {
                    case 52:
                        {
                        alt50=1;
                        }
                        break;
                    case 71:
                    case 74:
                        {
                        alt50=2;
                        }
                        break;
                    case 47:
                    case 49:
                    case 50:
                    case 53:
                    case 59:
                    case 60:
                    case 61:
                    case 64:
                    case 72:
                    case 73:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                        {
                        alt50=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;
                    }

                    switch (alt50) {
                        case 1 :
                            // RUSTWITHRULES.g:202:14: '(' ( expr ( ',' expr )* )? ')' ( expr_prime -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime ) | -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) )
                            {
                            char_literal156=(Token)match(input,52,FOLLOW_52_in_atom1406);  
                            stream_52.add(char_literal156);

                            // RUSTWITHRULES.g:202:18: ( expr ( ',' expr )* )?
                            int alt48=2;
                            int LA48_0 = input.LA(1);

                            if ( ((LA48_0>=IDF && LA48_0<=CSTE_ENT)||LA48_0==47||LA48_0==52||LA48_0==55||LA48_0==58||(LA48_0>=69 && LA48_0<=70)||(LA48_0>=76 && LA48_0<=77)||(LA48_0>=85 && LA48_0<=86)) ) {
                                alt48=1;
                            }
                            switch (alt48) {
                                case 1 :
                                    // RUSTWITHRULES.g:202:19: expr ( ',' expr )*
                                    {
                                    pushFollow(FOLLOW_expr_in_atom1409);
                                    expr157=expr();

                                    state._fsp--;

                                    stream_expr.add(expr157.getTree());
                                    // RUSTWITHRULES.g:202:24: ( ',' expr )*
                                    loop47:
                                    do {
                                        int alt47=2;
                                        int LA47_0 = input.LA(1);

                                        if ( (LA47_0==49) ) {
                                            alt47=1;
                                        }


                                        switch (alt47) {
                                    	case 1 :
                                    	    // RUSTWITHRULES.g:202:25: ',' expr
                                    	    {
                                    	    char_literal158=(Token)match(input,49,FOLLOW_49_in_atom1412);  
                                    	    stream_49.add(char_literal158);

                                    	    pushFollow(FOLLOW_expr_in_atom1414);
                                    	    expr159=expr();

                                    	    state._fsp--;

                                    	    stream_expr.add(expr159.getTree());

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop47;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            char_literal160=(Token)match(input,53,FOLLOW_53_in_atom1420);  
                            stream_53.add(char_literal160);

                            // RUSTWITHRULES.g:202:42: ( expr_prime -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime ) | -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) )
                            int alt49=2;
                            int LA49_0 = input.LA(1);

                            if ( (LA49_0==71||LA49_0==74) ) {
                                alt49=1;
                            }
                            else if ( (LA49_0==47||(LA49_0>=49 && LA49_0<=50)||LA49_0==53||(LA49_0>=59 && LA49_0<=61)||LA49_0==64||(LA49_0>=72 && LA49_0<=73)||(LA49_0>=76 && LA49_0<=84)) ) {
                                alt49=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 49, 0, input);

                                throw nvae;
                            }
                            switch (alt49) {
                                case 1 :
                                    // RUSTWITHRULES.g:202:43: expr_prime
                                    {
                                    pushFollow(FOLLOW_expr_prime_in_atom1423);
                                    expr_prime161=expr_prime();

                                    state._fsp--;

                                    stream_expr_prime.add(expr_prime161.getTree());


                                    // AST REWRITE
                                    // elements: expr_prime, IDF, expr
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (Object)adaptor.nil();
                                    // 202:55: -> ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime )
                                    {
                                        // RUSTWITHRULES.g:202:58: ^( ACCESS ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* ) expr_prime )
                                        {
                                        Object root_1 = (Object)adaptor.nil();
                                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACCESS, "ACCESS"), root_1);

                                        // RUSTWITHRULES.g:202:67: ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* )
                                        {
                                        Object root_2 = (Object)adaptor.nil();
                                        root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUN_CALL, "FUN_CALL"), root_2);

                                        adaptor.addChild(root_2, stream_IDF.nextNode());
                                        // RUSTWITHRULES.g:202:82: ( ^( FUN_CALL_ELT expr ) )*
                                        while ( stream_expr.hasNext() ) {
                                            // RUSTWITHRULES.g:202:82: ^( FUN_CALL_ELT expr )
                                            {
                                            Object root_3 = (Object)adaptor.nil();
                                            root_3 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUN_CALL_ELT, "FUN_CALL_ELT"), root_3);

                                            adaptor.addChild(root_3, stream_expr.nextTree());

                                            adaptor.addChild(root_2, root_3);
                                            }

                                        }
                                        stream_expr.reset();

                                        adaptor.addChild(root_1, root_2);
                                        }
                                        adaptor.addChild(root_1, stream_expr_prime.nextTree());

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;
                                    }
                                    break;
                                case 2 :
                                    // RUSTWITHRULES.g:203:53: 
                                    {

                                    // AST REWRITE
                                    // elements: expr, IDF
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (Object)adaptor.nil();
                                    // 203:53: -> ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* )
                                    {
                                        // RUSTWITHRULES.g:203:56: ^( FUN_CALL IDF ( ^( FUN_CALL_ELT expr ) )* )
                                        {
                                        Object root_1 = (Object)adaptor.nil();
                                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUN_CALL, "FUN_CALL"), root_1);

                                        adaptor.addChild(root_1, stream_IDF.nextNode());
                                        // RUSTWITHRULES.g:203:71: ( ^( FUN_CALL_ELT expr ) )*
                                        while ( stream_expr.hasNext() ) {
                                            // RUSTWITHRULES.g:203:71: ^( FUN_CALL_ELT expr )
                                            {
                                            Object root_2 = (Object)adaptor.nil();
                                            root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUN_CALL_ELT, "FUN_CALL_ELT"), root_2);

                                            adaptor.addChild(root_2, stream_expr.nextTree());

                                            adaptor.addChild(root_1, root_2);
                                            }

                                        }
                                        stream_expr.reset();

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }

                                    retval.tree = root_0;
                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // RUSTWITHRULES.g:204:10: expr_prime
                            {
                            pushFollow(FOLLOW_expr_prime_in_atom1527);
                            expr_prime162=expr_prime();

                            state._fsp--;

                            stream_expr_prime.add(expr_prime162.getTree());


                            // AST REWRITE
                            // elements: expr_prime, IDF
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 204:21: -> ^( ACCESS IDF expr_prime )
                            {
                                // RUSTWITHRULES.g:204:24: ^( ACCESS IDF expr_prime )
                                {
                                Object root_1 = (Object)adaptor.nil();
                                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ACCESS, "ACCESS"), root_1);

                                adaptor.addChild(root_1, stream_IDF.nextNode());
                                adaptor.addChild(root_1, stream_expr_prime.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;
                            }
                            break;
                        case 3 :
                            // RUSTWITHRULES.g:205:10: 
                            {

                            // AST REWRITE
                            // elements: IDF
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (Object)adaptor.nil();
                            // 205:10: -> IDF
                            {
                                adaptor.addChild(root_0, stream_IDF.nextNode());

                            }

                            retval.tree = root_0;
                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    // Delegated rules


 

    public static final BitSet FOLLOW_decl_in_fichier195 = new BitSet(new long[]{0x0008400000000002L});
    public static final BitSet FOLLOW_decl_struct_in_decl219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decl_fun_in_decl224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_decl_struct237 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDF_in_decl_struct239 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_decl_struct249 = new BitSet(new long[]{0x0004040000000000L});
    public static final BitSet FOLLOW_IDF_in_decl_struct252 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_decl_struct254 = new BitSet(new long[]{0x0780040000000000L});
    public static final BitSet FOLLOW_type_in_decl_struct256 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_49_in_decl_struct259 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDF_in_decl_struct261 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_decl_struct263 = new BitSet(new long[]{0x0780040000000000L});
    public static final BitSet FOLLOW_type_in_decl_struct265 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_50_in_decl_struct271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_decl_fun305 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDF_in_decl_fun307 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_decl_fun309 = new BitSet(new long[]{0x0020040000000000L});
    public static final BitSet FOLLOW_argument_in_decl_fun313 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_decl_fun317 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_argument_in_decl_fun319 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_decl_fun326 = new BitSet(new long[]{0x0040800000000000L});
    public static final BitSet FOLLOW_54_in_decl_fun329 = new BitSet(new long[]{0x0780040000000000L});
    public static final BitSet FOLLOW_type_in_decl_fun331 = new BitSet(new long[]{0x0040800000000000L});
    public static final BitSet FOLLOW_bloc_in_decl_fun335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_type369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_type375 = new BitSet(new long[]{0x0780040000000000L});
    public static final BitSet FOLLOW_type_in_type377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_type391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_type397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_type410 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_type412 = new BitSet(new long[]{0x0780040000000000L});
    public static final BitSet FOLLOW_type_in_type414 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_type416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_argument437 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_argument439 = new BitSet(new long[]{0x0780040000000000L});
    public static final BitSet FOLLOW_type_in_argument441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_bloc464 = new BitSet(new long[]{0x64D48C0000000000L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_in_bloc466 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_bloc469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_instruction_in_instruction_inter490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_instruction504 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_instruction518 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_instruction533 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_instruction554 = new BitSet(new long[]{0x84D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_63_in_instruction556 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_instruction561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_instruction563 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_instruction567 = new BitSet(new long[]{0x2000800000000000L});
    public static final BitSet FOLLOW_61_in_instruction589 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_accolade_in_instruction621 = new BitSet(new long[]{0x2000000000000000L,0x0000000000000480L});
    public static final BitSet FOLLOW_expr_prime_in_instruction624 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_instruction627 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_instruction666 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_instruction669 = new BitSet(new long[]{0x0040800000000000L});
    public static final BitSet FOLLOW_bloc_in_instruction672 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_instruction693 = new BitSet(new long[]{0x24D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_instruction695 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_instruction698 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_expr_in_instruction718 = new BitSet(new long[]{0x64D08C0000000002L,0x000000000060306EL});
    public static final BitSet FOLLOW_instruction_inter_in_instruction720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_accolade734 = new BitSet(new long[]{0x0004040000000000L});
    public static final BitSet FOLLOW_IDF_in_accolade737 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_accolade739 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_accolade741 = new BitSet(new long[]{0x0006800000000000L});
    public static final BitSet FOLLOW_ss_accolade_in_accolade743 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_49_in_accolade746 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDF_in_accolade748 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_accolade750 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_accolade752 = new BitSet(new long[]{0x0006800000000000L});
    public static final BitSet FOLLOW_ss_accolade_in_accolade754 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_50_in_accolade761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ss_accolade786 = new BitSet(new long[]{0x0004040000000000L});
    public static final BitSet FOLLOW_IDF_in_ss_accolade789 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ss_accolade791 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_ss_accolade793 = new BitSet(new long[]{0x0006800000000000L});
    public static final BitSet FOLLOW_ss_accolade_in_ss_accolade795 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_49_in_ss_accolade798 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_IDF_in_ss_accolade800 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ss_accolade802 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_ss_accolade804 = new BitSet(new long[]{0x0006800000000000L});
    public static final BitSet FOLLOW_ss_accolade_in_ss_accolade806 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_50_in_ss_accolade813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_if_expr852 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_if_expr854 = new BitSet(new long[]{0x0040800000000000L});
    public static final BitSet FOLLOW_bloc_in_if_expr856 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_if_expr859 = new BitSet(new long[]{0x64D08C0000000000L,0x000000000060306EL});
    public static final BitSet FOLLOW_if_test_in_if_expr862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloc_in_if_test895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_expr_in_if_test900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_expr922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_expr924 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_expr926 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_expr928 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_expr930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_expr946 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_expr948 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_expr950 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603160L});
    public static final BitSet FOLLOW_expr_in_expr953 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_49_in_expr955 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_expr957 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_expr964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloc_in_expr986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_level2_in_expr994 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_expr997 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_level2_in_expr1000 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_74_in_expr_prime1033 = new BitSet(new long[]{0x0000040000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_expr_prime1038 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_expr_prime1040 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_expr_prime1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_expr_prime1056 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000480L});
    public static final BitSet FOLLOW_expr_prime_in_expr_prime1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_expr_prime1080 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_expr_prime1082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_expr_prime1084 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000480L});
    public static final BitSet FOLLOW_expr_prime_in_expr_prime1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_facto_unaire1115 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_atom_in_facto_unaire1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_facto_unaire1130 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_atom_in_facto_unaire1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_facto_unaire1145 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_atom_in_facto_unaire1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_facto_unaire1160 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_atom_in_facto_unaire1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_level3_in_level21181 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_level21184 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_level3_in_level21187 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_level4_in_level31200 = new BitSet(new long[]{0x1800000000000002L,0x0000000000078000L});
    public static final BitSet FOLLOW_79_in_level31204 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_80_in_level31209 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_59_in_level31214 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_81_in_level31219 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_60_in_level31224 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_82_in_level31229 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_level4_in_level31233 = new BitSet(new long[]{0x1800000000000002L,0x0000000000078000L});
    public static final BitSet FOLLOW_level5_in_level41246 = new BitSet(new long[]{0x0000000000000002L,0x0000000000081000L});
    public static final BitSet FOLLOW_83_in_level41250 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_76_in_level41255 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_level5_in_level41260 = new BitSet(new long[]{0x0000000000000002L,0x0000000000081000L});
    public static final BitSet FOLLOW_atom_in_level51274 = new BitSet(new long[]{0x0000000000000002L,0x0000000000102000L});
    public static final BitSet FOLLOW_77_in_level51278 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_84_in_level51283 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_atom_in_level51288 = new BitSet(new long[]{0x0000000000000002L,0x0000000000102000L});
    public static final BitSet FOLLOW_CSTE_ENT_in_atom1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_atom1315 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_atom1317 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_atom1319 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000480L});
    public static final BitSet FOLLOW_expr_prime_in_atom1322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_atom1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_atom1382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_facto_unaire_in_atom1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDF_in_atom1402 = new BitSet(new long[]{0x0010000000000002L,0x0000000000000480L});
    public static final BitSet FOLLOW_52_in_atom1406 = new BitSet(new long[]{0x04F08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_atom1409 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_49_in_atom1412 = new BitSet(new long[]{0x04D08C0000000000L,0x0000000000603060L});
    public static final BitSet FOLLOW_expr_in_atom1414 = new BitSet(new long[]{0x0022000000000000L});
    public static final BitSet FOLLOW_53_in_atom1420 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000480L});
    public static final BitSet FOLLOW_expr_prime_in_atom1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_prime_in_atom1527 = new BitSet(new long[]{0x0000000000000002L});

}