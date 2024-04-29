package Project2;

import java.io.Serializable;

/**
 *  This class represents a Tree
 *  with properties: species, birth year, height, and growth rate.
 */
public class Tree implements Serializable {
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

    /** default constructor for Tree class */
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

    /** @param tree  simulates the growth of the tree
     *              by increasing the height of the tree by the growth rate
     *
     */
    public void grow(Tree tree){

        this.treeHeight = ((this.growthRatePerYear / 100) * this.treeHeight) + this.treeHeight;

    }
    public void reapTree(double reapHeight){
        if(this.treeHeight >= reapHeight){
            this.treeHeight = 0;
        }

    }// end of reapTree METHOD


    /** @return a string representation of the tree
     *  in the format: species, birth year, height, and growth rate.
     */
    public String toString(){
        String myString = null;
        myString = this.Treespecies + "  " + this.birthYear + "  " + String.format("%.2f" , this.treeHeight) + "' " + String.format("%.1f" ,this.growthRatePerYear)+ "%";
        return myString;
    }// end of toString


    /** @return the birth year of the tree
     */
    public double getHeight(){
        return this.treeHeight;
    }// end of getHeight




}// end of Tree CLASS
