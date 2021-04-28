package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Answer_Repository extends JpaRepository<Answer, Long> {
}
