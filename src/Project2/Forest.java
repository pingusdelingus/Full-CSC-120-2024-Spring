package Project2;

import java.io.*;
import java.util.ArrayList;


public class Forest implements Serializable {

    private String name;
    private String fileName;
    private ArrayList<Tree> listOfTrees = new ArrayList<>();

    /**
     * default constructor for Forest class
     */
    public Forest() {
        name = "";
    }// end of default constructor

    /**
     * @param name     the name of the forest
     * @param fileName the name of the file
     * @param Trees    the list of trees
     */
    public Forest(String name, String fileName, ArrayList<Tree> Trees) {
        this();
        this.name = name;
        this.fileName = fileName;
        this.listOfTrees = Trees;
    }// end of Forest constructor
    /**
     * @param tree     the name of the forest
     *
     */
    public void addTree(Tree tree) {
        listOfTrees.add(tree);
    }// end of addTree method

    /**
     * @param treeIndex the index of the tree to be removed
     */
    public void cutTree(int treeIndex) {
        listOfTrees.remove(treeIndex);

    }// end of cutTree method

    /** @param desiredIndex the index of the tree to be replaced
     *
     * @param randomTree the tree to replace the tree at the desired index
     */
    public void replaceTreeAtIndex(int desiredIndex, Tree randomTree) {
        listOfTrees.set(desiredIndex, randomTree);
    }// end of replaceTreeAtIndex METHOD

    /**
     * @param fileName  the name of the file
     * @param theForest the forest to be saved
     * @return true if the forest is saved, false otherwise
     */
    public boolean saveForest(String fileName, Forest theForest) {
        ObjectOutputStream toStream = null;
        try {
            toStream = new ObjectOutputStream(new FileOutputStream(fileName));
            toStream.writeObject(theForest);
            return true;
        } catch (IOException e) {
            System.out.println("ERROR Saving fix yo shit!");
            return false;
        } finally {
            if (toStream != null) {
                try {
                    toStream.close();
                } catch (IOException e) {
                    System.out.println("Error closing fix yo shit!");
                }
            }
        }
    }// end of saveForest

    /** @return the name of the forest
     *
     *
     */
    public String getName() {
        return this.name;
    }// end of getName

    public Forest loadForest(String fileName) {
        ObjectInputStream fromStream = null;
        Forest local;
        try {
            fromStream = new ObjectInputStream(new FileInputStream(fileName));
            local = (Forest) fromStream.readObject();
            return (local);
        } catch (IOException e) {
            System.out.println("ERROR loading fix yo shit! " + e.getMessage());
            return (null);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return (null);
        } finally {
            if (fromStream != null) {
                try {
                    fromStream.close();
                } catch (IOException e) {
                    System.out.println("ERROR Closing fix yo shit!" + e.getMessage());
                }
            }
        }// end of finally
    }// end of loadForest

    /** displays the content of the forest
     *
     */

    public void display() {
        int index;
        for (index = 0; index < listOfTrees.size(); index++) {
            System.out.print(index + " ");
            System.out.println(listOfTrees.get(index));

        }// end of for
    }// end of display

    /** @return the size of the arraylist
     *
     *
     */
    public int getForestSize() {
        return listOfTrees.size();
    }// end of getForestSize

    /** @return computes the average tree height and returns it
     *
     *
     */
    public double getAverageSize() {
        int index;
        double sum = 0;
        for (index = 0; index < listOfTrees.size(); index++) {
            sum = sum + listOfTrees.get(index).getHeight();
        }
        sum = sum / getForestSize();
        return sum;
    }// end of getAverageSize

    /** simulates growth of the entire forest
     *
     */
    public void growForest() {
        int index;

        for (index = 0; index < listOfTrees.size(); index++) {
            Tree tempTree = listOfTrees.get(index);
            tempTree.grow(tempTree);
        }// end of for loop
    }// end of growForest
    /**
     * @return the height of the tree at the desired index
     *
     *
     */
    public double getHeightOfTreeAtIndex(int desiredTreeIndex) {

        return listOfTrees.get(desiredTreeIndex).getHeight();

    }// end of getHeightOfTreeAtIndex


    /**
     * @return the string representation of the tree at the desired index
     *
     *
     */
    public String getSpecificTreeString(int desiredTreeIndex) {

        return listOfTrees.get(desiredTreeIndex).toString();


    }// end of getSpecificTreeString

    public String getLatestTree() {
        Tree tempTree = listOfTrees.get(listOfTrees.size() - 1);
        return tempTree.toString();
    }// end of getLatestTree

    /**
     * @return generates random tree
     */
    public Tree generateRandomTree(int index) {
        int randomBirthYear;
        double randomHeight, randomGrowthRate, randomSpecies;
        Tree.Species newTreeSpecies = null;

        randomSpecies = Math.round(Math.random() * 2);
        switch ((int) randomSpecies) {
            case 0:
                newTreeSpecies = Tree.Species.Birch;
                break;
            case 1:
                newTreeSpecies = Tree.Species.Maple;
                break;
            case 2:
                newTreeSpecies = Tree.Species.Fir;
                break;

        }
        randomBirthYear = (int) Math.round(Math.random() * 20) + 2000;
        randomHeight = (Math.random() * 10) + 10;
        randomGrowthRate = Math.random() * 10 + 10;
        randomHeight = Math.round(randomHeight * 10.0) / 10.0;
        randomGrowthRate = Math.round(randomGrowthRate * 10.0) / 10.0;
        return new Tree(newTreeSpecies, randomBirthYear, randomHeight, randomGrowthRate, index);
    }// end of addTree METHOD


}// end of the Forest class
