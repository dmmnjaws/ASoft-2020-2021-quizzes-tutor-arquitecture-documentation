[< Back to SAD](SAD.md)

# Quizzes-Tutor - Module View: Layered View

## Primary Presentation

<img src="pictures/Layered View.png" width="1200" >


Fig 1. Layered View graphic representation (magnifier recommended). Layers are represented with different shades of grey. Layers contain modules - these are presented as white boxes and they are perceptible as *parts-of* the same parent module if they are contained within the same opaque box (Take note that the submodules of the backend modules (**.domain**, .**repository**, **.dto** and **.api**) are not represented in the [Decomposition View](module_view_decomposition.md), but here, since they are relevant in the layered context. Please refer to the [Allocation Implementation View](allocation_view_implementation.md) for a perspective on their locations in the file system). All the arrows in this diagram symbolize *is-allowed-to-use* relations. Noteworthy relations or exceptions to the guidelines of a typical Layered Arquitecture are prescribed below, in the Element Catalog.

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

The modules that make this layer have a peculiar separation, in three main Segments: the **code subdomains api (engagement functionalities)**, the **core domain api** and the **generic subdomains api** segments. It's very important to be mindful that the **core subdomains api (engagement functionalities)** segment *is-allowed-to-use* the **core domain api** and **generic subdomains api** segments, but not the other way around.

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

Similarly to how the modules in the **api (CONTROLLER)** layer are separated, the modules that make this layer have a peculiar separation as well, in three main Segments: the **core subdomains (engagement functionalities)**, the **core domain** and the **generic subdomains** segments. Just like the relation of the homologue segments in the **api (CONTROLLER)** layer, the **core subdomains (engagement functionalities)** segment *is-allowed-to-use* the **core domain** and the **generic subdomains** segments, but not the other way around.

### <span style="color:#0080ff">TECHNOLOGY</span>
*Is-allowed-to-use*:
- **VIRTUAL MACHINE** layer.

This layer features the Springboot and NodeJS frameworks, purely for completion purposes, but the technology used isn't the focus of this SAD.

### <span style="color:#0080ff">VIRTUAL MACHINE</span>
This layer features the JVM (Java Virtual Machine), purely for completion purposes, but as mentioned before, the technology used isn't the focus of this SAD.

## Rationale
Considering quizzes-tutor was meant, from the beginning to be a web application, a layered architecture ended up being a constraint on the design of the system. This favored **modifiability** and **portability** even outside the scenarios highlighted in the [System Overview](system_overview.md). This view highlights both Domain Distillation and the use of the Model-View-Controller tactic, and helps to easily trace dependencies. However, a different kind of layered view is more suitable for rationalizing about the domain modeling decisions and responsabilities - [Layered View II (Large Scale Structure - Responsability Layers)](module_view_layered_responsability.md).

## Related Views

- Refer to the [Decomposition View](module_view_decomposition.md) for a brief uncollapsed description of each module.
- Refer to the [Allocation Implementation View](allocation_view_implementation.md) to form a better understanding of how the modules represented in this layered view are organized in the development environment file system.
- Refer to the [Layered View II (Large Scale Structure - Responsability Layers)](module_view_layered_responsability.md) for a layered view on the optics of Domain Large Scale Structure Responsability Layers.

## References
For a detailed style guide, refer to Chapter 2.4 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

For detailed information on the Domain Driven Design strategies mentioned, refer to Part IV of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley.
