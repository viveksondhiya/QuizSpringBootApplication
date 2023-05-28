# QuizSpringBootApplication
       
                 <h3 align="center"> Quiz Application Documentation </h3>


<h2> Introduction </h2>
The Quiz application is a Spring Boot project that allows users to create quizzes, participate in quizzes, and retrieve quiz results. This documentation provides an overview of the project structure, key components, and functionality.
<h2> Key Features: </h2>
•	<h1>Quiz Creation</h1>: 
The application allows users to create quizzes by providing a question, options, right answer, start date, and end date. The createQuiz method in the QuizController handles the creation of quizzes and saves them in the database.
•	<h1>Quiz Status Management:</h1> 
The application automatically determines the status of a quiz based on the current date and time. The createQuiz method in the QuizService class sets the status of the quiz as "inactive," "active," or "finished" depending on the start and end dates specified.  
•	<h1>Quiz Retrieval:</h1>
Users can retrieve quizzes based on their ID or get a list of all quizzes. The getQuizById and getAllQuizzes methods in the QuizController handle the retrieval of quizzes from the database.  
•	<h1>Active Quiz Tracking:</h1>
The application keeps track of the active quiz by checking the current date and time against the start and end dates of the quizzes. The getActiveQuiz method in the QuizService class retrieves the active quiz from the database and updates its status accordingly.  
•	<h1>Quiz Result Retrieval:</h1> 
The application allows users to retrieve the result of a finished quiz. The getQuizResult method in the QuizController returns the correct answer for a finished quiz based on the provided quiz ID.  
•	<h1>Quiz Result Scheduling: </h1>
The application schedules the retrieval of quiz results five minutes after the end date of each quiz. The scheduleQuizResultRetrieval method in the QuizService class uses a Timer and TimerTask to execute the retrieval task at the specified time.  
•	<h1>Database Persistence: </h1>
The application utilizes Spring Data JPA and the QuizRepository interface to perform database operations such as saving quizzes, retrieving quizzes, and querying quizzes based on start and end dates.
<h3> Project Structure </h3>
•	The Quiz application follows a standard Spring Boot project structure:  com.Quiz.controller: Contains the controllers responsible for handling HTTP requests.    • **com.Quiz.dao:** Contains the data access objects (DAOs) responsible for interacting with the database. 
•	**com.Quiz.entities:** Contains the entity classes that represent the data model of the application. 
•	**com.Quiz.services:** Contains the service classes that implement the business logic of the application.
•	**com.Quiz.QuizApplication:** The main class of the application with the Spring Boot configuration. resources: Contains the application properties and Maven's POM (Project Object Model) file.
<h3>Controllers</h3> 
The Quiz application provides the following controllers:
<h2>QuizController</h2> 
•	<h1>Endpoint:</h1> /quizzes/createQuiz
o	Method: POST
o	Description: Creates a new quiz. 
o	Request Body: Quiz object representing the quiz to be created. 
o	Response: Returns the created quiz object. 
•	<h1>Endpoint:</h1> /quizzes/active  
o	Method: GET 
o	Description: Retrieves the active quiz. 
o	Response: Returns the active quiz object if available. 
•	<h1>Endpoint:</h1>: /quizzes/{id}/result 
o	Method: GET 
o	Description: Retrieves the quiz result by ID. 
o	Path Variable: id - ID of the quiz. 
o	Response: Returns the quiz result if the quiz has finished, or an appropriate response if the result is not available yet.                          
•	<h1>Endpoint:</h1> /quizzes/all  
o	Method: GET 
o	Description: Retrieves all quizzes. 
o	Response: Returns a list of all quizzes.
<h3>Data Access Objects (DAOs)</h3>
 The Quiz application provides the following data access objects:
   <h2>QuizRepository </h2>
o	**Description:** Extends JpaRepository and provides methods for performing CRUD operations on the Quiz entity. 
o	**Methods:** findByStartDateBeforeAndEndDateAfter(startDate, endDate): Retrieves quizzes whose start date is before the specified date and end date is after the specified date.
<h3>Entities</h3> 
The Quiz application defines the following entity:
     <h2>Quiz</h2> 
•	<h1>Attributes:</h1> 
o	id: Unique identifier of the quiz. 
o	question: The question of the quiz. 
o	options: List of options for the quiz question. 
o	rightAnswer: The index of the correct answer in the options list. 
o	StartDate: The start date and time of the quiz. 
o	endDate: The end date and time of the quiz. 
o	status: The status of the quiz (active, inactive, finished).
<h3>Services </h3>
The Quiz application provides the following services:  
<h2>QuizService</h2> 
•	**Description:** Implements the business logic for quiz-related operations. 
•	**Methods:** 
o	createQuiz(quiz): Creates a new quiz, sets its status based on the current date and time, and saves it in the database. 
o	getActiveQuiz(): Retrieves the active quiz based on the current date and time, updates its status if necessary, and returns it. 
o	getQuizById(id): Retrieves a quiz by its ID from the database. 
o	getAllQuizzes(): Retrieves all quizzes from the database. scheduleQuizResultRetrieval(quiz): Schedules a task to retrieve
<h3>Quiz Application Configuration</h3>
   <h2> Database Configuration </h2>
The Quiz application uses a MySQL database for data storage. The database connection properties and other relevant configuration settings are
specified in the application.properties file located in the resources directory.

<h3>Spring Boot Application </h3>
The main class of the Quiz application is QuizApplication, which is annotated with @SpringBootApplication. It also enables scheduling with the @EnableScheduling annotation.  
•	<h1>Annotation:</h1> @SpringBootApplication  
	**Description:** Indicates that this is a Spring Boot application. 
	**Location:** com.Quiz.QuizApplication
•	<h1>Annotation:</h1> @EnableSchedu ling  
	**Description:** Enables scheduling support for the application. 
	**Location:** com.Quiz.QuizApplication 
<h3>Maven Configuration</h3> 
The Quiz application uses Maven as the build and dependency management tool. The project's dependencies and plugins are defined in the pom.xml file.  
<h2>Dependencies:</h2>  
•	Spring Boot starter dependencies for web, data JPA, test, and devtools. 
•	MySQL Connector/J dependency for connecting to the MySQL database. 
•	Springfox Swagger dependencies for API documentation. 
<h2>Plugins:</h2>  
•	Spring Boot Maven Plugin for building and packaging the application.
<h2>Additional Notes</h2> 
•	The project is built with Java version 17. 
•	The project follows the standard Spring Boot project structure.
<h2>Conclusion :</h2>
the provided code represents a Quiz application built with Spring Boot. The application allows users to create quizzes, track the status of active quizzes, retrieve quiz results, and manage quizzes in the database. Key features include quiz creation, quiz status management, quiz retrieval by ID or all quizzes, active quiz tracking, quiz result retrieval, quiz result scheduling, and database persistence using Spring Data JPA. Additionally, the application integrates with Swagger to provide API documentation.
Overall, the Quiz application demonstrates the use of Spring Boot, and Spring Data JPA. It can be further enhanced with additional functionality such as user authentication, scoring, and more advanced quiz management features based on specific requirements.

