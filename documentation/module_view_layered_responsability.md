# Quizzes-Tutor - Module View: Layered View (Large Scale Structure - Responsability Layers)

## Primary Presentation

<img src="pictures/Responsability Layered View.png" width="900" >

Fig 1. Responsability Layered View graphic representation. Layers are represented with different shades of grey. Layers contain modules - these are presented as white boxes. All the arrows in this diagram symbolize *is-allowed-to-use* relations. For this Layered View in particular, a relaxed layered system, which allows a layer to use any lower layer, was adopted, as opposed to a strict layered system, that only allows a layer to use the immediate lower layer. The relation between the **Analysis and Decision Making** and the **Engagement** layer is noteworthy - they are not allowed to use each other. Refer to the Element Catalogue for more.


## Element Catalog

*"..., these layers might have to be completely original"* - Eric Evans, Domain Driven Design

In his book on Domain Driven Design, Eric Evans defends that in some cases, in order to shape a domain design into a set of Responsability Layers that work, these layers might need to be original, therefore, this SAD proposes the following Responsability Layers:

### <span style="color:#0080ff">Policy</span>
This layer's responsability is associated with the policies enforced upon quizzes-tutor to allow the safe materialization of the business goals. These policies are in particular the authentication and authorization policies and constrain the behaviour of the lower layers.

This layer has the following modules:
- permission

### <span style="color:#0080ff">Analysis and Decision Making</span>
This layer's responsability is in part associated with the collection of data for individual end-user analysis and possible decision making. 

This layer has the following modules:
- statistics

Even though **statistics** is implements in it's core, an engagement functionality, introducing an element of gamification to quizzes-tutor, it's ultimately a collection of data for analysis on the part of the end-user and therefore is in a separate layer, horizontal to the **Engagement** layer. These two layers are not allowed to use each other, since the engagement functionalities should follow the Separate Ways DDD principle, allowing them to evolve idependently (refer to **DMI3** in the [Uses View](module_view_uses.md)).

### <span style="color:#0080ff">Engagement</span>
This layer's responsability is associated with what we've been calling engagement functionalities, or in other words, the "activities" quizzes-tutor offers to promote the student engagement.

This layer has the following modules:
- tournament
- discussion

### <span style="color:#0080ff">Operation</span>
This layer's responsability is associated with the basic operations allowed on the assets of quizzes-tutor. In short, what kinds of "operations" quizzes-tutor offers. In particular, questions can be submitted, grouped into quizzes, and answered. 

This layer has the following modules:
- answer
- questionsubmission
- quiz

### <span style="color:#0080ff">Assets</span>
This layer's responsability is associated with the resources (assets) that characterize the business model of quizzes-tutor, in particular questions and users.

This layer has the following modules:
- question
- user

### <span style="color:#0080ff">Commodities</span>
This layer's responsability is associated with commodities useful for quizzes-tutor but not motivational, in particular authentication. 

This layer has the following modules:
- auth

Other modules present in the [Decomposition View](module_view_decomposition.md) such as the **mailer** or **impexp** may also be seen as commodities, but they do not contain business logic so we're not including them in the responsability layers, as they don't have a responsability towards the business and are not a part of the domain model.

## Context Diagram

## Rationale

## Related Views

- Refer to the [Standard Layered View](module_view_layered.md) for a layered view focused on technical aspects and dependencies, highlighting Domain Distillation.

### References

For a detailed style guide, refer to Chapter 2.4 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

For detailed information on the Domain Driven Design strategies mentioned, refer to Part IV of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley.

For information on Responsability Layers, a pattern of the third Domain Driven Design paradigm of Large Scale Structure, refer to Chapter 16 of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley. 