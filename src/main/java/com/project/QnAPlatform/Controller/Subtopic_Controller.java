package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.Subtopic;
import com.project.QnAPlatform.Service.Subtopic_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/subtopics")
public class Subtopic_Controller {

    private final Subtopic_Service subtopicService;

    @Autowired
    public Subtopic_Controller(Subtopic_Service subtopicService) {
        this.subtopicService = subtopicService;
    }

    @GetMapping
    public List<Subtopic> getAllSubtopics() { return subtopicService.getAllSubtopics(); }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Subtopic> getSubtopic(@PathVariable Long id) { return subtopicService.getSubtopic(id); }

    @PostMapping
    public void addSubtopic(@RequestBody Subtopic subtopic) {
        subtopicService.addSubtopic(subtopic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Optional<Subtopic> updateSubtopic(@PathVariable Long id, @RequestBody Subtopic subtopic) {
        return subtopicService.updateSubtopic(id, subtopic);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSubtopic(@PathVariable Long id) {
        subtopicService.deleteSubtopic(id);
    }
}

