package com.example.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entity.Category;
import com.example.entity.Review;
import com.example.login.LoginUser;
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
	public String HomeList(Model model,@ModelAttribute("validationError") String validationError) {
		//一言レビュー
		FilmworkDetail filmwork = this.homeService.getFilmwork();
		List<Review> reviewList = this.homeService.listAllReviews((long)1);
		List<FilmworkDetail> latest = this.homeService.listLatest();
		List<FilmworkDetail> lineup = this.homeService.listAllFilmworks();
		//レビュー投稿
		Review postReview = new Review();

		//ジャンル
		List<Category> categories = this.homeService.listCategory();

		//画面に渡す
		model.addAttribute("filmwork", filmwork);
		model.addAttribute("postReview", postReview);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("latest", latest);
		model.addAttribute("lineup", lineup);
		model.addAttribute("categories", categories);
		return "home/home";
	}

	/**
	 *
	 * @param review 投稿
	 * @return　Home画面
	 */
	@PostMapping("/save")
	public String reviewPost(@RequestParam("id") Long id,@Validated Review review, BindingResult result,Model model,RedirectAttributes ra,@AuthenticationPrincipal LoginUser loginUser) {

		if(result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for(ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			ra.addFlashAttribute("validationError",errorList);
			return "redirect:/home";
		}
		this.homeService.saveReview(id,review,loginUser);

		return "redirect:/home";
	}
}
