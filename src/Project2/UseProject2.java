package Project2;
import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.Scanner;
import java.io.*;

/**
 * @author Esteban Morales
 * Driver class for Forestry Simulation Project
 * This is the main driver class for the Forestry Simulation Project.
 *  * It provides a menu for the user to interact with the forest.
 *  */

public class UseProject2 {
    public static int forestIndex = 0;
    private static final Scanner keyboard = new Scanner(System.in);
    public  static void main(String[] args) {





        System.out.println("Welcome to the Forestry Simulation");
        System.out.println("----------------------------------");
        //call the menu method to start the program
        menu(args);

}// end of main METHOD
/** @param args, array of Strings that program takes in to use as the forest name
 *  This method is the main menu for the program. It allows the user to interact with the forest
 *  by adding, cutting, growing, reaping, saving, loading, and moving to the next forest.
 *  */
private static void menu(String[] args){

    char choice;
    boolean savedS;





    String csvPath = "/Users/esteballs/Documents/coding stuff/csc 120/CSC120_SPRING2024/src/Project2/"
            + args[forestIndex] + ".csv";
    System.out.println("Initializing from " + args[forestIndex] );


        Forest TrialForest = new Forest (args[forestIndex], csvPath, setupForest(csvPath));




    do {
        System.out.println("(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it: ");
        // get user's choice from keyboard
        choice = Character.toUpperCase(keyboard.next().charAt(0));

        switch (choice) {
            case 'A':
                //add a tree
                addTree(TrialForest);
                //done
                break;
            case 'G':
                //grow the forest
                simulateGrowth(TrialForest);
                //done
                break;
            case 'C':
                //cut a tree at a specified index
                cutTree(TrialForest);
                //done
                break;
            case 'R':
                //reap trees taller than a specified height
                reapTrees(TrialForest);
                break;
            case 'S':
                //try to save the forest to a db file
                //gets the path of the csv file and replaces it with db
                String[] FindDBPath = csvPath.split("csv");
                String dbPath = FindDBPath[0];
                dbPath = dbPath + "db";

                savedS = saveForestAsDB(dbPath, TrialForest);
                if (savedS){
                    System.out.println("Happy Days, Saved successfully!");
                }
                break;
            case 'L':
                //load a forest from a db file
                System.out.println("Enter forest name:");
                String inputForest = keyboard.next();
                inputForest = "/Users/esteballs/Documents/coding stuff/csc 120/CSC120_SPRING2024/src/Project2/" + inputForest + ".db";

                TrialForest = loadForestFromDB(inputForest);
                break;
            case 'N':
                //move to the next forest, tests for errors
                forestIndex += 1;
                 csvPath = "/Users/esteballs/Documents/coding stuff/csc 120/CSC120_SPRING2024/src/Project2/"
                        + args[forestIndex] + ".csv";
                 ArrayList<Tree> tempForest = setupForest(csvPath);
                 if(tempForest.isEmpty()){
                     System.out.println("Forest is empty!");
                     forestIndex += 1;
                     csvPath = "/Users/esteballs/Documents/coding stuff/csc 120/CSC120_SPRING2024/src/Project2/"
                             + args[forestIndex] + ".csv";
                     tempForest = setupForest(csvPath);

                 }

                 TrialForest = new Forest (args[forestIndex], csvPath, tempForest);
                System.out.println("Moving to the next forest");
                System.out.println("Initializing from " + args[forestIndex] );


                break;
            case 'P':
                //print the forest and its stats
                printForest(TrialForest);
                System.out.println("There are " + TrialForest.getForestSize() + " trees, with an average height" +
                        " of " + String.format("%.2f" ,TrialForest.getAverageSize()));
                break;
            case 'X':
                //exit the program

                break;
            default:
                System.out.println("Invalid menu option, try again");
        }

    }while( choice != 'X');


}// end of menu METHOD


/** @param currentForest, the forest to be printed
 *  This method prints the forest and its stats
 *  */
private static void printForest(Forest currentForest) {
    System.out.println("Forest name: " + currentForest.getName());
        currentForest.display();

}// end of printForest METHOD


/** @param currentForest, the method to add randomly a tree to
 *  This method adds a tree to the forest
 *  */
private static void addTree(Forest currentForest) {
    int randomBirthYear;
    double randomHeight, randomGrowthRate, randomSpecies;
    Tree.Species newTreeSpecies = null;

    randomSpecies = Math.round(Math.random() * 2);
    switch ((int)randomSpecies){
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
    randomHeight = ( Math.random() * 10 )+ 10;
    randomGrowthRate = Math.random() * 10 + 10;
    randomHeight = Math.round(randomHeight * 10.0 ) / 10.0;
    randomGrowthRate = Math.round(randomGrowthRate * 10.0) / 10.0;
    currentForest.addTree(new Tree(newTreeSpecies, randomBirthYear, randomHeight, randomGrowthRate, currentForest.getForestSize()));
}// end of addTree METHOD

    /** @param currentForest, the forest to simulate growth on
     *  This method simulates growth on the entire forest
     *  */
private static void simulateGrowth(Forest currentForest) {
    currentForest.growForest();

}// end of simulateGrowth METHOD


    //* @param currentForest, the forest to cut a tree from specified index
private static void cutTree(Forest currentForest) {

    int indexToCut;
    indexToCut = 0;
    boolean validInput = false;
    int forestSize = 0;
    forestSize = currentForest.getForestSize();
    do{
        System.out.println("Tree number to cut down: ");
        try{
            indexToCut = keyboard.nextInt();
            validInput = true;

        }catch(InputMismatchException e){
            System.out.println("That is not an integer silly, try again");
            validInput = false;
            keyboard.next();
        }

    }while (!validInput );
    if (indexToCut > forestSize){
        System.out.println("Tree number " + indexToCut + " does not exist");
        return;
    }
    else{
        currentForest.cutTree(indexToCut);
    }
}// end of cutTree METHOD


    /** @param currentForrest, the forest to reap trees from
     *  This method reaps trees taller than a specified height
     *  */
private static void reapTrees(Forest currentForrest) {
        int userInput = 0;
        int index;

        boolean validInput = false;

    do{
        System.out.println("Height to reap from: ");
        try{
            userInput = keyboard.nextInt();
            validInput = true;

        }catch(InputMismatchException e){
            System.out.println("That is not an integer silly, try again");
            validInput = false;
            keyboard.next();
        }

    }while (!validInput );


        for(index = 0; index < currentForrest.getForestSize(); index++){
            if (currentForrest.getHeightOfTreeAtIndex(index) > userInput){
                System.out.print("Replacing the tall tree ");
                System.out.println(currentForrest.getSpecificTreeString(index));

                System.out.print("Replaced with new tree ");
                currentForrest.replaceTreeAtIndex(index, currentForrest.generateRandomTree(index));
                System.out.println(currentForrest.getSpecificTreeString(index));

            }// end of if
        }// end of for loop

}// end of reapTrees METHOD

    /** @param ForestName, the path of the forest to save
     *  @param currentForest, the forest to save
     *  This method saves the forest to a db file
     *  */
private static boolean saveForestAsDB(String ForestName, Forest currentForest) {
        boolean savedSuccessfully;
        savedSuccessfully = currentForest.saveForest(ForestName ,currentForest);
    return savedSuccessfully;
}// end saveForestAsDB
/** @param fileName, the path of the forest to load
 *  This method loads the forest from a db file
 *  */
private static Forest loadForestFromDB(String fileName) {
    ObjectInputStream fromStream = null;
    Forest local;
    try {
        fromStream = new ObjectInputStream(new FileInputStream(fileName));
        local = (Forest) fromStream.readObject();
        return (local);
    } catch (IOException e) {
        System.out.println("Error opening/reading" + fileName);
        System.out.println("Old Forest retained");
        return (null);
    } catch (ClassNotFoundException e) {
        System.out.println("Error opening/reading" + fileName);
        System.out.println("Old Forest retained");
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

}// end of loadForest METHOD



/** @param fileName, the path of the forest to setup
 * from initially
 * */

private static ArrayList<Tree> setupForest(String fileName){
        BufferedReader fromBuffer = null;
        String aLine;
        ArrayList<Tree> ListOfMyTrees = new ArrayList<Tree>();
        String[] ListOfStrings;
        int treeNumber = 0;
        try {

            fromBuffer = new BufferedReader(new FileReader(fileName));
            aLine = fromBuffer.readLine();
            while(aLine != null){
                ListOfStrings = aLine.split(",");

                ListOfMyTrees.add(new Tree(Tree.Species.valueOf(ListOfStrings[0]),
                        Integer.parseInt(ListOfStrings[1]),
                        Double.parseDouble(ListOfStrings[2]), Double.parseDouble(ListOfStrings[3]), treeNumber));
                        treeNumber++;
                aLine = fromBuffer.readLine();

            }
        }catch(IOException e){
            System.out.println("Error opening/reading from " + fileName);

        }

        return ListOfMyTrees;

}// end of setupForest


}// end of UseProject2 CLASS
