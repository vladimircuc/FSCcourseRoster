
package project.commands;

import project.model.*;
import project.controller.HelpingMethods;

public class AddRecord {
    public static void addRecord(String[] line, CourseRoster[] courses)
    {
        boolean ok = false;
        //ok will turn true if the course searched for is found in the list of roasters
        int i;
        for(i = 0; i< courses.length;i++)
        {
            if(courses[i].getCourseNumber().equals(line[1]))
            {
                //if we find the course we change the ok and break saving the value of i
                ok = true;
                break;
            }
        }
        //if ok is stil flase we did not find the course so we print a message
        if(ok == false)
        {
            System.out.printf("Command: ADDRECORD\n" +
        "	ERROR: cannot add student. Course \"%s\" does not exist.\n\n", line[1]);
        }
        else
        {
            //if ok is true means we found the course and we use i as its index
            //creating a list with the exam grades for the student
            //turning parts of the String line into integers and saving them in the list 
            int[] grades = {Integer.parseInt(line[5]), Integer.parseInt(line[6]), Integer.parseInt(line[7])};
            double finalGrade = (grades[0] * 3 + grades[1] * 3 + grades[2] * 4) / 10.0;
            //calculating the final grade
            char letter = HelpingMethods.getLetterGrade(finalGrade);
            //getting the final grade letter using getLetterGrade method
            courses[i].insert(line[1], Integer.parseInt(line[2]), line[3], line[4], grades, finalGrade, letter);
            //finally we add all the values into the corespond course roaster using insert function of FSCCourseRoaster
            
            //we also print the details after inserting the new student
            System.out.printf("Command: ADDRECORD\n" +
        "	%s %s (ID# %d) has been added to %s.\n" +
        "	Final Grade: %.2f (%c).\n\n", line[3], line[4], Integer.parseInt(line[2]), line[1], finalGrade, letter);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
