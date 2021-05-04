package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "subtopic")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Subtopic {

    @Id
    @Column(name = "subtopic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subtopicId;

    @Column(name = "subtopic_name")
    private String subtopicName;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Embedded
    private Topic topic;

    public Subtopic() {
    }

    public Subtopic(Long subtopicId, String subtopicName) {
        this.subtopicId = subtopicId;
        this.subtopicName = subtopicName;
    }

    public Long getSubtopicId() {
        return subtopicId;
    }

    public void setSubtopicId(Long subtopicId) {
        this.subtopicId = subtopicId;
    }

    public String getSubtopicName() {
        return subtopicName;
    }

    public void setSubtopicName(String subtopicName) {
        this.subtopicName = subtopicName;
    }

    public Question getQuestion() { return question; }

    public void setQuestion(Question question) { this.question = question; }
}
