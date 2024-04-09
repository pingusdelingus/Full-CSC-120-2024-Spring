package week13;

public class Diamond {
    private int carat;
    private double value;

    public Diamond(){
        this.carat = 0;
        this.value = 0.0;
    }// end default constructor

    public Diamond(int carat, double value){
        this.carat = carat;
        this.value = value;
    }// end constructor

    public int getCarat(){
        return this.carat;
    }// end getCarat METHOD

    public double getValue(){
        return this.value;
    }// end getValue METHOD
    public void setValue(double newValue){
        this.value = newValue;
    }
    public void setCarat(int newCarat){
        this.carat = newCarat;

    }


}// end of Diamond CLASS
