package Project2;

import java.util.Locale;
import java.util.Scanner;
import java.io.*;


public class UseProject2 {
    private static final Scanner keyboard = new Scanner(System.in);

    private static void main(String[] args) {

        String fileName;
        FileReader fromReader = null;
        int aChar;



        System.out.println("Welcome to the Forestry Simulation");
        System.out.println("----------------------------------");

        // Tries to open file from CMD line arguments at position 0
        // if found, prints out whole file.

        try{
            fromReader = new FileReader(args[0]);
            aChar = fromReader.read();
            while(aChar != -1){
                System.out.print((char) aChar);
                aChar = fromReader.read();

            }
        } catch(FileNotFoundException e){
            System.out.println("404: File not found" + e.getMessage());

        }catch(IOException e){
            System.out.println("Something went wrong! " + e.getMessage());
        }finally {
            if (fromReader != null){
                try {
                    fromReader.close();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }









}// end of main METHOD

private static void printForest(Forest currentForest) {

}// end of printForest METHOD

private static void addTree(currentForest) {

}// end of addTree METHOD

private static boolean simulateGrowth(Forest currentForest) {

}// end of simulateGrowth METHOD

private static boolean cutTree(Forest currentForest) {

}// end of cutTree METHOD

private static reapTrees(Forest currentForrest) {

}// end of reapTrees METHOD

private static saveForestAsDB(Forest currentForest) {

}// end saveForestAsDB

private static void loadForest() {

}// end of loadForest METHOD

private static void nextForest() {

}// end of nextForest






}// end of UseProject2 CLASS
