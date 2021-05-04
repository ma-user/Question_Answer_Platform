package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Question_likes_Repository;
import com.project.QnAPlatform.Model.Question_likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Question_likes_Service {

    private final Question_likes_Repository question_likes_repository;

    @Autowired
    public Question_likes_Service(Question_likes_Repository question_likes_repository) {
        this.question_likes_repository = question_likes_repository;
    }

    public void addQuestionLike(Question_likes questionLikes) {
        Question_likes newQuestionLike = new Question_likes();
        newQuestionLike.setQuestion(questionLikes.getQuestion());
        newQuestionLike.setUser(questionLikes.getUser());
        newQuestionLike.setNumOfLikesOfQuestion(questionLikes.getNumOfLikesOfQuestion()+1);
        question_likes_repository.saveAndFlush(newQuestionLike);
    }

    public Optional<Question_likes> findQuestionLikes(Question_likes questionLikes) {
        return question_likes_repository.findQuestionLikes(questionLikes);
    }
}

