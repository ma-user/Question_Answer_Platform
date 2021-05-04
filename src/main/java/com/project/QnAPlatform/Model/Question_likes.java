package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

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
    @JsonBackReference
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question_likes likes = (Question_likes) o;
        return numOfLikesOfQuestion == likes.numOfLikesOfQuestion && Objects.equals(id, likes.id) && Objects.equals(question, likes.question) && Objects.equals(user, likes.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numOfLikesOfQuestion, question, user);
    }
}
