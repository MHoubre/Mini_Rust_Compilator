package TDSPackage;

import Parsers.SemanticParser;

public class IntVar extends Var{

	//private int val;
	
	public IntVar(String idf, boolean mut/*, int val*/){
		super(idf, mut);
		//this.val= val;
	}
	
	public String getType(){
		return SemanticParser.TYPE_I32;
	}
	
	public int getSize() {
		return 2;
	}
}
