# QuizSpringBootApplication Documentation
       

<h2> Introduction </h2>
The Quiz application is a Spring Boot project that allows users to create quizzes, participate in quizzes, and retrieve quiz results. This documentation provides an overview of the project structure, key components, and functionality.
<h1> Key Features: </h1>
<h3>Quiz Creation: </h3>
The application allows users to create quizzes by providing a question, options, right answer, start date, and end date. The createQuiz method in the QuizController handles the creation of quizzes and saves them in the database.
<h3>Quiz Status Management:</h3> 
The application automatically determines the status of a quiz based on the current date and time. The createQuiz method in the QuizService class sets the status of the quiz as "inactive," "active," or "finished" depending on the start and end dates specified.  
<h3>Quiz Retrieval:</h3>
Users can retrieve quizzes based on their ID or get a list of all quizzes. The getQuizById and getAllQuizzes methods in the QuizController handle the retrieval of quizzes from the database.  
<h3>Active Quiz Tracking:</h3>
The application keeps track of the active quiz by checking the current date and time against the start and end dates of the quizzes. The getActiveQuiz method in the QuizService class retrieves the active quiz from the database and updates its status accordingly.  
<h3>Quiz Result Retrieval:</h3> 
The application allows users to retrieve the result of a finished quiz. The getQuizResult method in the QuizController returns the correct answer for a finished quiz based on the provided quiz ID.  
<h2>Quiz Result Scheduling: </h2>
The application schedules the retrieval of quiz results five minutes after the end date of each quiz. The scheduleQuizResultRetrieval method in the QuizService class uses a Timer and TimerTask to execute the retrieval task at the specified time.  
<h3>Database Persistence: </h3>
The application utilizes Spring Data JPA and the QuizRepository interface to perform database operations such as saving quizzes, retrieving quizzes, and querying quizzes based on start and end dates.
<h1> Project Structure </h1>
The Quiz application follows a standard Spring Boot project structure:  com.Quiz.controller: Contains the controllers responsible for handling HTTP requests. <br>  •      com.Quiz.dao: Contains the data access objects (DAOs) responsible for interacting with the database.<br> 
•	com.Quiz.entities: Contains the entity classes that represent the data model of the application.<br>
•	com.Quiz.services: Contains the service classes that implement the business logic of the application.<br>
•	com.Quiz.QuizApplication: The main class of the application with the Spring Boot configuration. resources: Contains the application properties and Maven's POM (Project Object Model) file.<br>
<h1>Controllers</h1> 
The Quiz application provides the following controllers:
<h3>QuizController</h3> 
•	Endpoint: /quizzes/createQuiz<br>
o	Method: POST<br>
o	Description: Creates a new quiz. <br>
o	Request Body: Quiz object representing the quiz to be created. <br>
o	Response: Returns the created quiz object.<br>

•	Endpoint: /quizzes/active  <br>
o	Method: GET <br>
o	Description: Retrieves the active quiz. <br>
o	Response: Returns the active quiz object if available. <br>

•	Endpoint: /quizzes/{id}/result <br>
o	Method: GET <br>
o	Description: Retrieves the quiz result by ID. <br>
o	Path Variable: id - ID of the quiz.<br> 
o	Response: Returns the quiz result if the quiz has finished, or an appropriate response if the result is not available yet.<br> 

•	Endpoint: /quizzes/all  <br>
o	Method: GET <br>
o	Description: Retrieves all quizzes.<br> 
o	Response: Returns a list of all quizzes.<br>

<h1>Data Access Objects (DAOs)</h1>
 The Quiz application provides the following data access objects:
   <h2>QuizRepository </h2>
o	Description: Extends JpaRepository and provides methods for performing CRUD operations on the Quiz entity. <br>
o	Methods: findByStartDateBeforeAndEndDateAfter(startDate, endDate): Retrieves quizzes whose start date is before the specified date and end date is after the specified date.<br>
<h1>Entities</h1> 
The Quiz application defines the following entity:
     <h3>Quiz</h3> 
	<h3>Attributes:</h3> <br>
o	id: Unique identifier of the quiz. <br>
o	question: The question of the quiz. <br>
o	options: List of options for the quiz question.<br> 
o	rightAnswer: The index of the correct answer in the options list. <br>
o	StartDate: The start date and time of the quiz. <br>
o	endDate: The end date and time of the quiz. <br>
o	status: The status of the quiz (active, inactive, finished).<br>
<h1>Services </h1>
The Quiz application provides the following services:  
<h3>QuizService</h3> 
•	Description: Implements the business logic for quiz-related operations. <br>
•	Methods: <br>
o	createQuiz(quiz): Creates a new quiz, sets its status based on the current date and time, and saves it in the database. <br>
o	getActiveQuiz(): Retrieves the active quiz based on the current date and time, updates its status if necessary, and returns it. <br>
o	getQuizById(id): Retrieves a quiz by its ID from the database. <br>
o	getAllQuizzes(): Retrieves all quizzes from the database. scheduleQuizResultRetrieval(quiz): Schedules a task to retrieve<br>
<h1>Quiz Application Configuration</h1>
   <h3> Database Configuration </h3>
The Quiz application uses a MySQL database for data storage. The database connection properties and other relevant configuration settings are
specified in the application.properties file located in the resources directory.<br>

<h1>Spring Boot Application </h1>
The main class of the Quiz application is QuizApplication, which is annotated with @SpringBootApplication. It also enables scheduling with the @EnableScheduling annotation.  
	<h3>Annotation:</h3> @SpringBootApplication <br> 
	Description: Indicates that this is a Spring Boot application. <br>
	Location: com.Quiz.QuizApplication <br>
	<h3>Annotation:</h3> @EnableSchedu ling <br> 
	Description: Enables scheduling support for the application. <br>
	Location: com.Quiz.QuizApplication <br>
<h1>Maven Configuration</h1> 
The Quiz application uses Maven as the build and dependency management tool. The project's dependencies and plugins are defined in the pom.xml file.  
<h2>Dependencies:</h2>  
•	Spring Boot starter dependencies for web, data JPA, test, and devtools.<br> 
•	MySQL Connector/J dependency for connecting to the MySQL database. <br>
•	Springfox Swagger dependencies for API documentation. <br>
<h2>Plugins:</h2>  
•	Spring Boot Maven Plugin for building and packaging the application.<br>
<h2>Additional Notes</h2> 
•	The project is built with Java version 17. <br>
•	The project follows the standard Spring Boot project structure.<br>
<h2>Conclusion :</h2>
the provided code represents a Quiz application built with Spring Boot. The application allows users to create quizzes, track the status of active quizzes, retrieve quiz results, and manage quizzes in the database. Key features include quiz creation, quiz status management, quiz retrieval by ID or all quizzes, active quiz tracking, quiz result retrieval, quiz result scheduling, and database persistence using Spring Data JPA. Additionally, the application integrates with Swagger to provide API documentation.<br>
Overall, the Quiz application demonstrates the use of Spring Boot, and Spring Data JPA. It can be further enhanced with additional functionality such as user authentication, scoring, and more advanced quiz management features based on specific requirements.

