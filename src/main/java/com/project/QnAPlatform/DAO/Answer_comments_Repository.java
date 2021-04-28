package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Answer_comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Answer_comments_Repository extends JpaRepository<Answer_comments, Long> {
}
