# Quizzes-Tutor - Module View: Aspects View

## Primary Presentation

<img src="pictures/Aspects View.png" width="1200" >

Fig 1. Aspects View graphic representation. In the aspects box are the main aspects of the software, this are identified by class alike boxes that may use entitys, handlers or controllers. This boxes identify were they crosscut with other modules.

## Element Catalog

### <span style="color:#0080ff">«aspect» TransactionManagement</span>

Crosscuts all public methods of all classes that contain the suffix Service and any methods with the @Transactional annotation.
The @Transactional annotation is present in the classes with the suffix Service or Repository. 

### <span style="color:#0080ff">«aspect» ExceptionHandling</span>

Uses CustomExceptionHandler.
Crosscuts any public methods with the suffix Service and Controller, and the run() method of all threads.

### <span style="color:#0080ff">CustomExceptionHandler</span>

Contains functions:

* tutorException()
* accessDeniedException()
* lockAcquisitionException()
* clientAbortException()
* randomException()

### <span style="color:#0080ff">«aspect» AuthorizationCheck</span>

Uses AuthController.
Crosscuts any methods with the @PreAuthorize annotation where it checks for Roles and Permissions.

### <span style="color:#0080ff">AuthController</span>

Contains functions:

* fenixAuth()
* externalUserAuth()

Uses to entitys:

* AuthExternalUser
* AuthTecnicoUser

Also has a demo entity but was not considered relevant to the scope of the program execution.

### <span style="color:#0080ff">«entity» AuthExternalUser</span>

Entity used by AuthController to refer to external users, also known as non-Fenix users.

### <span style="color:#0080ff">«entity» AuthTecnico</span>

Entity used by AuthController to refer to Tecnico's Fenix users.

### <span style="color:#0080ff">«aspect» Enforcement</span>

Crosscuts any methods with @Service, @Controller, @Repository and @RestController annotations.

## Context Diagram  

## Rationale

Quizzes-Tutor backend was developed in Java in the Spring framework, this enables many things including the use of annotations. This annotations refer to layers of the software, being Repository the lowest layer which comunicates with the database and the RestController the top layer and the exposed layer.
With this design the backend acts like a Service which is available to communicate with the frontend via restfull requests, then these requests go down the layers, inside Controllers and then Services to filter business logic and end in the Repository when needed.
This framework and it's application in this software allows crosscuting modules more easily.

## Related Views

- Refer to the [Layered View](module_view_layered.md) for the follow-up layered distribution of the modules, taking in consideration DDD Distillation principles.

## References
For a detailed style guide, refer to Chapter 2.5 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.