package com.example.mypage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Review;
import com.example.entity.User;
import com.example.form.UserForm;

@Controller
@RequestMapping("mypage")
public class MypageController {
	private final MypageService mypageService;

	//コンストラクタインジェクション
	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}

	@GetMapping
	public String Mypage() {
		return "mypage/mypage";
	}

	// 一覧の表示
	@GetMapping("/{id}")
	public String index(@PathVariable("id") Long id, Model Model, UserForm userForm) {
		Optional<User> user = this.mypageService.loadUserByUsername(id);
		List<Review> review = this.mypageService.loadReviewByUser(id);

		userForm.setName(user.get().getName());
		userForm.setProfile(user.get().getProfile());

		Model.addAttribute("reviewList", review);
		Model.addAttribute("user", user.get());
		Model.addAttribute("aa", "test");
		Model.addAttribute("userForm", userForm);
		return "mypage/mypage";

	}

	// レビュー削除の実行
	@PostMapping("/sakujo/{id}")
	public String sakujo(@PathVariable("id") Long id, @RequestParam("userId") Long userId) {
		// 処理を追加
		this.mypageService.deleteReviewByUser(id);
		return "redirect:/mypage/" + userId.toString();
	}

	/**
	 * ユーザ情報更新
	 * @param id ユーザID
	 * @param userForm ユーザフォーム
	 * @return マイページにリダイレクト
	 */
	@PostMapping("/edit/{id}")
	public String editName(@PathVariable("id") Long id, @ModelAttribute("userForm") UserForm userForm) {
		this.mypageService.editUser(id, userForm);

		//画面に返す
		return "redirect:/mypage/"+ id;
	}
}
