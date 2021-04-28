package com.project.QnAPlatform.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "question")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(name = "question_text")
    private String questionText;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question_likes> questionLikes;

    @ManyToMany
    @JoinTable(
            name = "Question_company_mapping",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private List<Company> companies;

    @ManyToMany
    @JoinTable(
            name = "Question_tags",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    private List<Tags> tags;

    @OneToMany
    @JoinColumn(name = "topic_id")
    private List<Topic> topics;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToMany
    @JoinColumn(name = "subtopic_id")
    private List<Subtopic> subtopics;

    public Question() {
    }

    public Question(Long questionId, String questionText) {
        this.questionId = questionId;
        this.questionText = questionText;
    }

    public Question(Date postedAt, List<Question_likes> questionLikes, List<Company> companies, List<Tags> tags, List<Subtopic> subtopics) {
        this.postedAt = postedAt;
        this.questionLikes = questionLikes;
        this.companies = companies;
        this.tags = tags;
        this.subtopics = subtopics;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Question_likes> getQuestionLikes() {
        return questionLikes;
    }

    public void setQuestionLikes(List<Question_likes> questionLikes) {
        this.questionLikes = questionLikes;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) { this.topics = topics; }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public List<Subtopic> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<Subtopic> subtopics) {
        this.subtopics = subtopics;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", postedAt=" + postedAt +
                ", answers=" + answers +
                ", questionLikes=" + questionLikes +
                ", companies=" + companies +
                ", tags=" + tags +
                ", topics=" + topics +
                ", user=" + user +
                ", subtopics=" + subtopics +
                '}';
    }
}
