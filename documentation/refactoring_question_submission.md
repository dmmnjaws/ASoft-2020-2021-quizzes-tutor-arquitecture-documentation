# Quizzes-Tutor - Refactoring: Question Submission

## Problem

In the actual implementation of quizzes-tutor, the **Course** and **Question** entities are a part of the same DDD Aggregate, where Course is the root entity. This essentially means that referencing a question outside the context of a course makes no sense in the current implementation of quizzes-tutor. Due to this, a question submission is also only applicable in the context of a course. This is not ideal in the light of the [BG1](system_overview.md#business-goals) business goal, from which the [UC1](system_overview.md#functionalities) funcionality results, since for instance, if a professor teaches two courses and wants to use the same questions in both courses, these question must be duplicated in the context of each course. The **modifiability** scenario [MS5](system_overview.md#modifiability), which is in particular a **reusability** scenario, highlights this problem.

## Refactoring Proposal

To address this problem, and looking from the perspective of the [Data Model](module_view_data_model.md), this SAD proposes the following refactoring:

1. A question is no longer attached to a course, and therefore becomes independent from it. This implies that the **Question** entity looses the *many-to-one* relation with **Course**, becoming a *many-to-none* relation.

2. Instead, a question is now a part of a repository of questions. This repository is identified by an unique Integer id and has a name that distinguishes the repository's fields of study and allow similarly named topics in different repositories without risks such as a Software Engineering course including questions about "security policies" related with Law Enforcement. This implies the creation of a **QuestionRepository** entity with a *one-to-many* relation with the **Question** entity. *Note: for now, it's logic to consider a question can be submitted to a single repository.*

3. A repository of questions has an administrator. This implies the **QuestionRepository** entity has a *many-to-one* relation with the **User** entity. *Note: for now, for simplicity, consider a repository has a single administrator.*

4. A question submission is no longer done in the context of a course (in particular, a course's execution), but instead, in the context of a question repository. Therefore, the repository administrator is now responsible for the question's approval or vetting. This implies the *many-to-one* relation between the **QuestionSubmission** entity and **CourseExecution** entity is severed and **QuestionSubmission** gains a new *many-to-one* relation with the **QuestionRepository** entity.

5. There's no relation between courses and repositories. Repositories are freely accessed by courses, and courses only keep the questions, and don't keep the repositories. Therefore, the **Course** entity preserves it's *none-to-many* relation with the **Question** entity and has no relation with **QuestionRepository**.

## Possible Implementation Details and Variants

1. A **Question**, instead of a *many-to-one* relation with **QuestionRepository**, may have a *many-to-none* relation, which reduces coupling. This implies that upon creation, the question's id is generated considering an hash with the name of the repository, for instance. The reason being that when a question is fetched for a course, the course looses the information about the repository, and yet, different ids should be preserved between questions fetched from different repositories.

2. When adding a question to a course, the available repository may be fetched directly from the database to the UI, and the questions or topics are handpicked by the user from there. `(perguntar opinião ao professor)`

## Post-Refactoring Data Model

`TO-DO: Altered Data Model Primary Presentation, with changes in RED.`

`Isto parece que resolve uma dependencia circular entre course e question, mas nos nao consideramos como dependencia course-uses-question, porque um course pode existir sem nenhuma pergunta lá dentro. No entanto, um course sem nenhuma pergunta não serve para nada. perguntar ao professor rito se uma dependencia de course-uses-question é aceitável.`


