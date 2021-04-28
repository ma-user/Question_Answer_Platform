package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.Answer_likes;
import com.project.QnAPlatform.Service.Answer_likes_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/answerLikes")
public class Answer_likes_Controller {

    private final Answer_likes_Service answerLikesService;

    @Autowired
    public Answer_likes_Controller(Answer_likes_Service answerLikesService) {
        this.answerLikesService = answerLikesService;
    }

    @PostMapping
    public void addAnswerLike(@RequestBody Answer_likes answerLikes) {
        answerLikesService.addAnswerLike(answerLikes);
    }
}
