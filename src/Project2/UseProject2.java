package Project2;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;

/**
 * Driver class for Forestry Simulation Project
 */
public class UseProject2 {
    public static int forestIndex = 0;

    private static final Scanner keyboard = new Scanner(System.in);

    public  static void main(String[] args) {



        String fileName;
        FileReader fromReader = null;
        int aChar;



        System.out.println("Welcome to the Forestry Simulation");
        System.out.println("----------------------------------");


        menu(args);










}// end of main METHOD
private static boolean menu(String[] args){
    boolean keepGoing = true;
    char choice;
    boolean savedS;


    Forest currentForest = new Forest();
    //trial
    File estebansFile = new File("Montane.csv");
    String absolute = estebansFile.getAbsolutePath();
    System.out.println(absolute);

    String csvPath = "/Users/esteballs/Documents/coding stuff/csc 120/CSC120_SPRING2024/src/Project2/"
            + args[forestIndex] + ".csv";
    System.out.println("Initializing from " + args[forestIndex] );
    System.out.println(csvPath);

        Forest TrialForest = new Forest (args[forestIndex], csvPath, setupForest(csvPath));




    do {
        System.out.println("(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it: ");
        // get user's choice from keyboard
        choice = Character.toUpperCase(keyboard.next().charAt(0));

        switch (choice) {
            case 'A':
                addTree(TrialForest);
                //done
                break;
            case 'G':
                simulateGrowth(TrialForest);
                //done
                break;
            case 'C':
                cutTree(TrialForest);
                //done
                break;
            case 'R':
                reapTrees(TrialForest);
                break;
            case 'S':
                savedS = saveForestAsDB(csvPath, TrialForest);
                if (savedS){
                    System.out.println("Happy Days, Saved successfully!");
                }
                break;
            case 'L':
                loadForest(TrialForest.getName());
                break;
            case 'N':
                nextForest(args);
                forestIndex += 1;
                String newCSVPath = "/Users/esteballs/Documents/coding stuff/csc 120/CSC120_SPRING2024/src/Project2/"
                        + args[forestIndex] + ".csv";
                 TrialForest = new Forest (args[forestIndex], newCSVPath, setupForest(newCSVPath));

                break;
            case 'P':

                printForest(TrialForest);
                System.out.println("There are " + TrialForest.getForestSize() + " with an average height" +
                        " of " + TrialForest.getAverageSize());
                break;
            case 'X':
                keepGoing = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }while( choice != 'X');
    return keepGoing;

}// end of menu METHOD



private static void printForest(Forest currentForest) {
    System.out.println("Forrest name: " + currentForest.getName());
        currentForest.display();

}// end of printForest METHOD

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

private static void simulateGrowth(Forest currentForest) {
    currentForest.growForest();

}// end of simulateGrowth METHOD

private static void cutTree(Forest currentForest) {
    System.out.println("Tree number to cut down: ");
    int indexToCut;
    indexToCut = 0;
    indexToCut = keyboard.nextInt();
    currentForest.cutTree(indexToCut);

}// end of cutTree METHOD

private static void reapTrees(Forest currentForrest) {
        int userInput = 0;
        int index;
        System.out.println("Height to reap from: ");
        userInput = keyboard.nextInt();
        for(index = 0; index < currentForrest.getForestSize(); index++){
            if (currentForrest.getHeightOfTreeAtIndex(index) > userInput){
                System.out.print("Replacing the tall tree ");
                System.out.println(currentForrest.getSpecificTreeString(index));
                currentForrest.cutTree(index);
                System.out.print("Replaced with new tree ");
                addTree(currentForrest);
                System.out.println(currentForrest.getLatestTree());

            }// end of if
        }// end of for loop



}// end of reapTrees METHOD

private static boolean saveForestAsDB(String ForestName, Forest currentForest) {
        boolean savedSuccessfully;
        savedSuccessfully = currentForest.saveForest(ForestName ,currentForest);
    return savedSuccessfully;
}// end saveForestAsDB

private static void loadForest(String fileName) {
    //currentForest.loadForest(fileName);

}// end of loadForest METHOD

private static void nextForest(String[] args) {
        forestIndex += 1;
        if(forestIndex >= args.length){
            forestIndex = 0;
        }

}// end of nextForest



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
            System.out.println("Error reading file stupid hoe!");

        }

        return ListOfMyTrees;

}// end of setupForest


}// end of UseProject2 CLASS
