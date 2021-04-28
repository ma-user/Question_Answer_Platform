package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Answer_Repository;
import com.project.QnAPlatform.Model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Answer_Service {

    private final Answer_Repository answerRepository;

    @Autowired
    public Answer_Service(Answer_Repository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Long addAnswer(Answer answer) {
        answerRepository.saveAndFlush(answer);
        return answer.getAnswerId();
    }
}
