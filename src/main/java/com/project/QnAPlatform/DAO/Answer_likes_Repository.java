package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Answer;
import com.project.QnAPlatform.Model.Answer_likes;
import com.project.QnAPlatform.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Answer_likes_Repository extends JpaRepository<Answer_likes, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Answer_likes a SET a.numOfLikesOfAnswer = a.numOfLikesOfAnswer + 1 WHERE a.answer=:aId and a.user=:uId")
    void addAnswerLike(@Param("aId") Answer answerId, @Param("uId") Users userId);
}
