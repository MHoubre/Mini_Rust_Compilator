grammar RUSTWITHRULES;

options {
   k = 1;
   output=AST;
}

tokens{
	ROOT;
	STRUCT;
	STRUCT_ELTS;
	STRUCT_ELT;
	FUN;
	FUN_ARGS;
	ARG;
	TYPE_VEC;
	TYPE_ADDR;
	BLOC;
	EXPR;
	RETOUR_BLOC;
	AFF;
	WHILE;
	RETURN;
	FUN_CALL;
	FUN_CALL_ELT;
	AFF_STRUCT;
	AFF_STRUCT_ELT;
	IF;
	ELSE;
	VEC_DECL;
	VEC_ELT;
	PRINT;
	EXPR_PARENTHESEE;
	POINT_ACCESS;
	BRACKET_ACCESS;
	LENGTH_ACCESS;
	OPPOSE;
	PTR_CONTENT_ACCESS;
	VAR_ADDRESS_ACCESS;
	OPPOSE_BOOL;
	AFF_STRUCT_SS_ACCOLADE;
	SS_ACCOLADE;
	FIN_AFF;
	L_VALUE;
	R_VALUE;
	/*PRIME;*/
	ACCESS;
}



fichier	:	decl*  -> ^(ROOT decl*) 
	;
	
decl 	:	decl_struct
	|	decl_fun 
	;
decl_struct 
	:	('struct' IDF -> IDF) (  '{' (IDF ':' type (',' IDF ':' type)*)? '}' -> ^(STRUCT $decl_struct  ^(STRUCT_ELT IDF type )*)  )	
	;
	
decl_fun:	'fn' IDF '(' ( argument ( ',' argument)* )? ')' ('->' type)? bloc -> ^(FUN IDF ^(FUN_ARGS argument*) type? bloc)
	;

type	:     IDF
	| 	'&' type -> ^(TYPE_ADDR type)
	|	 'i32'
	|	 'bool'
	|         'vec' '<' type '>' -> ^(TYPE_VEC type)
	;
		
argument
	:	IDF ':' type -> ^(ARG IDF type)
	;
	
bloc	
	: '{' instruction? '}' -> ^(BLOC instruction?)
	;
	
instruction_inter
	: instruction	
	;	
	
instruction
	:	';' instruction_inter? -> instruction_inter?
	|	 expr ( -> ^(RETOUR_BLOC expr) | (';' instruction_inter?) -> expr instruction_inter? )
	// IDF place a ce niveau mais c'est pas grave, il suffira de faire la verification semantique pour les accolades "ce qui peut etre accepte syntaxiquement ne l'est pas forcement semantiquement" Da.Silva
	|	('let' 'mut'? name=expr '=' res=expr -> ^(L_VALUE $name) ^(R_VALUE $res)) (  ';' instruction_inter? -> ^(AFF 'mut'? $instruction) instruction_inter?
							   | accolade/*'{' (IDF ':' expr (',' IDF ':' expr )*)? '}'*/ expr_prime? ';' instruction_inter? -> ^(AFF_STRUCT 'mut'? $instruction accolade) expr_prime? instruction_inter?
					  		)
	|	'while'  expr  bloc instruction_inter? -> ^(WHILE expr bloc) instruction_inter?
	|	'return' expr? ';' instruction_inter? -> ^(RETURN expr?) instruction_inter?
	|	if_expr instruction_inter?
	;
	
accolade 
	: '{' (IDF ':' expr ss_accolade (',' IDF ':' expr ss_accolade )*)? '}' -> ^(AFF_STRUCT_ELT IDF expr ss_accolade)*
	;
	
ss_accolade
	: '{' (IDF ':' expr ss_accolade (',' IDF ':' expr ss_accolade )*)? '}' -> ^(SS_ACCOLADE ^(AFF_STRUCT_SS_ACCOLADE IDF expr ss_accolade)*)
	| -> ^(FIN_AFF)
	;

/*
instruction_expr_facto
	: expr_commune ';' -> expr_commune
    	| IDF instruction_facto -> ^(AFF_WITH_IDF IDF instruction_facto)
    	;
    	

instruction_facto
    :  ('(' (expr (',' expr)*)? ')' expr_prime? ';' -> ^(FUN_CALL_AFF ^(FUN_CALL_ELT expr)*) expr_prime?
        | expr_prime? ';' -> expr_prime?
       )
    |  '{' (IDF ':' expr (',' IDF ':' expr )*)? '}' -> ^(AFF_STRUCT ^(AFF_STRUCT_ELT IDF expr)*)
    ;
*/

if_expr	: 'if' expr bloc ('else' (if_test))? -> ^(IF expr bloc ^(ELSE if_test)?) 
	;
	
if_test 	: bloc
	| if_expr
	;

//Raison percise du problme, ANTLR ne sait pas quelle regle appliquer quand il lit '-' ou '*' alors qu'on a deja eu une expr, en effet '-' et '*' son dans binaire et unaire !

/*expr_commune 
	//:  CSTE_ENT expr_prime?  -> DANS ATOM MAINTENANT
    	//: 'true' expr_prime? -> DANSS ATOM
    	//| 'false' expr_prime? -> DANS ATOM
    	: 'print' '!' '(' expr ')' expr_prime? -> ^(PRINT expr) expr_prime?
    	| bloc expr_prime?
    	//| '(' expr ')' expr_prime? -> ^(EXPR_PARENTHESEE expr) expr_prime? -> DANS ATOM MAINTENANT
    	| facto_unaire
    	| level2 ('||'^ level2)*
    	;*/

	
expr	
    : 'print' '!' '(' expr ')' -> ^(PRINT expr)
    | 'vec' '!' '[' (expr(',' expr) *)? ']' -> ^(VEC_DECL ^(VEC_ELT expr)* )
    | bloc
    | level2 ('||'^ level2)*
    ;
    
        
/*expr_prime 
	:'.'    ( 'len' '(' ')' -> ^(LENGTH_ACCESS)
		 | IDF expr_prime?  -> ^(POINT_ACCESS IDF) expr_prime?
		)
	//|'[' expr ']' expr_prime? -> ^(BRACKET_ACCESS expr) expr_prime?
	;*/
	
expr_prime 
	:'.' 	( 'len' '(' ')' -> ^(LENGTH_ACCESS) 
		 | IDF expr_prime?  -> ^(POINT_ACCESS IDF expr_prime?) 
		)
	|'[' expr ']' expr_prime? -> ^(BRACKET_ACCESS expr expr_prime?) 
	;
    
facto_unaire 
	: '-' atom -> ^(OPPOSE atom)
	| '*' atom -> ^(PTR_CONTENT_ACCESS atom)
	| '&' atom -> ^(VAR_ADDRESS_ACCESS atom)
	| '!' atom -> ^(OPPOSE_BOOL atom)	 
	;

level2:	level3 ('&&'^ level3)* 
	;
	
level3:	level4 (('=='^ | '!='^ | '<'^ | '<='^ | '>'^ | '>='^) level4)* 
	;
	
level4:	level5 (('+'^ | '-'^ ) level5)* 
	;	
	
level5:	atom (('*'^ | '/'^ ) atom)* 
	;	
	
/*atom 
	: CSTE_ENT expr_prime?
	| '(' expr ')' expr_prime? -> ^(EXPR_PARENTHESEE expr) expr_prime?
	| 'true' expr_prime?
        | 'false' expr_prime?
        |  facto_unaire
        | IDF	(	('(' (expr (',' expr)*)? ')'   -> ^(FUN_CALL IDF ^(FUN_CALL_ELT expr)*  ) )(('[' expr ']' -> ^(BRACKET_ACCESS $atom expr))*  )( (expr_prime?) -> ^(PRIME $atom expr_prime?) )  
    			| expr_prime? -> ^(IDF expr_prime?)
    			| (('[' expr ']' ) -> ^(BRACKET_ACCESS IDF expr) ) ( ('[' expr ']' -> ^(BRACKET_ACCESS $atom expr))*  )( (expr_prime?) -> ^(PRIME $atom expr_prime?) )  
    				
    	  	) 
	;	*/
	
atom 
	: CSTE_ENT 
	| '(' expr ')' (expr_prime -> ^(ACCESS ^(EXPR_PARENTHESEE expr) expr_prime )
	                | -> ^(EXPR_PARENTHESEE expr) ) 
	| 'true' 
    	| 'false' 
    	|  facto_unaire
    	| IDF	(	'(' (expr (',' expr)*)? ')' (expr_prime  -> ^(ACCESS ^(FUN_CALL IDF ^(FUN_CALL_ELT expr)*) expr_prime )
    	                                             | -> ^(FUN_CALL IDF ^(FUN_CALL_ELT expr)*) ) 
    			| expr_prime -> ^(ACCESS IDF expr_prime)
    			| -> IDF
    	  	) 
	;	
	

IDF     :   ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z' | '_' | '0'..'9')* 	;
CSTE_ENT: ('0'..'9')+	;
WS	: (' ' | '\t' | '\n' | '\r')+ { $channel = HIDDEN; } ;
COMMENT :'/*' (options {greedy=false;}: .)* '*/'{ $channel=HIDDEN; };