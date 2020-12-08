## **C1** Identify the Quality Attributes and functionalities from the Business Goals

### **BG1** The Quizzes Tutor supports a course that follows the flipped classroom model relaxing the load on the teaching body while promoting the student's engagement in the course
- Detected Functionalities
1. The teacher should be able to create quizzes and responses to questions
2. The teacher should be able to manage quizzes and responses to questions
3. Should support the reuse of questions with auto correction
4. To assure that the students are engaged during the lecture the system should be able to unlock a quizz at the end.
- Detected Quality Attributes 
1. `Modifiability`: It should be possible to add functionalities that promote student's engagement, like tournaments, etc.
2. `Availability`: The system must be available throughout the lecture and evaluation periods

### **BG2** The Quizzes Tutor promotes the student's learning process and self-assessment of their knowledge
- Detected Functionalities
1. The student should be able to create self-assessment quizzes
1. The student should  be able to answer to self-assessment quizzes
- Detected Quality Attributes 
1. `Availability`: The questions module and the dicussions module should be funcional and available outside of the lecture period. This is especially relevant for students to share knowlegde among each other, and to have the ability to discuss the best answers to the available questions

### **BG3** The Quizzes Tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application
- Detected Quality Attributes 
1. `Modifiability`: The code should have enough modularity in order for students to add new features or improve existing ones without negatively affecting existing system functions. This is also fundamental for students to later start thinking about transitioning some parts of quizzes-tutor into microservices



----------------


### Old considerations

#### BG1
- `Availability`: The questions module and the dicussions module should be funcional and available. This is specialy relevant for students to share knowlegde among each other and to have the ability to discuss the best answers to the available questions.
- `Portability`: These functionalities should be available in all other platforms (iOS, Android, multiple browsers, etc..)
- `Reusability`: Questions are assets to quizzes-tutor. Reusing these assets provides more consistency, reduces risk and improves productivity during development of the quizzes-tutor throughout the multiple executions of the course.

#### BG2
- `Usability`: The system should be easy to learn and use. Visually it should be effortless and fast to create new discussion topics and visualize their statistics on quizzes, questions and answers.

#### BG3

- `Development Distributability`: Mosts students work on their personal computers, from home, school or anywhere. The quizzes tutor application should support distributed software development.
- `Modularity`: Having quizzes-tutor modular makes it easier for students to define the modules boundaries, interfaces and responsabilities. This approach is also fundamental for students to later start thinking about transitioning some parts of quizzes-tutor into microservices
- `Extensibility`: Quizzes Tutor should be extensible, meaning it should be possible for students to add new functionality or modifiy existing ones without negatively affecting existing system functions
