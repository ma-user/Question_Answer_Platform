package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Answer_likes_Repository;
import com.project.QnAPlatform.Model.Answer_likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Answer_likes_Service {

    private final Answer_likes_Repository answer_likes_repository;

    @Autowired
    public Answer_likes_Service(Answer_likes_Repository answer_likes_repository) {
        this.answer_likes_repository = answer_likes_repository;
    }

    public void addAnswerLike(Answer_likes answerLikes) {
        Answer_likes newAnswerLike = new Answer_likes();
        newAnswerLike.setAnswer(answerLikes.getAnswer());
        newAnswerLike.setUser(answerLikes.getUser());
        newAnswerLike.setNumOfLikesOfAnswer(answerLikes.getNumOfLikesOfAnswer()+1);
        answer_likes_repository.saveAndFlush(newAnswerLike);
    }

    public Optional<Answer_likes> findAnswerLikes(Answer_likes answerLikes) {
        return answer_likes_repository.findAnswerLikes(answerLikes);
    }
}
