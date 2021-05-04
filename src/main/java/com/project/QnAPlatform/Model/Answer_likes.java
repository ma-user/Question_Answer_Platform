package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

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
    @JsonBackReference
    private Answer answer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer_likes that = (Answer_likes) o;
        return numOfLikesOfAnswer == that.numOfLikesOfAnswer && Objects.equals(id, that.id) && Objects.equals(answer, that.answer) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numOfLikesOfAnswer, answer, user);
    }
}
