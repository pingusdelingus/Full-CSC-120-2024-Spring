package Project2;

public class Tree {
    private double treeHeight;
    public enum Species{
        birch,
        maple,
        fir
    }
    private int birthYear;
    private Species Species;
    private double growthRatePerYear;

    public Tree(double treeHeight, int treeBirthYear, double treeGrowthRate, Species treeSpecies){
        this.treeHeight = 0;
        this.birthYear = 0;
        this.growthRatePerYear = 0;
        this.Species = treeSpecies;

    }// end of Tree  constructor


    public void grow(Tree tree){
        tree.treeHeight = (tree.treeHeight + (tree.growthRatePerYear * tree.treeHeight));
    }
    public void reapTree(double reapHeight){
        if(this.treeHeight >= reapHeight){
            this.treeHeight = 0;
        }

    }// end of reapTree METHOD


}// end of Tree CLASS
