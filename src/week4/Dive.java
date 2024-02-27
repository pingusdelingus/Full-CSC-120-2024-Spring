package week4;
import java.util.Scanner;

public class Dive{
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int FEET_PER_ATMOSPHERE = 33;
    public static void main(String[] args) {
        // declare variables
        int desiredMixture, diveDepth;
        float ambientPressure, partialPressure;
        // get variables from user input

        diveDepth = keyboard.nextShort();
        desiredMixture = keyboard.nextShort();

        // start ambient pressure method
        ambientPressure = AmbientPressureMethod(diveDepth);
        System.out.println(ambientPressure);

        //start partialPressure method

        partialPressure = PartialPressureMethod(ambientPressure, desiredMixture);


        ComputeWarningsMethod(partialPressure);
        System.out.println(partialPressure);


        System.out.println(OxygenGroupMethod(partialPressure));



    }// end of the main method
    private static float AmbientPressureMethod(int depth){
        float ambient;
        ambient = (depth / FEET_PER_ATMOSPHERE) + 1;
        return ambient;



    }// end of the AmbientPressure Method


    private static float PartialPressureMethod(float ambientPressure, int desiredMixture){
        float pressure;
        pressure = ambientPressure * (float) desiredMixture / 100;
        return pressure;






    }// End of PartialPressureMethod

    private static void ComputeWarningsMethod(float partialPressure){
    boolean exceedsMaximal, exceedsContingency;
    exceedsMaximal = partialPressure < 1.6;
    exceedsContingency = partialPressure < 1.4;
        System.out.println("Does exceed Maximal: " + exceedsMaximal);
        System.out.println("Does exceed contingency: " + exceedsContingency);
        System.out.println("partial pressure is : " + partialPressure);

    }//end of ComputeWarningsMethod

    private static char OxygenGroupMethod(float partialPressure){
//        float oxygenGroup;
//        oxygenGroup = partialPressure * 10;
//        oxygenGroup = (float) Math.floor(oxygenGroup);
//        oxygenGroup = (char)(oxygenGroup + 65);
//        System.out.println(oxygenGroup);
//        return oxygenGroup;
        return (char) ((int) (Math.floor(partialPressure * 10)) +65);
    }// end of OxygenGroupMethod


}// End of the dive class
