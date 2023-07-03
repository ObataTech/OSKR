package com.example.home;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.entity.Filmwork;
import com.example.entity.Review;
import com.example.login.LoginUser;
import com.example.utility.FilmworkDetail;

@Service
public class HomeService {

	private final HomeReviewRepository homeReviewRepository;
	private final HomeFilmworkRepository homeFilmworkRepository;
	private final HomeCategoryRepository homeCategoryRepository;

	@Autowired
	public HomeService(HomeFilmworkRepository homeFilmworkRepository, HomeReviewRepository homeReviewRepository,
			HomeCategoryRepository homeCategoryRepository) {
		this.homeFilmworkRepository = homeFilmworkRepository;
		this.homeReviewRepository = homeReviewRepository;
		this.homeCategoryRepository = homeCategoryRepository;
	}
/**
 * 一言レビュー作品
 * @return
 */
	public FilmworkDetail getFilmwork() {
		//一言レビューの作品をランダムで決める
		//作品のレコード数をカウント
		Long cnt = this.homeFilmworkRepository.count();
		Random random = new Random();
		//乱数を絶対値で取得し、作品数分に制限、0から始まるので＋１にする
		Long number = Math.abs(random.nextLong())%cnt + 1;
		Optional<Filmwork> filmwork = this.homeFilmworkRepository.findById(number);

		return detail(filmwork.get());

	}

	/**
	 * バリデーションエラー時の作品取得
	 * @param id 作品ID
	 * @return 作品情報
	 */
	public FilmworkDetail getFilmworkValidation(Long id) {
		Optional<Filmwork> filmwork = this.homeFilmworkRepository.findById(id);

		return detail(filmwork.get());
	}
	/**
	 * レビュー投稿保存
	 * @param review
	 */
	public void saveReview(Long id,Review review,LoginUser loginUser) {

		//レビュー情報の補足
		review.setFilmworkId(id);
		review.setPosttime(LocalDateTime.now());
		review.setRate(3);//評価は3固定
		review.setSpoiler(0);//ネタバレあり固定
        if(loginUser.getUser() != null) {
        	review.setUserId(loginUser.getUser().getId());
        }

		this.homeReviewRepository.save(review);
	}
	/**
	 * レビューを取得
	 */
	public List<Review> listAllReviews(Long filmworkId) {
		return this.homeReviewRepository.getFindAllById(filmworkId);
	}

	/**
	 * 作品一覧を取得
	 */
	public List<FilmworkDetail> listAllFilmworks() {
		return listFilmwork(this.homeFilmworkRepository.getLatestList());
	}

	/**
	 * 最新作品情報を取得
	 * @return 最新映画3件のリスト
	 */
	public List<FilmworkDetail> listLatest() {
		List<Filmwork> filmworkList = this.homeFilmworkRepository.getLatestList();
		List<Filmwork> ThreeList = new ArrayList<Filmwork>(filmworkList.subList(0, 3));

		return listFilmwork(ThreeList);
	}

	/**
	 * 全体リストの作成
	 * @param filmworksList
	 * @return
	 */
	public List<FilmworkDetail> listFilmwork(List<Filmwork> filmworksList) {
		List<FilmworkDetail> filmworkList = new ArrayList<FilmworkDetail>();
		filmworksList.forEach(filmwork -> {
			//リストに追加
			filmworkList.add(detail(filmwork));
		});

		return filmworkList;
	}

	/**
	 * レビューレコード数、総合評価の取得
	 * @param filmwork 作品情報
	 * @return レビュー数と評価を含めたデータ
	 */
	public FilmworkDetail detail(Filmwork filmwork) {
		FilmworkDetail filmworkDetail = new FilmworkDetail();
		//作品情報
		filmworkDetail.setId(filmwork.getId());
		filmworkDetail.setTitle(filmwork.getTitle());
		filmworkDetail.setReleasedate(filmwork.getReleasedate());
		filmworkDetail.setThumbnail("/images/" + filmwork.getThumbnail() + ".png");
		filmworkDetail.setSummary(filmwork.getSummary());
		filmworkDetail.setCast(filmwork.getCast());
		filmworkDetail.setCategory1Id(filmwork.getCategory1Id());
		filmworkDetail.setCategory2Id(filmwork.getCategory2Id());
		filmworkDetail.setCategory3Id(filmwork.getCategory3Id());

		//レビュー数
		Optional<Long> review = this.homeReviewRepository.countByFilmworkId(filmwork.getId());
		if (review.isPresent()) {
			filmworkDetail.setReviewSum(review.get());
		}

		//総合評価
		Optional<Double> rate = this.homeReviewRepository.reviewAve(filmwork.getId());
		if (rate.isPresent()) {
			BigDecimal bd = new BigDecimal(rate.get());
			bd = bd.setScale(1,RoundingMode.HALF_UP);
			filmworkDetail.setRateAve(bd.doubleValue());
		}

		return filmworkDetail;
	}

	/**
	 * ジャンル一覧取得
	 */
	public List<Category> listCategory() {
		return this.homeCategoryRepository.findAll();
	}
}
