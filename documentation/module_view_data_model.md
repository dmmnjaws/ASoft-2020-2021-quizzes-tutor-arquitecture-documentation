# Quizzes-Tutor - Module View: Data Model

## Primary Presentation

<img src="pictures/Data Model View.png" width="900" >

Fig 1. Data Model graphic representation. Caption:

<img src="pictures/Data Model View Caption.png" width="900" >

## Element Catalog

### <span style="color:#0080ff">AnswerDetails</span>
### <span style="color:#0080ff">Assessment</span>
### <span style="color:#0080ff">AuthDemoUser</span>
### <span style="color:#0080ff">AuthExternalUser</span>
### <span style="color:#0080ff">AuthUser</span>
### <span style="color:#0080ff">Course</span>
### <span style="color:#0080ff">CourseExecution</span>
### <span style="color:#0080ff">Discussion</span>
### <span style="color:#0080ff">Image</span>
### <span style="color:#0080ff">MultipleChoiceQuestion</span>
### <span style="color:#0080ff">MultipleChoiceAnswer</span>
### <span style="color:#0080ff">MultipleChoiceAnswerItem</span>
### <span style="color:#0080ff">Option</span>
### <span style="color:#0080ff">Question</span>
### <span style="color:#0080ff">QuestionAnswer</span>
### <span style="color:#0080ff">QuestionAnswerItem</span>
`Separation Ways DDD Pattern since we're using Foreign Keys instead of Object References for quizId, quizQuestionId and username`
### <span style="color:#0080ff">QuestionDetails</span>
### <span style="color:#0080ff">QuestionSubmission</span>
### <span style="color:#0080ff">Quiz</span>
### <span style="color:#0080ff">QuizAnswer</span>
### <span style="color:#0080ff">QuizAnswerItem</span>
### <span style="color:#0080ff">QuizQuestion</span>
### <span style="color:#0080ff">Reply</span>
### <span style="color:#0080ff">Review</span>
### <span style="color:#0080ff">Topic</span>
### <span style="color:#0080ff">TopicConjunction</span>
### <span style="color:#0080ff">Tournament</span>
### <span style="color:#0080ff">User</span>

## Context Diagram

## Rationale
`According to the professor, we should only have a view as close to the physical level as this one if we're catching up on scenarios that justify it. Either one of these two: António comes up with scenarios for the appropriate QAs. OR Another simpler view has to be done, closer to de Conceptual/Logic level of Data Model, and this one, closer to the Physical level, is left as a attachment, for further considerations...`

## Related Views

## References
For a detailed style guide, refer to Chapter 2.6 of Documenting Software Architectures: Views and Beyond (2nd Edition): Paul Clements, Felix Bachmann, Len Bass, David Garlan, James Ivers, Reed Little, Paulo Merson, Robert Nord, Judith Stafford 2010 Addison-Wesley.

----------------------------------------------
Reply			        XY


Discussion		        XY

Image			        XY

Question		        XY

QuestionSubmission  	XY

Assessment		        XY

QuestionDetails		    XY

Review 			        XY

CourseExecution		    XY

QuizAnswer		        XY

TopicConjunction	    XY

MultipleChoiceQuestion	XY

Quiz			        XY (duvida: one to one com tournament tem duas setas no ERD - comparar com one to one entre Question e QuestionDetails)

Option			        XY

AnswerDetails		    XY (duvida: one to one com questionanswer tem duas setas no ERD - comparar com one to one entre Question e QuestionDetails)

Tournament		        XY

MultipleChoiseAnswer	XY

QuestionAnswer		    XY

User			        XY

Topic			        XY

QuizQuestion		    XY

AuthUser		        XY

Course			        XY

AuthExternalUser	    XY

AuthDemoUser		    XY

AuthTecnicoUser		    XY