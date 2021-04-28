package com.project.QnAPlatform.Service;

import com.project.QnAPlatform.DAO.Subtopic_Repository;
import com.project.QnAPlatform.Model.Subtopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Subtopic_Service {

    private final Subtopic_Repository subtopicRepository;

    @Autowired
    public Subtopic_Service(Subtopic_Repository subtopicRepository) {
        this.subtopicRepository = subtopicRepository;
    }

    public List<Subtopic> getAllSubtopics() {
        return subtopicRepository.findAll();
    }

    public Optional<Subtopic> getSubtopic(Long id) {
        return subtopicRepository.findById(id);
    }

    public void addSubtopic(Subtopic subtopic) {
        subtopicRepository.saveAndFlush(subtopic);
    }

    public Optional<Subtopic> updateSubtopic(Long id, Subtopic newSubtopic) {
        return subtopicRepository.findById(id)
                .map(subtopic -> {
                    subtopic.setSubtopicName(newSubtopic.getSubtopicName());
                    return subtopicRepository.saveAndFlush(subtopic);
                });
    }

    public void deleteSubtopic(Long id) {
        subtopicRepository.deleteById(id);
    }
}
