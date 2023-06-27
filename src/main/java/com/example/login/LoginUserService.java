package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.filmwork.UserRepository;

@Service
public class LoginUserService implements UserDetailsService{
	private final UserRepository userRepository;

	@Autowired
	public LoginUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public LoginUser loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = this.userRepository.findByName(name);
		if (user == null) {
			throw new UsernameNotFoundException("ユーザが見つかりません");
		}

//		System.out.println("============================");
//		System.out.println("============================");
//		System.out.println(user.getName());
//		System.out.println(user.getPassword());
//		System.out.println("============================");
//		System.out.println("============================");

		return new LoginUser(user);
	}
}