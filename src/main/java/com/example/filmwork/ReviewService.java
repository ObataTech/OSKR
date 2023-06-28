package com.example.filmwork;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Review;
import com.example.login.LoginUser;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Integer reviewCnt(Long id) {
    	return this.reviewRepository.reviewCnt(id);
    }

    public Float rateAvg(Long id) {
    	return this.reviewRepository.rateAvg(id);
    }

    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    List<Review> findNoSpoilerReviews(Long id, Integer spoiler) {
    	return this.reviewRepository.findNoSpoilerReviews(id, 1);
    }

    List<Review> findReviews(Long id) {
    	return this.reviewRepository.findReviews(id);
    }

    // レビュー保存用のメソッドです
    public Review save(FilmworkForm filmworkForm, LoginUser loginUser) {
        // Entityクラスのインスタンスを生成します
        Review review = new Review();
        // フィールドのセットを行います
        review.setContent(filmworkForm.getReviewContent());
        review.setRate(filmworkForm.getRate());
        review.setSpoiler(filmworkForm.getSpoiler());
        LocalDateTime now = LocalDateTime.now();
        review.setPosttime(now);
        review.setUserId(loginUser.getUser().getId());
        review.setFilmworkId(filmworkForm.getId());
//        review.setFilmworkId(1L);
        // repository.saveメソッドを利用してデータの保存を行います
        return this.reviewRepository.save(review);
    }

}
