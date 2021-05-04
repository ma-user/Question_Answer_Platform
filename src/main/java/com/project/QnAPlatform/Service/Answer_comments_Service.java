package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Answer_comments_Repository;
import com.project.QnAPlatform.Model.Answer_comments;
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
        Answer_comments newAnswerComment = new Answer_comments();
        newAnswerComment.setCommentText(answerComments.getCommentText());
        newAnswerComment.setAnswer(answerComments.getAnswer());
        newAnswerComment.setUser(answerComments.getUser());
        return (answerCommentsRepository.saveAndFlush(newAnswerComment)).getAnswerCommentsId();
    }
}
