package week10;

public class fluidParticle {
    private static int identificationTag;
    private static double xPosition;
    private static double yPosition;

    public fluidParticle(int id){
        identificationTag = id;
        xPosition = 0.0;
        yPosition = 0.0;



    }// end of fluidParticle CONSTRUCTOR METHOD

    public void move(double x, double y){
        xPosition += x;
        yPosition += y;

    }// end of move METHOD

    public String toString(){
       return "Particle " + identificationTag + " is at  (" + xPosition + ", " + yPosition + ")";
    }//end of to String METHOD


}// end of fluidParticle CLASS
