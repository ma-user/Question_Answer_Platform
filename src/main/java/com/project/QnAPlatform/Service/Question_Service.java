package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Question_Repository;
import com.project.QnAPlatform.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Question_Service {

    private final Question_Repository questionRepository;

    @Autowired
    public Question_Service(Question_Repository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestion(Long id) {
        return questionRepository.getOne(id);
    }

    public Long addQuestion(Question question) {
        questionRepository.saveAndFlush(question);
        return question.getQuestionId();
    }

    public List<Question> getQuestions(List<String> companies, List<String> subtopics, List<String> tags, Integer questionLikes, Date postedAt ) {
        return questionRepository.findByCompaniesAndSubtopicsAndTagsAndQuestionLikesGreaterThanAndPostedAtAfter(companies, subtopics, tags, questionLikes, postedAt);
    }
}
