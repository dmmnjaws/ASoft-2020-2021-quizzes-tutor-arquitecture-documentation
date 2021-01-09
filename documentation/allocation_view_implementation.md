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

We can see from the primary presentation that while the backend project has a very straight forward (typically 1 to 1) representation of the modules in the implementation, the frontend spreads the modules more, using a different organization.
This is due to the backend organizing the first level folders based on the modules, and only deeper in the tree the architectural and then technical categories are used. While the frontend does the opposite, starting by the architectural and technical categories, and only at the deeper level separating the modules.
One could propose a different general approach. But even in the current one, if in the frontend we organize the module level folders according to the decomposition view, a much-cleared appreciation of the overall system could be achieved.



## Related Views

- Refer to the [Decomposition View](module_view_decomposition.md) for more details on the modules.
- Refer to the [Uses View](module_view_uses.md) for the follow-up on which modules *use* each module.
- Refer to the [Layered View](module_view_layered.md) for the follow-up layered distribution of the modules, taking in consideration DDD Distillation principles.

