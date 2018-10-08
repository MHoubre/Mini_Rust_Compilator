package TDSPackage;

import Parsers.SemanticParser;

import java.util.ArrayList;

public class Vec extends OwnableVar {

    private ArrayList<Var> components;
    private String comptype;

    public Vec(String s, boolean mutable){
        super(s,mutable);
        this.components= new ArrayList<Var>();
        this.comptype = null;

    }

    public void setNumberOfComp(int n){
        this.components = new ArrayList<Var>(n);
    }

    public String getType(){
        return SemanticParser.TYPE_VEC;
    }

    public String getComptype(){
        return this.comptype;
    }

    public void setComptype(String s){
        this.comptype = s;
    }

    public void setMut(Boolean b){
        this.mut=b;
    }

    public void addComponent(Var var){

        if(var.getType().equals(this.comptype)){
            this.components.add(var);
        }
        else{
            System.out.println("Semantic error "+ " "+var.getType()+" "+var.getIdf() + " should be of type " +this.comptype);
        }
    }

    public Var getComponent(int i){
        return this.components.get(i);
    }

    public ArrayList<Var> getComponents() {
        return this.components;
    }

    public ArrayList<Var> popComponent(int i) {
        this.components.remove(i);
        return this.components;
    }

    public String toString(){
        String res= "VEC : " +this.idf + " - " + (mut ? "Mutable" : "Non-Mutable") + " - " + this.getType();
        res += "\n" + "COMPONENTS : " + "\t";
        for (Var v : this.components){
            if(v instanceof Vec){
                res+= "\t"+"VEC : "+ v.getIdf();
            }else {
                res += "\t" + v.toString();
            }
        }

        return res;
    }
    
    // TODO A completer ici pour que la fonction renvoi la taille du tableau nécessaire en mémoire (par exemple si c'est un tableau qui contient 2 i32, il faudra 4 case je crois car
    // 2 * 2octets = 4 cases (comme si on stockait 2 i32 en fait, un i32 = 2 octets)
	public int getSize() {
        int size=0;
        for(int i =0; i<this.components.size();i++){
            size += this.components.get(i).getSize();
        }
        return size;
    }

}

