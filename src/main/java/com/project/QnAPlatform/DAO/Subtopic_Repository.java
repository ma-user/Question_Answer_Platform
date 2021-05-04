package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Subtopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Subtopic_Repository extends JpaRepository<Subtopic, Long> {
    Subtopic findBySubtopicId(Long subtopicId);
}
