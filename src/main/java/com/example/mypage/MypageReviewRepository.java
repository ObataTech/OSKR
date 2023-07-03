package com.example.mypage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Review;

@Repository
public interface MypageReviewRepository extends JpaRepository<Review, Long> {
    // ユーザーIDと一致するレビューを取得する
	@Query("SELECT r FROM Review r WHERE r.userId = ?1 ORDER BY r.posttime DESC")
    public List<Review> listReview(Long id);

}

