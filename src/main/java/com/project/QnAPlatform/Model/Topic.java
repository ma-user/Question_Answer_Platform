package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "topic")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topic {

    @Id
    @Column(name = "topic_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topic_id;

    @Column(name = "topic_name")
    private String topic_name;

    public Topic() {
    }

    public Topic(Long topic_id, String topic_name) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
    }

    public Long getTopicId() {
        return topic_id;
    }

    public void setTopicId(Long topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopicName() {
        return topic_name;
    }

    public void setTopicName(String topic_name) {
        this.topic_name = topic_name;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", topic_name='" + topic_name + '\'' +
                '}';
    }
}
