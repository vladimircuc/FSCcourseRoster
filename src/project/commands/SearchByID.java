
package project.commands;

import project.model.*;


public class SearchByID {
    public static void searchByID(CourseRoster[] courses, String[] line){
        boolean ok = false;
        //creating a boolean ok that turnes true if the ID is found in any of the roasters in the list
        System.out.println("Command: SEARCHBYID");
        //print the first line
        for(int i = 0; i < courses.length; i++)
        {
            //we loop over all the roasters
            //we use the search by ID method to find out if the student with that ID is in the respective course
            //and we save the Student in the Student variable if it is found
            Student student = courses[i].searchByID(Integer.parseInt(line[1]));
            //student will be null if the ID was not found in the roaster
            
            if(student != null)
            {
                //if so ok beclomes true 
                ok = true;
                //we print the delete details 
                System.out.printf("Student Record for %s %s (ID# %d):\n" +
        "	Course: %s\n" +
        "		Exam 1:       %d\n" +
        "		Exam 2:       %d\n" +
        "		Final Exam:   %d\n" +
        "		Final Grade:  %.2f\n" +
        "		Letter Grade: %c\n", student.getFirstName(), student.getLastName(), 
            student.getID(), student.getCourseNumber(), student.getExamGrade1(), 
            student.getExamGrade2(), student.getExamGrade3(), student.getFinalGrade(), 
            student.getLetterGrade());
                //and we break the for
                break;
                
            }
        }
        if(ok == false)
        {
            //if the student was not found in any roaster print the apropriate message 
            System.out.printf("	ERROR: there is no record for student ID# %s.\n\n", line[1]);
        }
        else
            System.out.println("");
    }
}
