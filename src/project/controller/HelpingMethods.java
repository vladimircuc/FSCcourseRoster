
package project.controller;


public class HelpingMethods {
    public static char getLetterGrade(double grade){
        //depending what number the grade is, the function returns the corepsond letter grade as a char

        if (grade >= 90)
            return 'A';
        else if (grade >= 80)
            return 'B';
        else if (grade >= 70)
            return 'C';
        else if (grade >= 60)
            return 'D';
        else 
            return 'F';
    }
}
