package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Question;
import com.project.QnAPlatform.Model.Question_likes;
import com.project.QnAPlatform.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Question_likes_Repository extends JpaRepository<Question_likes, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Question_likes q SET q.numOfLikesOfQuestion = q.numOfLikesOfQuestion + 1 WHERE q.question=:qId and q.user=:uId")
    void addQuestionLike(@Param("qId") Question questionId, @Param("uId") Users userId);

}
