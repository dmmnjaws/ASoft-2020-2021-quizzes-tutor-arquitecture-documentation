[< Back to SAD](SAD.md)

# Quizzes-Tutor - Refactoring: Question Submission

## Problem

In the actual implementation of quizzes-tutor, the **Course** and **Question** entities are conceptually part of the same DDD Aggregate, where Course functions as the root entity. This essentially means that referencing a question outside the context of a course makes no sense in the current implementation of quizzes-tutor. Due to this, a question submission is also only applicable in the context of a course. Not only does this cause a cyclic dependency between the **question** and **course** modules, highlighted in the [Uses View](module_view_uses_view.md), but it's also not ideal in the light of the [BG1](system_overview.md#business-goals) business goal, from which the [UC1](system_overview.md#functionalities) funcionality results, since for instance, if a professor teaches two courses and wants to use the same questions in both courses, these question must be duplicated in the context of each course. The **modifiability** scenario [MS5](system_overview.md#modifiability), which is in particular a **reusability** scenario, highlights this problem.

## Refactoring Proposal

To address this problem, and looking from the perspective of the [Data Model](module_view_data_model.md), this SAD proposes the following refactoring:

1. A question is no longer attached to a course, and therefore becomes independent from it. This implies that the **Question** entity looses the *many-to-one* relation with **Course**, becoming a *many-to-none* relation. This relation will be better understood in point **5.**.

2. Instead, a question is now a part of a repository of questions. This repository is identified by an unique Integer id and has a name that distinguishes the repository's fields of study and allow similarly named topics in different repositories without risks such as a Software Engineering course including questions about "security policies" related with Law Enforcement. This implies the creation of a **QuestionRepository** entity with a *one-to-many* relation with the **Question** entity. *Note: for now, it's logic to consider a question can be submitted to a single repository.*

3. A repository of questions has an administrator. This implies the **QuestionRepository** entity has a *many-to-one* relation with the **User** entity. *Note: for now, for simplicity, consider a repository has a single administrator.*

4. A question submission is no longer done in the context of a course (in particular, a course's execution), but instead, in the context of a question repository. Therefore, a question submission can now be done by both teachers and students, as opposed to just by students, and the repository's administrator is now responsible for the question's approval or vetting. This implies the *many-to-one* relation between the **QuestionSubmission** entity and **CourseExecution** entity is severed and **QuestionSubmission** gains a new *many-to-one* relation with the **QuestionRepository** entity.

5. Questions may be fetched for a course from the question repositories, but there's no relation between courses and repositories. Repositories are freely accessed by courses, and courses only keep the questions, and don't keep information on the repositories these came from. This reduces coupling between courses and repositories. When adding a question to a course, the available repository are publicly available and exposed in the UI, and the questions or topics are handpicked by the user (teacher) from there. Therefore, the **Course** entity preserves the previously established *none-to-many* relation with the **Question** entity and has no relation with **QuestionRepository**. 

## Possible Implementation Details and Variants

The refactoring proposed above has many ways of being implemented, in particular, this section highlights alternative considerations that may be taken according to the priorities:

1. A **Question**, instead of a *many-to-one* relation with **QuestionRepository**, may have a *many-to-none* relation, which reduces coupling. This implies that upon creation, the question's id is generated considering an hash with the name of the repository, for instance. The reason being that when a question is fetched for a course, the course looses the information about the repository, and yet, different ids should be preserved between questions fetched from different repositories.

## Post-Refactoring Data Model

<img src="pictures/Refactoring Proposal.png" width="900" >

Fig 1. Refactoring proposal, reflected in the [Data Model](module_view_data_model.md) graphic representation. Caption:

<img src="pictures/Refactoring Proposal Caption.png" width="900" >

## Future Considerations

The refactoring process is iterative and cyclic, so this section suggests some further refactoring beyond the original proposed:

1. Since the original refactoring eliminated the cyclic dependency between **question** and **course**, by eliminating the *uses* relation from **question** to **course**, **course** as a module has one of it's main responsabilities severily weakened, since the questions it now aggregates don't "know of it's existence". Since these responsabilities were in fact, within the **course** module, carried by the **Course** entity, this renders the concept of a course useless and therefore an interesting consideration would be to refactor the **Course** entity out of the Data Model, allowing the responsability of being an aggregate of course executions to dissappear, and transferring the responsability of aggregating questions to the **CourseExecution** entities.

2. For future scalability of the domain logic, in the possible situation a large volume of **QuestionRepository** entities accumulates, it might be interesting to formalize a taxonomy of question repositories. An example would be to relate **QuestionRepository** entities in a graph style, based in it's fields of study, or other attributes that may be introduced in future refactorings.

3. This is an unlikely scenario, but even though it's attractive to keep the **Course** entity decoupled from the **QuestionRepository** entity, if the system evolves in the future such that the multiplicity of **Course** entities becomes much higher then the multiplicity of **QuestionRepositories**, it might be interesting to set up a publish-subscribe network of question repositories, as publishers (where questions are actually submitted to and revised before being published) and courses, as subscribers.

