package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Question_likes_Repository;

import com.project.QnAPlatform.Model.Question;
import com.project.QnAPlatform.Model.Question_likes;
import com.project.QnAPlatform.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Question_likes_Service {

    private final Question_likes_Repository question_likes_repository;

    @Autowired
    public Question_likes_Service(Question_likes_Repository question_likes_repository) {
        this.question_likes_repository = question_likes_repository;
    }

    public void addQuestionLike(Question_likes questionLikes) {
        Question questionId = questionLikes.getQuestion();
        Users userId = questionLikes.getUser();
        question_likes_repository.saveAndFlush(questionLikes);
        question_likes_repository.addQuestionLike(questionId, userId);
    }
}
