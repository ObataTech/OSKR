package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Review;
import com.example.repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // コンストラクタインジェクション
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    // nameはユーザーから送信されるユーザー名を想定
    public List<Review> loadReviewByUser(Long id){
        // nameによりデータベースからユーザ情報の取得
        List<Review> review = this.reviewRepository.listReview(id);
        // ユーザ情報が見つかった場合は、UserDetailsを生成し返却します
        return review;
    }


    public void deleteReviewByUser(Long id) {
    	  this.reviewRepository.deleteById(id);
    }
}