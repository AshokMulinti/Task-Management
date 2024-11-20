The Task Management API allows users to manage tasks, including creating, updating, retrieving, and deleting tasks. It is designed to provide a backend for task management applications, supporting basic task tracking functionalities.

This API uses an H2 in-memory database for persistent data storage.

Installation
1. Clone the Repository
  Clone the repository to your local machine:
      git clone https://github.com/AshokMulinti/Task-Management
2. Navigate to the Project Directory
    Change into the project directory:
         cd taskmanagement-api
3.Install Dependencies
   For Maven projects, use:
        ./mvnw install

Running the Application
1.Run the Application Locally
     To run the application, use:
         ./mvnw spring-boot:run
 2. Accessing Application
      Once the application is up and running, you can access it locally at:
        http://localhost:8080


Testing
   1.Run Unit Tests
     To run the unit tests for the application, use the following command:
      ./mvnw test
   2. Run Tests in IntelliJ IDEA
      In IntelliJ IDEA, you can right-click on a test class or method and select "Run" to execute specific tests.
      You can also run all tests by right-clicking the test folder or using the test runner in the IDE.


Got it! Here's an updated version of the README.md file for your Task Management API project, considering that you're using an in-memory H2 database and not implementing any authentication (i.e., no security enabled).

Task Management API
Description
The Task Management API allows users to manage tasks, including creating, updating, retrieving, and deleting tasks. It is designed to provide a backend for task management applications, supporting basic task tracking functionalities.

This API uses an H2 in-memory database for persistent data storage.

Table of Contents
Installation
Running the Application
Testing
Design Decisions
Assumptions
Installation
Clone the Repository

Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/username/task-management-api.git
Navigate to the Project Directory

Change into the project directory:

bash
Copy code
cd task-management-api
Install Dependencies

For Maven projects, use:

bash
Copy code
./mvnw install
For Gradle projects:

bash
Copy code
./gradlew build
Running the Application
Run the Application Locally

To run the application, use:

For Maven:

bash
Copy code
./mvnw spring-boot:run
Or for Gradle:

bash
Copy code
./gradlew bootRun
Accessing the Application

Once the application is up and running, you can access it locally at:

arduino
Copy code
http://localhost:8080
The API will be available on this URL.

Testing
Run Unit Tests

To run the unit tests for the application, use the following command:

For Maven:

bash
Copy code
./mvnw test
For Gradle:

bash
Copy code
./gradlew test
Run Tests in IntelliJ IDEA

In IntelliJ IDEA, you can right-click on a test class or method and select "Run" to execute specific tests.
You can also run all tests by right-clicking the test folder or using the test runner in the IDE.


Design Decisions
1. Database Choice
   The H2 Database is used as an in-memory database for easy setup and lightweight operation during development or testing.
   As an in-memory database, H2 is ephemeral and resets its state when the application stops. This design choice allows for simple testing environments and quick setup without the need for an external database.
2. Application Architecture
  The application follows a Layered Architecture pattern:
   Controller Layer: Manages HTTP requests. Each endpoint in the controller maps to a specific 
  task operation like creating, updating, or deleting tasks.
  Service Layer: Contains the business logic for managing tasks.
  Repository Layer: Handles data storage and retrieval. For this project, it uses Spring Data JPA 
  to interact with the H2 database.
3.RESTful API Design
  The API is built around REST principles, using HTTP methods such as GET, POST, PUT, and DELETE 
 to manage resources (tasks).
  Each task is identified by an id, and typical operations like creating, updating, and deleting 
 tasks are supported by respective HTTP requests.

Assumptions
   1.In-Memory Database (H2)
      The application assumes that the H2 Database is used as an in-memory database for local 
    storage. The database is automatically set up when the application starts and is reset every 
    time the application stops.
    You can configure the database settings in application.properties (if needed).

  2.Spring Boot Version
     The project is designed to work with Spring Boot 4.0.0 and uses dependencies that are 
   compatible with this version.

  3.Java Version
     The application assumes the use of Java 21 or higher, as required by Spring Boot 4.0.0.

  4. Task Model
     The application assumes a simple task model with basic attributes such as id, name, 
  description, status, and dueDate. This allows for simple task management operations.
  
    
