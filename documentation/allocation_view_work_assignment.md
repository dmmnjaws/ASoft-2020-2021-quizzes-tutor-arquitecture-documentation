[< Back to SAD](SAD.md)

# Quizzes-Tutor - Allocation View: Work Assignment View

## Primary Presentation

<img src="pictures/Work Assignment View.png" width="900" >

Fig 1. Work Assignment View graphic representation. Represents the actors contributing to the project and their change from one semester to another.

## Element Catalog


### <span style="color:#0080ff">Students</span>
Groups of **Students** from University of Lisbon - IST courses (for example Software Engineering course), may engage in projects involving the quizzes-tutor application. These groups will develop some quality or engagement functionality, homologue to the **discussion**, **tournament** and **statistics** modules. Teams of **Students** will tipicaly be connected to the quizzes-tutor project for the duration of their course, one semester (in the future, one trimester).

The **Students** work in a "fork" of the original project, possibly in a team/organization for their own course.


### <span style="color:#0080ff">Teachers</span>
The IST course **Teachers**, which use quizzes-tutor development as part of their course plan, and oversee the **Students** work.


### <span style="color:#0080ff">Project Maintainers</span>
**Project Maintainers** correspond to other contributers to the project for a mid to long-term basis, and not restricted by the course period.


### <span style="color:#0080ff">Independent Contributors</span>
Other contributers not directly aligned or responsible for the project, but contribute from their own personal intentions, with pull requests or issue reporting.


## Rationale


Quizzes-tutor is an open source project with most of it's contributors belonging to University of Lisbon - IST courses.
In the context of the Software Engineering Course, groups of **Students** participate in the implementation of contributions to be integrated into quizzes-tutor.
In terms of design this means there is a large diversity of improvements being generated, favouring a reinforced and compreensive model interpretation and better refactoring to the project.

This organization and cycle comes to benefit the [BG3](system_overview.md#business-goals) business goal, which relates to quizzes-tutor being used as a pedagogical tool.



Rationale on **Domain Model Integrity** comments, improvements and considerations:

- **DMI1.** 

    *If the criteria mentioned in **DMI3.** in the [Uses View's **Rationale**](module_view_uses.md#rationale) is respected, Student groups can develop their engagement functionalities independently, contributing to [BG3](system_overview.md#business-goals) business goal in respect to scenario [MS3](system_overview.md#modifiability).*

    *The Engagement functionality of each Student group would then correspond to a new Bounded Context. Keeping the desired **modifiability** benefits of using small Bounded Contexts.*

    *As mentoined by **DMI1.** in the [Decomposition View's **Rationale**](module_view_decomposition.md#rationale): "This is achieved by using a decomposition style that uses the information-hiding principle of the Encapsulation **modifiability** tactic."*


- **DMI2.** 

    *A conclusion was taken in **DMI1.** in the [Uses View's **Rationale**](module_view_uses.md#rationale) - the **question** and **answer** modules should be grouped in the same Bounded Context; and peripheral functionalities should assume a Conformist posture towards this Bounded Context. Therefore, idealy there would be a single team working in this **question+answer** Bounded Context. A further suggesting would be the assignment of a **Project Maintainer** or **Teacher** to this Bounded Context.*

- **DMI3.** 

    *In **DMI3.** in the [Uses View's **Rationale**](module_view_uses.md#rationale) it's mentioned that the **course**, **quiz** and **user** modules are three of the Core Domain's Bounded Contexts which may accumulate responsabilities due to the increase of engagement functionalities (developed by **Students**). For this reason, assigning a **Project Maintainer** or **Teacher** to these modules would be ideal. Especially in the light of the [BG3](system_overview.md#business-goals) business goal, assigning a **Teacher** would help with possible student doubts.*


## Related Views

- Refer to the [Implementation View](allocation_view_implementation.md) to form a better understanding of how the modules represented are organized in the development environment file system.
- Refer to the [Decomposition View](module_view_decomposition.md) for more details on the modules.
- Refer to the [Uses View](module_view_uses.md) for details on the relations between the engagement functionalities' Bounded Contexts and the Core Domain's Bounded Contexts.

