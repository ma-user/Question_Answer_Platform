package com.project.QnAPlatform.DAO;

import com.project.QnAPlatform.Model.Answer_likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Answer_likes_Repository extends JpaRepository<Answer_likes, Long> {

    @Query("select al  from Answer_likes al where al.answer = :#{#ansLikes.answer} and al.user = :#{#ansLikes.user}")
    Optional<Answer_likes> findAnswerLikes(@Param("ansLikes") Answer_likes answerLikes);

}
