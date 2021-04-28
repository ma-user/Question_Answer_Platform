package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Company_Repository extends JpaRepository<Company, Long> {
}
