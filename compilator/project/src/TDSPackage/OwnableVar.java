package TDSPackage;

import Parsers.SemanticParser;

public abstract class OwnableVar extends Var{

	protected String owner;
	
	public OwnableVar(String idf, Boolean mut) {
		super(idf, mut);
		this.owner= Symbol.NULL_OWNER;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void setOwner(String newOwner){
		SemanticParser.printDebugging("Passage dans OWNER");
		this.owner= newOwner;
	}
	
	public String getOwner() {
		return this.owner;
	}
}
