package week15;
import java.util.Objects;
import java.util.Scanner;

public class BackwardsRecursion {
    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String[] listOfWords = new String[];

        System.out.println("Please enter a backwards sentence");
        String aSentence = keyboard.next();
        listOfWords = aSentence.split(" ");
        int listSize = listOfWords.length;

        String[] outputList= new String[listSize];
        rr(listOfWords, outputList, 0);

        int index = 0;
        for(index = 0; index< outputList.length){
            System.out.println(outputList[index]);

        }// end of for







    }// end of main method

    public static void rr(String[] listOfWords,String[] outputList,int startingIndex){

        if(listOfWords[startingIndex] == "."){
            return;
        }
        else{
            outputList[listOfWords.length - startingIndex] = listOfWords[startingIndex];
            rr(listOfWords, outputList, startingIndex - 1);

        }// end of rr





    }// end of rr







}// end of Backwards Recursion
