# Quizzes-Tutor - Distillation Document

This Distillation Document is crucial to highlight quizzes-tutor's Core Domain. Most of the topics discussed here were already mentioned in the various Rationale sections across the Views of this SAD, but are made concise and localized in this piece of documentation. This document isn't referenced anywhere in the SAD Views, other than the main section.

A Distillation Document typically focuses on Domain Distillation, as does this one. However the Core Subdomains of quizzes-tutor are highly related with aspects of development distributability, therefore, there will be considerations on Domain Model Integrity.

Marked with spoiler tags are some mentions to the SAD, with useful considerations and references in the light of Domain Model Integrity, Domain Distillation and Domain Large-Scale Structure.

>Before reading it's recommended to read the [Decomposition View](module_view_decomposition_view.md) for more on the semantic meaning of each module.

## The Core Domain

From a point of view of implementation, the Core Domain of quizzes-tutor is comprised of the **course**, **question**, **answer**, **questionsubmission**, **quiz** and **user** modules.

The **question** and **answer** modules deserve particular attention, since these aren't part of the Core Domain in their entirety. There's a prominent decoupling between the questions/answers themselves and the types of questions/answers, meaning any functionality present in quizzes-tutor that uses questions is "unaware" of their types, and thus is independent from them. Therefore, new types of questions/answers are straightforward to implement with minimized, localized effort from developers. This implies that the classes that implement the different types of questions/answers aren't a part of the Core Domain. 

>Refer to **DD1.** in the [Data Model's **Rationale**](module_view_data_model.md#rationale) for a detailed, technical explanation of how the decoupling between questions/answers and types of questions/answers is conceived.

## The Core Subdomain

The Core Subdomains of quizzes-tutor include the parts of the system that still add value to the domain model, but are accessory, meaning the system won't loose it's integrity and purpose without them. Core Subdomains, contrarily to the Core Domain are susceptible to change, but are included in this Distillation Document since the way they shape with the Core Domain is relevant to the proposed Business Goals of the system. The parts of quizzes-tutor that make the Core Subdomains are divided in three categories: the types of questions, the engagement functionalities, and the policies of the system.

Types of questions, as mentioned before, can be added independently of the rest of the system, which allows Core Subdomains to be materialized by small localized and independent teams. Of course a team aiming to implement a type of question also needs to implement a type of answer, and therefore, both the **question** and **answer** modules might need to be changed. 

>Having this in mind, a principal of Domain Model Integrity is proposed in **DMI1.** in the [Uses View's **Rationale**](module_view_uses.md#rationale).

Engagement functionalities are accessory functionalities aimed at promoting the engagement of students, as described in [BG2](system_overview.md#business-goals). Similarly to the types of questions, quizzes-tutor is designed to allow engagement functionalities to be added, deleted and changed independently from the rest of the system, allowing the concretization of [BG3](system_overview.md#business-goals), in particular, of the scenario [MS3](system_overview.md#modifiability). In the actual implementation of quizzes-tutor, modules like **discussion**, **tournament** and **statistics** equate to Core Subdomains, each implementing an engagement functionality. A Team working on an engagement functionality is mostly allowed to trust the stable Core Domain of quizzes-tutor, and assume a Separate Ways position towards all other Core Subdomains, including the types of questions.  

>In the light of Domain Model Integrity, **DMI3.** in the [Uses View's **Rationale**](module_view_uses.md#rationale), proposes a handful of approaches teams developing engagement functionalities may take in order to optimize the Continuous Integration of their code with the rest of quizzes-tutor. 

>**DLSS1.**, in the [Responsability Layered View's **Rationale**](module_view_layered_responsability.md#rationale), also proposes some improvements in the light of Domain Large-Scale Structure to allow smoother integration between the engagement functionalities' Core Subdomains and the Core Domain.

The policies of quizzes-tutor include the **Permissions** module that deals with authorization policies.

## Highlighting the Core Domain - The Extra Step

Since quizzes-tutor is meant to be developed by "outsourced" teams of students, as stated in [BG3]((system_overview.md#business-goals)), it's highly recommended to pair this Distillation Document with the formal Flagging of the entities of the Core in the code itself. This is another way of highlighting the Core Domain, to help guide future development.