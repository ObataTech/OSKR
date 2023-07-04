package com.example.mypage;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Review;
import com.example.entity.User;
import com.example.form.UserForm;

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


    /**
     * レビュー削除
     * @param id レビューID
     */
    public void deleteReviewByUser(Long id) {
    	Optional<Review> review = this.mypageReviewRepository.findById(id);
    	review.get().setDeletedDate(LocalDateTime.now());
    	this.mypageReviewRepository.save(review.get());
//    	  this.mypageReviewRepository.deleteById(id);
    }

    /**
     * ユーザ情報更新
     * @param id ユーザID
     * @param userform ユーザフォーム
     */
    public void editUser(Long id,UserForm userForm) {
    	//ユーザ情報の取得
        Optional<User> user = this.mypageUserRepository.findById(id);
    	//ユーザ情報を取得したフォームの情報で更新
        user.get().setName(userForm.getName());
        user.get().setProfile(userForm.getProfile());

        this.mypageUserRepository.save(user.get());
    }

}
