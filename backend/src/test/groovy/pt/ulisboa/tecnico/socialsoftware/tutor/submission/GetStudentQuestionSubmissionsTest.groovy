package pt.ulisboa.tecnico.socialsoftware.tutor.questionsubmission.service

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.TestConfiguration
import pt.ulisboa.tecnico.socialsoftware.tutor.SpockTest
import pt.ulisboa.tecnico.socialsoftware.tutor.BeanConfiguration
import pt.ulisboa.tecnico.socialsoftware.tutor.question.domain.Question
import pt.ulisboa.tecnico.socialsoftware.tutor.questionsubmission.domain.QuestionSubmission
import pt.ulisboa.tecnico.socialsoftware.tutor.user.User

@DataJpaTest
class GetStudentQuestionSubmissionsTest extends SpockTest{
    def student1
    def student2
    def teacher
    def question
    def questionSubmission

    def setup() {
        student1 = new User(USER_1_NAME, USER_1_USERNAME, USER_1_EMAIL, User.Role.STUDENT, true, false)
        student1.setEnrolledCoursesAcronyms(externalCourseExecution.getAcronym())
        userRepository.save(student1)
        student2 = new User(USER_2_NAME, USER_2_USERNAME, USER_2_EMAIL, User.Role.STUDENT, true, false)
        student2.setEnrolledCoursesAcronyms(externalCourseExecution.getAcronym())
        userRepository.save(student2)
        teacher = new User(USER_3_NAME, USER_3_USERNAME, USER_3_EMAIL, User.Role.TEACHER, true, false)
        userRepository.save(teacher)
        question = new Question()
        question.setKey(1)
        question.setTitle(QUESTION_1_TITLE)
        question.setContent(QUESTION_1_CONTENT)
        question.setCourse(externalCourse)
        question.setStatus(Question.Status.IN_REVIEW)
        questionRepository.save(question)
    }

    def "get question submissions with 1 submitted question"(){
        given: "a question submission"
        def questionSubmission = new QuestionSubmission()
        questionSubmission.setQuestion(question)
        questionSubmission.setUser(student1)
        questionSubmission.setCourseExecution(externalCourseExecution)
        externalCourseExecution.addQuestionSubmission(questionSubmission)
        student1.addQuestionSubmission(questionSubmission)
        questionSubmissionRepository.save(questionSubmission)

        when:
        def result = questionSubmissionService.getStudentQuestionSubmissions(student1.getId(), externalCourseExecution.getId())

        then: "the returned data is correct"
        result.size() == 1
        def submission = result.get(0)

        submission.getId() != null
        submission.getQuestion().getId() == question.getId()
        submission.getUserId() == student1.getId()
        submission.getCourseExecutionId() == externalCourseExecution.getId()
    }

    def "get question submissions with 3 submitted questions"(){
        given: "a question submission"
        def questionSubmission1 = new QuestionSubmission()
        questionSubmission1.setQuestion(question)
        questionSubmission1.setUser(student1)
        questionSubmission1.setCourseExecution(externalCourseExecution)
        externalCourseExecution.addQuestionSubmission(questionSubmission1)
        student1.addQuestionSubmission(questionSubmission1)
        questionSubmissionRepository.save(questionSubmission1)

        and: "another question submission"
        def questionSubmission2 = new QuestionSubmission()
        questionSubmission2.setQuestion(question)
        questionSubmission2.setUser(student1)
        questionSubmission2.setCourseExecution(externalCourseExecution)
        externalCourseExecution.addQuestionSubmission(questionSubmission2)
        student1.addQuestionSubmission(questionSubmission2)
        questionSubmissionRepository.save(questionSubmission2)

        and: "another question submission"
        def questionSubmission3 = new QuestionSubmission()
        questionSubmission3.setQuestion(question)
        questionSubmission3.setUser(student1)
        questionSubmission3.setCourseExecution(externalCourseExecution)
        externalCourseExecution.addQuestionSubmission(questionSubmission3)
        student1.addQuestionSubmission(questionSubmission3)
        questionSubmissionRepository.save(questionSubmission3)

        and: "another students' question submission"
        def questionSubmission4 = new QuestionSubmission()
        questionSubmission4.setQuestion(question)
        questionSubmission4.setUser(student2)
        questionSubmission4.setCourseExecution(externalCourseExecution)
        externalCourseExecution.addQuestionSubmission(questionSubmission4)
        student2.addQuestionSubmission(questionSubmission4)
        questionSubmissionRepository.save(questionSubmission4)

        when:
        def result = questionSubmissionService.getStudentQuestionSubmissions(student1.getId(), externalCourseExecution.getId())

        then: "the returned data is correct and only belongs to student 1"
        result.size() == 3
        def submission1 = result.get(0)
        def submission2 = result.get(1)
        def submission3 = result.get(2)

        submission1.getId() != null
        submission2.getId() != null
        submission3.getId() != null
        submission1.getQuestion().getId() == question.getId()
        submission2.getQuestion().getId() == question.getId()
        submission3.getQuestion().getId() == question.getId()
        submission1.getUserId() == student1.getId()
        submission2.getUserId() == student1.getId()
        submission3.getUserId() == student1.getId()
        submission1.getCourseExecutionId() == externalCourseExecution.getId()
        submission2.getCourseExecutionId() == externalCourseExecution.getId()
        submission3.getCourseExecutionId() == externalCourseExecution.getId()

    }

    def "get question submissions with no submitted questions"(){
        when:
        def result = questionSubmissionService.getStudentQuestionSubmissions(student1.getId(), externalCourseExecution.getId())

        then: "the returned data is correct"
        result.size() == 0
    }


    @TestConfiguration
    static class LocalBeanConfiguration extends BeanConfiguration {}
}



