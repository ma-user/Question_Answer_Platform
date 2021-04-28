package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.*;
import com.project.QnAPlatform.Service.Question_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/questions")
public class Question_Controller {

    private final Question_Service questionService;

    @Autowired
    public Question_Controller(Question_Service questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping
    @RequestMapping("/filter_questions")
    public List<Question> getQuestions(@RequestParam(value = "companies", required = false) List<String> companies,
                                       @RequestParam(value = "subtopics", required = false) List<String> subtopics,
                                       @RequestParam(value = "tags", required = false) List<String> tags,
                                       @RequestParam(value = "questionLikes", required = false) Integer questionLikes,
                                       @RequestParam(value = "postedAt", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date postedAt) {
        return questionService.getQuestions(companies, subtopics, tags, questionLikes, postedAt);
    }


    @PostMapping
    public Long addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return question.getQuestionId();
    }
}
