package week8;
import java.util.Scanner;
public class SentenceReader {

    StringBuilder quailities = new StringBuilder();
    public static String sentence;
    public static String stringToAppend;
    public static StringBuilder finalSentence = new StringBuilder();

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter sentences, . to end.");

        do {
            sentence = keyboard.nextLine();
        if (sentence.startsWith("I am ")){
            stringToAppend = sentence.substring(5);
            finalSentence.append(stringToAppend).append(",");

        }// end of if



        } while (!sentence.equals("."));
        System.out.println("The qualities are" + finalSentence);
        // comment


    }// end of the main METHOD
}// end of SentenceReader CLASS
