package com.project.QnAPlatform.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Topic implements Serializable {

    private String topic_name;

    public Topic() {
    }

    public Topic(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getTopicName() {
        return topic_name;
    }

    public void setTopicName(String topic_name) {
        this.topic_name = topic_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(topic_name, topic.topic_name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic_name);
    }
}
