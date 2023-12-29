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
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Running](#running)
* [Evaluation](#evaluation)

## About The Project

My Student Grade Book project employs Object-Oriented Programming (OOP) principles to efficiently manage and organize student academic information. The core structure of the project revolves around creating two main classes: Student and Roster.       

The Student class serves as a blueprint for individual student objects, encapsulating relevant attributes such as student ID, name, and an array to store grades. The encapsulation ensures data integrity and provides a systematic way to represent each student's academic profile.    

The Roster class acts as a container for managing multiple Student objects, incorporating functionalities to add, remove, or update student records. Through encapsulation and abstraction, the Roster class enables the creation of a dynamic and scalable system to accommodate a varying number of students.   

In addition to managing individual student records, the Student Grade Book project incorporates a feature that allows users to access real-time statistics for the entire roster. This functionality enhances the project's usability by providing valuable insights into the overall performance of the group.    

The project achieves this by implementing methods within the Roster class that calculate and display statistical measures such as the average, highest, and lowest grades across all students. Through encapsulation and abstraction, these methods can be seamlessly invoked, providing instant access to essential information without the need for complex computations.   

It was created during my Data structures class, practicing Linked Lists.    

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher

### Installation

1. Download the files inside "src"    
2. Run the program.    
3. (Optional) - run the sample file 

### Running    

List of Commands:    
- The number (n) on the first line represents the number of roasters      
    - The next n lines will be the names of the n roasters     
- ADDRECORD + (more information) - adds a student in a roaster   
- SEARCHBYNAME + (one name) - searching for the student with the searched name in all roasters     
- SEARCHBYID + (one ID) - searches for the student with the searched ID in all roasters   
- DISPLAYSTATS + (one course name) - dispaly the statistics for the searched roaster     
- DISPLAYSTATS ALL - display stats for all roasters      
- DISPLAYSTUDENTS + (one course name) - dispaly the students in the searched roaster     
- DISPLAYSTUDENTS ALL - dispaly all students in the grade book      
- QUIT //terminates the program (it is always needed as a last line)   


## Evaluation

I believe my implementation of the Student Grade Book demonstrates a robust and stable design, with key features functioning effectively. The encapsulation of student and roster objects within the Object-Oriented Programming (OOP) paradigm contributes to the project's stability, as it promotes modular development and minimizes dependencies between different components.   

Extensive testing has been conducted to ensure the correctness and reliability of the project. Unit tests have been applied to individual methods within the Student and Roster classes, verifying their functionality in isolation. Integration tests have been performed to assess how these classes interact with each other and the broader system. This comprehensive testing approach has helped identify and address any potential bugs, enhancing the overall stability of the implementation.    

While the current implementation is stable and fulfills its core objectives, there is always room for improvement. If additional time were available, enhancements could be made to the user interface, introducing graphical elements and improving the overall user experience. The project could also benefit from the incorporation of a database system for more robust data storage and retrieval, enabling scalability for larger rosters and long-term data persistence.    

A more extensive focus on error handling and user input validation could further fortify the project's stability. By anticipating and gracefully handling potential issues during runtime, the system could become even more resilient to unexpected scenarios.    

Overall, the implemented features work harmoniously, bugs have been addressed through rigorous testing, and the project remains stable. With further development time, the user interface and data management aspects could be refined to elevate the project's overall quality and user satisfaction.   

<!--
Discuss the stability of your implementation. What works well? Are there any bugs? Is everything tested properly? Are there still features that have not been implemented? Also, if you had the time, what improvements would you make to your implementation? Are there things which you would have done completely differently? Try to aim for at least 250 words.
-->


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
 
