package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  private final LUserService luserService;

  @Autowired
  public LoginController(LUserService luserService) {
     this.luserService = luserService;
  }

	@GetMapping("/loginForm")
	public String getLogin(SignupForm signupForm) {
		return "loginForm";
	}

    @GetMapping("/signup")
    public String newSignup(SignupForm signupForm) {
    	return "login/loginForm";
    }

    @PostMapping("/signup")
    public String signup(SignupForm signupForm) {

    	this.luserService.register(signupForm);

    	return "login/loginForm";
    }
}