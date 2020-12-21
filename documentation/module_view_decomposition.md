# Quizzes-Tutor - Module View: Decomposition View

## Primary Presentation

<img src="pictures/Decomposition View.png" width="900" >


Fig 1. Decomposition View graphic representation. Modules in white are strictly part of the business logic. Modules in grey are not part of the business logic. The **config** module in itself does not contain any business logic other than the **permissions** module.

## Element Catalog

### <span style="color:#0080ff">quizzes-tutor</span>
 This module equates to the whole of quizzes-tutor. The functionalities it provides include:
- Users (students and teachers) may submit multiple choice questions based on topics and create quizzes based on the existing questions in the system;
- Multiple courses are supported, a course can have distinct executions over the years, with reuse of questions;
- Teachers can approve or vet question submissions;
- Teachers can create topics;
- Students may answer quizzes;
- Discussions between users can be created and carried for each quizz question;
- Tournaments between students can be organized. These tournaments may be password restricted;
- Student are allowed to view their current stats. (Gamification)

### <span style="color:#0080ff">answer</span>
This module contains the business logic related to the various answers of a question.

### <span style="color:#0080ff">auth</span>
This module provides the means to authenticate a user into the system using token-based authentication. Authentication works for both IST students and external students. 

### <span style="color:#0080ff">course</span>
This module contains the business logic related to a course. A distinction is done between a Cource and a CourceExecution, since a course can be executed multiple times over the years, and with different students, but reuse of questions.

### <span style="color:#0080ff">discussion</span>
This module contains the business logic related to the discussions functionality and management of replies.

### <span style="color:#0080ff">question</span>
This module contains the business logic related to questions and topics. A Topic has a set of Questions and a Question has a Topic.

### <span style="color:#0080ff">questionsubmission</span>
This module contains the business logic related to question submissions and posterior review/vetting of such submissions.

### <span style="color:#0080ff">quiz</span>
This module contains the business logic related to quizzes, including the ordering of the questions, among others.

### <span style="color:#0080ff">statement</span>
This module contains services to handle the data collected in the various stages of a student answering the quiz, including the start of the quiz, when there's a click in a multiple choice answer, or the quiz is completed.
*This module is deprecated. In the future it is expected to disappear and all data to be handled directly by other elements of the domain.*

### <span style="color:#0080ff">statistics</span>
This module doesn't have persistent content and is simply used to present data. It is however relevant for the business logic as it materializes the gamification aspect of the system, in the form of a stats board.

### <span style="color:#0080ff">tournament</span>
This module contains the business logic related with the tournaments functionality.

### <span style="color:#0080ff">user</span>
This module contains the business logic related with a user. In particular, it contains the god class User.

### <span style="color:#0080ff">permission</span>
This module handles permissions of access to all the logical business entities - Relevant questions like: Can a user view this course? Can a user view this tournament? ...

### <span style="color:#0080ff">backend modules</span>
These submodules contains the server-side logic of their parent module.

### <span style="color:#0080ff">frontend modules</span>
These submodules contains the client-side logic of their parent module and handle related presentation.

## Context Diagram

## Rationale

From a point of view of DDD Distillation, the following modules are part of the **Core Domain**:
- course
- question and answer
- question submission
- quiz
- user

And the following modules are **Core Subdomains**:
- discussion
- tournament
- statistics
- permission

And the following modules are **Generic Subdomains**:
- auth
- mailer

It's worth to consult the [Layered View](module_view_layered.md) to form a better understanding of the logic behind this Distillation.

Rationale on **Domain Model Integrity** improvements and considerations:

1. *Quizzes-tutor was planned to be developed by multiple independent teams which called for the distinction of Bounded Contexts. This is achieved by using a decomposition style that uses the information-hiding principle of the Encapsulation **modifiability** tactic. Encapsulation reduces the probability that a change to one module propagates to other modules. This is achieved through the introduction of an explicit interfaces to modules which in in the quizzes-tutor are the Service classes of each module.*

## Related Views

- Refer to the [Uses View](module_view_uses.md) for the follow-up on which modules *use* each module.
- Refer to the [Layered View](module_view_layered.md) for the follow-up layered distribution of the modules, taking in consideration DDD Distillation principles.

## References
For a detailed style guide, refer to Chapter 2.1 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.