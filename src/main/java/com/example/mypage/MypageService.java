package com.example.mypage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Review;
import com.example.entity.User;

@Service
public class MypageService {

    private final MypageUserRepository mypageUserRepository;
    private final MypageReviewRepository mypageReviewRepository;

    // コンストラクタインジェクション
    @Autowired
    public MypageService(MypageReviewRepository mypageReviewRepository,MypageUserRepository mypageUserRepository) {
    	this.mypageReviewRepository = mypageReviewRepository;
    	this.mypageUserRepository = mypageUserRepository;
    }

    // nameはユーザーから送信されるユーザー名を想定
    public Optional<User> loadUserByUsername(Long id){
        // nameによりデータベースからユーザ情報の取得
        Optional<User> user = this.mypageUserRepository.findById(id);


        // ユーザ情報が見つかった場合は、UserDetailsを生成し返却します
        return user;
    }


    // nameはユーザーから送信されるユーザー名を想定
    public List<Review> loadReviewByUser(Long id){
        // nameによりデータベースからユーザ情報の取得
        List<Review> review = this.mypageReviewRepository.listReview(id);
        // ユーザ情報が見つかった場合は、UserDetailsを生成し返却します
        return review;
    }


    public void deleteReviewByUser(Long id) {
    	  this.mypageReviewRepository.deleteById(id);
    }


}
