package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Topic_Repository extends JpaRepository<Topic, Long> {
}
