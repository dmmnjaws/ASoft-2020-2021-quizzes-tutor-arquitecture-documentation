[< Back to SAD](SAD.md)

# Quizzes-Tutor - Component and Connector View: Client-Server View

## Prologue: Component and Connector Types

<img src="pictures/C&C Type Definition.png" width="600" >

Fig 1. Representation of all the Component and Connector Types used in this view. This representation uses Lollipop - Wrapper notations for the ports of the components. This means a lollipop-wrapper represents the readyness of the component type for a relation component-*attachment*-connector-*attachment*-component. * There's a queueing system put in place for incoming responses to the server, explained in the Element Catalog.

## Primary Presentation

<img src="pictures/C&C View.png" width="600" >

Fig 2. Client/Server View graphic representation. The connector linking **frontend-client** with **backend-server** is a typical synchronous REST-based Request/Reply connector. The connector linking **backend-server** with **database** is a typical DB-Access connector.

## Element Catalog

### <span style="color:#0080ff">frontend-client</span>
This **component** serves as the client for quizzes-tutor and executes in the user's machine. It has a multiplicity of N (typically between 30 and 50 for each class using the system at the any given time). A frontend-client component is created whenever a user accesses the quizzes-tutor Webpage and destroyed whenever the same Webpage is closed.

### <span style="color:#0080ff">backend-server</span>
This **component** serves as the server for quizzes-tutor and executes the bigger portion of the business logic. It has a multiplicity of 1 as it runs in a single machine with 4 cores. This component's port *a* features a queueing system that allows incoming requests from clients (output from the REST connector's role) to be received concurrently and scheduled, to be processed sequentially. Since the machine this component is running on has 4 cores, a max of 4 requests can be processed in parallel.

### <span style="color:#0080ff">database</span>
This **component** runs a PostgreSQL Relational Database. It has a multiplicity of 1 as it runs in a single machine.

### <span style="color:#0080ff">REST Request/Reply Connector </span>
This **connector** is a typical REST-based request/reply connector, with a multiplicity of N, one per client component. 

### <span style="color:#0080ff">database-access</span>
This **connector** mediates access from the server to the database. It has a multiplicity of 1. The protocol is assured at `jdbc:postgresql://localhost:5432/tutortestdb`.

## Rationale
Quizzes-Tutor follows a standard client-server architecture, therefore it makes sense to document a Component and Connector View such as this one. Tiers are implicit, but are as follows: a Frontend, a Backend and a Repository. The components, execution units, map to the code structure, in particular to the implementation units, in a straightforward fashion, with the Frontend Tier components mapping to the code of the **frontend** modules, the Backend Tier components mapping to the **backend** modules, and the Repository Tier components mapping to the PostgreSQL Relational Database. Refer to the [Decomposition](module_view_decomposition.md) and [Standard Layered](module_view_layered.md) Views to know more about these modules' semantics and layered organization. The [Implementation View](allocation_view_implementation.md) contains a concise description of how quizzes-tutor's development file system is organized, and the Components may also be mapped to the code structure itself in a similar fashion.

The focus of this SAD is **modifiability** but in the light of the business goals, it's necessary to mention **availability**. In a situation of formal student evaluation, such as [AS1](system_overview.md#availability), one of the contexts in which quizzes-tutor is used, **availability** is relevant to discuss, otherwise students may be hindered of being evaluated. In fact, actually, high-reliability is a requirement, since it's expected that quizzes-tutor meets standards for a set period of time (during evaluation) rather than over time (since for now that quizzes-tutor is only used nationally, it's unnoticeable if the system is unavailable at 4:00AM for a period of 2 hours). But as we've seen before, the components of the Backend and Repository Tiers run in a single machine with a multiplicity of 1, which is not at all ideal for **availability** and some form of redundancy of these components (and consequently of plugged connectors) might be required. Depending on the **performance** requirements and considering implementation costs, different kinds of redundancy can be recommended - Hot, Warm or Cold Spare redundancy. Hot redundancy achieves highest **performance** and **availability** but is costly to implement, while Cold redundancy achieves the slowest **performance** and **availability** due to recovery time. However, discarding **performance**, Cold Spare redundancy is recommended, since it's much cheaper to implement and it's ideal for systems with high-reliability requirements.

## Related Views

- Refer to the [Decomposition View](module_view_decomposition.md) for the semantic description of the **frontend** and **backend** modules.
- Refer to the [Standard Layered View](module_view_layered.md) for a better understanding of further module decomposition and organization in layers, characterized primarily by their Domain Distillation nature.
- Refer to the [Implementation View](allocation_view_implementation.md) for a concise description of quizzes-tutor's development file system and correlation to the C&C View.

## References
For a detailed style guide, refer to Chapter 4.3.1 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.
