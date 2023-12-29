
package project.controller;

import java.util.Scanner;
import project.model.*;
import project.commands.*;

public class MainExecution {
    public static void MainExecution(String[] args) {
        Scanner in = new Scanner(System.in);
        //creating a scanner object
        int numCourses = Integer.parseInt(in.nextLine());
        //creating a list of all courses 
        CourseRoster[] courses = new CourseRoster[numCourses];
        //printing the initial information 
        System.out.printf("Welcome to the Grade Book.\n" +
        "\n" +
        "The following course(s) have been added to the database:\n");
        for (int i = 0; i < numCourses; i++) {
            //looping as many times as many courses we have 
            //and add them in the coresponding index
            courses[i] = new CourseRoster();
            courses[i].setCourseNumber(in.nextLine());
            //then print the course
            System.out.printf("	%s\n", courses[i].getCourseNumber());
        }
        System.out.println("");
        //creating the line array
        String[] line;

        //we start looping until the input is "QUIT"
        do{
            line = in.nextLine().split(" ");
                //read the line with the command
                //depending on the command call the function corresponding 
            if(line[0].equals("ADDRECORD"))
                AddRecord.addRecord(line, courses);
            if(line[0].equals("DELETERECORD"))
                DeleteStudent.deleteStudent(courses, line);
            if(line[0].equals("SEARCHBYID"))
                SearchByID.searchByID(courses, line);
            if(line[0].equals("SEARCHBYNAME"))
                SearchByName.searchByName(courses, line);
            if(line[0].equals("DISPLAYSTATS"))
                DisplayStats.displayStats(courses, line);
            if(line[0].equals("DISPLAYSTUDENTS"))
                DisplayStudents.displayStudents(courses, line);
            
            
        }while(!line[0].equals("QUIT"));
        System.out.println("Thank you for using the the Grade Book.\n" +
        "\n" +
        "Goodbye.");
        
    }
}
