# Quizzes-Tutor - Module View: Uses View

## Primary Presentation

<img src="pictures/Uses View.png" width="500" >

Fig 1. Uses View graphic representation. All arrows represent *uses* relations, which are specialized cases of *depends-on* relations between modules. Pairs of red arrows highlight cyclic dependencies. * The **permission** module doesn't have incoming *uses* dependencies, but *uses* other modules. This wasn't represented for the sake of not cluttering the diagram, but these relations can be consulted below, in the **permission** module entry in the Element Catalog.

## Element Catalog
For detailed descriptions of each module, please refer to the [Decomposition View's **Element Catalog**](module_view_decomposition.md/#element-catalog). In this section we highlight considerations related exclusively to the *uses* relationship among modules.

### <span style="color:#0080ff">quizzes-tutor</span>
Main module.

### <span style="color:#0080ff">answer</span>
- *Uses*: **question**
- *Is used by*: **discussion**, **question**, **statistics**

*There's a cyclic uses-dependency between this module and the **question** module. Please refer to the **Rationale's section DMI1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">auth</span>
- *Uses*: -
- *Is used by*: **course**, **user** 

This module *uses* a module from an external Bounded Context, the FenixEdu REST API, whose Ubiquitous Language is a publicly published language to which quizzes-tutor assumes a Conformist posture. For more information consult [FenixEdu REST API's SLA](https://fenix.tecnico.ulisboa.pt/personal/external-applications/api-service-agreement).

### <span style="color:#0080ff">course</span>
- *Uses*: **auth**
- *Is used by*: **discussion**, **question**, **questionsubmission**, **quiz**, **tournament** 

### <span style="color:#0080ff">discussion</span>
- *Uses*: **answer**, **course**, **question**, **user**
- *Is used by*: -

*This module, like **tournament** implements an engagement functionality and has no incoming uses-dependency. Please refer to the **Rationale's section DD1.** followed by **DMI3.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">question</span>
- *Uses*: **answer**, **course**
- *Is used by*: **answer**, **discussion**, **questionsubmission**, **quiz**, **statistics**, **tournament**

*There's a cyclic uses-dependency between this module and the **answers** module. Furthermore, this module has many incoming uses-dependencies as it is a part of the Core Domain of quizzes-tutor. Please refer to the **Rationale's section DMI1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

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

*This module, like **discussion** implements an engagement functionality and has no incoming uses-dependency. Please refer to the **Rationale's section DD1.** followed by **DMI3.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">tournament</span>
- *Uses*: **course**, **question**, **quiz**, **user**
- *Is used by*: -

*This module, like **discussion** and **statistics** implements an engagement functionality and has no incoming uses-dependency. Please refer to the **Rationale's section DD1.** followed by **DMI3.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">user</span>
- *Uses*: **auth**
- *Is used by*: **discussion**, **questionsubmission**, **quiz**, **statistics**, **tournament**

*This module, like **question**, has a lot of incoming *uses* dependencies. Please refer to the **Rationale's section DMI2.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">permission</span>
- *Uses*: **answer**, **course**, **discussion**, **question**, **questionsubmission**, **quiz**, **user**
- *Is used by*: -

## Context Diagram

`NOTE: To document the interfaces of each module, the best place to look is at the Service classes in each module.`

## Rationale

Rationale on **Domain Model Integrity** comments, improvements and considerations:

- **DMI1.** 

  *Since the **answer** uses the **question** module, which in turn also uses the **answer** module, there's a prominent cyclic dependency. To eliminate this cyclic dependency and improve the continuous integration of these and the dependent modules, a possible future solution is to merge **answer** and **question** in the same module and make them a part of the same Bounded Context. Furthermore, given the fact this conjoined Bounded Context has a lot of incoming uses-dependencies, this could be considered a Shared Kernel, among all other Bounded Contexts that use it. This guarantees uncoordinated teams have a common point of knowledge, but since it's part of the realization of the business goals for quizzes-tutor to allow the implementation of new functionalities by outside teams (groups of students developing projects), for all effects, and outside the normal conventions of a Shared Kernel, the dependent Bounded Contexts should actually assume a Conformist position to what the new **question+answer** module has to offer and should not be allowed to make changes to it under any circumstance. Another reason to consider the union of these two modules relates to the semantic meaning of the **QuestionDetails** and **AnswerDetails** entities described in the [Data Model](module_view_data_model.md) as most likely, in a **modifiability** scenario where a new type of question is added to quizzes-tutor, a new type of answer will also be required.*

- **DMI2.** 

  *The **user** module has a lot of incoming uses dependencies, and therefore, In the future (and a possible solution to migrate quizzes-tutor into a microservices architecture), this module may be turned into an event publisher, publishing events to all the other modules. In turn the other modules would have a specific partition of the original user module, relevant in that context, that would adapt to the change brought by the events. A part of the **user** Bounded Context would still be preserved, as an event publisher, but the dependent Bounded Contexts would need to adapt.*
 
- **DMI3.** 

  (It's recommended to read **DD1.** in the **Domain Distillation** section first) *In **DMI1.**, it's suggested that the **question+answer** could be a Shared Kernel among the peripheral functionalities, which is a tactic that applies typically to modules internal to the system under design. However, also in **DMI1.** the conclusion was that perhaps it was best for peripheral functionalities to assume a Conformist posture, a relationship more suited to be had with external systems. This is the perfect opurtunity to further justify this - Due to **DD1.**, we can almost look at the modules of engagement functionalities as external systems (they don't work as external systems, but should aim to evolve as so, independently, so there are some tactics in respect to these that may work here, such as the Conformist and Anticorruption Layer tactics). The Bounded Context of the **tournament**, **discussion** and **statistics** peripheral functionalities (likely to be teams of Software Engineering students) have a couple of options: either assume Conformist positions or Customer/Supplier relations towards the Bounded Contexts of the Core Domain, or even put in place Anticorruption Layers to retrench the effect of changes in the Bounded Contexts of the Core Domain.*

  *As a consequence of the decoupling between the generic attributes of questions/answers and the types of questions/answers (described in **DD1.** in the [Data Model](module_view_data_model.md)), the **question**/**answer** modules are not likely to be modified in ways that directly affect the engagement functionalities, which in turn allows for a more independent relation between the Core Subdomains and this crucial part of the Core Domain, therefore suggesting the possibility of a Conformist position for developers of **tournament**, **discussion** and **statistics** towards the **question+answer** Bounded Context.*
  
  *The Core Domain should be relatively stable, but module like **course**, **quiz** and **user**, may still change over time, and these changes may ultimately affect the engagement functionalities, given the uses relations. What can be done? A Customer/Supplier relation implies responsability from the upstream teams of the Core Domain, which isn't be ideal here, given the fact the engagement functionalities are largely of the responsability of teams of students (which are normally in no position to negotiate changes with upstream teams), therefore, it's best to shift the responsability to each of these downstream teams individually. This can be done thru the implementation of Anticorruption Layers (each engagement functionality team is responsible for it's own), saving the Bounded Contexts of the Core Domain from additional constraints imposed by Customer/Supplier relations.* 
  
  *It's also worth noting that **tournament**, **discussion** and **statistics** don't use each other, because otherwise their Bounded Contexts would be coupled, which is impractical for the teams of students, so these and other similar future engagement functionalities should be designed and implemented with Separated Ways in mind, rejecting any integration among other engagement functionalities' Bounded Contexts.*

- **DMI-SUMMARY:**
  
  <img src="pictures/Uses View Context Map.png" width="500" >
  
  Fig 2. The proposed Context Map of quizzes-tutor, reflecting the considerations in this section. Each Bounded Context is highlighted in a different color. Anticorruption Layers are represented as small boxes with **ACL** notation. The color scheme is an attempt to map the Bounded Contexts with the bigger portion of each Subdomain they are a part of (explicit in **DD1.** in the [Decomposition View](module_view_decomposition.md)). Once again, keep in mind that the boundaries between Subdomains don't equate to neither the boundaries between Bounded Contexts, or the boundaries between modules.

  - **DD1.** 
    - The **question** and **answer** modules should be a part of the same Bounded Context - **question+answer**.
    - Peripheral functionalities should assume a Conformist position towards the **question+answer** Bounded Context, as if they were part of a different system, since these are implemented as so changes are unlikely to leak to other modules.

  - **DD2.**
    - The **user** module could be turned into an event publisher if quizzes-tutor migrates from a monolith to a microservices architecture. A part of the *user* Bounded Context would be preserved, but the dependent Bounded Contexts would need to adapt.

  - **DD3.**
    - The **tournament**, **discussion** and **statistics** modules, as implementations of engagement functionalities, should:
      - Assume a Conformist position towards **questions+answers**, as these are implemented as so changes are unlikely to affect the engagement functionalities.
      - Implement Anticorruption Layers between other Bounded Contexts of the Core Domain, such as **course**, **quiz** and **user**.
      - Evolve separately from each other, allowing their Bounded Contexts to follow the Separated Ways tactic. 

Rationale on **Domain Distillation** comments, improvements and considerations:

- **DD1.** 

  *The **tournament**, **discussion** and **statistics** modules (which are Core Subdomains and implement engagement functionalities) don't have any incoming uses relation, but rather only use modules of the stable Core Domain. This means that from a point of view of **modifiability** it's easy to modify and delete them, and by following the same principle, add other homologue engagement functionalities.* (It's recommended to read **DMI3.** in the **Domain Model Integrity** section next) 

## Related Views

- Refer to the [Decomposition View](module_view_decomposition.md) for module descriptions and purposes. 

## References
For a detailed style guide, refer to Chapter 2.2 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

For detailed information on the Domain Driven Design strategies mentioned, refer to Part IV of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley.