## **C2**  Create scenarios for the identified QAs

## **BG1** The Quizzes Tutor supports a course that follows the flipped classroom model relaxing the load on the teaching body while promoting the student's engagement in the course
### Modifiability scenario
- `Source` : The teacher
- `Stimulus` : Create a new question with the purpose of being reused in the future
- `Artifacts` : The question asset
- `Environment` : Design time
- `Response` : Create the asset and deploy it
- `Response Measure` : Number of uses of asset. Time to create the asset

### Availability scenario
- `Source` : Internal fault
- `Stimulus` : A student submission to the quizz did not appear due to DB malfunction
- `Artifacts` : Database
- `Environment` : Normal operation 
- `Response` : Log the fault
- `Response Measure` : Time to detect the fault. Time to repair the fault

-----------

## **BG2** The Quizzes Tutor promotes the student's learning process and self-assessment of their knowledge
### Usability/Modifiability scenario (p.178 of SAP)
`DISCUSS WITH PROFESSOR`
- `Source` : The student
- `Stimulus` : Ability to filter the stats in the quizzes-tutor to view different perpectives on the quizz results(e.g how different are the grades from wendnesday different from monday?)
- `Artifacts` : A specific module
- `Environment` : Design time
- `Response`: Make the change, test it, and deploy it
- `Response Measure`: Time to implement the change.

### Availability scenario
- `Source` : Internal fault
- `Stimulus` : A student submission to the discussion did not appear due to DB malfunction
- `Artifacts` : Database
- `Environment` : Normal operation 
- `Response`: Log the fault
- `Response Measure`: Time to detect the fault. Time to repair the fault

-----------

## **BG3** The Quizzes Tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application
### Modifiability scenario
- `Source` : The student
- `Stimulus` : Divide a many responsabilities module into single responsability modules
- `Artifacts` : A specific module
- `Environment` : Design time
- `Response` : Make the change, test it, and deploy it
- `Response Measure` : Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. Effect on other Quality Attributes


----------------


### Old considerations

### Reusability scenario for BG1
- Source: The student
- Stimulus: Create a new question with the purpose of being reused in the future
- Artifacts: The question asset
- Environment: Design time
- Response: Create the asset and deploy it
- `Response Measure`: Number of uses of asset. Time to create the asset.

### Extensibility scenario for BG2
- Source: The student
- Stimulus: Request to add a new function
- Artifacts: A specific module
- Environment: Design time
- Response: Create the function, test it, and deploy it
- `Response Measure`: Time to implement the function. Number of modules or other artifacts affected. Effect on other Quality Attributes.

### Availability scenario for BG2
- Source: Internal fault
- Stimulus: A student submission to the discussion did not appear due to DB malfunction
- Artifacts: DB
- Environment: Normal operation 
- Response: Log the fault. 
- `Response Measure`: Time to detect the fault. Time to repair the fault.

### Modularity scenario for BG3
- Source: The student
- Stimulus: Divide a many responsabilities module into single responsability modules
- Artifacts: A specific module
- Environment: Design time
- Response: Make the change, test it, and deploy it
- `Response Measure`: Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. Effect on other Quality Attributes.




