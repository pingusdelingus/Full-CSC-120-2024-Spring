package Project2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Locale;

public class Forest implements Serializable{

    private String name;
    private String csvPath;
    private ArrayList<Tree> listOfTrees = new ArrayList<Tree>();
    public Forest (){
        name = "";
    }// end of default constructor

    public Forest(String name, String csvPath){
        this();
        this.name = name;
        this.csvPath = csvPath;
    }// end of Forrest CONSTRUCTOR

    public void setupForest(){
        try {
            File file = new File(csvPath);
            Scanner keyboard = new Scanner(file);
            keyboard.useDelimiter(",");
            while(keyboard.hasNext()){
                Tree.Species treeSpecies = Tree.Species.valueOf(keyboard.next().toUpperCase());
                int treeBirthYear = keyboard.nextInt();
                double treeHeight = keyboard.nextInt();
                double treeGrowthRate = keyboard.nextDouble();
                Tree tree = new Tree(treeHeight, treeBirthYear, treeGrowthRate, treeSpecies);
                listOfTrees.add(tree);
            }
            keyboard.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }// end of setupForest METHOD


    public void addTree(Tree tree){
        listOfTrees.add(tree);
    }// end of addTree METHOD

    public void cutTree(Tree tree){
        listOfTrees.remove(tree);
    }// end of cutTree METHOD











}// end of the Forrest CLASS
