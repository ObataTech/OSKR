package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  private final LoginUserService loginUserService;

  @Autowired
  public LoginController(LoginUserService loginUserService) {
     this.loginUserService= loginUserService;
  }

	@GetMapping("/loginForm")
	public String getLogin(SignupForm signupForm) {
		return "login/loginForm";
	}

//    @GetMapping("/signup/")
//    public String NewSignup(SignupForm signupForm) {
 //   	return "login/loginForm";
 //   }

    @PostMapping("login/signup")
    public String newSignup(SignupForm signupForm) {

    	this.loginUserService.register(signupForm);

    	return "login/loginForm";
    }
}