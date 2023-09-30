
public class Student {
    private String courseNumber;
    private int ID;
    private String firstName;
    private String lastName;
    private int[] examGrades;
    private double finalGrade;
    private char letterGrade;
    private static int numStudents;
    private Student next;

    public Student(String courseNumber, int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade, Student next) {
        this.courseNumber = courseNumber;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examGrades = examGrades;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        this.next = next;
        numStudents++;
    }
    public Student(String courseNumber, int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade) {
        this.courseNumber = courseNumber;
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examGrades = examGrades;
        this.finalGrade = finalGrade;
        this.letterGrade = letterGrade;
        this.next = null;
        numStudents++;
    }
    

    public Student() {
        numStudents++;

    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int[] getExamGrades() {
        return examGrades;
    }
    
    public int getExamGrade1() {
        return examGrades[0];
    }
    public int getExamGrade2() {
        return examGrades[1];
    }
    public int getExamGrade3() {
        return examGrades[2];
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public char getLetterGrade() {
        return letterGrade;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public Student getNext() {
        return next;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamGrades(int[] examGrades) {
        this.examGrades = examGrades;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    public void setLetterGrade(char letterGrade) {
        this.letterGrade = letterGrade;
    }

    public static void setNumStudents(int numStudents) {
        Student.numStudents = numStudents;
    }

    public void setNext(Student next) {
        this.next = next;
    }
    
    
    
    
    
    
    
}
