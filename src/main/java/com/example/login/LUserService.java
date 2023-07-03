package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LUserService {

    private final LUserRepository luserRepository;

    @Autowired
    public LUserService(LUserRepository luserRepository) {
        this.luserRepository = luserRepository;
    }

//    public User findById(Long id) {
//        Optional<User> optionalUser = this.luserRepository.findById(id);
//       User user  = optionalUser.get();
//        return user;
//    }

    // ユーザー登録用のメソッドです
//    public User register(SignupForm signupForm) {
        // Entityクラスのインスタンスを生成します
//        User user = new User();
        // フィールドのセットを行います
//        user.setName(signupForm.getName());
        // encode()メソッドの引数にハッシュ化したい文字列を渡すことでハッシュ化した値を返す
//        user.setPassword(signupForm.getPassword());
 //       user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
  //      user.setProfile(" ");
   //     user.setIcon(" ");
        // repository.saveメソッドを利用してデータの保存を行います
    //    return this.luserRepository.save(user);
   // }
}
