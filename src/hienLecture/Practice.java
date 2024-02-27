package hienLecture;

import java.util.Scanner;

public class Practice {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {


        int[] array = new int[5];
        int index;

        for (index = 0; index < array.length; index++) {
            System.out.println("Enter a number for the :" + index + "Th column in the array");
            array[index] = keyboard.nextInt();

        }
    for (index = 0; index < array.length; index++){
        System.out.println("at index : " + index + " the value is : " + array[index]);

    }

    for (index = 0; index < array.length; index++){
        System.out.println("The element at the" + index + "th place is " + array[index]);

    }

    int sumTotal = getSum(array);
        System.out.println("the sum of the elements is: " + sumTotal);

    }// end of the Main Method

    private static final int getSum(int[] inputArray){

        int total = 0;
        int index;

        for (index = 0; index < inputArray.length; index++ ){
            total = total + inputArray[index];
        }
        return total;
    }// end of the getSum METHOD




}// end of the Practice Class

