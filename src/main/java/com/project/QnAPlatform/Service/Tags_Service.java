package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Tags_Repository;
import com.project.QnAPlatform.Model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Tags_Service {

    private final Tags_Repository tagsRepository;

    @Autowired
    public Tags_Service(Tags_Repository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }

    public Optional<Tags> getTag(Long id) {
        return tagsRepository.findById(id);
    }

    public void addTag(Tags tag) {
        tagsRepository.saveAndFlush(tag);
    }

    public Optional<Tags> updateTag(Long id, Tags newTag) {
        return tagsRepository.findById(id)
                .map(tags -> {
                    tags.setTags(newTag.getTags());
                    return tagsRepository.saveAndFlush(tags);
                });
    }

    public void deleteTag(Long id) {
        tagsRepository.deleteById(id);
    }

    public Tags findTagById(Long tagsId) {
        return tagsRepository.findByTagsId(tagsId);
    }
}
