package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;

@Service
public class LoginUserService implements UserDetailsService{

	private final LUserRepository luserRepository;
	private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginUserService(LUserRepository luserRepository, PasswordEncoder passwordEncoder) {
        this.luserRepository = luserRepository;
        this.passwordEncoder = passwordEncoder;
    }

//	@Autowired
//	public LoginUserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	@Override
	public LoginUser loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = this.luserRepository.findByName(name);
		if (user == null) {
			throw new UsernameNotFoundException("ユーザが見つかりません");
		}
		return new LoginUser(user);
	}

    // ユーザー登録用のメソッドです
    public User register(SignupForm signupForm) {
        // Entityクラスのインスタンスを生成します
        User user = new User();
        // フィールドのセットを行います
        user.setName(signupForm.getName());
        // encode()メソッドの引数にハッシュ化したい文字列を渡すことでハッシュ化した値を返す
//        user.setPassword(signupForm.getPassword());
        user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
        user.setProfile(" ");
        user.setIcon(" ");
        // repository.saveメソッドを利用してデータの保存を行います
        return this.luserRepository.save(user);
    }
}