[< Back](SAD.md)

# Quizzes-Tutor - Documentation Roadmap

## Purpose and Scope of the SAD

This SAD described the architecture of **Quizzes-Tutor**, an under-development, open-source application, aimed at improving the teaching and learning experience, mainly, but not exclusively, within IST. The development of quizzes-tutor started as an effort of project IMPRESS to share and reuse questions and quizzes related with software engineering and evolved into a system that allows teachers to create and reuse multiple-choice questions with images and topics, that can be inserted in assessments and quizzes, which students can answer providing them with a useful self-assessment tool to improve their learning. 

The architecture described in this SAD was reconstructed from the implementation artifacts of the Quizzes-Tutor, forked for analysis on the 19th of November (therefore discarding any changes commited in posterior dates). The system was deconstructed to it's basic structures, documented as architectural views, allowing the rationing of how to effectively apply Domain Driven Design to satisty a handful scenarios for quality attribute requirements deducted from pre-revealed business goals.


## How is the SAD structured 

- This **Documentation Roadmap** section provides information about this document. It provides the roadmap for how to navigate through the document, presenting a brief document overview.

- The **[System Overview](system_overview.md)** section provides information about the mission statement of the quizzes-tutor project, decomposing it from **business goals** down to the **functionalities** and **scenarios for quality attribute requirements**. 

- The **Views** section provides the documentation for the views of the system, allowing a detailed description of the different structures and perspectives the system can be seen from. These include:
    - **Module Views**, related to the implementation units of the system, addressing topics such as modular dependencies and separation of concerns.
    - **Component-and-Connector Views**, related with the runtime elements of the system, called components, and how they interact through connectors. 
    - **Allocation Views**, related with the mapping of software elements with non-software elements, such as hardware, personal, and other resources.

    Mappings between views and between requirements and architectural aspects are achieved organically in the **Rationale** sections of each View, where the focus is on the discussion of aspects of Domain Driven Design, and as mentioned prior, on how these satisfy the scenarios for quality attribute requirements.

## Other Documents
Outside the scope of the SAD, the following documents result from an analysis of Domain Distillation. 

- The [**Domain Vision Statement**](domain_vision_statement.md) provides a summarized look into the value of quizzes-tutor's Core Domain. It's aimed at all stakeholders.

- The [**Distillation Document**](distillation_document.md) provides a deeper look on the technical and implementational value of quizzes-tutor's Core Domain and Core Subdomains. It's aimed at stakeholders interested in some implementation aspects of quizzes-tutor, mainly development distributability.