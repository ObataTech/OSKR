package com.example.filmwork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("filmwork")
public class FilmworkController {

	@GetMapping
	public String Filmwork() {
		return "filmworks/filmworks";
	}
}
