package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.*;
import com.project.QnAPlatform.Service.Answer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/answers")
public class Answer_Controller {

    private final Answer_Service answerService;

    @Autowired
    public Answer_Controller(Answer_Service answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public Long addAnswer(@RequestBody Answer answer) {
        answerService.addAnswer(answer);
        return answer.getAnswerId();
    }
}
