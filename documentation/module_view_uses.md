# Quizzes-Tutor - Module View: Uses View

## Primary Presentation

<img src="pictures/Uses View.png" width="500" >

Fig 1. Uses View graphic representation. All arrows represent *uses* relations, which are specialized cases of *depends-on* relations between modules. Pairs of red arrows highlight cyclic dependencies.

## Element Catalog
For detailed descriptions of each module, please refer to the [Decomposition View's **Element Catalogue**](module_view_decomposition.md/#element-catalogue). In this section we highlight considerations related exclusively to the *uses* relationship among modules.

### <span style="color:#0080ff">quizzes-tutor</span>
Main module.

### <span style="color:#0080ff">answer</span>
- *Uses*: **question**
- *Is used by*: **discussion**, **question**

*There's a cyclic uses-dependency between this module and the **question** module. Please refer to the **Rationale's section 1.** below for reasoning on possible future considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">auth</span>
- *Uses*: -
- *Is used by*: **course**, **user** 

This module *uses* a module from an external bounded context, the FenixEdu REST API, whose ubiquitous language is a publicly published language to which quizzes-tutor assumes a comformist posture. For more information consult [FenixEdu REST API's SLA](https://fenix.tecnico.ulisboa.pt/personal/external-applications/api-service-agreement).


### <span style="color:#0080ff">course</span>
- *Uses*: **auth**
- *Is used by*: **discussion**, **question**, **questionsubmission**, **quiz**, **tournament** 

### <span style="color:#0080ff">discussion</span>
- *Uses*: **answer**, **course**, **question**, **user**
- *Is used by*: -

### <span style="color:#0080ff">question</span>
- *Uses*: **answer**, **course**
- *Is used by*: **answer**, **discussion**, **questionsubmission**, **tournament**

*There's a cyclic uses-dependency between this module and the **answers** module. Furthermore, this module has many incoming uses-dependencies as it is a part of the Core Domain of quizzes-tutor. Please refer to the **Rationale's section 1.** section below for reasoning on possible future considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">questionsubmission</span>
- *Uses*: **course**, **question**, **user**
- *Is used by*: -

### <span style="color:#0080ff">quiz</span>
- *Uses*: **course**, **question**, **user**
- *Is used by*: **tournament**

### <span style="color:#0080ff">statement</span>
- *Uses*: -
- *Is used by*: -

### <span style="color:#0080ff">statistics</span>
- *Uses*: -
- *Is used by*: -

### <span style="color:#0080ff">tournament</span>
- *Uses*: **question**
- *Is used by*: **discussion**, **question**

### <span style="color:#0080ff">user</span>
- *Uses*: **auth**
- *Is used by*: **discussion**, **questionsubmission**, **quiz**, **tournament**

*This module, like **question**, has a lot of incoming *uses* dependencies. Please refer to the **Rationale's section 2.** section below for reasoning on possible future considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">permission</span>~
- *Uses*: -
- *Is used by*: -

## Context Diagram

`NOTE: To document the interfaces of each module, the best place to look is at the Service classes in each module.`

## Rationale

Rationale on Model Integrity improvements and considerations:

1. *Since the **answer** uses the **question** module, which in turn also uses the **answer** module, there's a prominent cyclic dependency. To eliminate this cyclic dependency and improve the continuous integration of these and the dependent modules, a possible future solution is to merge **answer** and **question** in the same module and make them a part of the same Bounded Context. Furthermore, given the fact this conjoined Bounded Context has a lot of incoming uses-dependencies, this should be considered a Shared Kernel, among all other Bounded Contexts that use it. This guarantees uncoordinated teams have a common point of knowledge, but since it's part of the realization of the business goals for quizzes-tutor to allow the implementation of new functionalities by outside teams (groups of students developing projects), for all effects, and outside the normal conventions of a Shared Kernel, the dependent Bounded Contexts assume a Comformist position to what the new **answer+question** module has to offer. Another reason to consider the union of these two modules relates to the semantic meaning of the **QuestionDetails** and **AnswerDetails** entities described in the [Data Model](module_view_data_model.md) as most likely, in a **modifiability** scenario where a new type of question is added to quizzes-tutor, a new type of answer will also be required.*

2. *The **user** module has a lot of incoming uses dependencies, and therefore, In the future (and a possible solution to migrate quizzes-tutor into a microservices architecture), this module may be turned into an event publisher, publishing events to all the other modules. In turn the other modules would have a specific partition of the original user module, relevant in that context, that would adapt to the change brought by the events.*

## Related Views

## References
For a detailed style guide, refer to Chapter 2.2 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.















-----------------------------------------------------
TOURNAMENT

Correct implementation depends on:
- quiz
- question
- user
- course

Other dependencies:
- exceptions
- statement
- config
- answer
-----------------------------------------------------
DISCUSSION

Correct implementation depends on:
- question
- course
- user
- answer

Other dependencies:
- exceptions
- impexp
- config
- quiz
-----------------------------------------------------
ANSWER

Correct implementation depends on:
- question

Other dependencies:
- impexp
- statement
- config
- discussion
- quiz
- course
- user
- exceptions
-----------------------------------------------------
QUIZ

Correct implementation depends on:
- question
- course
- user

Other dependencies:
- impexp
- tournament
- statement
- config
- answer
- exceptions
-----------------------------------------------------
QUESTIONSUBMISSION

Correct implementation depends on:
- course
- user
- question

Other dependencies:
- tournament
- config
- exceptions
-----------------------------------------------------
QUESTION

Correct implementation depends on:
- answer
- course

Other dependencies:
- impexp
- tournament
- statement
- config
- discussion
- quiz
- exceptions
-----------------------------------------------------
COURSE

Correct implementation depends on:
- auth

Other dependencies:
- impexp
- statement
- config
- discussion
- answer
- quiz
- questionsubmission
- question
- user
- exceptions
-----------------------------------------------------
USER

Correct implementation depends on:
- auth

Other dependencies:
- impexp
- tournament
- config
- discussion
- answer
- quiz
- questionsubmission
- question
- course
- exceptions
- mailer
- utils
-----------------------------------------------------
CROSS-CUTTING CONCERN MODULES (MORE RELEVANT TO ASPECTS STYLE):

- impexp 
- mailer
- utils
- exceptions
- config
- auth?

-----------------------------------------------------

-----------------------------------------------------

OTHER NOTES:
- impexp can be a ONE HOST SERVICE ?
