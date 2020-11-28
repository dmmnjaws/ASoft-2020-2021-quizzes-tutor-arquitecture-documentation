## **C1** Identify the Quality Attributes from the Business Goals

### BG1 The Quizzes Tutor supports a course that follows the flipped classroom model facilitating the reuse of questions across the different executions of the course.
- `Reusability`: Questions are assets to quizzes-tutor. Reusing these assets provides more consistency, reduces risk and improves productivity during development of the quizzes-tutor throughout the multiple executions of the course.

### BG2 The Quizzes Tutor promotes the student's learning process and self-assessment of their knowledge.
- `Extensibility`: Quizzes Tutor should be extensible, meaning it should be possible for students to add new functionality or modifiy existing ones without negatively affecting existing system functions.
- `Availability`: The questions module and the dicussions module should be funcional and available. This is especially relevant for students to share knowlegde among each other and to have the ability to discuss the best answers to the available questions.

### BG3 The Quizzes Tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application.
- `Modularity`: Having quizzes-tutor modular makes it easier for students to define the modules boundaries, interfaces and responsabilities. This approach is also fundamental for students to later start thinking about transitioning some parts of quizzes-tutor into microservices.


### Old considerations

#### BG1
- `Availability`: The questions module and the dicussions module should be funcional and available. This is specialy relevant for students to share knowlegde among each other and to have the ability to discuss the best answers to the available questions.
- `Portability`: These functionalities should be available in all other platforms (iOS, Android, multiple browsers, etc..)

#### BG2
- `Usability`: The system should be easy to learn and use. Visually it should be effortless and fast to create new discussion topics and visualize their statistics on quizzes, questions and answers.

#### BG3
- `Modifiability`: The code should have enough modularity in order for students to add new features or improve existing ones.
- `Development Distributability`: Mosts students work on their personal computers, from home, school or anywhere. The quizzes tutor application should support distributed software development.

## **C2** Create scenarios for the identified QAs

### Reusability scenario for BG1
- Source: The student
- Stimulus: Create a new question with the purpose of being reused in the future
- Artifacts: The question asset
- Environment: Design time
- Response: Create the asset and deploy it
- Response Measure: Number of uses of asset. Time to create the asset.

### Extensibility scenario for BG2
- Source: The student
- Stimulus: Request to add a new function
- Artifacts: A specific module
- Environment: Design time
- Response: Create the function, test it, and deploy it
- Response Measure: Time to implement the function. Number of modules or other artifacts affected. Effect on other Quality Attributes.

### Availability scenario for BG2
- Source: Internal fault
- Stimulus: A student submission to the discussion did not appear due to DB malfunction
- Artifacts: DB
- Environment: Normal operation 
- Response: Log the fault. 
- Response Measure: Time to detect the fault. Time to repair the fault.

### Modularity scenario for BG3
- Source: The student
- Stimulus: Divide a many responsabilities module into single responsability modules
- Artifacts: A specific module
- Environment: Design time
- Response: Make the change, test it, and deploy it
- Response Measure: Time to implement the change. Number of interfaces created between the newly created modules and the rest of the application. Number of cyclic dependencies created. Effect on other Quality Attributes.



## **C3** Identify the ASRs

..............................
.............WIP..............
..............................