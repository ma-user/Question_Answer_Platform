package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer {

    @Id
    @Column(name = "answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(name = "answer_text")
    private String answerText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer_likes> answerLikes;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer_comments> answerComments;

    public Answer() {
    }

    public Answer(Long answerId, String answerText) {
        this.answerId = answerId;
        this.answerText = answerText;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer_comments> getAnswerComments() {
        return answerComments;
    }

    public void setAnswerComments(List<Answer_comments> answerComments) {
        this.answerComments = answerComments;
    }

    public List<Answer_likes> getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(List<Answer_likes> answerLikes) {
        this.answerLikes = answerLikes;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answerText='" + answerText + '\'' +
                ", question=" + question +
                ", user=" + user +
                ", answerLikes=" + answerLikes +
                ", answerComments=" + answerComments +
                '}';
    }
}
