package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tags {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagsId;

    @Column(name = "tag")
    private String tags;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Question> questions;

    public Tags() {
    }

    public Tags(Long tagsId, String tags) {
        this.tagsId = tagsId;
        this.tags = tags;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tagsId=" + tagsId +
                ", tags='" + tags + '\'' +
                ", questions=" + questions +
                '}';
    }
}
