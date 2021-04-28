package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.Topic;
import com.project.QnAPlatform.Service.Topic_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/topic")
public class Topic_Controller {

    private final Topic_Service topicService;

    @Autowired
    public Topic_Controller(Topic_Service topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() { return topicService.getAllTopics(); }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Topic> getTopic(@PathVariable Long id) { return topicService.getTopic(id); }

    @PostMapping
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Optional<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
        return topicService.updateTopic(id, topic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }
}
