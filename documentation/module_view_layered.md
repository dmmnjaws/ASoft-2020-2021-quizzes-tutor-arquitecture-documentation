# Quizzes-Tutor - Module View: Layered View

## Primary Presentation

<img src="pictures/Layered View.png" width="1200" >


Fig 1. Layered View graphic representation. Layers are represented with different shades of grey. Layers contain modules - these are presented as white boxes and they are perceptible as *parts-of* the same parent module if they are contained within the same opaque box (Keep in mind that the submodules of the backend modules (**.domain**, .**repository**, **.dto** and **.api**) are not represented in the [Decomposition View](module_view_decomposition.md), but here, since they are relevant in the layered context. Please refer to the [Allocation Implementation View](allocation_view_implementation.md) for a perspective on their locations in the file system). All the arrows in this diagram symbolize *is-allowed-to-use* relations. Noteworthy relations or exceptions to the guidelines of a typical Layered Arquitecture are prescribed below, in the Element Catalogue.

## Element Catalog

### <span style="color:#0080ff">web (VIEW)</span>
*Is-allowed-to-use*:
- **api (CONTROLLER)** layer.
- **NodeJS** module in the **TECHNOLOGY** layer.
### <span style="color:#0080ff">api (CONTROLLER)</span>
*Is-allowed-to-use*:
- **domain and dtos (MODEL)** layer.
- **Springboot** module in the **TECHNOLOGY** layer.
- **VIRTUAL MACHINE** layer.

This layer isn't allowed to use the **repository** layer, which is directly below. The correct representation for this would be for the two layers to be side by side as both *are-allowed-to-use* the **domain and dtos (MODEL)** layer, but they are represented as is, for the sake of not cluttering the diagram.

### <span style="color:#0080ff">repository</span>
*Is-allowed-to-use*:
- **domain and dtos (MODEL)** layer.
- **Springboot** module in the **TECHNOLOGY** layer.
- **VIRTUAL MACHINE** layer.

### <span style="color:#0080ff">domain and dtos (MODEL)</span>
*Is-allowed-to-use*:
- **Springboot** module in the **TECHNOLOGY** layer.
- **VIRTUAL MACHINE** layer.

The modules that make this layer have a peculiar separation in two main Segments: the **core subdomain (engagement functionalities)** and **core domain and generic subdomains**, which can be further divided in three segments that are not represented in the Primary Representation: the **dtos** the **core domain** and the **generic subdomains**. It's very important to keep in mind that the **core subdomain (engagement functionalities)** segment *is-allowed-to-use* the **core domain and generic subdomains** segment, but not the other way around.

### <span style="color:#0080ff">TECHNOLOGY</span>
*Is-allowed-to-use*:
- **VIRTUAL MACHINE** layer.

This layer features the Springboot and NodeJS frameworks, purely for completion purposes, but this SAD's focus isn't the technology used.

### <span style="color:#0080ff">VIRTUAL MACHINE</span>
This layer features the JVM (Java Virtual Machine), purely for completion purposes, but as mentioned before, this SAD's focus isn't the technology used.

## Context Diagram

## Rationale
Considering quizzes-tutor was meant, from the beginning to be a web application, a layered architecture ended up being a constraint on the design of the system. This favored modifiability and portability even outside the scenarious highlighted in the [System Overview](system_overview.md).

## Related Views

## References
For a detailed style guide, refer to Chapter 2.4 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.
