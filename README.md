
# Java JDBC CRUD Project

This is a personal project I build to implement a Java CRUD using JDBC API.




## 📦 Tech Stack

- Programming Language: Java 17
- Dependencies Manager: Maven
- Database Management System: MySQL
- Database Connection API: JDBC (Java Database Connectivity)
- Design Pattern: Client-Server
- Data Access Pattern: Repository
## 🗒 Features

- Make a connection between SQL Database "schedules" and a Java Program.
- Map a SQL Table "person" to a Java program usign JDBC API.
- Execute CRUD methods directly from Java project and persist results in Database.
## 🛠 Software Architecture

The project is divided in the following packages:

- **main:**
    
    *Main.java*: Contains the main method and executes the program.

    *Crud.java*: Contains the processes and logic to test the program.
- **model:**

    *Person.java*: Contains the atributes and methods that are going to be mapped to the table "person" from the database "schedules". Works as a simple "POJO (Plain Old Java Object)". 
- **repository:**

    *PersonRepository.java*: Following the Repository Architecture, PersonRepository.java contains the implementation of the Repository interface:
    
    - *findAll()*: public method that list all records on the "person" table.
    - *getById()*: public method that list one (1) person from the "person" table.
    - *save()*: public method that can either *INSERT* a new person on the "person" table or *UPDATE* an existing peron on the "person" table. If the person's id provided to the method is null then the method will automatically process an *INSERT* query instead of an *UPDATE*.
    - *delete()*: public method that deletes an existing person from the "person" table using person's id.

    *Respository.java*: Interface with the *findAll()*, *getById()*, *save()* & *delete()* methods implementation's specifications. Uses Generics so it can be implemented by different types of classes. 
- **util:**

    *DatabaseConnection.java*: This class defines the details of implementation of the DriverManager. This is where we need to specify:

    - *URL* -> dabatase url. e.g.:"jdbc:mysql://localhost:3306/schedules"
    - *USERNAME*-> database admin username. e.g.:"root"
    - *PASSWORD* -> database admin password. e.g.:"Password".

    The implementation of the DriverManager class was done for learning purposes and not production so make sure database doesn't have sensitive info.




## 💬 Resources

- The main resource for building this project was finishing the Platzi Course "Java SE: SQL y Base de Datos" and using what I learned with my own database and table. Course LinK: https://platzi.com/cursos/java-sql/