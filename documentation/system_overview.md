# Quizzes-Tutor - System Overview

**Quizzes-Tutor** is an under-development, open-source application, aimed at improving the teaching and learning experience between students and teachers. For a more detailed description, refer to the **Purpose and Scope** section of the [Documentation Roadmap](documentation_roadmap.md).

## Business Goals

The functionalities and quality attribute scenarios that follow were infered from the following business goals:

- The Quizzes Tutor supports a course that follows the flipped classroom model relaxing the load on the teaching body while promoting the student's engagement in the course.
- The Quizzes Tutor promotes the students learning process and self-assessment of their knowledge.
- The Quizzes Tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application.

## Functionalities

- **UC1:** Professors should have the possibility to reuse questions between annual/semiannual executions of a course.
- **UC2:** Professors should be able to evaluate the students using quizzes-tutor.
- **UC3:** Students should be able to answer quizzes for evaluation and self-assessment.
- **UC4:** Engagement functionalities, such as discussions, tournaments, statistics and others.

## Quality Attributes

### Modifibility

- **MS1:** A developer adds, deletes or modifies types of questions, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code.
- **MS2:** A developer adds, deletes or modifies engagement functionalities, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modification with small effort and without adding defects to the existing code.
- **MS3:** A Software Engineering student understands quizzes-tutor to the point of being able to add, delete or modify an engagement functionality, requiring change to the code and possibly to data structures of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project.
- **MS4:** A Software Architectures student understands quizzes-tutor to the point of being able to change a quality attribute, such as improving performance during the process of answering a quiz, requiring change to the code and possibly data, interfaces, components, resources and configurations of quizzes-tutor during design time. The objective is to make, test and deploy the modifications within the duration of the project. 

### Availability

This SAD won't be focusing on Availability, but rather on Modifiability. However, it's worth mentioning that the system should be highly available, as it's used by students for formal evaluation.
