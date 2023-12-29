
package project.commands;

import project.model.CourseRoster;


public class DisplayStats {
    public static void displayStats(CourseRoster[] courses, String[] line)
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
}
