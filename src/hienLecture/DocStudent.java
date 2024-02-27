package hienLecture;

//=============================================================================
/**
 Generic student. this is the practice class for Geoff's CSC 120 Spring 2024

 @author Geoff Sutcliffe & Genghis Khan
 */
public class DocStudent {
//-----------------------------------------------------------------------------
    /**
     The number of tests for grades.
     */
    protected static final int NUMBER_OF_TESTS = 3;
//-----------------------------------------------------------------------------
    /**
     Name of the student.
     */
    private String name;
    /**
     Marks for the tests.
     */
    protected int[] marks;
    /**
     Grade achieved.
     */
    protected char grade;
//-----------------------------------------------------------------------------
    /**
     Default constructor.
     */
    public DocStudent() {

        int index;

        this.name = "";
        marks = new int[NUMBER_OF_TESTS];
        for (index = 0; index < NUMBER_OF_TESTS; index++) {
            marks[index] = -1;
        }
        grade = '*';
    }
//-----------------------------------------------------------------------------
    /**
     Initial value constructor.
     @param name Name of the student.
     */
    public DocStudent(String name) {

        this();
        this.name = name;
    }
//-----------------------------------------------------------------------------
    /**
     Produce printable information about the student.
     @return String with student's name, marks, and grade.
     */
    public String toString() {

        String displayString;
        int index;

        displayString = name + " ";
        for (index = 0; index < NUMBER_OF_TESTS; index++) {
            if (marks[index] >= 0) {
                displayString += marks[index] + ",";
            }
        }
        displayString += " " + grade;
        return(displayString);
    }
//-----------------------------------------------------------------------------
    /**
     Set the mark for specified test.
     @param testNumber Index for the test
     @param mark Mark achieved in the test
     */
    public void setMark(int testNumber,int mark) {

        marks[testNumber-1] = mark;
    }
//-----------------------------------------------------------------------------
    /**
     Compute the grade based on the mark.
     @param mark Final mark over all tests.
     @return Grade.
     */
    protected char gradeFromMark(int mark) {

        if (mark >= 85) {
            return('A');
        } else if (mark >= 75) {
            return('B');
        } else if (mark >= 65) {
            return('C');
        } else if (mark >= 50) {
            return('D');
        } else {
            return('N');
        }
    }
//-----------------------------------------------------------------------------
//----Extra method required for UseStudent2 with polymorphism
//    public void computeGrade() {
//
//        System.out.println("ERROR: Subclass missing computeGrade() method");
//    }
//-----------------------------------------------------------------------------
}
//=============================================================================
