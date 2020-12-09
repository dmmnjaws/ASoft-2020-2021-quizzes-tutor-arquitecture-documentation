# Quizzes-Tutor - Allocation View: Deployment View

## Primary Presentation

## Element Catalog

## Context Diagram

## Rationale
`Mapping C&C components and connectors to execution hardware.` 

`MOTIVATION: We know that the component backend-server runs in a single 4 core machine with 16GB of RAM, and we know the code implementation that concretizes this server isn't prepared for concurrent replicated execution, so that should be a little spark for this view to take off... This might be important to rationalize about Performance, Availability, Reliability, Security, Modifiability (more funcionalities - more demanding backend-server component - need more potent machines?) and Scalability (how easy is it to add computational power?)!`

## Related Views

[Component and Connector Views: Client-Server View](c&c_view_client_server.md)

## References
For a detailed style guide, refer to Chapter 5.2 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.