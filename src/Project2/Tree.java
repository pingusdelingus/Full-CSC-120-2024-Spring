package Project2;

public class Tree {
    private double treeHeight;
    public enum Species{
        Birch,
        Maple,
        Fir
    }
    private int birthYear;
    private Species Treespecies;
    private int treeNum;

    private double growthRatePerYear;

    public Tree(Species treeSpecies,int treeBirthYear, double treeHeight,  double treeGrowthRate,int treeNumber){
        this.treeHeight = treeHeight;
        this.birthYear = treeBirthYear;
        this.growthRatePerYear = treeGrowthRate;
        this.Treespecies = treeSpecies;
        this.treeNum = treeNumber;
    }// end of Tree constructor
    public Tree(int treeNumber){
        this.treeNum = treeNumber;
    }// end of tree number constructor


    public void grow(Tree tree){
        this.treeHeight = (this.treeHeight + (this.growthRatePerYear * this.treeHeight));
        this.birthYear = this.birthYear + 1;
    }
    public void reapTree(double reapHeight){
        if(this.treeHeight >= reapHeight){
            this.treeHeight = 0;
        }

    }// end of reapTree METHOD

    public String toString(){
        return this.Treespecies + "  " + this.birthYear + "  " + this.treeHeight + "' " + this.growthRatePerYear;
    }// end of toString

    public double getHeight(){
        return this.treeHeight;
    }// end of getHeight




}// end of Tree CLASS
