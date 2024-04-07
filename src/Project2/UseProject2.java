package Project2;

import java.util.Locale;
import java.util.Scanner;
import java.io.*;


public class UseProject2 {
    public String relativePath = "Monstane.csv";

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


    String relativePath = "Monstane.csv";
    String workingDir = System.getProperty("user.dir");
    File file = new File(workingDir, relativePath);
    String absolutePath = file.getAbsolutePath();


    System.out.println("Initializing from " + args[forestIndex] );


    do {
      currentForest = new Forest(args[forestIndex], absolutePath);
        currentForest.setupForest();

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
                saveForestAsDB(currentForest);
                break;
            case 'L':
                loadForest();
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

private static void saveForestAsDB(Forest currentForest) {

}// end saveForestAsDB

private static void loadForest() {

}// end of loadForest METHOD

private static void nextForest(String[] args) {
        forestIndex += 1;
        if(forestIndex >= args.length){
            forestIndex = 0;
        }

}// end of nextForest






}// end of UseProject2 CLASS
