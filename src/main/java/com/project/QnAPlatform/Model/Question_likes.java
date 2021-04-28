package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "question_likes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question_likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_of_likes_of_question")
    private int numOfLikesOfQuestion = 0;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    public Question_likes() {
    }

    public Question_likes(Long id, int numOfLikesOfQuestion) {
        this.id = id;
        this.numOfLikesOfQuestion = numOfLikesOfQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfLikesOfQuestion() {
        return numOfLikesOfQuestion;
    }

    public void setNumOfLikesOfQuestion(int numOfLikesOfQuestion) {
        this.numOfLikesOfQuestion = numOfLikesOfQuestion;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Question_likes{" +
                "id=" + id +
                ", numOfLikesOfQuestion=" + numOfLikesOfQuestion +
                ", question=" + question +
                ", user=" + user +
                '}';
    }
}
