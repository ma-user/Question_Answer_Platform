package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Topic_Repository;
import com.project.QnAPlatform.Model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Topic_Service {

    private final Topic_Repository topicRepository;

    @Autowired
    public Topic_Service(Topic_Repository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopic(Long id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.saveAndFlush(topic);
    }

    public Optional<Topic> updateTopic(Long id, Topic newTopic) {
        return topicRepository.findById(id)
                .map(topic -> {
                    topic.setTopicName(newTopic.getTopicName());
                    return topicRepository.saveAndFlush(topic);
                });
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
