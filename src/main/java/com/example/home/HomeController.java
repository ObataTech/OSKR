package com.example.home;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Category;
import com.example.entity.Review;
import com.example.utility.FilmworkDetail;

@Controller
@RequestMapping("home")
public class HomeController {

	private final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	/**
	 * 画面表示
	 * @return 画面情報
	 */
	@GetMapping
	public String HomeList(Model model) {
		//一言レビュー
//		FilmworkDetail filmework = this.homeService.getFilmworkById((long) 1);
		List<Review> reviewList = this.homeService.listAllReviews((long)1);
		List<FilmworkDetail> latest = this.homeService.listLatest();
		List<FilmworkDetail> lineup = this.homeService.listAllFilmworks();
		//ジャンル
		List<Category> categories = this.homeService.listCategory();

		//画面に渡す
//		model.addAttribute("filmework", filmework);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("latest", latest);
		model.addAttribute("lineup", lineup);
		model.addAttribute("categories", categories);
		return "home/home";
	}
}
