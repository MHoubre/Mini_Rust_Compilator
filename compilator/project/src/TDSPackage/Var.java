package TDSPackage;

public abstract class Var extends Symbol{

	protected boolean mut;
	protected int stackValue;
	protected boolean isDeclared= false; // sert lors de la generation du code assembleur
	protected int size;
	
	public Var(String idf, boolean mut){
		super(idf);
		this.mut= mut;
	}
	
	public boolean Compare(Symbol s){
		if(super.compare(s)){
			if(s.getType().equals(this.getType())){
				return true;
			}else{
				System.out.println("Semantic Error: incompatible types: "+s.getIdf()+" and "+this.getIdf());
			}
		}
		return false;
	}
	
	public abstract String getType();
	
	public boolean getMut(){
		return this.mut;
	}
	
	public String toString() {
		return  "VAR : " + this.idf + " - " + (mut ? "Mutable" : "Non-Mutable") + " - " + this.getType() + " - "+ this.stackValue;
	}
	
	public void setStackValue(int i){
		this.stackValue= i;
	}
	
	public int getStackValue(){
		return this.stackValue;
	}
	
	public boolean getDeclaredStatus(){
		return this.isDeclared;
	}
	
	public void setIsDeclared(){
		this.isDeclared= true;
	}
	
	public abstract int getSize();
	
	
}
