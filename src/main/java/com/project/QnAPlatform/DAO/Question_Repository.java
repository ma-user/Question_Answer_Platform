package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface Question_Repository extends JpaRepository<Question, Long> {

    @Query("SELECT Q FROM Question Q JOIN Q.companies C JOIN Q.subtopics S JOIN Q.tags T JOIN Q.questionLikes QL" +
            " WHERE C.companyName IN (:companies) AND S.subtopicName IN (:subtopics)" +
            " AND T.tags IN (:tags) AND QL.numOfLikesOfQuestion > (:questionLikes) AND Q.postedAt > (:postedAt)")
    List<Question> findByCompaniesAndSubtopicsAndTagsAndQuestionLikesGreaterThanAndPostedAtAfter(@Param("companies") List<String> companies,
                                                                                                 @Param("subtopics") List<String> subtopics,
                                                                                                 @Param("tags") List<String> tags,
                                                                                                 @Param("questionLikes") Integer questionLikes,
                                                                                                 @Param("postedAt") Date postedAt);
}


