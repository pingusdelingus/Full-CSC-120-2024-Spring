package week13;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput;
        int userCarts = 0;
        double userValue = 0.0;

        System.out.println("Enter the name of the girl");
        userInput = keyboard.next();
        Girl newGirl = new Girl(userInput);

        // this loop will run until the user enters 0


            if (!newGirl.checkDiamond()) {
                System.out.println(newGirl.getName() + "has no best friend");
            }
            else{
                System.out.println(newGirl.getName() + " has no best friends");
            }

            System.out.println("Enter carats and value");


                userCarts = keyboard.nextInt();
                userValue = keyboard.nextDouble();

            Diamond aDiamond = new Diamond(userCarts, userValue);
            newGirl.setDiamond(aDiamond);
            newGirl.toString();

            while(userCarts != 0) {
                try {
                    userCarts = keyboard.nextInt();
                    userValue = keyboard.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Enter an int, then a double!");

                }
                boolean diamondBetter = newGirl.isDiamondBetter(userCarts, userValue);
                if (diamondBetter) {
                    System.out.println("WooHOo, the girl took the diamond!");

                } else {
                    System.out.println("Aaargh, the diamond was rejected");
                }
                System.out.println(newGirl.toString());
            }




    }// end of main METHOD
}// end of Driver CLASS
