package com.project.QnAPlatform.Controller;

import com.project.QnAPlatform.Model.Tags;
import com.project.QnAPlatform.Service.Tags_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tags")
public class Tags_Controller {

    private final Tags_Service tagsService;

    @Autowired
    public Tags_Controller(Tags_Service tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping
    public List<Tags> getAllTags() { return tagsService.getAllTags(); }

    @GetMapping
    @RequestMapping("/{id}")
    public Optional<Tags> getTag(@PathVariable Long id) { return tagsService.getTag(id); }

    @PostMapping
    public void addTag(@RequestBody Tags tag) {
        tagsService.addTag(tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Optional<Tags> updateTag(@PathVariable Long id, @RequestBody Tags tag) {
        return tagsService.updateTag(id, tag);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteTag(@PathVariable Long id) {
        tagsService.deleteTag(id);
    }
}
