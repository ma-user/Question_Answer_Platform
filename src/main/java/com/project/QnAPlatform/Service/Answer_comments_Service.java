package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Answer_comments_Repository;
import com.project.QnAPlatform.Model.Answer;
import com.project.QnAPlatform.Model.Answer_comments;
import com.project.QnAPlatform.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Answer_comments_Service {

    private final Answer_comments_Repository answerCommentsRepository;

    @Autowired
    public Answer_comments_Service(Answer_comments_Repository answerCommentsRepository) {
        this.answerCommentsRepository = answerCommentsRepository;
    }

    public Long addComment(Answer_comments answerComments) {
        answerCommentsRepository.saveAndFlush(answerComments);
        return answerComments.getAnswerCommentsId();
    }
}
