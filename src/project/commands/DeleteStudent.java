
package project.commands;

import project.model.*;


public class DeleteStudent {
    public static void deleteStudent(CourseRoster[] courses, String[] line){
        boolean ok = false;
        //creating a boolean ok that turnes true if the ID is found in any of the roasters in the list
        System.out.println("Command: DELETERECORD");
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
                System.out.printf("	%s %s (ID# %d) has been deleted from %s.\n", student.getFirstName(), student.getLastName(), student.getID(), student.getCourseNumber());
                //and we use the delete method to delete by ID the student from the roaster 
                courses[i].deleteByID(Integer.parseInt(line[1]));
                
            }
        }
        if(ok == false)
        {
            //if the student was not found in any roaster print the apropriate message 
            System.out.printf("	ERROR: cannot delete student. ID# %s does not exist.\n\n", line[1]);
        }
        else
            System.out.println("");
    }
}
