[< Back to SAD](SAD.md)

# Quizzes-Tutor - Allocation View: Implementation View

## Primary Presentation


### Main Source Code Distribution

| [Modules](module_view_decomposition.md)            | [**Backend**](pictures/backend_complete_folder_structure.png)            | [**Frontend**](pictures/backend_complete_folder_structure.png)                         |
| ------------------ | ------------------ | -------------------------------- |
| answer             | answer             | models/management/questions <br /> models/management <br /> views/teacher/assessments components/multiple-choice       |
| auth               | auth               | models/user  <br /> components/auth                  |
| course             | course             | models/user <br /> views/admin/Courses              |
| discussion         | discussion         | models/management <br /> views/student/discussions <br /> views/teacher/discussions        |
| question           | question           | models/management <br /> models/management/questions <br /> views/teacher/questions <br /> components/multiple-choice       |
| questionsubmission | questionsubmission | models/management <br />| views/questionsubmission         |
| quiz               | quiz               | models/management <br /> views/student/quiz <br /> views/teacher/quizzes            |
| statistics         | statistics         | models/statement/StudentStats.ts |
| tournament         | tournament         | models/user <br /> views/student/tournament <br /> views/teacher/tournaments        |
| user               | user               | models/user <br /> views/user <br /> views/student <br /> views/teacher <br /> views/teacher/students           |
| statement          | statement          | models/statement                 |
| {config}           | {config}           | project and source root folders  |
| config/permission  | config/permission  | project and source root folders  |
| {exceptions}       | {exceptions}       |                                  |
| {impexp}           | {impexp}           | views/teacher/impexp             |
| {mailer}           | {mailer}           |                                  |
| {utils}            | {utils}            | components/ <br /> views/ <br /> services/ <br /> {assets}                         |

Table 1. Main source code distribution, mapping the modules highlighted in the [Decomposition View](module_view_decomposition.md) to the development file system elements of quizzes-tutor.

### Test Code Availability/Distribution

| [Modules](module_view_decomposition.md)            | [**Backend**](pictures/backend_complete_folder_structure.png) : <br />src/test/groovy/<br />jmeter/            | [**Frontend**](pictures/backend_complete_folder_structure.png) : <br /> tests/unit/                         |
| ------------------ | ------------------ | -------------------------------- |
| answer             | src/test/groovy/answer<br />jmeter/answer             | -                  |
| auth               | src/test/groovy/auth               | -                  |
| course             | src/test/groovy/course<br />jmeter/administration             | -                  |
| discussion         | src/test/groovy/discussion         | -                  |
| question           | src/test/groovy/question<br />jmeter/question           | tests/unit/views/teacher/questions       |
| questionsubmission | src/test/groovy/questionsubmission | -                  |
| quiz               | src/test/groovy/quiz               | -                  |
| statistics         | -                  | -                  |
| tournament         | src/test/groovy/tournament         | -                  |
| user               | src/test/groovy/user               | -                  |
| statement          | src/test/groovy/statement          | -                  |
| {config}           | -                  | -                  |
| config/permission  | -                  | -                  |
| {exceptions}       | -                  | -                  |
| {impexp}           | -                  | -                  |
| {mailer}           | -                  | -                  |
| {utils}            | -                  | -                  |

Table 2. Test code distribution, mapping the modules highlighted in the [Decomposition View](module_view_decomposition.md) to quizzes-tutor's test files.

## Element Catalog


### <span style="color:#0080ff">Modules</span>
This column lists the modules identified in the module [Decomposition View](module_view_decomposition.md).


### <span style="color:#0080ff">Backend</span>
This column describes the packages from the backend project which are responsible for the module in question.  


### <span style="color:#0080ff">Frontend</span>
This column describes the files, folders or packages from the frontend project which are responsible for the module in question. These elements contain something related with the module in a fundamental level or may need changes when the module changes.

We can simplify the folder structure to this hierarchy:
- frontend
    - src
        - assets
        - components
        - models
        - services
        - views

In the table we mention locations in a file system path notation, being “src” the root folder.
The Frontend corresponds to the Web (VIEW) layer in the [Layered View](module_view_layered.md).


### <span style="color:#0080ff">Frontend - models</span>
The model’s folder contains TypeScript files (“.ts”) for the business model representations.


### <span style="color:#0080ff">Frontend - components</span>
The components folder contains small Vue template components, with the file type “.vue”. These will typically be imported by the page templates in the views folder. 


### <span style="color:#0080ff">Frontend - views</span>
The views folder contains Vue templates, with the file type “.vue”. These can be page templates or smaller components.


### <span style="color:#0080ff">Frontend - services</span>
The models folder contains TypeScript files (“.ts”). These files have service logic and utility classes for the interaction with the backend. Including the backend API requests themselves.


### <span style="color:#0080ff">Frontend - assets</span>
The assets folder contains style sheets and binary resources, such as images.


### <span style="color:#0080ff">Frontend - project and source root folders</span>
The project folder corresponds to the frontend project root. And the source folder corresponds to the “src” folder inside it.


## Rationale

It can be seen from the primary presentation that while the backend project has a very straight forward (typically 1 to 1) representation of the modules in the implementation, the frontend spreads the modules more, using a different organization.*
    
The backend organizes the first level folders based on the modules, and only deeper in the tree the architectural and then technical categories are used. While the frontend does the opposite, starting by the architectural and technical categories, and only at the deeper level separating the modules.*

One could propose a different general approach. But even in the current one, if in the frontend we organize the module level folders according to the decomposition view, a cleared appreciation of the overall system could be achieved.*

Rationale on **Domain Model Integrity** comments, improvements and considerations:

- **DMI1.** 

    *The use of small Bounded Contexts (refer to the **DMI** section in the [Uses View](module_view_uses.md#r**ationale)), contributes to the desired **modifiability** trait, especially with scenarios such as [MS2](system_overview.md#modifibility), [MS3](system_overview.md#modifibility) and [MS4](system_overview.md#modifibility).*


    *The backend side takes considerable benefits from this due to what was commented in the Rationale's intro. In the frontend we notice 3 new terms that overlap more than 1 Bounded Contexts:*
    * teacher
    * student
    * management

## Related Views

- Refer to the [Decomposition View](module_view_decomposition.md) for more details on the modules.
- Refer to the [Uses View](module_view_uses.md) for the follow-up on which modules *use* each module and the bounding contexts.
- Refer to the [Layered View](module_view_layered.md) for the follow-up layered distribution of the modules, taking in consideration DDD Distillation principles.
- Refer to the [Layered View II (Large Scale Structure - Responsability Layers)](module_view_layered_responsability.md) for a layered view on the optics of Domain Large Scale Structure Responsability Layers.

## References

For a brief description of the Implementation style, refer to Chapter 5.5 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.


