# Quizzes-Tutor - Module View: Layered View (Large Scale Structure - Responsability Layers)

## Primary Presentation

<img src="pictures/Responsability Layered View.png" width="900" >

Fig 1. Responsability Layered View graphic representation. Layers are represented with different shades of grey. Layers contain modules - these are presented as white boxes. All the arrows in this diagram symbolize *is-allowed-to-use* relations. For this Layered View in particular, a relaxed layered system, which allows a layer to use any lower layer, was adopted, as opposed to a strict layered system, that only allows a layer to use the immediate lower layer. The relation between the **Analysis and Decision Making** and the **Engagement** layer is noteworthy - they are not allowed to use each other. Refer to the Element Catalog for more.


## Element Catalog

*"..., these layers might have to be completely original"* - Eric Evans, Domain Driven Design

In his book on Domain Driven Design, Eric Evans defends that in some cases, in order to shape a domain design into a set of Responsability Layers that work, these layers might need to be original, therefore, this SAD proposes the following Responsability Layers:

### <span style="color:#0080ff">Policy</span>
This layer's responsability is associated with the policies enforced upon quizzes-tutor to allow the safe materialization of the business goals. The only unique policy inforced on quizzes-tutor besides generic authentication is authorization. Ultimately, this constrains the behaviour of the lower layers, but doesn't block the continuous evolution of the domain model.

This layer has the following modules:
- permission

### <span style="color:#0080ff">Analysis and Decision Making</span>
This layer's responsability is in part associated with the collection of data for individual end-user analysis and possible decision making. 

This layer has the following modules:
- statistics

*Even though **statistics** is in it's core an engagement functionality, introducing an element of gamification to quizzes-tutor, it's ultimately a collection of data for analysis on the part of the end-user and therefore is in a separate layer, horizontal to the **Engagement** layer. These two layers are not allowed to use each other, since the engagement functionalities should follow the Separate Ways DDD principle, allowing them to evolve idependently (refer to **DMI3** in the [Uses View's **Rationale**](module_view_uses.md#rationale)).*

### <span style="color:#0080ff">Engagement</span>
This layer's responsability is associated with what we've been calling engagement functionalities, or in other words, the "activities" quizzes-tutor offers to promote the student engagement.

This layer has the following modules:
- tournament
- discussion

*For the same reason the **Analysis and Decision** and **Engagement** layers are not allowed to use each other, the modules within this layer are also not allowed to use each other.*

*This layer is especially relevant to allow the quizzes-tutor's functionalities to be flexible on demand. Please refer to the **Rationale's section DLSS1.** below for reasoning on possible considerations/solutions in the optics of Domain Driven Design.*

### <span style="color:#0080ff">Operation</span>
This layer's responsability is associated with the basic operations allowed on the assets of quizzes-tutor. In short, what kinds of "operations" quizzes-tutor offers. In particular, questions can be submitted, grouped into quizzes, and answered. 

This layer has the following modules:
- answer
- course
- questionsubmission
- quiz

*Typically, according to the definition of the commmon **Operation** layer, an Operational object may reference or even be composed of Potential objects (here, **Assets** is the analogous layer), therefore, something that hasn't been mentioned yet and is worth considering is that the quiz object (**quiz** module, in the **Operation** layer) is a composition of question objects (**question** module, in the **Assets** layer), and therefore, can be looked at as a DDD Aggregate. Also, considering these are saved and loaded as a whole to and from data storage (How? Refer to the **QuizAnswerItem** and **QuestionAnswerItem** entities described in the [Data Model's **Element Catalog**]((module_view_data_model.md/#element-catalogue))).*

### <span style="color:#0080ff">Assets</span>
This layer's responsability is associated with the resources (assets) that characterize the business model of quizzes-tutor, in particular questions and users.

This layer has the following modules:
- question
- user

Due to **DD1.** in the [Data Model](module_view_data_model.md/#rationale), question is allowed to be used freely by above layers independently of the adition/removal of types of questions.

### <span style="color:#0080ff">Commodities</span>
This layer's responsability is associated with commodities useful for quizzes-tutor but not motivational, in particular authentication. 

This layer has the following modules:
- auth

Other modules present in the [Decomposition View](module_view_decomposition.md) such as the **mailer** or **impexp** may also be seen as commodities, but they do not contain business logic so we're not including them in the responsability layers, as they don't have a responsability towards the business and are not a part of the domain model.

## Context Diagram

## Rationale

Rationale on **Domain Large-Scale Structure** comments, improvements and considerations:

- **DLSS1.**

  *This view highlights the modules of quizzes-tutor in cohesive responsability units and organizes them in Responsability Layers, bringing out the priorities of the system. Higher layers can be changed freely without affecting lower layers, so this View in particular is useful to understand what layers are susceptible to grow and change.*

  *The engagement functionality modules, in the **Analysis and Decision Making** and the **Engagement** layers (for simplicity, both refered to as "**Engagement** layers" from here on) can, as mentioned in **DMI3.** in the [Uses View's **Rationale**](module_view_uses.md/#rationale), be treated almost as external systems, and therefore can also be seen, in the light of quizzes-tutor's Core Domain, as separate, independent applications that can be available on demand. Therefore, a Pluggable Component Framework pattern emerges where each module in the **Engagement** layers maps to a component, pluggable to the interface of an Abstract Core composed of the **Operation**, **Assets** and **Commodities** layers. For this to be applicable, this interface must be explicit and must lie somewhere in the boundaries between the **Engagement** layers and the below layers. In the current implementation of quizzes-tutor each module has Controller classes that provide entrance APIs for that module, to serve the Views of the frontend, as evident in the [Standard Layered View](module_view_layered.md), and Service classes that work as transactionality points and offer the service itself. The interface of the Abstract Core could be a composition of these Service classes, spamming across all modules in the lower layers to the **Engagement** layers, similarly to how a Facade would work. This is both relevant in the context of the [MS2](system_overview.md#modifibility) and [MS3](system_overview.md#modifibility) **modifiability** scenarios, as it makes both the adition (plugging) and deletion (unplugging) of engagement functionalities straightforward, with minimal risk.*

## Related Views

- Refer to the [Standard Layered View](module_view_layered.md) for a layered view focused on technical aspects and dependencies, highlighting Domain Distillation.

### References

For a detailed style guide, refer to Chapter 2.4 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

For detailed information on the Domain Driven Design strategies mentioned, refer to Part IV of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley.

For information on Responsability Layers, a pattern of the third Domain Driven Design paradigm of Large Scale Structure, refer to Chapter 16 of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley. 
