package TDSPackage;

import Parsers.SemanticParser;

public class PtrVar extends  OwnableVar{

    private String pointedVar;
    private String pointedType; //A utiliser pour les pointeurs paramètres de fonctions

    /**
     *
     * @param idf
     * @param mut
     * @param var
     */
    public PtrVar(String idf, boolean mut, String var){
        super(idf, mut);
        this.pointedVar = var;
        this.pointedType = null;
    }

    /**
     * Constructeur utilisé pour les pointeurs appartenant aux fonctions
     * @param idf
     * @param type
     */
    public PtrVar(String idf, String type){
        super(idf, false);
        this.pointedVar = null;
        this.pointedType = type;
    }

    /**
     * Constructeur utilisé pour les pointeurs appartenant aux structures ...
     * C'est du bricolage :c
     * @param idf
     * @param type
     * @param mut
     */
    public PtrVar(String idf, String type, boolean mut){
        super(idf, mut);
        this.pointedVar = null;
        this.pointedType = type;
    }


    public String getPointedType(){
        return this.pointedType;
    }

    public String getPointedVar() {
        return this.pointedVar;
    }

    public String getType(){
        return SemanticParser.TYPE_ADDR;
    }

    public String toString() {
        return  "VAR : " + this.idf + " - " + (mut ? "Mutable" : "Non-Mutable") + " - " + this.getType() + " - "+ this.stackValue
               + " - point to : " + this.getPointedVar();
    }

    @Override
    public int getSize() {
        return 2; //TODO vérifier la taille mais normalement c'est bon
    }

}