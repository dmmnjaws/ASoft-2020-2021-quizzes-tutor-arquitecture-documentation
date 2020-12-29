### **BG1** The Quizzes Tutor supports a course that follows the flipped classroom model relaxing the load on the teaching body while promoting the student's engagement in the course

------

### **BG2** The Quizzes Tutor promotes the student's learning process and self-assessment of their knowledge

------

### **BG3** The Quizzes Tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application

------

**MS1:** A developer adds, deletes or modifies types of questions, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code.

- `Source` : A developer
- `Stimulus` : Add, delete or modify types of questions
- `Artifacts` : Code and/or data structures
- `Environment` : Design time
- `Response` : Create the asset, test and deploy it
- `Response Measure` : Time to implement the change. `Number of interfaces created between the newly created modules and the rest of the application.` Number of cyclic dependencies created. 

**MS2:** A developer adds, deletes or modifies engagement functionalities, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code.

- `Source` : A developer
- `Stimulus` : Add, delete or modify engagement functionalities
- `Artifacts` : Code and/or data structures
- `Environment` : Design time
- `Response` : Create the asset, test and deploy it
- `Response Measure` : Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. 

**MS3:** A Software Engineering student understands quizzes-tutor to the point of being able to add, delete or modify an engagement functionality, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project.

- `Source` : Software Engineering student
- `Stimulus` : Add, delete or modify engagement functionalities
- `Artifacts` : Code and/or data structures
- `Environment` : Design time
- `Response` : Create the asset, test and deploy it
- `Response Measure` : Time to implement the change. 

**MS4:** A Software Architectures student understands quizzes-tutor to the point of being able to change a quality attribute, such as improving performance during the process of answering a quiz, requiring change to the code and possibly data, interfaces, components, resources and configurations of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project. 

- `Source` : Software Architectures student
- `Stimulus` : Improve performance during the process of answering a quiz
- `Artifacts` : Code, data structures, interfaces, components, resources and configurations 
- `Environment` : Design time
- `Response` : Make the modifications test and deploy them
- `Response Measure` : Time to implement the change. Number of resources created. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created.  

-----------------
`AVALIAR A UTILIZAÇÃO DOS SEGUINTES CENÁRIOS - considerar overlaps com os de cima`

### Modifiability scenario for BG1
- `Source` : The teacher
- `Stimulus` : Create a new question with the purpose of being reused in the future
- `Artifacts` : The question asset
- `Environment` : Design time
- `Response` : Create the asset and deploy it
- `Response Measure` : Number of uses of asset. Time to create the asset

### Availability scenario for BG1
- `Source` : Internal fault
- `Stimulus` : A student submission to the quizz did not appear due to DB malfunction
- `Artifacts` : Database
- `Environment` : Normal operation 
- `Response` : Log the fault
- `Response Measure` : Time to detect the fault. Time to repair the fault

### Usability scenario for BG2 (p.178 of SAP)
`DISCUSS WITH PROFESSOR`
- `Source` : The student
- `Stimulus` : Ability to filter the stats in the quizzes-tutor to view different perpectives on the quizz results(e.g how different are the grades from wendnesday different from monday?)
- `Artifacts` : A specific module
- `Environment` : Design time
- `Response`: Make the change, test it, and deploy it
- `Response Measure`: Time to implement the change.

### Availability scenario for BG2 
- `Source` : Internal fault
- `Stimulus` : A student submission to the discussion did not appear due to DB malfunction
- `Artifacts` : Database
- `Environment` : Normal operation 
- `Response`: Log the fault
- `Response Measure`: Time to detect the fault. Time to repair the fault

### Modifiability scenario for BG3 
- `Source` : The student
- `Stimulus` : Divide a many responsabilities module into single responsability modules
- `Artifacts` : A specific module
- `Environment` : Design time
- `Response` : Make the change, test it, and deploy it
- `Response Measure` : Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. Effect on other Quality Attributes




