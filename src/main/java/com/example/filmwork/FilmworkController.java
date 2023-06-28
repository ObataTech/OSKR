package com.example.filmwork;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.entity.Category;
import com.example.entity.Filmwork;
import com.example.entity.Review;
import com.example.login.LoginUser;

@Controller
@RequestMapping("filmwork")
public class FilmworkController {

    private final FilmworkService filmworkService;
    private final CategoryService categoryService;
    private final ReviewService reviewService;
    private final ReplyService replyService;
//    private final UserService userService;

    @Autowired
    public FilmworkController(FilmworkService filmworkService, CategoryService categoryService, ReviewService reviewService, ReplyService replyService, UserService userService) {
        this.filmworkService = filmworkService;
        this.categoryService = categoryService;
        this.reviewService = reviewService;
        this.replyService = replyService;
  //      this.userService = userService;
    }

	@GetMapping
	public String Filmwork() {
		return "filmworks/filmworks";
	}

    @PostMapping("/reviewtoroku/{id}")
    public String postReview(@PathVariable Integer id, FilmworkForm filmworkForm, Model model, @AuthenticationPrincipal LoginUser loginUser) {
        this.reviewService.save(filmworkForm, loginUser);
//        System.out.println("======" + filmworkForm.getRate() + "========");

        // 登録成功のメッセージを格納
 //       ra.addFlashAttribute("success_message", "登録に成功しました");

        return "redirect:/filmwork/" + id.toString();
//         return this.filmworkPage(id, model, filmworkForm);
    }

    @PostMapping("/replytoroku/{id}")
    public String postReply(@PathVariable Integer id, FilmworkForm filmworkForm, Model model, @AuthenticationPrincipal LoginUser loginUser) {
        this.replyService.save(filmworkForm, loginUser);

        return "redirect:/filmwork/" + id.toString();
 //       return this.filmworkPage(id, model, filmworkForm);
    }

    // 作品ページ
    @GetMapping("/{id}")
    public String filmworkPage(@PathVariable("id") Long id, Model model
                             , @ModelAttribute("filmworkForm") FilmworkForm filmworkForm, @ModelAttribute("message") String message
                             , UriComponentsBuilder builder) {

    	// FilmworkのEntityクラスのインスタンスをidより検索し取得する
        Filmwork filmwork = this.filmworkService.findById(id);

        // 作品ID/タイトル/あらすじ/監督/キャストをセットする
        filmworkForm.setFilmworkId(filmwork.getId());
        filmworkForm.setTitle(filmwork.getTitle());
        filmworkForm.setSummary(filmwork.getSummary());
        filmworkForm.setDirector(filmwork.getDirector());
        filmworkForm.setCast(filmwork.getCast());

        // 作品画像をセットする
        String thumbnailPass = "/images/" + filmwork.getThumbnail() + ".png";
        filmworkForm.setThumbnail(thumbnailPass);

        // 作品カテゴリーをセットする
        String strCategory = "";
        if (filmwork.getCategory1Id() != null) {
        	Category category1 = this.categoryService.findById(filmwork.getCategory1Id());
        	strCategory = category1.getName();
        	if (filmwork.getCategory2Id() != null) {
            	Category category2 = this.categoryService.findById(filmwork.getCategory2Id());
            	strCategory += "・" + category2.getName();
            	if (filmwork.getCategory3Id() != null) {
                	Category category3 = this.categoryService.findById(filmwork.getCategory3Id());
                	strCategory += "・" + category3.getName();
            	}
        	}
        }
        filmworkForm.setCategory(strCategory);

        // 公開日をセットする
        // SimpleDateFormat により任意フォーマットに整形
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年 MM月 dd日");
        String strReleaseDate = sdf.format(filmwork.getReleasedate());
        filmworkForm.setReleasedate(strReleaseDate);

        // レビュー数をセットする
        Integer reviewCnt = this.reviewService.reviewCnt(id);
        filmworkForm.setReviewCnt(reviewCnt);

        // 総合評価(平均)をセットする
        BigDecimal bd;
        Float rateAvg = this.reviewService.rateAvg(id);
        if (rateAvg != null) {
        	bd = new BigDecimal(rateAvg);
        	bd = bd.setScale(1, RoundingMode.HALF_UP);
        	filmworkForm.setRateAvg(bd);
        }
//        filmworkForm.setRateAvg(rateAvg);

        // レビューをセットする
 //       filmworkForm.setReviews(filmwork.getReviews());
        List<Review> reviews = this.reviewService.findReviews(id);
        filmworkForm.setReviews(reviews);

        List<Review> nospoilerreviews = this.reviewService.findNoSpoilerReviews(id, 1);
        filmworkForm.setNoSpoilerReviews(nospoilerreviews);

        // レビュー者名をセットする
//        List<User> listUser = new ArrayList<User>();
 //       for (Review review : filmwork.getReviews()) {
//        	List<Reply> listReply = this.replyService.findReplies(review.getId());
//        	filmworkForm.setReplies(listReply);
//        	listUser.add(userService.findById(review.getUserId()));
 //       }

        // リプライをセットする
//        for (Review review : filmwork.getReviews()) {
//        	List<Reply> listReply = this.replyService.findReplies(review.getId());
 //       	filmworkForm.setReplies(listReply);
  //      }

        // idをセットする
        model.addAttribute("id", id);
//        model.addAttribute("message",message);

        // 作品ページを表示する
//        URI location = builder.path("/filmwork/" + id.toString()).build().toUri();

//        return location.toString();
 //       return "/filmwork/" + id.toString();
        return "filmworks/filmworks";
    }
}