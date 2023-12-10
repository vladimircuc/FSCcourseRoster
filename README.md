<br />
<p align="center">
  <h1 align="center">Student Grade Book</h1>

  <p align="center">
    Academic Record that uses linked lists to store students and their details ordered by ID as well as add students, delete students, search students by name or ID and display the 
students’ statistics.
  </p>
</p>

## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Running](#running)
* [Modules](#modules)
* [Notes](#notes)
* [Evaluation](#evaluation)
* [Extras](#extras)

## About The Project

The Java-based Student Grade Book project employs Object-Oriented Programming (OOP) principles to efficiently manage and organize student academic information. The core structure of the project revolves around creating two main classes: Student and Roster.       

The Student class serves as a blueprint for individual student objects, encapsulating relevant attributes such as student ID, name, and an array to store grades. The encapsulation ensures data integrity and provides a systematic way to represent each student's academic profile.    

The Roster class acts as a container for managing multiple Student objects, incorporating functionalities to add, remove, or update student records. Through encapsulation and abstraction, the Roster class enables the creation of a dynamic and scalable system to accommodate a varying number of students.   

In addition to managing individual student records, the Student Grade Book project incorporates a feature that allows users to access real-time statistics for the entire roster. This functionality enhances the project's usability by providing valuable insights into the overall performance of the group.    

The project achieves this by implementing methods within the Roster class that calculate and display statistical measures such as the average, highest, and lowest grades across all students. Through encapsulation and abstraction, these methods can be seamlessly invoked, providing instant access to essential information without the need for complex computations.   

It was created during my Data structures class, practicing Linked Lists.  
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher
* [Maven 3.6](https://maven.apache.org/download.cgi) or higher

### Installation

1. Navigate to the `stocks` directory
2. Clean and build the project using:
```sh
mvn install
```

### Running

1. Download the files inside "src"
2. Run the program.
3. (Optional) - run the sample file found inside the project

List of Commands: 
The number (n) on the first line represents the number of roasters    
The next n lines will be the names of the n roasters   

ADDRECORD CSC-2290 111 Kalyn Salido 90 85 94 //adds a student in the roaster CSC-2290 with the ID 111, name Kalyn Salido and exam scores 90 85 94   
SEARCHBYNAME Kalyn Salido //searching for the student with the name Kayle Salido in all roasters   
SEARCHBYID 111 //searches for the student with ID 111 in all roasters   
DISPLAYSTATS CSC-3280 //dispaly the statistics for the roaster CSC-3280   
DISPLAYSTATS ALL //display stats for all roasters    
DISPLAYSTUDENTS CSC-2290 //dispaly the students in roaster CSC-2290   
DISPLAYSTUDENTS ALL //dispaly all students in the grade book   
QUIT //terminates the program (it is always needed as a last line)


## Modules

<!--
Describe each module in the project, what their purpose is and how they are used in your program. Try to aim for at least 100 words per module.
-->

## Design

<!--
List all the design patterns you used in your program. For every pattern, describe the following:
- Where it is used in your application.
- What benefit it provides in your application. Try to be specific here. For example, don't just mention a pattern improves maintainability, but explain in what way it does so.
-->

## Evaluation

<!--
Discuss the stability of your implementation. What works well? Are there any bugs? Is everything tested properly? Are there still features that have not been implemented? Also, if you had the time, what improvements would you make to your implementation? Are there things which you would have done completely differently? Try to aim for at least 250 words.
-->

## Extras

<!--
If you implemented any extras, you can list/mention them here.
-->

___


<!-- Below you can find some sections that you would normally put in a README, but we decided to leave out (either because it is not very relevant, or because it is covered by one of the added sections) -->

<!-- ## Usage -->
<!-- Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources. -->

<!-- ## Roadmap -->
<!-- Use this space to show your plans for future additions -->

<!-- ## Contributing -->
<!-- You can use this section to indicate how people can contribute to the project -->

<!-- ## License -->
<!-- You can add here whether the project is distributed under any license -->


<!-- ## Contact -->
<!-- If you want to provide some contact details, this is the place to do it -->

<!-- ## Acknowledgements  -->

# 


 and try it yourself!
For now it needs to receive exact commands from the user.  
Examples of commands that can be used:  
3 //number of roasters   
CSC-2290 //names of roasters   
CSC-3280  
CSC-2100  



Best way to test this program is input the sample input and see how the program react. Look for the sample input file    
