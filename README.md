# QuizSpringBootApplication
                 Quiz Application Documentation

Introduction
The Quiz application is a Spring Boot project that allows users to create quizzes, participate in quizzes, and retrieve quiz results. This documentation provides an overview of the project structure, key components, and functionality.
Key Features:
•	Quiz Creation: 
The application allows users to create quizzes by providing a question, options, right answer, start date, and end date. The createQuiz method in the QuizController handles the creation of quizzes and saves them in the database.
•	Quiz Status Management: 
The application automatically determines the status of a quiz based on the current date and time. The createQuiz method in the QuizService class sets the status of the quiz as "inactive," "active," or "finished" depending on the start and end dates specified.  
•	Quiz Retrieval:
Users can retrieve quizzes based on their ID or get a list of all quizzes. The getQuizById and getAllQuizzes methods in the QuizController handle the retrieval of quizzes from the database.  
•	Active Quiz Tracking:
The application keeps track of the active quiz by checking the current date and time against the start and end dates of the quizzes. The getActiveQuiz method in the QuizService class retrieves the active quiz from the database and updates its status accordingly.  
•	Quiz Result Retrieval: 
The application allows users to retrieve the result of a finished quiz. The getQuizResult method in the QuizController returns the correct answer for a finished quiz based on the provided quiz ID.  
•	Quiz Result Scheduling: 
The application schedules the retrieval of quiz results five minutes after the end date of each quiz. The scheduleQuizResultRetrieval method in the QuizService class uses a Timer and TimerTask to execute the retrieval task at the specified time.  
•	Database Persistence: 
The application utilizes Spring Data JPA and the QuizRepository interface to perform database operations such as saving quizzes, retrieving quizzes, and querying quizzes based on start and end dates.
Project Structure
•	The Quiz application follows a standard Spring Boot project structure:  com.Quiz.controller: Contains the controllers responsible for handling HTTP requests. com.Quiz.dao: Contains the data access objects (DAOs) responsible for interacting with the database. 
•	com.Quiz.entities: Contains the entity classes that represent the data model of the application. 
•	com.Quiz.services: Contains the service classes that implement the business logic of the application.
•	com.Quiz.QuizApplication: The main class of the application with the Spring Boot configuration. resources: Contains the application properties and Maven's POM (Project Object Model) file.
Controllers 
The Quiz application provides the following controllers:
QuizController 
•	Endpoint: /quizzes/createQuiz
o	Method: POST
o	Description: Creates a new quiz. 
o	Request Body: Quiz object representing the quiz to be created. 
o	Response: Returns the created quiz object. 
•	Endpoint: /quizzes/active  
o	Method: GET 
o	Description: Retrieves the active quiz. 
o	Response: Returns the active quiz object if available. 
•	Endpoint: /quizzes/{id}/result 
o	Method: GET 
o	Description: Retrieves the quiz result by ID. 
o	Path Variable: id - ID of the quiz. 
o	Response: Returns the quiz result if the quiz has finished, or an appropriate response if the result is not available yet.                          
•	Endpoint: /quizzes/all  
o	Method: GET 
o	Description: Retrieves all quizzes. 
o	Response: Returns a list of all quizzes.
Data Access Objects (DAOs)
 The Quiz application provides the following data access objects:
   QuizRepository 
o	Description: Extends JpaRepository and provides methods for performing CRUD operations on the Quiz entity. 
o	Methods: findByStartDateBeforeAndEndDateAfter(startDate, endDate): Retrieves quizzes whose start date is before the specified date and end date is after the specified date.
Entities 
The Quiz application defines the following entity:
     Quiz 
•	Attributes: 
o	id: Unique identifier of the quiz. 
o	question: The question of the quiz. 
o	options: List of options for the quiz question. 
o	rightAnswer: The index of the correct answer in the options list. 
o	StartDate: The start date and time of the quiz. 
o	endDate: The end date and time of the quiz. 
o	status: The status of the quiz (active, inactive, finished).
Services 
The Quiz application provides the following services:  
QuizService 
•	Description: Implements the business logic for quiz-related operations. 
•	Methods: 
o	createQuiz(quiz): Creates a new quiz, sets its status based on the current date and time, and saves it in the database. 
o	getActiveQuiz(): Retrieves the active quiz based on the current date and time, updates its status if necessary, and returns it. 
o	getQuizById(id): Retrieves a quiz by its ID from the database. 
o	getAllQuizzes(): Retrieves all quizzes from the database. scheduleQuizResultRetrieval(quiz): Schedules a task to retrieve
Quiz Application Configuration
    Database Configuration 
The Quiz application uses a MySQL database for data storage. The database                    connection properties and other relevant configuration settings are
specified in the application.properties file located in the resources directory.

Spring Boot Application 
The main class of the Quiz application is QuizApplication, which is annotated with @SpringBootApplication. It also enables scheduling with the @EnableScheduling annotation.  
•	Annotation: @SpringBootApplication  
	Description: Indicates that this is a Spring Boot application. 
	Location: com.Quiz.QuizApplication
•	Annotation: @EnableSchedu ling  
	Description: Enables scheduling support for the application. 
	Location: com.Quiz.QuizApplication 
Maven Configuration 
The Quiz application uses Maven as the build and dependency management tool. The project's dependencies and plugins are defined in the pom.xml file.  
Dependencies:  
•	Spring Boot starter dependencies for web, data JPA, test, and devtools. 
•	MySQL Connector/J dependency for connecting to the MySQL database. 
•	Springfox Swagger dependencies for API documentation. 
Plugins:  
•	Spring Boot Maven Plugin for building and packaging the application.
Additional Notes 
•	The project is built with Java version 17. 
•	The project follows the standard Spring Boot project structure.
Conclusion :
the provided code represents a Quiz application built with Spring Boot. The application allows users to create quizzes, track the status of active quizzes, retrieve quiz results, and manage quizzes in the database. Key features include quiz creation, quiz status management, quiz retrieval by ID or all quizzes, active quiz tracking, quiz result retrieval, quiz result scheduling, and database persistence using Spring Data JPA. Additionally, the application integrates with Swagger to provide API documentation.
Overall, the Quiz application demonstrates the use of Spring Boot, and Spring Data JPA. It can be further enhanced with additional functionality such as user authentication, scoring, and more advanced quiz management features based on specific requirements.

