package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Question_Repository;
import com.project.QnAPlatform.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Question_Service {

    private final Question_Repository questionRepository;

    @Autowired
    public Question_Service(Question_Repository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Autowired
    private Company_Service companyService;

    @Autowired
    private Tags_Service tagsService;

    @Autowired
    private Subtopic_Service subtopicService;

    public Question getQuestion(Long id) {
        return questionRepository.getOne(id);
    }

    public Long addQuestion(Question question) {
        Question newQuestion = new Question();
        newQuestion.setQuestionText(question.getQuestionText());
        newQuestion.setUser(question.getUser());
        newQuestion.getSubtopics()
                .addAll(question
                        .getSubtopics()
                        .stream()
                        .map(s -> {
                            Subtopic ss = subtopicService.findSubtopicById(s.getSubtopicId());
                            ss.setQuestion(newQuestion);
                            return ss;
                        }).collect(Collectors.toList())
                );
        newQuestion.getCompanies()
                .addAll(question
                        .getCompanies()
                        .stream()
                        .map(c -> {
                            Company cc = companyService.findCompanyById(c.getCompanyId());
                            cc.getQuestions().add(newQuestion);
                            return cc;
                        }).collect(Collectors.toList())
                );
        newQuestion.getTags()
                .addAll(question
                        .getTags()
                        .stream()
                        .map(t -> {
                            Tags tt = tagsService.findTagById(t.getTagsId());
                            tt.getQuestions().add(newQuestion);
                            return tt;
                        }).collect(Collectors.toList())
                );
        return (questionRepository.saveAndFlush(newQuestion)).getQuestionId();
    }

    public List<Question> getQuestions(List<String> companies, List<String> subtopics, List<String> tags, Integer questionLikes, Date postedAt ) {
        return questionRepository.findByCompaniesAndSubtopicsAndTagsAndQuestionLikesGreaterThanAndPostedAtAfter(companies, subtopics, tags, questionLikes, postedAt);
    }
}
