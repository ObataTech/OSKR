package com.example.filmwork;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

//    @Query("SELECT COUNT(*) FROM REVIEW r WHERE r.id = id")
    @Query("SELECT COUNT(*) FROM Review r WHERE r.filmworkId = ?1")
    public Integer reviewCnt(Long id);

    @Query("SELECT AVG(r.rate) FROM Review r WHERE r.filmworkId = ?1")
    public Float rateAvg(Long id);

    @Query("SELECT r FROM Review r WHERE r.filmworkId = ?1 AND r.spoiler = ?2 ORDER BY r.posttime DESC")
    public List<Review> findNoSpoilerReviews(Long id, Integer spoiler);

    @Query("SELECT r FROM Review r WHERE r.filmworkId = ?1 ORDER BY r.posttime DESC")
    public List<Review> findReviews(Long id);
}