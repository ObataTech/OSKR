package com.example.home;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.entity.Filmwork;
import com.example.entity.Review;
import com.example.utility.FilmworkDetail;

@Service
public class HomeService {

	private final HomeReviewRepository homeReviewRepository;
	private final HomeFilmworkRepository homeFilmworkRepository;
	private final HomeCategoryRepository homeCategoryRepository;

	@Autowired
	public HomeService(HomeFilmworkRepository homeFilmworkRepository
					,HomeReviewRepository homeReviewRepository
					,HomeCategoryRepository homeCategoryRepository) {
		this.homeFilmworkRepository = homeFilmworkRepository;
		this.homeReviewRepository = homeReviewRepository;
		this.homeCategoryRepository = homeCategoryRepository;
	}


	public FilmworkDetail getFilmworkById(Long id){
		Optional<Filmwork> filmwork = this.homeFilmworkRepository.findAllById(id);

		FilmworkDetail filmworkDetail = new FilmworkDetail();
		//作品情報
		filmworkDetail.setId(filmwork.get().getId());
		filmworkDetail.setTitle(filmwork.get().getTitle());
		filmworkDetail.setReleasedate(filmwork.get().getReleasedate());
		filmworkDetail.setThumbnail("/images/"+filmwork.get().getThumbnail()+".png");
		filmworkDetail.setSummary(filmwork.get().getSummary());
		filmworkDetail.setCast(filmwork.get().getCast());
		filmworkDetail.setCategory1Id(filmwork.get().getCategory1Id());
		filmworkDetail.setCategory2Id(filmwork.get().getCategory2Id());
		filmworkDetail.setCategory3Id(filmwork.get().getCategory3Id());

		//レビュー数
		Optional<Long> review=this.homeReviewRepository.countByFilmworkId(filmwork.get().getId());
		if(review.isPresent()) {
			filmworkDetail.setReviewSum(review.get());
		}
		//総合評価
		Optional<Double> rate = this.homeReviewRepository.reviewAve(filmwork.get().getId());
		if(rate.isPresent()) {
			filmworkDetail.setRateAve(rate.get());
		}

		return filmworkDetail;
	}
	/**
	 * レビューを取得
	 */
	public List<Review> listAllReviews(Long filmworkId){
		return this.homeReviewRepository.getFindAllById(filmworkId);
	}

	/**
	 * 作品一覧を取得
	 */
	public List<FilmworkDetail> listAllFilmworks(){
		return listFilmwork(this.homeFilmworkRepository.findAll());
	}


	/**
	 * 最新作品情報を取得
	 * @return 最新映画3件のリスト
	 */
	public List<FilmworkDetail> listLatest (){
		List<Filmwork> filmworkList = this.homeFilmworkRepository.getLatestThreetList();
		List<Filmwork> ThreeList  = new ArrayList<Filmwork>(filmworkList.subList(0, 3));

		return listFilmwork(ThreeList);
	}


	/**
	 * レビューレコード数、総合評価の取得し全体リストの作成
	 * @param filmworksList
	 * @return
	 */
	public List<FilmworkDetail> listFilmwork(List<Filmwork> filmworksList){
		List<FilmworkDetail> filmworkList = new ArrayList<FilmworkDetail>();
		filmworksList.forEach(filmwork->{
			FilmworkDetail filmworkDetail = new FilmworkDetail();

			//作品情報
			filmworkDetail.setId(filmwork.getId());
			filmworkDetail.setTitle(filmwork.getTitle());
			filmworkDetail.setReleasedate(filmwork.getReleasedate());
			filmworkDetail.setThumbnail("/images/"+filmwork.getThumbnail()+".png");
			filmworkDetail.setSummary(filmwork.getSummary());
			filmworkDetail.setCast(filmwork.getCast());
			filmworkDetail.setCategory1Id(filmwork.getCategory1Id());
			filmworkDetail.setCategory2Id(filmwork.getCategory2Id());
			filmworkDetail.setCategory3Id(filmwork.getCategory3Id());

			//レビュー数
			Optional<Long> review=this.homeReviewRepository.countByFilmworkId(filmwork.getId());
			if(review.isPresent()) {
				filmworkDetail.setReviewSum(review.get());
			}
			//総合評価
			Optional<Double> rate = this.homeReviewRepository.reviewAve(filmwork.getId());
			if(rate.isPresent()) {
				filmworkDetail.setRateAve(rate.get());
			}

			//リストに追加
			filmworkList.add(filmworkDetail);
		});

		return filmworkList;
	}

	/**
	 * ジャンル一覧取得
	 */
	public List<Category> listCategory(){
		return this.homeCategoryRepository.findAll();
	}
}
