package TDSPackage;

import java.util.ArrayList;

public class Function extends Symbol {

	private String returntype;
	private ArrayList<Var> parameters;
	
	public Function(String idf, String rtype) {
		super(idf);
		this.returntype = rtype;
		this.parameters = new ArrayList<Var>();
	}

	@Override
	public String getType() {
		return returntype;
	}
	
	public void addParameters(ArrayList<Var> v) {
		this.parameters.addAll(v);
	}

	
	public ArrayList<Var> getParameters() {
		return parameters;
	}
	
	public int getSize() {
		int res = 0;
		for(int i = 0; i < this.parameters.size(); i++) {
			res += this.parameters.get(i).getSize();
		}
		return res;
	}

	public String toString() {
		String res = "FUNCTION : " + this.idf + " - RETURN : " + getType() + "\n";
		res += "ARGSLIST : \n";
		for(Var v : this.parameters)
			res += "\t" + v.toString();
		return res;
	}
	
	
}
