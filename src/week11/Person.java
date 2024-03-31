package week11;

public class Person {
    private String PersonName;
    private int PersonAge;

    public Person() {
        PersonName = "";
        PersonAge = 0;


    }// end of Person DEFAULT Constructor METHOD

    public Person(String name, int age) {
        PersonName = name;
        PersonAge = age;


    }// end of Person Constructor METHOD

    public String toString() {

        return PersonName + " is " + PersonAge + " years old";

    }// end of the toString METHOD

    public void incrementAge(){
        this.PersonAge+= 1;


    }// end of incrementAge METHOD

    public String getName() {
        return PersonName;

    }// end of the getName METHOD

    public int getAge(){
        return PersonAge;

    }// end of getAge METHOD




}// end of Person class
