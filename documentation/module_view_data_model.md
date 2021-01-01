# Quizzes-Tutor - Module View: Data Model

## Primary Presentation

<img src="pictures/Data Model View.png" width="900" >

Fig 1. Data Model graphic representation. Caption:

<img src="pictures/Data Model View Caption.png" width="900" >

## Element Catalog

### <span style="color:#0080ff">AnswerDetails</span>
This entity is a link entity that maps to a single **QuestionAnswer** entity, and vice-versa, and it's identified primarily by a unique Integer id. This is a particular case of entity, since what it really does, is mapping the **QuestionAnswer** entity to a type of answer. *For now quizzes-tutor only supports multiple choice answers (note the inheritance relation between **MultipleChoiceAnswers** and **AnswerDetails**), but this form of specialization/generalization favors **modifiability**, since, in the future, quizzes-tutor is expected to support other kinds of questions with other kinds of answers. Aditional kinds of answers will require entities homologue to **MultipleChoiceAnswer** to inherit from **AnswerDetails**.*
- **Semantics:** Answer details is roughly speaking, the broad concept (or *generalization*) of "type of answer". The different kinds of answer details (it's inheritances) are the concrete (or *specialized*) types of answers. For instance, different types of questions may require different kinds of answers, which should be threated differently: A multiple choice question requires a multiple choice answer; an open question requires a written answer.

*Please refer to the **Rationale's section DD1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">Assessment</span>
This entity corresponds to an assessment's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **CourseExecution**.
- **Semantics:** An assessment is a group of questions polled from a conjunction of topics (Refer to **TopicConjunction** to understand how an assessment is mapped to a conjunction of topics). An asssessment exists exclusively in the context of a course's execution, since even though the questions remain the same across multiple executions of the course, the assessments should be created according to annual/semiannual necessities.

### <span style="color:#0080ff">AuthDemoUser</span>
This entity is a *specialization* of **AuthUser**, relating to the authentication of a demo user. It's identified by a unique Integer id.
- **Semantics:** A demo user is used for testing. Anyone can test-drive quizzes-tutor as a demo user without logging in.

### <span style="color:#0080ff">AuthExternalUser</span>
This entity is a *specialization* of **AuthUser**, relating to the authentication of external users. It's identified by a unique Integer id and contains, aditionally, a *token* for authentication.
- **Semantics:** An external user is a user outside IST. For instance, a user that authenticates into quizzes-tutor with a *gmail.com* email address is an external user.

### <span style="color:#0080ff">AuthTecnicoUser</span>
This entity is a *specialization* of **AuthUser**, relating to the authentication of a member of IST. It's identified by a unique Integer id.
- **Semantics:** A member of IST (Instituto Superior Técnico) is a student or teacher that's part of the IST organization. This distinction between an external user and a tecnico user is done because IST has it's own authentication API and quizzes-tutor benefits from it.

### <span style="color:#0080ff">AuthUser</span>
This entity corresponds to user-authentication data and it's identified by a unique Integer id. There are multiple *specializations* of authentication, each inherits from the **AuthUser** entity. *For now quizzes-tutor supports authentication of external users and IST students/teachers, but this generalization/specialization relation offers a degree of **modifiability**, by making it straight forward to add other authentication methods, like, for instance, authentication exclusive to other schools.*
- **Semantics:** User authentication data is all the data relevant to user authentication, in particular and in a general way, the *email*, *username* and *password* of a user.

### <span style="color:#0080ff">Course</span>
This entity corresponds to a course's data and it's identified by a unique Integer id.
- **Semantic:** A course is as the name suggests a training course, in particular in the context of a school or teaching institution.

### <span style="color:#0080ff">CourseExecution</span>
This entity corresponds to a course-execution's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **Course**.
- **Semantic:** A course execution corresponds to an annual/semiannual execution of a course. For example, the course of *Software Arquitectures* had multiple executions including in 2017/2018, 2018/2019 and 2019/2020.

### <span style="color:#0080ff">Discussion</span>
This entity corresponds to a discussion's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **Question**.
- **Semantic:** A discussion is a written conversation that can be had among users in the context of a question. It's particularly useful for students to ask questions and clear doubts.

### <span style="color:#0080ff">Image</span>
This entity corresponds to an image's data and it's identified by a unique Integer id.
- **Semantic:** An image is a picture that can be attached to one question.

### <span style="color:#0080ff">MultipleChoiceQuestion</span>
This entity is a *specialization* of **QuestionDetails** and therefore identifies the concrete type of a question. It's identified by a unique Integer id. If a **Question** has this entity as the *questionDetails* attribute, it's a multiple choice question. Refer to **QuestionDetails** for aditional information
- **Semantic:** A multiple choice question is a possible type of question.

*Please refer to the **Rationale's section DD1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">MultipleChoiceAnswer</span>
This entity is a *specialization* of **AnswerDetails** and therefore identifies the concrete type of an answer. It's identified by a unique Integer id. If a **QuestionAnswer** has this entity as the *answerDetails* attribute, it's a multiple choice answer. Refer to **AnswerDetails** for aditional information 
- **Semantic:** A multiple choice answer is a possible type of answer.

*Please refer to the **Rationale's section DD1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">MultipleChoiceAnswerItem</span>
This entity is a *specialization* of **QuizAnswerItem** and together with it serves an homologue purpose to **MultipleChoiceAnswer** and **AnswerDetails**. It's identified by a unique Integer id.
- **Semantic:** A mutiple-choice-answer-item's semantic purpose is to *specialize* the asynchronous collection of data for multiple choice questions. Since quizzes-tutor allows a question's options to be scrambled, which means the answers may appear in a completely altered order for the user, it's also crucial to map the option selected by the user with the right option of the question, by using the *optionId* Integer parameter.

### <span style="color:#0080ff">Option</span>
This entity corresponds to an option's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **MultipleChoiseQuestion**.
- **Semantics:** An option exists in the concept of a multiple choice question and corresponds to a possible answer for that question. For example, in a question with answers A, B, C and D; there are 4 options - A, B, C and D.

### <span style="color:#0080ff">Question</span>
This entity corresponds to a question's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **CourseExecution**.
- **Semantics:** A question, as the name suggests, corresponds to a question that can be put in a quiz. In particular the question entity relates to what's absolutely common to all kinds of question - the "concept" of "a question". The type and parameters of the question are attributed by other entities and relations, mainly by what *specialization* of **QuestionDetails** the question owns.

### <span style="color:#0080ff">QuestionAnswer</span>
This entity corresponds to a question-answer's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **QuizAnswer**.
- **Semantics:** A question answer exists in the context of a quiz answer and is characterized by the final clicked answer (sequence attribute) to a given question and how much time it took to select that answer.

### <span style="color:#0080ff">QuestionAnswerItem</span>
This entity corresponds to a question-answer-item's data and it's identified by a unique Integer id. This entity is generated asynchronously during the answering of the quiz.
- **Semantics:** A question-answer-item corresponds to a grouping of important data adjacent to a "click" in an answer for the question (which may be many in the context of one question). For example, an instance of a **QuestionAnswerItem** entity is created if a quiz starts, the first question is presented to the user and he/she picks answer B. Another instance is created if the user changes it's answer to answer A.

### <span style="color:#0080ff">QuestionDetails</span>
This entity is a link entity that maps to a single **Question** entity, and vice-versa, and it's identified primarily by a unique Integer id. This is a particular case of entity, since what it really does, is mapping the **Question** entity to a type of question. *For now quizzes-tutor only supports multiple choice questions (note the inheritance relation between **MultipleChoiceQuestion** and **QuestionDetails**), but this form of specialization/generalization favors **modifiability**, since, in the future, quizzes-tutor is expected to support other kinds of questions. Aditional kinds of questions will require entities homologue to **MultipleChoiceQuestion** to inherit from **QuestionDetails**.*
- **Semantics:** Question details is roughly speaking, the broad concept (or *generalization*) of "type of question". The different kinds of question details (it's inheritances) are the concrete (or *specialized*) types of question.

*Please refer to the **Rationale's section DD1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">QuestionSubmission</span>
This entity corresponds to a question-submission's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **Question** entity.
- **Semantics:** A question submission corresponds to the act of a user submitting a question to the system, that then becomes dependent on reviews (**Review** entity) for approval/vetting.

### <span style="color:#0080ff">Quiz</span>
This entity corresponds to a quiz's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **CourseExecution** entity.
- **Semantics:** A quiz corresponds to a set of questions a user can answer.

### <span style="color:#0080ff">QuizAnswer</span>
This entity corresponds to a quiz-answer's data and it's identified by a unique Integer id. It's a weak entity depending on one and only one **Quiz** entity. This entity is instantiated in the beginning of a quiz but populated in the end of the quiz with the processing of the data collected in the database.
- **Semantics:** A quiz answer corresponds to the grouping of the user's answers to all questions in a quizz, from the moment a question appears on the screen, to the moment he/she "ends" the quiz.

### <span style="color:#0080ff">QuizAnswerItem</span>
This entity corresponds to a quiz-answer-item's data and it's identified by a unique Integer id. This entity is generated asynchronously during the answering of the quiz.
- **Semantics:** A quiz-answer-item corresponds to a grouping of important data adjacent to the conclusion of a quiz.

### <span style="color:#0080ff">QuizQuestion</span>
This entity is a link entity that maps a single **Quiz** entity to a single **Question** entity, and it's identified primarily by a unique Integer id.
- **Semantics:** This QuizQuestion entity actually carries semantic value, as it also gives information about the position (sequence attribute) a question appears at, in the quiz.

### <span style="color:#0080ff">Reply</span>
This entity corresponds to a reply's data and it's identified primarily by a unique int id. It's a weak entity depending on one and only one **Discussion** entity.
- **Semantics:** A reply is given in the context of a discussion. A discussion is in it's core, a set of replies.

### <span style="color:#0080ff">Review</span>
This entity corresponds to a review's data and it's identified primarily by a unique Integer id. It's a weak entity depending on one and only one **QuestionSubmission** entity. 
- **Semantics:** A review is only relevant in the context of a question submission and corresponds to the concept of a user reviewing another user's question submission. A question submission can however have multiple reviews.

### <span style="color:#0080ff">Topic</span>
This entity corresponds to a topic's data and it's identified primarily by a unique Integer id. 
- **Semantics:** A topic is characterized by it's name and refers to a given subject used to characterize questions. For example, a question about *Software Engineering* has *Software Engineering* as it's topic.

### <span style="color:#0080ff">TopicConjunction</span>
This entity is a link entity that maps a single **Assessment** entity to **Questions** grouped by **Topics**, and it's identified primarily by a unique Integer id. 
- **Semantics:** A topic conjunction is a grouping of topics that takes in consideration the topics of the questions available in the quizzes-tutor.

### <span style="color:#0080ff">Tournament</span>
This entity corresponds to a tournament's data and it's identified primarily by a unique Integer id. 
- **Semantics:** Roughly speaking, a tournament is, as the name sugests, an organized "competition" between users (participants), who answer one quiz featuring questions on a given topic.

### <span style="color:#0080ff">User</span>
This entity corresponds to a user's data and it's identified primarily by a unique Integer id. 
- **Semantics:** A user corresponds to a real user that uses quizzes tutor.

## Context Diagram

## Rationale
The Data Model is particularly important for **modifiability** analysis. Consider, for instance scenario [MS4](system_overview.md#modifibility) where a Software Architecture student must modify the system to improve a quality attribute. In order to properly analyze the impact of the required modifications to the system, it may not be enough to look at the code structure directly. This modification may require altering the data model (addition of new entities or, possibly change existing data abstractions, their operations or their properties) and hence its physical implementation. This can be costly depending on how the data model is structured and therefore a prior analysis is greatly recommended.

There's an interesting refactoring towards the process of question submission better described in the [Refactoring: Question Submission](refactoring_question_submission.md) document.

Rationale on **Domain Distillation** comments, improvements and considerations:

- **DD1.** 

    *The Core Domains, Core Subdomains and Generic Subdomains have been defined in **DD1.**, in the [Decomposition View's **Rationale**](module_view_decomposition.md#rationale) and the [Standard Layered View](module_view_layered.md), but the boundaries can be refined and well defined with the help of the Data Model. One of these boundaries is particularly evident in the relation with the **Question** and **Answer** entities and the **QuestionDetails** and **AnswerDetails** entities. Also **Question** and **Answer** are undoubtably parts of the Core Domain, but what makes them a strong and stable part of it is their relation with **QuestionDetails** and **AnswerDetails** - an abstraction of common services that exists to support **modifiability** (consider, for instance, scenario [MS1](system_overview.md#modifibility)) and deline the decoupling boundaries between the generic attributes of questions/answers and the quite differing semantics of different kinds of questions/answers. This encapsulation of the types of question and answers behind the abstract entities **QuestionDetails** and **AnswerDetails** reduces coupling between **Question**/**Answer** (unlikely to change), and the types of question/answer (likely to be added, deleted or changed). As mentioned prior, the clear distinction of the Core Domain and the Core Subdomains is a godsend to **modifiability**, as developers trust this stable Segregated Core Domain containing the **Questions** and **Answers** entities, to implement aditional kinds of questions and answers independently, such as multiple choice questions and answers (the entities **MultipleChoiceQuestions** and **MultipleChoiceAnswers**), and possibly, in the future, open questions and written answers, among others.* 

## Related Views

## References
For a detailed style guide, refer to Chapter 2.6 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

For detailed information on the Domain Driven Design strategies mentioned, refer to Part IV of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley.
