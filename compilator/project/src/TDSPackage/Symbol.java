package TDSPackage;

import Parsers.SemanticParser;

public abstract class Symbol {

	protected String idf;
	
	public final static String NULL_OWNER= "NULL_OWNER";
	
	public Symbol(String idf){
		this.idf= idf;
	}
	
	public abstract String getType();
	
	public String getIdf(){
		return this.idf;
	}
	
	public boolean compare(Symbol s){
		return this.idf.equals(s.getIdf()) ;
	}
	
}
