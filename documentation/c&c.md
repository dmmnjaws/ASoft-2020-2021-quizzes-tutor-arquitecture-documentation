# Quizzes-Tutor - Component and Connectors: Client-Server View

## Primary Presentation

`do a simple picture of the frontend(client) and the backend(server) and a database`

`either consider doing interface delegation in the backend or do a separate view of the c&c view of the backend - NOT NEEDED!`

`either way, might be worth to inquire the professor about the querying system between the frontend and the backend.`

`we're writting in a relational database.`

## Element Catalog

- `1 server (the teach mentioned there was no replication in quizzes-tutor`

- `n clients`

- `1 database`

- `1 request/reply connector with remote calls between server client`

- `1 connector between server and database`

## Context Diagram

## Rationale

## Related Views

## References
For a detailed style guide, refer to Chapter 4.3.1 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

## Notes

a first decomposition:
components: backend(1); frontend(*); database(1)

decomposing the backend:
components: 

a request arrives at the backend; 

quizzes-tutor is executing in a machine with 4 threads.