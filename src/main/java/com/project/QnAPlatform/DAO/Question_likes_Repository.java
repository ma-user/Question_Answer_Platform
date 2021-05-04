package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Question_likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Question_likes_Repository extends JpaRepository<Question_likes, Long> {

    @Query("select ql  from Question_likes ql where ql.question = :#{#quesLikes.question} and ql.user = :#{#quesLikes.user}")
    Optional<Question_likes> findQuestionLikes(@Param("quesLikes") Question_likes questionLikes);
}
