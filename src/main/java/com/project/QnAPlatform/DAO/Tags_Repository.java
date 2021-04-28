package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tags_Repository extends JpaRepository<Tags, Long> {
}
