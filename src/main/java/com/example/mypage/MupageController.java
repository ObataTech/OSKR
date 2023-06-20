package com.example.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage")
public class MupageController {

	@GetMapping
	public String Mypage() {
		return "mypage/mypage";
	}
}
