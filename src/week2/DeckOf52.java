package week2;

public class DeckOf52 {
    private int[][] deck = new int[4][13];
    private int currentCard;
    private int index;
    private int jdex;
    private int range;
    private int max = 13;
    private int min = 1;
    private int randomNumber;
    private int randomSuit;
// randomNumber = (int) Math.random() * range + min;
//
//            }// end of inner for loop
//            randomSuit = (int) Math.random() * 4;




    public DeckOf52() {
        range = max - min;
        for (index = 0; index < deck.length; index++ ){
            for (jdex = 0; jdex < 10; jdex++){
                deck[index][jdex] = jdex;

            }// end of inner for loop


        }// end of outer for loop


    }// end of DeckOf52 CONSTRUCTOR


}// end of DeskOf52 CLASS (METHOD SETUP NO MAIN)
