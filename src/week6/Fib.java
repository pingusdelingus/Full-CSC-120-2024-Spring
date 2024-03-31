package week6;

import java.util.Scanner;

public class Fib {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final short MAX_NUMBERS = 10;
    private static final short STOP_VALUE = 0;


    public static void main(String[] args) {
        // Declaration of Variables
        int index;


        boolean isFib;
        boolean isPrime;


        //Declaration of Arrays
        int[] values = new int[MAX_NUMBERS];
        int[] candidates = new int[MAX_NUMBERS];
        values = getCandidates(candidates);
        System.out.println(values);


        // for loop to test every number if its fib or prime
        for (index = 0; index < MAX_NUMBERS; index++) {
            isFib = isFib(values[index]);
            isPrime = isPrime(values[index]);
            if (values[index] == 0){
                break;
            }

            if (isFib && isPrime) {
                System.out.println(values[index] + " is Fibonacci and Prime");
            } else if (!isFib && isPrime) {
                System.out.println(values[index] + " is not Fibonacci and is Prime");

            } else if (isFib && !isPrime) {
                System.out.println(values[index] + " is Fibonacci and not Prime");

            } else if (!isFib && !isPrime) {
                System.out.println(values[index] + " is not Fibonacci and not Prime");

            }
        }


    }// end of the main METHOD

    private static int[] getCandidates(int[] candidates) {
        int index;
        int userInput;
        int numOfInts;
        index = 0;


        // getting candidates into the array

        do {
            try {
                System.out.println("Please enter numbers (0 to stop) ");
                userInput = keyboard.nextInt();

                if (userInput < 0) {
                    System.out.println("Positive numbers only silly! Try again");
                    userInput = 0;
                }
                candidates[index] = userInput;
                index = index + 1;
                if (userInput == 0) {
                    return candidates;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
                userInput = keyboard.nextInt();
            }

        } while (userInput >= 0);
        return candidates;

    }// end of the getCandidates METHOD

    private static boolean isFib(int fibCandidate) {
        // declare variables
        int first, second, third;

        first = 0;
        second = 1;


        int jdex;
        // creating the fibonacci sequence
        for (jdex = 0; jdex < fibCandidate; ++jdex) {
            third = first + second;
            first = second;
            second = third;
            // if fibCandidate is equal to the fibonacci number then return true
            if (third == fibCandidate) {
                return true;
            }

        }


        return false;


    } // end of the isFib METHOD


    private static boolean isPrime(int primeCandidate) {
        short divisor = 2;

        while (divisor <= Math.sqrt(primeCandidate)) {
            if (primeCandidate % divisor == 0) {
                return (false);
            }
            divisor++;
        }

        return true;


    }// end of the isPrime METHOD


}// end of the Fib CLASS
