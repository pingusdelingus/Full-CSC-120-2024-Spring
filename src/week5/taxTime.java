package week5;

import java.util.Scanner;

public class taxTime {
    private static final long STINKING_RICH = 500000;
    private static final long QUITE_RICH = 200000;
    private static final long MIAMI_POOR = 100000;
    private static final long AVERAGE = 50000;
    private static final long REALISTIC = 20000;
    private static final float HIGH_TAX_RATE = 0.25F;
    private static final float MEDIUM_TAX_RATE = 0.10F;
    private static final float LOW_TAX_RATE = 0.3F;

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
     // declaration of variables
        float taxableInc;
        int dataEntry;
        float incomeBefore;
        float deductions;
        char taxGroup;
        float taxOwed;
        incomeBefore = 0.0F;
        deductions = 0.0F;
        taxOwed = 0.0F;

    // do while loop for cts prompts and to collect deductions and income
        do {
            System.out.println("Enter next amount :");
            dataEntry = keyboard.nextInt();
            if (dataEntry >= 0) {
                incomeBefore = dataEntry + incomeBefore;
            } else if (dataEntry < 0) {
                deductions = deductions - dataEntry;
            } else {
                return;
            }

        } while (dataEntry != 0);



            // start method to get taxable income

        taxableInc = calculateTaxableIncome(incomeBefore, deductions);


        // start method to calculate tax group
        taxGroup = calculateTaxGroup(taxableInc);


        // start method to find tax owed
        taxOwed = calculateTaxOwed(taxGroup, taxableInc);

        outputMethod(incomeBefore, deductions, taxableInc, taxGroup, taxOwed);
    } // end of the main METHOD

    private static float calculateTaxableIncome(float income, float deductions) {
       // declaration of variables
        float taxable;
        //determine if taxable income is negative or not
        if (deductions > income) {
            return 0.0F;
        } else {
            taxable = income - deductions;
            return taxable;

        }


    }// end of CalculateTaxableIncome

    private static char calculateTaxGroup(float taxableInc) {
       // finding which tax group taxable income falls under
        if (taxableInc >= 500000) {
            return 'S';
        } else if (taxableInc >= 200000) {
            return 'Q';
        } else if (taxableInc >= 100000) {
            return 'M';
        } else if (taxableInc >= 50000) {
            return 'A';
        } else if (taxableInc >= 20000) {
            return 'R';
        } else if (taxableInc <= 20000) {
            return 'P';
        } else {
            return 'E';
        }


    }// end of the calculateTaxGroup METHOD

    private static float calculateTaxOwed(char taxGroup, float taxableIncome) {
        // declaration of variables
        float taxOwed;
       // determine which tax rate to apply for which tax group
        switch (taxGroup) {
            case 'S':
                return taxOwed = HIGH_TAX_RATE * taxableIncome;
            case 'Q':
                return taxOwed = HIGH_TAX_RATE * taxableIncome;

            case 'M':
                return taxOwed = MEDIUM_TAX_RATE * taxableIncome;

            case 'A':
                return taxOwed = LOW_TAX_RATE * taxableIncome;
            case 'R':
                return taxOwed = LOW_TAX_RATE * taxableIncome;

            case 'P':
                return taxOwed = 0;

            default:
                System.out.println("This shouldn't happen, please call a developer!");
                return taxOwed = 0;
        }// end of taxGroup Switch
    }// end of calculateTaxOwed METHOD
    static final void outputMethod(float incomeBefore ,float deductions,float taxableInc,char taxGroup, float taxOwed){
        System.out.println("Your income is :" + incomeBefore);
        System.out.println("Your deductions are : " + deductions);
        System.out.println("Your taxable income is : " + taxableInc);
        System.out.println("Your tax group is :" + taxGroup);
        System.out.println("Your tax owed is :" + taxOwed);
    }// end of outputMETHOD

} // end of taxTime class



