package TDSPackage;
import java.util.ArrayList;

public class TDS {

	public final static int NO_DECLARATION_FLAG= 1;
	public final static int DECLARED_BUT_NOT_MUTABLE_FLAG= 2;
	public final static int DECLARED_AND_MUTABLE_FLAG= 3;
	
	private int stackPointer= 0;
	private int id;
	private ArrayList<Symbol> arrayListSymbols;
	
	// Pour recuperer les elts lors du parcours de la pile des regions ouvertes
	private Symbol currentSymbol;
	
	public TDS(int id){
		this.id= id;
		this.arrayListSymbols = new ArrayList<Symbol>();
	}
	
	/**
	 * A utiliser dans le cadre d'une identification de variable (ex: let a = val + 1) // a utiliser pour val
	 */
	/*public boolean containsSymbol(Symbol s){
		for(int i= 0; i<arrayListSymbols.size(); i++){
			if(s.compare(arrayListSymbols.get(i))){
				return true;
			}
		}
		return false;
	}*/
	
	/**
	 * A utiliser sur membre gauche lors d'une affectation (ex: let a = val + 1) // a utiliser pour a
	 */
	public Symbol containsSymbol(String idf){
		Symbol current = null;
		for(int i= 0; i<arrayListSymbols.size(); i++){
			current= arrayListSymbols.get(i);
			//if(current instanceof Var){ // Car seuls les Var sont mutables
				if(current.getIdf().equals(idf)){
					// On verifie si current est mutable
					/*if(((Var)current).getMut()){
						this.currentSymbol= current;
					}else{
						System.out.println("Semantic Error: affectation to non-mutable variable "+current.getIdf());
					}*/
					return current;
				}
			//}
		}
		return null;
	}
	
	/*public Symbol getCurrentSymbol(){
		return this.currentSymbol;
	}
	
	public void setCurrentSymbol(Symbol currentSymbol){
		this.currentSymbol= currentSymbol;
	}*/
	
	/**
	 * 
	 * @param : nouveau symbole (juste cree a partir des infos de la ligne)
	 * @param : idf du symbole affecte
	 * ex: let v = w : s <=> v et idf <=> w
	 */
	/*public boolean changeOwner(Symbol , String idf){
		// 1: chercher si W existe, garder son type
		// 2: 
		return false;
	}*/
	
	public ArrayList<Symbol> getArrayListSymbols() {
		return arrayListSymbols;
	}

	/**
	 * Pour ajouter Symbol s dans arrayList
	 */
	public void addSymbol(Symbol s){
		this.arrayListSymbols.add(s);
		if(s instanceof Var){
			((Var)s).setStackValue(this.stackPointer);
			this.stackPointer+= ((Var)s).getSize()/2;
		}
	}

	
	public String toString() {
		String res = "";
		res += "------------------" + this.id +"------------------\n";
		
		for(Symbol s : this.arrayListSymbols) {
			res += s.toString() + "\n";
		}
		res += "-------------------------------------\n";
		return res;
	}
}
