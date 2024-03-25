package week10;
import java.util.Scanner;

public class usefluidParticle {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args0){
        //declaring variables
        int id;
        id = 0;

        double x,y;
        x = 0.0;
        y = 0.0;
        //prompt user for input of particle tag ID
        System.out.println("Enter the identification tag for the particle: ");
        id = keyboard.nextInt();

        // creating particle object
        fluidParticle particle = new fluidParticle(id);
        System.out.println(particle.toString());

       //do while loop to repeat the movement of the particle until the user enters 0,0
        do{
            //ask for the movement of the particle
            System.out.println("Enter movement   :");

            //get the movement from the user
            x = keyboard.nextDouble();
            y = keyboard.nextDouble();

            //move the particle
            particle.move(x,y);

            //print the new position of the particle
            System.out.println(particle.toString());



        }while ( (x != 0.0 && y != 0));





    }// end of the main METHOD
}// end of usefluidParticle CLASS
