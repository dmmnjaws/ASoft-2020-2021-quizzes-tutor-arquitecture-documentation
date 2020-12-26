# Quizzes-Tutor - Module View: Layered View (Large Scale Structure - Responsability Layers)

## Primary Presentation

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

### <span style="color:#0080ff">Operation</span>
This layer's responsability is associated with the operations allowed on the resources of quizzes-tutor. In short, what kinds of "activities" quizzes-tutor offers. In particular, questions can be submitted, grouped into quizzes, answered and discussed by users. Tournaments may be organized by users. 

This layer has the following modules:
- answer
- tournament
- discussion
- questionsubmission
- quiz

### <span style="color:#0080ff">Potential Resources</span>
This layer's responsability is associated with the resources (assets) that characterize the business model of quizzes-tutor, in particular questions and users.

This layer has the following modules:
- question
- user

## Context Diagram

## Rationale

## Related Views

- Refer to the [Standard Layered View](module_view_layered.md) for a layered view focused on technical aspects and dependencies, highlighting Domain Distillation.

### References

For a detailed style guide, refer to Chapter 2.4 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

For information on Responsability Layers, a pattern of the third Domain Driven Design paradigm of Large Scale Structure, refer to Chapter 6 of Domain Driven Design: Tackling Complexity in the Heart of Software: Eric Evans 2003 Addison-Wesley. 