# Quizzes-Tutor - Component and Connector: Client-Server View

## Prologue: Component and Connector Types

<img src="pictures/C&C Type Definition.png" width="900" >

Fig 1. Representation of all the Component and Connector Types used in this view. Component Types appear in light-grey with their ports in white. Connectors Types appear in dark-grey with their ports in white. * Queueing System, explained in the Element Catalogue.

## Primary Presentation

<img src="pictures/C&C View.png" width="600" >

Fig 2. Client/Server View graphic representation. Components appear in light-grey which their ports in white. Connectors appear in dark-grey with their ports in white. The connector linking **backend-server** with **database** is a typical DB-Access connector.

## Element Catalog

### <span style="color:#0080ff">frontend-client</span>
This **component** serves as the client for quizzes-tutor and executes in the user's machine. It has a multiplicity of n (typically between 30 and 40 for each class using the system at the any given time).

### <span style="color:#0080ff">backend-server</span>
This **component** serves as the server for quizzes-tutor and executes the bigger portion of the business logic. It has a multiplicity of 1 as it runs in a single machine with 4 cores.

### <span style="color:#0080ff">database</span>
This **component** runs a PostgreSQL Relational Database. It has a multiplicity of 1 as it runs in a single machine.

### <span style="color:#0080ff">queued-request/reply</span>
This **connector** is a typical request/reply connector. However, client requests are forwarded from the **queued-request/reply** connectors' roles to the **backend-server** component's port, which features a queueing system that allows requests to be received concurrently but processed sequentially. It has a multiplicity of N, one per client component.

### <span style="color:#0080ff">database-access</span>
This **connector** mediates access from the server to the database. It has a multiplicity of 1.

## Context Diagram

## Rationale
Quizzes-Tutor follows a standard client-server architecture, therefore it makes sense to document a Component and Connector View such as this one.

## Related Views

## References
For a detailed style guide, refer to Chapter 4.3.1 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.
