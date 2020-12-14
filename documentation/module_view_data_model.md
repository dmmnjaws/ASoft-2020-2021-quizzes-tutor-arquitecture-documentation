# Quizzes-Tutor - Module View: Data Model

## Primary Presentation

<img src="pictures/Data Model View.png" width="900" >

Fig 1. Data Model graphic representation. Caption:

<img src="pictures/Data Model View Caption.png" width="900" >

## Element Catalog

### <span style="color:#0080ff">AnswerDetails</span>


### <span style="color:#0080ff">Assessment</span>


### <span style="color:#0080ff">AuthDemoUser</span>


### <span style="color:#0080ff">AuthExternalUser</span>


### <span style="color:#0080ff">AuthUser</span>


### <span style="color:#0080ff">Course</span>


### <span style="color:#0080ff">CourseExecution</span>


### <span style="color:#0080ff">Discussion</span>


### <span style="color:#0080ff">Image</span>


### <span style="color:#0080ff">MultipleChoiceQuestion</span>


### <span style="color:#0080ff">MultipleChoiceAnswer</span>


### <span style="color:#0080ff">MultipleChoiceAnswerItem</span>


### <span style="color:#0080ff">Option</span>


### <span style="color:#0080ff">Question</span>


### <span style="color:#0080ff">QuestionAnswer</span>
This entity corresponds to a question-answer's data and it's identified by an Integer id. It's a weak entity depending on one and only one **QuizAnswer** entity.
- **Semantics:** A question answer exists in the context of a quiz answer (the route until the user clicks to the "next question"), and is characterized by the clicked answer (sequence attribute) and how much time it took to select that answer. Therefore, a question-answer corresponds to a "click" in an answer for the question (which may be many in the context of one question). For example, an instance of a **QuestionAnswer** entity is created if a quiz starts, the first question is presented to the user and he/she picks answer B in 2 seconds. Another instance is created if the user changes it's question to question A in 3 seconds.
`Ask professor for revision and discussion`

### <span style="color:#0080ff">QuestionAnswerItem</span>
`Ask professor for revision and discussion`

`Separation Ways DDD Pattern since we're using Foreign Keys instead of Object References for quizId, quizQuestionId and username`


### <span style="color:#0080ff">QuestionDetails</span>
This entity is a link entity that maps to a single **Question** entity, and vice-versa, and it's identified primarily by an Integer id. This is a particular case of entity, since what it really does, is mapping the **Question** entity to a type of question. For now quizzes-tutor only supports multiple choice questions (note the inheritance relation between **MultipleChoiceQuestion** and **QuestionDetails**), but in the future, it's expected to support other kinds of questions. Aditional kinds of questions will require entities homologue to **MultipleChoiceQuestion** to inherit from **QuestionDetails**  
- **Semantics:** Question details is roughly speaking, the broad concept of "type of question". The different kinds of question details (it's inheritances) are the concrete types of question.

### <span style="color:#0080ff">QuestionSubmission</span>
This entity corresponds to a question-submission's data and it's identified by an Integer id. It's a weak entity depending on one and only one **Question** entity.
- **Semantics:** A question submission corresponds to the act of a user submitting a question to the system, that then becomes dependent on reviews (**Review** entity) for approval/vetting.
`Ask professor to discuss if questionsubmission is a weak entity to question, because even though it generates a question, and depends on a question to formarly exist, the QuestionSubmission instance may exist prior to the question itself, before the user "types" the question.`

### <span style="color:#0080ff">Quiz</span>
This entity corresponds to a quiz's data and it's identified by an Integer id. It's a weak entity depending on one and only one **CourseExecution** entity.
- **Semantics:** A quiz corresponds to a set of questions a user can answer.
`Ask professor to discuss if it really is a weak entity towards CourseExecution`


### <span style="color:#0080ff">QuizAnswer</span>
This entity corresponds to a quiz-answer's data and it's identified by an Integer id. It's a weak entity depending on one and only one **Quiz** entity.
- **Semantics:** A quiz answer corresponds to a description of the entire route it took an user, from the moment a question appears on the screen, to the moment he/she "skips" to the next question.

### <span style="color:#0080ff">QuizAnswerItem</span>
`Ask professor for revision and discussion`


### <span style="color:#0080ff">QuizQuestion</span>
This entity is a link entity that maps a single **Quiz** entity to a single **Question** entity, and it's identified primarily by an Integer id.
- **Semantics:** This QuizQuestion entity actually carries semantic value, as it also gives information about the position (sequence attribute) a question appears at, in the quiz.

### <span style="color:#0080ff">Reply</span>
This entity corresponds to a reply's data and it's identified primarily by an int id. It's a weak entity depending on one and only one **Discussion** entity.
- **Semantics:** A reply is given in the context of a discussion. A discussion is in it's core, a set of replies.

### <span style="color:#0080ff">Review</span>
This entity corresponds to a review's data and it's identified primarily by an Integer id. It's a weak entity depending on one and only one **QuestionSubmission** entity. 
- **Semantics:** A review is only relevant in the context of a question submission and corresponds to the concept of a user reviewing another user's question submission. A question submission can however have multiple reviews.

### <span style="color:#0080ff">Topic</span>
This entity corresponds to a topic's data and it's identified primarily by an Integer id. 
- **Semantics:** A topic is characterized by it's name and refers to a given subject used to characterize questions. For example, a question about *Software Engineering* has *Software Engineering* as it's topic.

### <span style="color:#0080ff">TopicConjunction</span>
This entity is a link entity that maps a single **Assessment** entity to many **Topic** entities, and it's identified primarily by an Integer id. 
- **Semantics:** It has no semantic value.

### <span style="color:#0080ff">Tournament</span>
This entity corresponds to a tournament's data and it's identified primarily by an Integer id. 
- **Semantics:** Roughly speaking, a tournament is, as the name sugests, an organized "competition" between users (participants), who answer one quiz featuring questions on a given topic.

### <span style="color:#0080ff">User</span>
This entity corresponds to a user's data and it's identified primarily by an Integer id. 
- **Semantics:** A user corresponds to a real user that uses quizzes tutor.

## Context Diagram

## Rationale
`According to the professor, we should only have a view as close to the physical level as this one if we're catching up on scenarios that justify it. Either one of these two: António comes up with scenarios for the appropriate QAs. OR Another simpler view has to be done, closer to de Conceptual/Logic level of Data Model, and this one, closer to the Physical level, is left as a attachment, for further considerations...`

## Related Views

## References
For a detailed style guide, refer to Chapter 2.6 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.