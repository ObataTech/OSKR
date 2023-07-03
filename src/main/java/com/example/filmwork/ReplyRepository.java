package com.example.filmwork;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

//    @Query("SELECT r FROM Reply r WHERE r.reviewId = ?1")
    @Query("SELECT r FROM Reply r WHERE r.reviewId = ?1 ORDER BY r.posttime DESC")
    public List<Reply> findReplies(Long id);
}
