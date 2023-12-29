
package project.commands;

import project.model.CourseRoster;


public class DisplayStudents {
    public static void displayStudents(CourseRoster[] courses, String[] line)
    {

        //first we check if we print only one roaster or all of them
        if(!line[1].equals("ALL"))
        {
            //we get here is we only print one roaster
            //we first check if there are students in the roaster
            for(int i = 0; i< courses.length; i++)
            {
                //we first loop through all the courses to find the course we look for
                //then we check if the course name is the same as the one we look for
                if(courses[i].getCourseNumber().equals(line[1]))
                {
                    //if we found our course we check if the course has studnets and print the 
                    //acoring message if not
                    if(courses[i].isEmpty())
                        System.out.printf("Command: DISPLAYSTUDENTS (%s)\n" +
        "	ERROR: there are no student records for %s.\n\n", line[1], line[1]);
                    else
                    {
                        //if we do have students we call te=he display students function for the roaster class
                        //oh, before that we print he first line of message 
                        System.out.printf("Command: DISPLAYSTUDENTS (%s)\n", line[1]);
                        //now we call the function
                        courses[i].displayStudents();
                        System.out.println("");
                    }
                    //then we break
                    break;
                }
            }
        }
        else
        {
            boolean ok = false;
            //of will tell us if any students are anywhere in the courses
            //if we need to print all students
            //we first loop over all the courses
            System.out.println("Command: DISPLAYSTUDENTS (ALL)\n");
            for(int i = 0; i< courses.length; i++)
            {
                //if we have at least 1 course that is not empty ok will be true
                if(!courses[i].isEmpty())
                    ok = true;
                courses[i].displayStudents();
                //and we display the students in the respective course
            }
            if(ok == false)
                System.out.println(
                        //if ok is false we print the message that no stduents are anyware 
                        "	ERROR: there are no students currently in the system.\n\n");
            else
                System.out.println("");
        }
    }
}
