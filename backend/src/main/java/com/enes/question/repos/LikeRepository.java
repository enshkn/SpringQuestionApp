package com.enes.question.repos;
import com.enes.question.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findAllLikesByUserIdAndPostId(Long userId, Long postId);

    List<Like> findAllLikesByUserId(Long userId);

    List<Like> findAllLikesByPostId(Long postId);
}
