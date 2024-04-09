package week13;

public class Girl {
    private String name;
    private Diamond herDiamond;

    public Girl(){
        name = null;
        herDiamond = null;

    }// end default constructor
    public Girl(String herName){
        this();
        this.name = herName;


    }// end constructor

    public void setDiamond(Diamond aDiamond){
        herDiamond = aDiamond;

    }

    public String toString(){
        return name + " has a diamond, " + this.herDiamond.getCarat()
                + " carats, worth $" + this.herDiamond.getValue();

    }// end of toString

    public boolean isDiamondBetter(int newCarat, double newValue){
        if(newValue >0 && newValue > this.herDiamond.getValue()){
            this.herDiamond.setValue(newValue);
            this.herDiamond.setCarat(newCarat);

            return true;
        }// end of if
        else{
            return false;
        }
    }// end of getDiamond

    public String getName(){
        return this.name;
    }
    public boolean checkDiamond(){
        if (this.herDiamond != null){

            return false;
        }
        else{
            return true;
        }
    }


}// end of Girl CLASS
