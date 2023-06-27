package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class LoginUserService {

    private final UserRepository userRepository;

    // コンストラクタインジェクション
    @Autowired
    public LoginUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // nameはユーザーから送信されるユーザー名を想定
    public Optional<User> loadUserByUsername(Long id){
        // nameによりデータベースからユーザ情報の取得
        Optional<User> user = this.userRepository.findById(id);


        // ユーザ情報が見つかった場合は、UserDetailsを生成し返却します
        return user;
    }

//    レビュー
//    // nameはユーザーから送信されるユーザー名を想定
//    public LoginUser loadUserByUsername(String name) throws UsernameNotFoundException {
//        // nameによりデータベースからユーザ情報の取得
//        User user = this.userRepository.findByname(name);
//
//        // ユーザー情報が見つからない場合、例外を発生させます
//        if (user == null) {
//            throw new UsernameNotFoundException("ユーザが見つかりません");
//        }
//
//        // ユーザ情報が見つかった場合は、UserDetailsを生成し返却します
//        return new LoginUser(user);
//    }

}