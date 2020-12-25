# Quizzes-Tutor - Module View: Uses View

## Primary Presentation

<img src="pictures/Uses View.png" width="500" >

Fig 1. Uses View graphic representation. All arrows represent *uses* relations, which are specialized cases of *depends-on* relations between modules. Pairs of red arrows highlight cyclic dependencies. Keep in mind that the **permission** module doesn't have incoming *uses* dependencies, but *uses* other modules. This wasn't represented for the sake of not cluttering the diagram, but these relations can be consulted below, in the **permission** module entry in the Element Catalogue.

## Element Catalog
For detailed descriptions of each module, please refer to the [Decomposition View's **Element Catalogue**](module_view_decomposition.md/#element-catalogue). In this section we highlight considerations related exclusively to the *uses* relationship among modules.

### <span style="color:#0080ff">quizzes-tutor</span>
Main module.

### <span style="color:#0080ff">answer</span>
- *Uses*: **question**
- *Is used by*: **discussion**, **question**, **statistics**

*There's a cyclic uses-dependency between this module and the **question** module. Please refer to the **Rationale's section 1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">auth</span>
- *Uses*: -
- *Is used by*: **course**, **user** 

This module *uses* a module from an external Bounded Context, the FenixEdu REST API, whose Ubiquitous Language is a publicly published language to which quizzes-tutor assumes a Comformist posture. For more information consult [FenixEdu REST API's SLA](https://fenix.tecnico.ulisboa.pt/personal/external-applications/api-service-agreement).

### <span style="color:#0080ff">course</span>
- *Uses*: **auth**
- *Is used by*: **discussion**, **question**, **questionsubmission**, **quiz**, **tournament** 

### <span style="color:#0080ff">discussion</span>
- *Uses*: **answer**, **course**, **question**, **user**
- *Is used by*: -

*This module, like **tournament** implements an engagement functionality and has no incoming uses-dependency. Please refer to the **Rationale's section 3.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">question</span>
- *Uses*: **answer**, **course**
- *Is used by*: **answer**, **discussion**, **questionsubmission**, **quiz**, **statistics**, **tournament**

*There's a cyclic uses-dependency between this module and the **answers** module. Furthermore, this module has many incoming uses-dependencies as it is a part of the Core Domain of quizzes-tutor. Please refer to the **Rationale's section 1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">questionsubmission</span>
- *Uses*: **course**, **question**, **user**
- *Is used by*: -

`This module was added before the modules of engagement functionality (therefore is part of the Core Domain, but there's an interesting refactoring here if we consider the professor can also submit questions. - Professor Rito`

### <span style="color:#0080ff">quiz</span>
- *Uses*: **course**, **question**, **user**
- *Is used by*: **statistics**, **tournament**

### <span style="color:#0080ff">statement</span>
- *Uses*: -
- *Is used by*: -

### <span style="color:#0080ff">statistics</span>
- *Uses*: **answer**, **question**, **quiz**, **user**
- *Is used by*: -

The StatsService in this module collects statistics on quizzes, questions and answers for each user. Howeber, it does so solely by accessing the **user** module. However, without the existence of the **answer**, **question** and **quiz** modules, **statistics** would make no sense conceptually, and therefore it's said to have outbound uses-dependencies to these modules as well.

### <span style="color:#0080ff">tournament</span>
- *Uses*: **course**, **question**, **quiz**, **user**
- *Is used by*: -

*This module, like **discussion** implements an engagement functionality and has no incoming uses-dependency. Please refer to the **Rationale's section 3.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">user</span>
- *Uses*: **auth**
- *Is used by*: **discussion**, **questionsubmission**, **quiz**, **statistics**, **tournament**

*This module, like **question**, has a lot of incoming *uses* dependencies. Please refer to the **Rationale's section 2.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">permission</span>
- *Uses*: **answer**, **course**, **discussion**, **question**, **questionsubmission**, **quiz**, **user**
- *Is used by*: -

## Context Diagram

`NOTE: To document the interfaces of each module, the best place to look is at the Service classes in each module.`

## Rationale

Rationale on **Domain Model Integrity** improvements and considerations:

1. *Since the **answer** uses the **question** module, which in turn also uses the **answer** module, there's a prominent cyclic dependency. To eliminate this cyclic dependency and improve the continuous integration of these and the dependent modules, a possible future solution is to merge **answer** and **question** in the same module and make them a part of the same Bounded Context. Furthermore, given the fact this conjoined Bounded Context has a lot of incoming uses-dependencies, this should be considered a Shared Kernel, among all other Bounded Contexts that use it. This guarantees uncoordinated teams have a common point of knowledge, but since it's part of the realization of the business goals for quizzes-tutor to allow the implementation of new functionalities by outside teams (groups of students developing projects), for all effects, and outside the normal conventions of a Shared Kernel, the dependent Bounded Contexts assume a Comformist position to what the new **answer+question** module has to offer. Another reason to consider the union of these two modules relates to the semantic meaning of the **QuestionDetails** and **AnswerDetails** entities described in the [Data Model](module_view_data_model.md) as most likely, in a **modifiability** scenario where a new type of question is added to quizzes-tutor, a new type of answer will also be required.*

2. *The **user** module has a lot of incoming uses dependencies, and therefore, In the future (and a possible solution to migrate quizzes-tutor into a microservices architecture), this module may be turned into an event publisher, publishing events to all the other modules. In turn the other modules would have a specific partition of the original user module, relevant in that context, that would adapt to the change brought by the events.*

Rationale on **Domain Distillation** improvements and considerations:

3. *The **tournament** and **discussion** modules (which are core subdomains and implement engagement functionalities) don't have any incoming uses relation, but rather only use modules of the core domain. This means that from a point of view of **modifiability** it's easy to modify and delete them, and also add other  homologue engagement functionalities. From a point of view of Domain Model Integrity the Bounded Context of these peripheric functionalities (likely to be teams of Software Engineering students) assume a Conformist position towards the Bounded Contexts of the Core Domain.* 

## Related Views

- Refer to the [Decomposition View](module_view_decomposition.md) for module descriptions and purposes. 

## References
For a detailed style guide, refer to Chapter 2.2 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.