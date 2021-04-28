package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.Answer_comments;
import com.project.QnAPlatform.Service.Answer_comments_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/comments")
public class Answer_comments_Controller {

    private final Answer_comments_Service answerCommentsService;

    @Autowired
    public Answer_comments_Controller(Answer_comments_Service answerCommentsService) {
        this.answerCommentsService = answerCommentsService;
    }

    @PostMapping
    public Long addComment(@RequestBody Answer_comments answerComments) {
        answerCommentsService.addComment(answerComments);
        return answerComments.getAnswerCommentsId();
    }
}
