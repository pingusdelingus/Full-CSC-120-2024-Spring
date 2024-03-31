package week7;
import java.util.Scanner;


public class Kindle {
    Scanner keyboard = new Scanner(System.in);
    private int totalNumOfPages;
    private int currentPageNum;



    public Kindle(int numberOfPages) {
        currentPageNum = 1;
        totalNumOfPages = numberOfPages;


    }// end of the Kindle constructor METHOD

    public int getNumOfPages(){
        return totalNumOfPages;

    }// end of getNumOfPages
    public int getCurrentPageNum(){
        return currentPageNum;
    }// end of getCurrentPageNum

    public String toString(){

        return "Page " + currentPageNum + " of " + totalNumOfPages + ".";
    }// end of toString

    public void turnPages(){
        currentPageNum++;


    }// end of turnPages NO PARAMETER

    public void turnPages(int numOfPagesTurn){
        if (numOfPagesTurn + currentPageNum > totalNumOfPages){
            toString();
            currentPageNum = totalNumOfPages;
            System.out.println("You were on                : Page  " + (currentPageNum) + " of " + totalNumOfPages + ".");
            System.out.println("Turning " + numOfPagesTurn + " pages would take you past the last page.");
            System.out.println("You are now on             : Page  " + currentPageNum + " of " + totalNumOfPages + ".");

            return;

        }// end of if
        currentPageNum = numOfPagesTurn + currentPageNum;


    }// end of turnPages WITH PARAMETER (INT)


}// end of the KindleReader CLASS
