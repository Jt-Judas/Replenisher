================================================
Replenisher Task List - coding challenge
================================================
Technologies used:  

 1.Spring boot , 2. Maven, 3. Spring MVC, 
 4.Object Relational Mapping - JPA, 
 5. CSS, 6. Bootstrap, 7. JSP,
 8. STS, 9. Windows, 10. Java 8, 11. JUnit (for unit tests) 
 
 Database used: H2 (Similar to SQLite)
 Architectural Design pattern: Monolithic Model View Controller (MVC).
 
 ================================================
 Design:
 
 1. User:          id, firstname, lastname, username, email
 2. Task:          id, name, description, status, man-hours, progress, rank, priority
 3. comment:       id, description, feedback
 4. Task Status:   Pending, Assigned, In-progress, completed
 5. Task Priority: Low, Mid, High  
 
 Design notes: 
 1. A user can have several tasks, and a task is assigned to a single user.
 2. A task can have several comments, and a comment is given for a single task.
 4. Rank is computed based on task priority against time (quantified as man-hours in my design)
 ==================================================
RUNNING UNIT TESTS VIA COMMAND LINE (And directly)
   
1. Ensure Maven is installed, Navigate to the project directory (via command line, windows). Type command "mvn test" press ENTER.

2. Alternatively, you can use STS (eclipse) to run the tests. Simply open the TaskTest.java file under src/test/java/ com.test , right-click in the class file, and select, Run->JUnit Test.

RUNNING THE APPLICATION VIA COMMAND LINE (And directly)

1. You can use Maven to run the application. Navigate to the application directory via command line and type the command "mvn spring-boot:run". In your browser, type the url : http://localhost:8080/home/ depending on the port (don't forget the last forward slash "/").
2. You may also run the application directly in STS or eclipse. In your browser, type the url : http://localhost:8080/home/ depending on the port (don't forget the last forward slash "/").

==================================================

MAJOR TASKS COMPLETED

1. Add a user, or task.
2. Assign a task to a user.
3. Add a comment to a task.
4. Update task progress, and change task status.
5. View task rank.
6. Filter tasks, and view them sorted based on Status, or rank.
7. Test the model using unit tests
 


  
 
 
 
