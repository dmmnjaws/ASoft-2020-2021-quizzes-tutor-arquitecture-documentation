**MS1:** A developer adds, deletes or modifies types of questions, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code.

- `Source` : A developer
- `Stimulus` : Add, delete or modify types of questions
- `Artifacts` : Code and/or data structures
- `Environment` : Design time
- `Response` : Create the asset, test and deploy it
- `Response Measure` : Time to implement the change `Number of interfaces created between the newly created modules and the rest of the application.` Number of cyclic dependencies created. 

**MS2:** A developer adds, deletes or modifies engagement functionalities, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code.

- `Source` : A developer
- `Stimulus` : Add, delete or modify engagement functionalities
- `Artifacts` : Code and/or data structures
- `Environment` : Design time
- `Response` : Create the asset, test and deploy it
- `Response Measure` : Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created

**MS3:** A Software Engineering student understands quizzes-tutor to the point of being able to add, delete or modify an engagement functionality, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project.

- `Source` : Software Engineering student
- `Stimulus` : Add, delete or modify engagement functionalities
- `Artifacts` : Code and/or data structures
- `Environment` : Design time
- `Response` : Create the asset, test and deploy it
- `Response Measure` : Time to implement the change

**MS4:** A Software Architectures student understands quizzes-tutor to the point of being able to change a quality attribute, such as improving performance during the process of answering a quiz, requiring change to the code and possibly data, interfaces, components, resources and configurations of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project. 

- `Source` : Software Architectures student
- `Stimulus` : Improve performance during the process of answering a quiz
- `Artifacts` : Code, data structures, interfaces, components, resources and configurations 
- `Environment` : Design time
- `Response` : Make the modifications test and deploy them
- `Response Measure` : Time to implement the change. Number of resources created. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created  

**MS5:** A Software Engineering student refactors the system in order to make all questions available to all courses by means of implementing shared question repositories, each of these with its own field of study (e.g. Software Engineering, Software Architectures, etc). This will require changes to the code and data structures. The objective is to make, test and deploy the modifications within the duration of the project.

- `Source` : Software Engineering student
- `Stimulus` : Change the system in order to make all questions available to all courses
- `Artifacts` : Code and data structures.
- `Environment` : Design time
- `Response` : Make the modifications test and deploy them
- `Response Measure` : Time to implement the change

**AS1:** An internal, omission fault (such as a student requesting a quiz and the quiz not appearing; or a question in a quiz being skipped without the student's consent, among others) happens during the normal operation of the system, in particular during the period of evaluation of a student. The fault must be isolated, preventing it from becoming a failure, and it must be logged to safeguard the student's evaluation. A good measure would be the percentage of evaluation of a class lost during the course of the semester.

- `Source` : Internal
- `Stimulus` : Omission fault
- `Artifacts` : Persistent storage (database)
- `Environment` : Normal operation, during the period of evaluation of a student 
- `Response` : Prevent the fault from becoming a failure and log it
- `Response Measure` : percentage of evaluation of a class lost during the course of the semester

**SS1:** An outside attacker (using demo user credentials) launches a Denial of Service attack (using jmeter scripts or others) at the quizzes-tutor services and/or data consumed by these, reducing the overall availability of the system during normal operation, in particular during the period of evaluation of the students. The attack must be detected and assurances must be put in place to allow the data and system services to be available for legitimate use. A good measure would be the percentage of evaluation of a class lost during the course of the semester.

- `Source` : Attacker
- `Stimulus` : Denial of Service attack on the system by means of demo user logins(using jmeter scripts or others) prevents quizzes-tutor from being fully available during assessment quizzes.
- `Artifacts` : System services and/or data consumed by the system(answers)
- `Environment` : Normal operation, during the period of evaluation of a student 
- `Response` : Detect the attack and assure that the data and system services will be available for legitimate use.
- `Response Measure` : percentage of evaluation of a class lost during the course of the semester

