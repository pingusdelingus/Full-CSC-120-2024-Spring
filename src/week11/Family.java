package week11;

public class Family {
    private static final int MAX_FAMILY_MEMBERS = 10;
    private int numOfMembers;
    private Person[] peopleInFam = new Person [MAX_FAMILY_MEMBERS];
    public Family(){
        numOfMembers = 0;

    }// end of Family default CONSTRUCTOR METHOD

    public boolean addPerson(String name, int age){
       //   if statement to check if the number of members is less than the max family members
        if (numOfMembers < MAX_FAMILY_MEMBERS){
            // creating a new person object
            Person member = new Person(name, age);
            // adding the person to the family
            peopleInFam[numOfMembers] = member;

            numOfMembers += 1;
            return true;
        }
        else{
            return false;
        }

    }// end of addPerson METHOD

    public int getNumberOfPeople(){
        return numOfMembers;
    }
    public int getTotalAge(){
        int index, totalAge;
        totalAge = 0;
        // for loop to get the total age of the family
        for (index = 0; index < peopleInFam.length; index++){
           // try catch block to handle null pointer exception
            try {
               totalAge += peopleInFam[index].getAge();
           }
        catch (NullPointerException e){
               totalAge += 0;
        }
        }// end of for loop
        return totalAge;
    }// end of getTotalAge METHOD
public void birthday(String name){
        int index;
        // for loop to increment the age of the person
        for (index = 0; index< peopleInFam.length; index++){
            // if statement to check if the name is in the family
            if (peopleInFam[index] != null) {

                if (name.equals(peopleInFam[index].getName())) {
                    peopleInFam[index].incrementAge();
                }

            }

        }// end of for loop
}// end of birthday METHOD
    public void display(){

        int index;
        for(index = 0; index<peopleInFam.length; index++){
            // if statement to check if the person is in the family
            if( peopleInFam[index]!= null){
                System.out.println(peopleInFam[index].getName() + " is " + peopleInFam[index].getAge() + " years old");
            }
            else{

            }

        }// end of for loop

    }// end of display METHOD


}// end of Family CLASS
