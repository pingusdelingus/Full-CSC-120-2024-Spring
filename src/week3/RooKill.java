package week3;
import java.util.Scanner;
public class RooKill {
    private static Scanner scnr = new Scanner(System.in);
    private static final double ROADKILL_CONSTANT = 1.47;
    private static final double AVERAGE_ROAD_WIDTH = 0.01;
    public static void main(String[] args) {
   // Define 3 input variables

    double lengthSquareLand;
    double lengthRoadInSquare;
    double numRoosInSquare;

    // Define variables used for methods
    double rooDensity;
    double surfaceArea;
    double expectedRooKills;
    double calculationInjured = 0;
    byte numInjured;



    // Get Input from users

     lengthSquareLand = scnr.nextDouble();
     lengthRoadInSquare = scnr.nextDouble();
     numRoosInSquare = scnr.nextDouble();

     //Finding Kangaroo Density
        rooDensity = numRoosInSquare / (lengthSquareLand * lengthSquareLand);

    // Finding Surface Area
        surfaceArea = lengthRoadInSquare * AVERAGE_ROAD_WIDTH;

      //Finding the number of expected kills
      expectedRooKills = rooDensity * surfaceArea * ROADKILL_CONSTANT;

      // Finding expected injuries
        calculationInjured = expectedRooKills;
        calculationInjured = calculationInjured % 1;
        numInjured = (byte) Math.ceil(calculationInjured);

    // Returning Injury and Kill #'s

        System.out.println("Num 'Roo's killed :" + (int) Math.floor(expectedRooKills));
        System.out.println("Num 'Roos injured: " + numInjured);





    } // end of main method
} // end of classRooKill

