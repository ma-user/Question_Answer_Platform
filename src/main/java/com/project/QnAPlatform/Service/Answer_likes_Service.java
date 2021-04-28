package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Answer_likes_Repository;
import com.project.QnAPlatform.Model.Answer;
import com.project.QnAPlatform.Model.Answer_likes;
import com.project.QnAPlatform.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Answer_likes_Service {

    private final Answer_likes_Repository answer_likes_repository;

    @Autowired
    public Answer_likes_Service(Answer_likes_Repository answer_likes_repository) {
        this.answer_likes_repository = answer_likes_repository;
    }

    public void addAnswerLike(Answer_likes answerLikes) {
        Answer answerId = answerLikes.getAnswer();
        Users userId = answerLikes.getUser();
        answer_likes_repository.saveAndFlush(answerLikes);
        answer_likes_repository.addAnswerLike(answerId, userId);
    }
}
