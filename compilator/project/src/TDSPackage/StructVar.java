package TDSPackage;

public class StructVar extends Var {

    private String type; //Le type de la structure
    private Structure structure;

    public StructVar(String idf, boolean mut, String type) {
        super(idf, mut);
        this.type = type;
        this.structure = null;
    }

    public void setStructure(Structure struct){
        this.structure = struct;
        //System.out.println(this.structure);
    }

    public Structure getStructure(){
        return this.structure;
    }

    @Override
    public String getType() {
        return type;
    }
    
    // TODO A completer ici pour que la fonction renvoi la taille nécessaire en mémoire poure représenter la structure (si c'est une structure avec 3 champs i32, il faudra 3 cases donc une taille
	public int getSize() {
		//System.out.println("/!\\ Attention : taille d'une structure pas encore implémentée pour l'assembleur !");
		return this.structure.getSize();
	}
}
