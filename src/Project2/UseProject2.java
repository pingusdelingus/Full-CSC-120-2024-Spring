package Project2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;


public class UseProject2 {
    public String relativePath = "Montane.csv";

    static int forestIndex = 0;
    static Forest currentForest = new Forest();

    private static final Scanner keyboard = new Scanner(System.in);

    public  static void main(String[] args) {



        String fileName;
        FileReader fromReader = null;
        int aChar;



        System.out.println("Welcome to the Forestry Simulation");
        System.out.println("----------------------------------");

        // Tries to open file from CMD line arguments at position 0
        // if found, prints out whole file.
        menu(args);










}// end of main METHOD
private static boolean menu(String[] args){
    boolean keepGoing = true;
    char choice;
    boolean savedS;


    String relativePath = "Monstane.csv";
    String workingDir = System.getProperty("user.dir");
    File file = new File(workingDir, relativePath);
    String absolutePath = file.getAbsolutePath();


    System.out.println("Initializing from " + args[forestIndex] );
    ArrayList<Tree> =
    currentForest = new Forest(args[forestIndex], absolutePath, ArrayList<Tree> Treelist);
    do {



        System.out.println("(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it: ");
        // get user's choice from keyboard
        choice = keyboard.next().toUpperCase().charAt(0);

        switch (choice) {
            case 'A':
                addTree(currentForest);
                break;
            case 'G':
                simulateGrowth(currentForest);
                break;
            case 'C':
                cutTree(currentForest);
                break;
            case 'R':
                reapTrees(currentForest);
                break;
            case 'S':

                savedS = saveForestAsDB(currentForest.getName(), currentForest);
                if (savedS){
                    System.out.println("Happy Days, Saved successfully!");
                }
                break;
            case 'L':
                loadForest(currentForest.getName());
                break;
            case 'N':
                nextForest(args);
                break;
            case 'P':
                printForest(currentForest);
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

}// end of printForest METHOD

private static void addTree(Forest currentForest) {

}// end of addTree METHOD

private static boolean simulateGrowth(Forest currentForest) {
return true;
}// end of simulateGrowth METHOD

private static boolean cutTree(Forest currentForest) {
return true;
}// end of cutTree METHOD

private static void reapTrees(Forest currentForrest) {

}// end of reapTrees METHOD

private static boolean saveForestAsDB(String ForestName, Forest currentForest) {
        boolean savedSuccessfully;
    savedSuccessfully = currentForest.saveForest(ForestName ,currentForest);
    return savedSuccessfully;
}// end saveForestAsDB

private static void loadForest(String fileName) {
        currentForest.loadForest(fileName);

}// end of loadForest METHOD

private static void nextForest(String[] args) {
        forestIndex += 1;
        if(forestIndex >= args.length){
            forestIndex = 0;
        }

}// end of nextForest



private static Forest setupForest(String fileName){
        BufferedReader fromBuffer = null;
        String aLine;
        int lineNumber;
        try {
            fromBuffer = new BufferedReader(new FileReader(fileName));
        }catch(IOException e){
            System.out.println("Error reading file stupid hoe!");
            return (null);
        }
        for (lineNumber = 0 ; lineNumber < lin)

}// end of setupForest


}// end of UseProject2 CLASS
