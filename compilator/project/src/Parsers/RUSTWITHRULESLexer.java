package Parsers;
// $ANTLR 3.3 Nov 30, 2010 12:50:56 RUSTWITHRULES.g 2018-02-27 15:18:39

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class RUSTWITHRULESLexer extends Lexer {
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

    public RUSTWITHRULESLexer() {;} 
    public RUSTWITHRULESLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public RUSTWITHRULESLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "RUSTWITHRULES.g"; }

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:3:7: ( 'struct' )
            // RUSTWITHRULES.g:3:9: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:4:7: ( '{' )
            // RUSTWITHRULES.g:4:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:5:7: ( ':' )
            // RUSTWITHRULES.g:5:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:6:7: ( ',' )
            // RUSTWITHRULES.g:6:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:7:7: ( '}' )
            // RUSTWITHRULES.g:7:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:8:7: ( 'fn' )
            // RUSTWITHRULES.g:8:9: 'fn'
            {
            match("fn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:9:7: ( '(' )
            // RUSTWITHRULES.g:9:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:10:7: ( ')' )
            // RUSTWITHRULES.g:10:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:11:7: ( '->' )
            // RUSTWITHRULES.g:11:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:12:7: ( '&' )
            // RUSTWITHRULES.g:12:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:13:7: ( 'i32' )
            // RUSTWITHRULES.g:13:9: 'i32'
            {
            match("i32"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:14:7: ( 'bool' )
            // RUSTWITHRULES.g:14:9: 'bool'
            {
            match("bool"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:15:7: ( 'vec' )
            // RUSTWITHRULES.g:15:9: 'vec'
            {
            match("vec"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:16:7: ( '<' )
            // RUSTWITHRULES.g:16:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:17:7: ( '>' )
            // RUSTWITHRULES.g:17:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:18:7: ( ';' )
            // RUSTWITHRULES.g:18:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:19:7: ( 'let' )
            // RUSTWITHRULES.g:19:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:20:7: ( 'mut' )
            // RUSTWITHRULES.g:20:9: 'mut'
            {
            match("mut"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:21:7: ( '=' )
            // RUSTWITHRULES.g:21:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:22:7: ( 'while' )
            // RUSTWITHRULES.g:22:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:23:7: ( 'return' )
            // RUSTWITHRULES.g:23:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:24:7: ( 'if' )
            // RUSTWITHRULES.g:24:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:25:7: ( 'else' )
            // RUSTWITHRULES.g:25:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:26:7: ( 'print' )
            // RUSTWITHRULES.g:26:9: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:27:7: ( '!' )
            // RUSTWITHRULES.g:27:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:28:7: ( '[' )
            // RUSTWITHRULES.g:28:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:29:7: ( ']' )
            // RUSTWITHRULES.g:29:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:30:7: ( '||' )
            // RUSTWITHRULES.g:30:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:31:7: ( '.' )
            // RUSTWITHRULES.g:31:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:32:7: ( 'len' )
            // RUSTWITHRULES.g:32:9: 'len'
            {
            match("len"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:33:7: ( '-' )
            // RUSTWITHRULES.g:33:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:34:7: ( '*' )
            // RUSTWITHRULES.g:34:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:35:7: ( '&&' )
            // RUSTWITHRULES.g:35:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:36:7: ( '==' )
            // RUSTWITHRULES.g:36:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:37:7: ( '!=' )
            // RUSTWITHRULES.g:37:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:38:7: ( '<=' )
            // RUSTWITHRULES.g:38:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:39:7: ( '>=' )
            // RUSTWITHRULES.g:39:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:40:7: ( '+' )
            // RUSTWITHRULES.g:40:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:41:7: ( '/' )
            // RUSTWITHRULES.g:41:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:42:7: ( 'true' )
            // RUSTWITHRULES.g:42:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:43:7: ( 'false' )
            // RUSTWITHRULES.g:43:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "IDF"
    public final void mIDF() throws RecognitionException {
        try {
            int _type = IDF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:210:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // RUSTWITHRULES.g:210:13: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // RUSTWITHRULES.g:210:33: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // RUSTWITHRULES.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDF"

    // $ANTLR start "CSTE_ENT"
    public final void mCSTE_ENT() throws RecognitionException {
        try {
            int _type = CSTE_ENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:211:9: ( ( '0' .. '9' )+ )
            // RUSTWITHRULES.g:211:11: ( '0' .. '9' )+
            {
            // RUSTWITHRULES.g:211:11: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // RUSTWITHRULES.g:211:12: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CSTE_ENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:212:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // RUSTWITHRULES.g:212:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // RUSTWITHRULES.g:212:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\t' && LA3_0<='\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // RUSTWITHRULES.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // RUSTWITHRULES.g:213:9: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // RUSTWITHRULES.g:213:10: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // RUSTWITHRULES.g:213:15: ( options {greedy=false; } : . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='/') ) {
                        alt4=2;
                    }
                    else if ( ((LA4_1>='\u0000' && LA4_1<='.')||(LA4_1>='0' && LA4_1<='\uFFFF')) ) {
                        alt4=1;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<=')')||(LA4_0>='+' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // RUSTWITHRULES.g:213:41: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match("*/"); 

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // RUSTWITHRULES.g:1:8: ( T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | IDF | CSTE_ENT | WS | COMMENT )
        int alt5=45;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // RUSTWITHRULES.g:1:10: T__46
                {
                mT__46(); 

                }
                break;
            case 2 :
                // RUSTWITHRULES.g:1:16: T__47
                {
                mT__47(); 

                }
                break;
            case 3 :
                // RUSTWITHRULES.g:1:22: T__48
                {
                mT__48(); 

                }
                break;
            case 4 :
                // RUSTWITHRULES.g:1:28: T__49
                {
                mT__49(); 

                }
                break;
            case 5 :
                // RUSTWITHRULES.g:1:34: T__50
                {
                mT__50(); 

                }
                break;
            case 6 :
                // RUSTWITHRULES.g:1:40: T__51
                {
                mT__51(); 

                }
                break;
            case 7 :
                // RUSTWITHRULES.g:1:46: T__52
                {
                mT__52(); 

                }
                break;
            case 8 :
                // RUSTWITHRULES.g:1:52: T__53
                {
                mT__53(); 

                }
                break;
            case 9 :
                // RUSTWITHRULES.g:1:58: T__54
                {
                mT__54(); 

                }
                break;
            case 10 :
                // RUSTWITHRULES.g:1:64: T__55
                {
                mT__55(); 

                }
                break;
            case 11 :
                // RUSTWITHRULES.g:1:70: T__56
                {
                mT__56(); 

                }
                break;
            case 12 :
                // RUSTWITHRULES.g:1:76: T__57
                {
                mT__57(); 

                }
                break;
            case 13 :
                // RUSTWITHRULES.g:1:82: T__58
                {
                mT__58(); 

                }
                break;
            case 14 :
                // RUSTWITHRULES.g:1:88: T__59
                {
                mT__59(); 

                }
                break;
            case 15 :
                // RUSTWITHRULES.g:1:94: T__60
                {
                mT__60(); 

                }
                break;
            case 16 :
                // RUSTWITHRULES.g:1:100: T__61
                {
                mT__61(); 

                }
                break;
            case 17 :
                // RUSTWITHRULES.g:1:106: T__62
                {
                mT__62(); 

                }
                break;
            case 18 :
                // RUSTWITHRULES.g:1:112: T__63
                {
                mT__63(); 

                }
                break;
            case 19 :
                // RUSTWITHRULES.g:1:118: T__64
                {
                mT__64(); 

                }
                break;
            case 20 :
                // RUSTWITHRULES.g:1:124: T__65
                {
                mT__65(); 

                }
                break;
            case 21 :
                // RUSTWITHRULES.g:1:130: T__66
                {
                mT__66(); 

                }
                break;
            case 22 :
                // RUSTWITHRULES.g:1:136: T__67
                {
                mT__67(); 

                }
                break;
            case 23 :
                // RUSTWITHRULES.g:1:142: T__68
                {
                mT__68(); 

                }
                break;
            case 24 :
                // RUSTWITHRULES.g:1:148: T__69
                {
                mT__69(); 

                }
                break;
            case 25 :
                // RUSTWITHRULES.g:1:154: T__70
                {
                mT__70(); 

                }
                break;
            case 26 :
                // RUSTWITHRULES.g:1:160: T__71
                {
                mT__71(); 

                }
                break;
            case 27 :
                // RUSTWITHRULES.g:1:166: T__72
                {
                mT__72(); 

                }
                break;
            case 28 :
                // RUSTWITHRULES.g:1:172: T__73
                {
                mT__73(); 

                }
                break;
            case 29 :
                // RUSTWITHRULES.g:1:178: T__74
                {
                mT__74(); 

                }
                break;
            case 30 :
                // RUSTWITHRULES.g:1:184: T__75
                {
                mT__75(); 

                }
                break;
            case 31 :
                // RUSTWITHRULES.g:1:190: T__76
                {
                mT__76(); 

                }
                break;
            case 32 :
                // RUSTWITHRULES.g:1:196: T__77
                {
                mT__77(); 

                }
                break;
            case 33 :
                // RUSTWITHRULES.g:1:202: T__78
                {
                mT__78(); 

                }
                break;
            case 34 :
                // RUSTWITHRULES.g:1:208: T__79
                {
                mT__79(); 

                }
                break;
            case 35 :
                // RUSTWITHRULES.g:1:214: T__80
                {
                mT__80(); 

                }
                break;
            case 36 :
                // RUSTWITHRULES.g:1:220: T__81
                {
                mT__81(); 

                }
                break;
            case 37 :
                // RUSTWITHRULES.g:1:226: T__82
                {
                mT__82(); 

                }
                break;
            case 38 :
                // RUSTWITHRULES.g:1:232: T__83
                {
                mT__83(); 

                }
                break;
            case 39 :
                // RUSTWITHRULES.g:1:238: T__84
                {
                mT__84(); 

                }
                break;
            case 40 :
                // RUSTWITHRULES.g:1:244: T__85
                {
                mT__85(); 

                }
                break;
            case 41 :
                // RUSTWITHRULES.g:1:250: T__86
                {
                mT__86(); 

                }
                break;
            case 42 :
                // RUSTWITHRULES.g:1:256: IDF
                {
                mIDF(); 

                }
                break;
            case 43 :
                // RUSTWITHRULES.g:1:260: CSTE_ENT
                {
                mCSTE_ENT(); 

                }
                break;
            case 44 :
                // RUSTWITHRULES.g:1:269: WS
                {
                mWS(); 

                }
                break;
            case 45 :
                // RUSTWITHRULES.g:1:272: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\41\4\uffff\1\41\2\uffff\1\50\1\52\3\41\1\60\1\62\1\uffff"+
        "\2\41\1\66\4\41\1\74\6\uffff\1\76\1\41\3\uffff\1\41\1\101\1\41\4"+
        "\uffff\1\41\1\104\2\41\4\uffff\2\41\2\uffff\4\41\4\uffff\2\41\1"+
        "\uffff\1\41\1\121\1\uffff\1\41\1\123\1\124\1\125\1\126\7\41\1\uffff"+
        "\1\136\4\uffff\2\41\1\141\1\41\1\143\1\41\1\145\1\uffff\1\146\1"+
        "\41\1\uffff\1\150\1\uffff\1\151\2\uffff\1\152\3\uffff";
    static final String DFA5_eofS =
        "\153\uffff";
    static final String DFA5_minS =
        "\1\11\1\164\4\uffff\1\141\2\uffff\1\76\1\46\1\63\1\157\1\145\2"+
        "\75\1\uffff\1\145\1\165\1\75\1\150\1\145\1\154\1\162\1\75\6\uffff"+
        "\1\52\1\162\3\uffff\1\162\1\60\1\154\4\uffff\1\62\1\60\1\157\1\143"+
        "\4\uffff\1\156\1\164\2\uffff\1\151\1\164\1\163\1\151\4\uffff\2\165"+
        "\1\uffff\1\163\1\60\1\uffff\1\154\4\60\1\154\1\165\1\145\1\156\1"+
        "\145\1\143\1\145\1\uffff\1\60\4\uffff\1\145\1\162\1\60\1\164\1\60"+
        "\1\164\1\60\1\uffff\1\60\1\156\1\uffff\1\60\1\uffff\1\60\2\uffff"+
        "\1\60\3\uffff";
    static final String DFA5_maxS =
        "\1\175\1\164\4\uffff\1\156\2\uffff\1\76\1\46\1\146\1\157\1\145"+
        "\2\75\1\uffff\1\145\1\165\1\75\1\150\1\145\1\154\1\162\1\75\6\uffff"+
        "\1\52\1\162\3\uffff\1\162\1\172\1\154\4\uffff\1\62\1\172\1\157\1"+
        "\143\4\uffff\2\164\2\uffff\1\151\1\164\1\163\1\151\4\uffff\2\165"+
        "\1\uffff\1\163\1\172\1\uffff\1\154\4\172\1\154\1\165\1\145\1\156"+
        "\1\145\1\143\1\145\1\uffff\1\172\4\uffff\1\145\1\162\1\172\1\164"+
        "\1\172\1\164\1\172\1\uffff\1\172\1\156\1\uffff\1\172\1\uffff\1\172"+
        "\2\uffff\1\172\3\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\7\uffff\1\20\10\uffff"+
        "\1\32\1\33\1\34\1\35\1\40\1\46\2\uffff\1\52\1\53\1\54\3\uffff\1"+
        "\11\1\37\1\41\1\12\4\uffff\1\44\1\16\1\45\1\17\2\uffff\1\42\1\23"+
        "\4\uffff\1\43\1\31\1\55\1\47\2\uffff\1\6\2\uffff\1\26\14\uffff\1"+
        "\13\1\uffff\1\15\1\21\1\36\1\22\7\uffff\1\14\2\uffff\1\27\1\uffff"+
        "\1\50\1\uffff\1\51\1\24\1\uffff\1\30\1\1\1\25";
    static final String DFA5_specialS =
        "\153\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\43\2\uffff\1\43\22\uffff\1\43\1\30\4\uffff\1\12\1\uffff"+
            "\1\7\1\10\1\35\1\36\1\4\1\11\1\34\1\37\12\42\1\3\1\20\1\16\1"+
            "\23\1\17\2\uffff\32\41\1\31\1\uffff\1\32\3\uffff\1\41\1\14\2"+
            "\41\1\26\1\6\2\41\1\13\2\41\1\21\1\22\2\41\1\27\1\41\1\25\1"+
            "\1\1\40\1\41\1\15\1\24\3\41\1\2\1\33\1\5",
            "\1\44",
            "",
            "",
            "",
            "",
            "\1\46\14\uffff\1\45",
            "",
            "",
            "\1\47",
            "\1\51",
            "\1\53\62\uffff\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\61",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "\1\77",
            "",
            "",
            "",
            "\1\100",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\102",
            "",
            "",
            "",
            "",
            "\1\103",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\105",
            "\1\106",
            "",
            "",
            "",
            "",
            "\1\110\5\uffff\1\107",
            "\1\111",
            "",
            "",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "",
            "",
            "",
            "",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\1\122",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "",
            "",
            "\1\137",
            "\1\140",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\142",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\144",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\147",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | IDF | CSTE_ENT | WS | COMMENT );";
        }
    }
 

}