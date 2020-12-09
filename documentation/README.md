# ASoF course project. Group 6

## Objectives 
- Propose a decomposition of the Quizzes Tutor domain model using the domain-driven design strategic patterns. Write the scenarios and document the architecture of the Quizzes Tutor.
The work should be driven by the following business goals for the Quizzes Tutor:
1. The Quizzes Tutor supports a course that follows the flipped classroom model facilitating the reuse of questions across the different executions of the course.
2. The Quizzes Tutor promotes the students learning process and self-assessment of their knowledge.
3. The Quizzes Tutor is used as a pedagogical tool, such that groups of students can easily use the system in their projects to learn how to develop a web application.

Business goals general scenarios: [link](business_goals_general_scenarios.md)

## Group members:
| Name | student number | main responsabilities |
|----------|:-------------:|:------------:| 
| António Teixeira | 97430 | C |
| Duarte Miguel | 87527 | A |
| João Vieira | 98624 | |
| João Marques | 90865 | |
| Miguel Azinheira | 98725 | |

---
## Main responsabilities list:
---
### A
2 person: read the code, infer structure from code, where are the dependencies ? (try finding a tool for reverse engineering)
#### FOR NOW:
- Produce a module-view document `(Possibly uses-style since we have access to DSM and Dependency Flow Graph (both available in documentations/pictures), for more Module-Styles - page 65 of DSA - six important module styles)`:
1. Make an easily understood and organized module diagram
2. Write an element catalogue (what each module is and it's properties)
3. Specify each elements interfaces (what each module's interface (if there's one) offers)
4. Follow the template and examples provided below for more

#### FOR LATER:
- Produce a component-and-connector-view document: `(ATTENTION: module vs. component - page 31 of DSA - client/server example explanation)`
1. Make an easily understood and organized component/connector diagram (extracted from the ER Diagram)
2. Write an element catalogue (what each component/connector is and it's properties)
3. (IDEA) Specify module-component mappings (ex: 1 user module translates into +1000 user components at runtime; 1 course module translates into dozens of course components at runtime, etc)
4. Follow the template and examples provided below for more

### CONCLUSIONS:

1. When writing a uses-view document we should be careful with circular dependencies. The first step is to identify them thru the DSM, code and Graphs, then we should propose a way to elinminate these circular dependencies based in principles of DDD, written as a *"in the future..."* in the element catalogue for those modules. An example would be the *answer* and *quiz* modules, that have really strong circular dependencies. Identified the dependencies, we should write something like this in the element catalogue for *answer/quiz* - *"In the future, the answer module will be merged with the quiz module in a single module, because there's no sense in keeping them apart."* OR *"In the future, the answer module and the quiz module should be part of the same Shared Kernel."* (The professor likes the first better.)

2. The statistics module is a module that uses a lot of other modules to colect statistics from everywhere (an example is the user class). 

---
### B
1 person: look at the business statement (more info?)

---
### C
1 person: Infer which are the important qualities by looking at the business goals
c1. Identify the funcionalities and quality attributes from business goals
c2. Write the core scenarios for each quality attributes identified
c3. Write general scenarios for the Business Goals 
c4. Write the ASR Utility Tree in tabular form
c5. Going back to quality attributes which tactics should we use to fulfill them and where?
c6. Evaluate how to fit all this information into a SAD as shown here:  https://wiki.sei.cmu.edu/confluence/display/SAD/System+Overview

---
### D
1 person: Use some tools to get metrics - coupling, cohesion and complexity

---
## Useful links:

https://fenix.tecnico.ulisboa.pt/disciplinas/ASof7/2020-2021/1-semestre/project

https://www.inesc-id.pt/projects/II03017/

https://bettercodehub.com/ (TOOL: check code-base quality, RESULT: https://bettercodehub.com/results/dmmnjaws/AS-2020-2021-quizzes-tuto)

https://github.com/cqfn/jpeek (TOOL: more code-base quality metrics)

https://structure101.com/ (TOOL: analyse modular dependencies)

https://omerad.msu.edu/teaching/teaching-strategies/27-teaching/162-what-why-and-how-to-implement-a-flipped-classroom-model

## Software Architecture Document Template and Example:
### Template: 
https://wiki.sei.cmu.edu/confluence/display/SAD/Software+Architecture+Documentation+Template

### Examples:
https://wiki.sei.cmu.edu/confluence/pages/viewpage.action?pageId=146280205
https://wiki.sei.cmu.edu/confluence/display/SAD/The+Java+Pet+Store+SAD



