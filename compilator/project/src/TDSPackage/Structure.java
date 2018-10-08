package TDSPackage;

import TDSPackage.Symbol;
import TDSPackage.Var;

import java.util.ArrayList;

public class Structure extends Symbol {

    private String idf;
    private ArrayList<Var> fields;

    public Structure(String idf){
        super(idf);
        this.idf = idf;
        this.fields = new ArrayList<Var>();
    }

    public void addFields(ArrayList<Var> v) {
        this.fields.addAll(v);
    }

    /**
     * Recupere un champ de la structure
     * @param field nom du champ teste
     * @return le champ en question ou null s'il n'existe pas
     */
    public Var getField(String field){
        for (Var v : fields){
            if (v.getIdf().equals(field)){
                return v;
            }
        }
        return null;
    }

    public ArrayList<Var> getFields(){
        return this.fields;
    }

    public int getSize(){
        int size = 0;
        for (Var v : this.getFields()){
            size += v.getSize();
        }
        return size;
    }

    @Override
    public String getType(){
        return idf;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("STRUCTURE : " + this.idf + "\nFIELDS : \n");
        for (Var v : this.fields)
            res.append("\t").append(v.toString()).append("\n");
        return res.toString();
    }
}