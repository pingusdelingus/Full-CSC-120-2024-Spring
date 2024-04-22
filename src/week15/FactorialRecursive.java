package week15;
import java.util.Scanner;

public class FactorialRecursive {
    public static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter an Int you want to factorialize");
        int userInput = keyboard.nextInt();
        int returnInt = Factorial(userInput);
        System.out.println(" Here is your factorial");
        System.out.println(returnInt);


    }
    public static int Factorial(int userInput){
        if(userInput <= 0){
            return 1;
        }
        int NminusOne;
        int factorialOfNMinusOne;
        int FactorialOfUserInput;
        NminusOne = userInput -1;
        factorialOfNMinusOne = Factorial(NminusOne);
        FactorialOfUserInput = userInput * factorialOfNMinusOne;
        return FactorialOfUserInput;

    }
}
