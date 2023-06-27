package com.example.mypage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Review;
import com.example.entity.User;
import com.example.service.LoginUserService;
import com.example.service.ReviewService;

@Controller
@RequestMapping("mypage")
public class MypageController {
private final LoginUserService loginUserService;
private final ReviewService reviewService;

//コンストラクタインジェクション
@Autowired
public MypageController(LoginUserService loginUserService, ReviewService reviewService) {
    this.loginUserService = loginUserService;
    this.reviewService = reviewService;
}

	@GetMapping
	public String Mypage() {
		return "mypage/mypage";
	}

    // 一覧の表示
    @GetMapping("/{id}")
    public String index(@PathVariable("id")Long id ,Model Model) {
    	Optional<User> user = this.loginUserService.loadUserByUsername(id);
    	List<Review> review = this.reviewService.loadReviewByUser(id);
    Model.addAttribute("reviewList", review);
    Model.addAttribute("user", user.get());
    	return "mypage/mypage";

    }

    // レビュー削除の実行
    @PostMapping("/sakujo/{id}")
    public String sakujo(@PathVariable("id") Long id ,@RequestParam("userId") Long userId) {
        // 処理を追加
    	reviewService.deleteReviewByUser (id);
        return "redirect:/mypage/" + userId.toString();
    }


}
