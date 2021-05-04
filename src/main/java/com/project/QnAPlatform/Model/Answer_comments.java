package com.project.QnAPlatform.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "answer_comments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Answer_comments {

    @Id
    @Column(name = "answer_comments_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerCommentsId;

    @Column(name = "comment_text")
    @Size(min = 50, max = 500)
    @NotEmpty(message = "Please enter comment")
    private String commentText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "commented_at")
    private Date commentedAt = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    @JsonBackReference
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    public Answer_comments() {
    }

    public Answer_comments(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getAnswerCommentsId() {
        return answerCommentsId;
    }

    public void setAnswerCommentsId(Long answerCommentsId) {
        this.answerCommentsId = answerCommentsId;
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

    public Date getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(Date commentedAt) {
        this.commentedAt = commentedAt;
    }
}
