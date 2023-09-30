//Name: Vladimir Cuc
//ID: 1282672
//Date: 09/20/2023
//FSC honor code: Be honest in all situations, academic and nonacademic, and to respect the rights and the property of others. Live in a manner that brings credit to themselves and to the College.

import java.util.*;

public class Main {
    public static void addRecord(String[] line, FSCcourseRoster[] courses)
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
            char letter = getLetterGrade(finalGrade);
            //getting the final grade letter using getLetterGrade method
            courses[i].insert(line[1], Integer.parseInt(line[2]), line[3], line[4], grades, finalGrade, letter);
            //finally we add all the values into the corespond course roaster using insert function of FSCCourseRoaster
            
            //we also print the details after inserting the new student
            System.out.printf("Command: ADDRECORD\n" +
        "	%s %s (ID# %d) has been added to %s.\n" +
        "	Final Grade: %.2f (%c).\n\n", line[3], line[4], Integer.parseInt(line[2]), line[1], finalGrade, letter);
        }
    }
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
    
    
    
    
    public static void deleteStudent(FSCcourseRoster[] courses, String[] line){
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
    
    public static void searchByID(FSCcourseRoster[] courses, String[] line){
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
    
    public static void searchByName(FSCcourseRoster[] courses, String[] line){
        boolean ok = false;
        //creating a boolean ok that turnes true if the name is found in any of the roasters in the list
        System.out.println("Command: SEARCHBYNAME");
        //print the first line
        for(int i = 0; i < courses.length; i++)
        {
            //we loop over all the roasters
            //we use the search by name method to find out if the student with that ID is in the respective course
            //and we save the Student in the Student variable if it is found
            Student student = courses[i].searchByName(line[1], line[2]);
            //student will be null if the name was not found in the roaster
            
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
            System.out.printf("	ERROR: there is no record for student \"%s %s\".\n\n", line[1], line[2]);
        }
        else
            System.out.println("");
    }
    
    public static void displayStats(FSCcourseRoster[] courses, String[] line)
    {
        if(!line[1].equals("ALL"))
        {
            //if we only print details for one course we loop over all the courses and find the courses searched
            for(int i = 0; i< courses.length; i++)
                if(courses[i].getCourseNumber().equals(line[1]))
                {
                    //when we find it we use the print stats function to print them
                    courses[i].printStats();
                    break;
                }
        }
        else
        {
            //if we need to print the stats for all roasters together
            //we first create the variables where we will store the sum or avrages for all the roasters
            //and we initialize them with the values with the first course
            //the only thing we need to calucate again are the letter percentages and the avrage
            int numStudents = courses[0].returnNumStudent();
            double sum = courses[0].returnSum();
            double max = courses[0].returnMax();
            double min;
            //for min, if the first roaster has no students but we still have other roasters min will be 100
            // if it is the only roaster min will be 0
            if(courses[0].returnNumStudent() == 0)
            {
                if(courses.length > 1)
                    min = 101;
                else
                    min = 0;
            }
            else
                min = courses[0].returnMin();
            int[] letters = courses[0].returnLetters();
            for(int i = 1; i<courses.length;i++)
            {
                //we loop over all the roasters and make the adjustments to our variables
                numStudents+= courses[i].returnNumStudent();
                //add the number of students and the final sum
                sum += courses[i].returnSum();
                if(max < courses[i].returnMax())
                    max = courses[i].returnMax();
                //if we find a bigger max de replace our max
                //we only chnage the min if the next roaster does not a min equal to 0 (no members inside)
                //or if it the last roaster 
                if(min > courses[i].returnMin()){
                    if(courses[i].returnMin() != 0)
                        min = courses[i].returnMin();
                    else
                        if(i+1 == courses.length && min == 101)
                            min = 0;
                }
                //we save the new number of letters into a new list of ints
                //and add them to our global list of number of letters
                int[] lettersNew = courses[i].returnLetters();
                for(int j = 0; j< 5; j++)
                    letters[j] += lettersNew[j];
                
                
            }
            //calculating the avrage
            double avrage;
            if(numStudents == 0)
            {
                //if the number of students is 0, the avrage is 0
                avrage = 0;
            }
            else
            {
                //else we calculate the avrage
                avrage = (double) sum / numStudents;
            }
            //and now we calculate the percentages of letters from the initial list of ints
            double[] pers = new double[6];
            //creating a double lsit to svae all percentages
            if(numStudents == 0)
            {
                //if there is no student in the roaster we initiate the percentages so we don't divide by 0
                pers[0] = 0;
                pers[1] = 0;
                pers[2] = 0;
                pers[3] = 0;
                pers[4] = 0;
            }
            else
            {
                //if there are we calculate 
                pers[0] = ((float) letters[0] / numStudents*100);
                pers[1] = ((float) letters[1] / numStudents*100);
                pers[2] = ((float) letters[2] / numStudents*100);
                pers[3] = ((float) letters[3] / numStudents*100);
                pers[4] = ((float) letters[4] / numStudents*100);
            }
            
            //and now we just print
            System.out.printf("Command: DISPLAYSTATS (ALL)\n" +
                "Statistical Results for All Courses:\n" +
                "	Total number of student records: %d\n" +
                "	Average Score: %.2f\n" +
                "	Highest Score: %.2f\n" +
                "	Lowest Score:  %.2f\n" +
                "	Total 'A' Grades: %d (%.2f%% of class)\n" +
                "	Total 'B' Grades: %d (%.2f%% of class)\n" +
                "	Total 'C' Grades: %d (%.2f%% of class)\n" +
                "	Total 'D' Grades: %d (%.2f%% of class)\n" +
                "	Total 'F' Grades: %d (%.2f%% of class)\n\n", numStudents, 
                avrage, max, min, letters[0], pers[0], letters[1], pers[1], letters[2],pers[2], letters[3],pers[3],
                letters[4], pers[4]);
          
            
        }
    }
    
    public static void displayStudents(FSCcourseRoster[] courses, String[] line)
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
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //creating a scanner object
        int numCourses = Integer.parseInt(in.nextLine());
        //creating a list of all courses 
        FSCcourseRoster[] courses = new FSCcourseRoster[numCourses];
        //printing the initial information 
        System.out.printf("Welcome to the FSC Grade Book.\n" +
        "\n" +
        "The following course(s) have been added to the database:\n");
        for (int i = 0; i < numCourses; i++) {
            //looping as many times as many courses we have 
            //and add them in the coresponding index
            courses[i] = new FSCcourseRoster();
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
                addRecord(line, courses);
            if(line[0].equals("DELETERECORD"))
                deleteStudent(courses, line);
            if(line[0].equals("SEARCHBYID"))
                searchByID(courses, line);
            if(line[0].equals("SEARCHBYNAME"))
                searchByName(courses, line);
            if(line[0].equals("DISPLAYSTATS"))
                displayStats(courses, line);
            if(line[0].equals("DISPLAYSTUDENTS"))
                displayStudents(courses, line);
            
            
        }while(!line[0].equals("QUIT"));
        System.out.println("Thank you for using the the FSC Grade Book.\n" +
        "\n" +
        "Goodbye.");
        
    }
    
}
