package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "answer_likes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer_likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_of_likes_of_answer")
    private int numOfLikesOfAnswer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    @JsonIgnore
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Users user;

    public Answer_likes() {
    }

    public Answer_likes(Long id, int numOfLikesOfAnswer) {
        this.id = id;
        this.numOfLikesOfAnswer = numOfLikesOfAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumOfLikesOfAnswer() {
        return numOfLikesOfAnswer;
    }

    public void setNumOfLikesOfAnswer(int numOfLikesOfAnswer) {
        this.numOfLikesOfAnswer = numOfLikesOfAnswer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Answer_likes{" +
                "id=" + id +
                ", numOfLikesOfAnswer=" + numOfLikesOfAnswer +
                ", answer=" + answer +
                ", user=" + user +
                '}';
    }
}
