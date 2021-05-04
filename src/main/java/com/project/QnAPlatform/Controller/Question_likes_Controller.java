package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.*;
import com.project.QnAPlatform.Service.Question_likes_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/questionLikes")
public class Question_likes_Controller {

    private final Question_likes_Service questionLikesService;

    @Autowired
    public Question_likes_Controller(Question_likes_Service questionLikesService) {
        this.questionLikesService = questionLikesService;
    }

    @PostMapping
    public void addQuestionLike(@RequestBody Question_likes questionLikes) {
        Optional<Question_likes> question_likesOptional = questionLikesService.findQuestionLikes(questionLikes);
        if(question_likesOptional.isPresent()) {
            throw new IllegalStateException("User has already liked the answer");
        }
        else {
            questionLikesService.addQuestionLike(questionLikes);
        }
    }
}
