package TDSPackage;

import Parsers.SemanticParser;

public class BoolVar extends Var{

	//private int val;
	
	public BoolVar(String idf, boolean mut/*, int val*/){
		super(idf, mut);
		//this.val= val;
	}
	
	public String getType(){
		return SemanticParser.TYPE_BOOL;
	}
	
	public int getSize() {
		return 2;
	}
	
}
