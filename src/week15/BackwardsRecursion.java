package week15;
import java.util.Objects;
import java.util.Scanner;

public class BackwardsRecursion {
    public static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Please enter a backwards sentence");
        String str = keyboard.nextLine();


        String[] words = str.split(" ");

        int index;


        System.out.println(words.length + " is the list size");



        String[] outputList= new String[words.length];

        int testInt = rr(words,outputList,0);
        System.out.println(testInt);




        for(index = 0; index< outputList.length; index++){

            System.out.print(outputList[index] + " ");
        }// end of for


    }// end of main method

    public static int rr(String[] listOfWords,String[] outputList,int startingIndex){


        if (listOfWords[startingIndex].endsWith(".")){
            return 0;
        }
        else{
            outputList[(listOfWords.length-1) - startingIndex] = listOfWords[startingIndex];
            rr(listOfWords, outputList, startingIndex + 1);


        }// end of rr
        return 1;




    }// end of rr







}// end of Backwards Recursion
