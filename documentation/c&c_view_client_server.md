# Quizzes-Tutor - Component and Connector View: Client-Server View

## Prologue: Component and Connector Types

<img src="pictures/C&C Type Definition.png" width="900" >

Fig 1. Representation of all the Component and Connector Types used in this view. Component Types appear in light-grey with their ports in white. Connectors Types appear in dark-grey with their ports in white. * Queueing System, explained in the Element Catalogue.

## Primary Presentation

<img src="pictures/C&C View.png" width="600" >

Fig 2. Client/Server View graphic representation. Components appear in light-grey with their ports in white. Connectors appear in dark-grey with their ports in white. The connector linking **backend-server** with **database** is a typical DB-Access connector.

## Element Catalog

### <span style="color:#0080ff">frontend-client</span>
This **component** serves as the client for quizzes-tutor and executes in the user's machine. It has a multiplicity of n (typically between 30 and 40 for each class using the system at the any given time). A frontend-client component is created whenever a user accesses the quizzes-tutor Webpage and destroyed whenever the same Webpage is closed.

### <span style="color:#0080ff">backend-server</span>
This **component** serves as the server for quizzes-tutor and executes the bigger portion of the business logic. It has a multiplicity of 1 as it runs in a single machine with 4 cores. (Refer to the [Alocation View: Deployment View](allocation_view_deployment.md) for a detailed resource mapping). This component's port *a* features a queueing system that allows incoming requests from the **queued-request/reply** connector's role *b* to be received concurrently and scheduled, to be processed sequentially. `(Ask the professor if the fact the machine has 4 cores allows 4 threads to be processing 4 queued requests at once)`

### <span style="color:#0080ff">database</span>
This **component** runs a PostgreSQL Relational Database. It has a multiplicity of 1 as it runs in a single machine.

### <span style="color:#0080ff">queued-request/reply</span>
This **connector** is a typical request/reply connector, with a multiplicity of N, one per client component. However, client requests are forwarded from the **queued-request/reply** connectors' role *b* to the **backend-server** component's port *a*, which features a queueing system that allows requests to be received concurrently and scheduled, to be processed sequentially. `(Ask the professor if the fact the machine has 4 cores allows 4 threads to be processing 4 queued requests at once)` 

### <span style="color:#0080ff">database-access</span>
This **connector** mediates access from the server to the database. It has a multiplicity of 1.

## Context Diagram

## Rationale
Quizzes-Tutor follows a standard client-server architecture, therefore it makes sense to document a Component and Connector View such as this one.
`Explore Tiers: frontend, backend, repository. The queued-request/reply connector may only be used between components in the frontend tier and components in the backend tier; and a DB Access connector may only be used between components in the backend and the repository tier. (read page 183 and 184 of DSA)`

## Related Views
`Mention the allocation views`

## References
For a detailed style guide, refer to Chapter 4.3.1 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.
