package week12;

import java.util.ArrayList;

public class ExceptionalIntegers {
    public static void main(String[] args) {
        ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
        int index, inputInteger;

        for (index = 0; index < args.length; index++) {
            try {
                listOfIntegers.add(Integer.parseInt(args[index]));
                System.out.println("Converter method says integer OK - " + args[index]);
            } catch (NumberFormatException e) {
                System.out.println("Catch block says the argument " + args[index] + " is ignored because " + args[index]);
            }
        }// end of for loop

        System.out.println("Vector contents are:");
        for(index = 0; index < listOfIntegers.size(); index++){
            System.out.println("Item " + index + " is " + listOfIntegers.get(index));
        }

    }// end of main method

}// end of ExceptionalIntegers
