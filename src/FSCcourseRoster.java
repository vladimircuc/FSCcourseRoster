
public class FSCcourseRoster {
    private Student head;
    private String courseNumber;

    public FSCcourseRoster(String courseNumber) {
        this.head = null;
        this.courseNumber = courseNumber;
    }

    public FSCcourseRoster() {
        this.head = null;
    }
    

    public Student getHead() {
        return head;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setHead(Student head) {
        this.head = head;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
    
    
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
            return head == null;
    }
       
    
    //
    // void | insert(int)
    //
    public void insert(String courseNumber, int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade) {
            head = insert(head, courseNumber, ID, firstName, lastName, examGrades, finalGrade, letterGrade);
    }
    //
    // LLnode | insert(LLnode, value)
    //
    private Student insert(Student head, String courseNumber, int ID, String firstName, String lastName, int[] examGrades, double finalGrade, char letterGrade) {
            // IF there is no list, newNode will be the first node, so just return it
            if (head == null || head.getID()> ID) {
                    head = new Student(courseNumber, ID, firstName, lastName, examGrades, finalGrade, letterGrade, head);
                    return head;
            }

            // ELSE, we have a list. Insert the new node at the correct location
            else {
                    // We need to traverse to the correct insertion location...so we need a help ptr
                    Student helpPtr = head;
                    // Traverse to correct insertion point
                    while (helpPtr.getNext() != null) {
                            if (helpPtr.getNext().getID()> ID)
				break; // we found our spot and should break out of the while loop
                            else
                                helpPtr = helpPtr.getNext();
                    }
                    // Now make the new node. Set its next to point to the successor node.
                    // And then make the predecessor node point to the new node
                    Student newNode = new Student(courseNumber, ID, firstName, lastName, examGrades, finalGrade, letterGrade,helpPtr.getNext());
                    helpPtr.setNext(newNode);
            }
            // Return head
            return head;
    }
    
    public Student searchByID(int ID) {
            return searchByID(head, ID);
    }
    //
    // boolean | search(LLnode, int)
    //
    private Student searchByID(Student p, int ID) {
        //getting a help porinter to search the roaster
            Student helpPtr = p;
            //we loop until we saw the ID of the whole roaster
            while (helpPtr != null) {
                    if (helpPtr.getID() == ID)
                            return helpPtr;
                    helpPtr = helpPtr.getNext();			
            }
            return null;
	}
    
    public Student searchByName(String firstName, String lastName) {
            return searchByName(head, firstName, lastName);
    }
    //
    // boolean | search(LLnode, int)
    //
    private Student searchByName(Student p, String firstName, String lastName) {
        //getting a help porinter to search the roaster
            Student helpPtr = p;
            //we loop until we saw the ID of the whole roaster
            while (helpPtr != null) {
                    if (helpPtr.getFirstName().equals(firstName) && helpPtr.getLastName().equals(lastName))
                            return helpPtr;
                    helpPtr = helpPtr.getNext();			
            }
            return null;
	}
    
    //
    // void | delete(int)
    //
    public void deleteByID(int ID) {
            head = deleteByID(head, ID);
    }
    //
    // LLnode | delete(LLnode, value)
    //
    private Student deleteByID(Student head, int ID) {
            // We can only delete if the list has nodes (is not empty)
            if (!isEmpty()) {
                    // IF the first node (at the head) has the data value we are wanting to delete
                    // we found it. Delete by skipping the node and making head point to the next node.
                    if (head.getID()== ID) {
                            head = head.getNext();
                    }
                    // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
                    else {
                            // We need to traverse to find the data we want to delete...so we need a help ptr
                            Student helpPtr = head;
                            // Traverse to correct deletion point
                            while (helpPtr.getNext() != null) {
                                    if (helpPtr.getNext().getID()== ID) {
                                            helpPtr.setNext(helpPtr.getNext().getNext());
                                            break; // we deleted the value and should break out of the while loop
                                    }
                                    helpPtr = helpPtr.getNext();
                            }
                    }
                    // return the possibly updated head of the list
                    return head;
            }
            return head;
    }
    
    public int returnNumStudent() {
        return returnNumStudent(head);
    }
   
    private int returnNumStudent(Student p) {
        int nr = 0;
        //retunrs the number of students in the roster
        //getting a help porinter to search the roaster
            Student helpPtr = p;
            //we loop the whoe the roaster
            while (helpPtr != null) {
                    nr++;
                    helpPtr = helpPtr.getNext();			
            }
            return nr;
	}
    
    public double returnSum() {
        return returnSum(head);
    }
   
    private double returnSum(Student p) {
        //here we calculate the sum of the roaster
        double sum = 0;
        
        //getting a help porinter to search the roaster
            Student helpPtr = p;
            //we loop the whole roaster and find the total sum
            while (helpPtr != null) {
                //add to the sum every final grade
                    sum += helpPtr.getFinalGrade();
                    helpPtr = helpPtr.getNext();			
            }
            
            return sum;
	}
    
    public double returnAvg() {
        return returnAvg(head);
    }
   
    private double returnAvg(Student p) {
        //here we calculate the avrage of the roaster
        double sum = 0;
        
        //getting a help porinter to search the roaster
            Student helpPtr = p;
            //we loop the whole roaster and find the total sum
            while (helpPtr != null) {
                //add to the sum every final grade
                    sum += helpPtr.getFinalGrade();
                    helpPtr = helpPtr.getNext();			
            }
            double avrage;
            if(isEmpty())
            {
                //if the roaster is empty avrage will be 0.00
                avrage = 0.00;
            }
            else
            {
                //if not we calculate the avrage
                avrage = (double) sum / returnNumStudent();
            }
            return avrage;
	}
    
    public double returnMin() {
        return returnMin(head);
    }
   
    private double returnMin(Student p) {
        
        //retunrs the smallest grade in the roaster
        //initialise min to 100
        double min = 100.00;
        if(isEmpty())
            min = 0.00;
        //if the roaster is empty min is 0.00
        else
        {
            //getting a help porinter to search the roaster
            Student helpPtr = p;
            //we loop the whoe the roaster
            while (helpPtr != null) {
                    if(min > helpPtr.getFinalGrade())
                        min = helpPtr.getFinalGrade();
                    //if we find a smaller final grade we change the min value
                    helpPtr = helpPtr.getNext();			
            }
        }
        
            return min;
	}
    
    public double returnMax() {
        return returnMax(head);
    }
   
    private double returnMax(Student p) {
        
        //retunrs the biggest grade in the roaster
        //initialise max to 0
        double max = 0.00;
        
        
        
        //getting a help porinter to search the roaster
        Student helpPtr = p;
        //we loop the whoe the roaster
        while (helpPtr != null) {
                if(max < helpPtr.getFinalGrade())
                    max = helpPtr.getFinalGrade();
                //if we find a smaller final grade we change the min value
                helpPtr = helpPtr.getNext();			
        }
        
        
            return max;
	}
    
    public int[] returnLetters() {
        return returnLetters(head);
    }
   
    private int[] returnLetters(Student p) {
        
        //retunrs a list of the number of each grade letter in the roaster
        //create a list of int
        int[] letters = new int[6];
        //each time we find a letter we increment the apropriate data in the list
        //each time we have an A we increment i[0], each B increment i[1] and so on
        
        //getting a help porinter to search the roaster
        Student helpPtr = p;
        //we loop the whoe the roaster
        while (helpPtr != null) {
            
                if(Character.compare(helpPtr.getLetterGrade(), 'A') == 0)
                    letters[0]++;
                //we cpunt how many As we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'B') == 0)
                    letters[1]++;
                //we cpunt how many Bs we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'C') == 0)
                    letters[2]++;
                //we cpunt how many Cs we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'D') == 0)
                    letters[3]++;
                //we cpunt how many Ds we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'F') == 0)
                    letters[4]++;
                //we cpunt how many Fs we have
                
                
                helpPtr = helpPtr.getNext();			
        }
        
        
            return letters;
	}
    
    public double[] returnLettersPers() {
        return returnLettersPers(head);
    }
   
    private double[] returnLettersPers(Student p) {
        
        //retunrs a list of the percentage of each grade letter in the roaster
        //create a list of int to save the number of each grade
        int[] letters = new int[6];
        //each time we find a letter we increment the apropriate data in the list
        //each time we have an A we increment i[0], each B increment i[1] and so on
        
        //getting a help porinter to search the roaster
        Student helpPtr = p;
        //we loop the whoe the roaster
        while (helpPtr != null) {
            
                if(Character.compare(helpPtr.getLetterGrade(), 'A') == 0)
                    letters[0]++;
                //we cpunt how many As we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'B') == 0)
                    letters[1]++;
                //we cpunt how many Bs we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'C') == 0)
                    letters[2]++;
                //we cpunt how many Cs we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'D') == 0)
                    letters[3]++;
                //we cpunt how many Ds we have
                
                if(Character.compare(helpPtr.getLetterGrade(), 'F') == 0)
                    letters[4]++;
                //we cpunt how many Fs we have
                
                
                helpPtr = helpPtr.getNext();			
        }
        
        double[] persLet = new double[6];
        //creating a double lsit to svae all percentages
        if(returnNumStudent() == 0)
        {
            //if there is no student in the roaster we initiate the percentages so we don't divide by 0
            persLet[0] = 0;
            persLet[1] = 0;
            persLet[2] = 0;
            persLet[3] = 0;
            persLet[4] = 0;
        }
        else
        {
            //if there are we calculate 
            persLet[0] = ((float) letters[0] / returnNumStudent()*100);
            persLet[1] = ((float) letters[1] / returnNumStudent()*100);
            persLet[2] = ((float) letters[2] / returnNumStudent()*100);
            persLet[3] = ((float) letters[3] / returnNumStudent()*100);
            persLet[4] = ((float) letters[4] / returnNumStudent()*100);
        }
        
        
        //calculate the the percentages of each letter garde and saving them into the coresponding place in the 
        //list of percentages 
        
        
            return persLet;
	}
    
    
    
    public void printStats()
    {
        //this function only prinds the stats calculated in methods above
        //we call all the functions and save them into variables 
        int numStudents = returnNumStudent();
        double avrage = returnAvg();
        double max = returnMax();
        double min = returnMin();
        int[] letters = returnLetters();
        double[] pers = returnLettersPers();
        //and print them acordingly 
        System.out.printf("Command: DISPLAYSTATS (%s)\n" +
        "Statistical Results of %s:\n" +
        "	Total number of student records: %d\n" +
        "	Average Score: %.2f\n" +
        "	Highest Score: %.2f\n" +
        "	Lowest Score:  %.2f\n" +
        "	Total 'A' Grades: %d (%.2f%% of class)\n" +
        "	Total 'B' Grades: %d (%.2f%% of class)\n" +
        "	Total 'C' Grades: %d (%.2f%% of class)\n" +
        "	Total 'D' Grades: %d (%.2f%% of class)\n" +
        "	Total 'F' Grades: %d (%.2f%% of class)\n\n", getCourseNumber(), getCourseNumber(), numStudents, 
        avrage, max, min, letters[0], pers[0], letters[1], pers[1], letters[2],pers[2], letters[3],pers[3],
        letters[4], pers[4]);
    }
    
    public void displayStudents(){
        head = displayStudents(head);
    }
    
    private Student displayStudents(Student p){
        //this function will peint all studnets in the roaster
        if(!isEmpty())
            System.out.printf("Course Roster for %s:\n", getCourseNumber());
        //print the first line first only if the roaster in not empty
        //now we loop over all the Students and print them
        //we will need a helpptr
        Student helpptr = p;
        while(helpptr != null)
        {
            //we loop over the whole roaster using helpptr
            //and print the details of the student we are at
            System.out.printf("	%s %s (ID# %d):\n" +
        "		Exam 1:       %d\n" +
        "		Exam 2:       %d\n" +
        "		Final Exam:   %d\n" +
        "		Final Grade:  %.2f\n" +
        "		Letter Grade: %c\n", helpptr.getFirstName(), helpptr.getLastName(), helpptr.getID(), helpptr.getExamGrade1(),
        helpptr.getExamGrade2(), helpptr.getExamGrade3(), helpptr.getFinalGrade(), helpptr.getLetterGrade());
            helpptr = helpptr.getNext();
            //increment helpptr
        }
        
        return head;
    }


}
