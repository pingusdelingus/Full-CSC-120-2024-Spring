package Project2;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
public class UseProject2 {




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
    int forestIndex = 0;

    Forest currentForest = new Forest();


    String csvPath = args[forestIndex] + ".csv";
    System.out.println("Initializing from " + args[forestIndex] );
    try {
        setupForest(csvPath);
    }catch(IOException e){
        System.out.println("suck on my jim jams!");
    }



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



private static ArrayList<Tree> setupForest(String fileName)throws IOException{
        BufferedReader fromBuffer = null;
        String aLine;
        ArrayList<Tree> ListOfMyTrees = new ArrayList<Tree>();
        String[] ListOfStrings;
        try {

            fromBuffer = new BufferedReader(new FileReader(fileName));
            aLine = fromBuffer.readLine();
            while(aLine != null){
                ListOfStrings = aLine.split(" ,");
                ListOfMyTrees.add(new Tree(Tree.Species.valueOf(ListOfStrings[0]),
                        Integer.parseInt(ListOfStrings[1]),
                        Double.parseDouble(ListOfStrings[2]), Double.parseDouble(ListOfStrings[3])));


            }
        }catch(IOException e){
            System.out.println("Error reading file stupid hoe!");

        }
    aLine = fromBuffer.readLine();
        while(aLine != null){
            lines.add(aLine);

            aLine = fromBuffer.readLine();
        }
        fromBuffer.close();
        return ListOfMyTrees;

}// end of setupForest


}// end of UseProject2 CLASS
