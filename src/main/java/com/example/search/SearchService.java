package com.example.search;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Filmwork;
import com.example.entity.Review;
import com.example.utility.FilmworkDetail;

@Service
public class SearchService {

	private SearchRepository searchRepository;
	private SeacrchReviewRepository searchReviewRepository;

	@Autowired
	public SearchService(SearchRepository searchRepository,SeacrchReviewRepository searchReviewRepository) {
		this.searchRepository = searchRepository;
		this.searchReviewRepository = searchReviewRepository;
	}

	public List<FilmworkDetail> listAll(){
		return listFilmwork(this.searchRepository.findAll());
	}

	//検索欄から検索
	public List<FilmworkDetail> listAllKeyword(String keyword){
		return listFilmwork(this.searchRepository.searchKeyword(keyword));


	}

	//製作年から検索
	public List<FilmworkDetail> listAllYear(String year){
		String start = year + "-01-01";
		String end   = year + "-12-31";
		SimpleDateFormat formatter = new SimpleDateFormat("yy-MM-dd");
		try {
			Date startDate = formatter.parse(start);
			Date endDate = formatter.parse(end);
			return listFilmwork(this.searchRepository.searchYear(startDate,endDate));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	//ジャンル検索
	public List<FilmworkDetail> listAllCategory(String category){
		return listFilmwork(this.searchRepository.searchCategory(category));
	}


	/*
	 * レビューレコード数、総合評価の取得し全体リストの作成
	 * List FilmworkEntityのList
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
			Optional<Long> review=this.searchReviewRepository.countByFilmworkId(filmwork.getId());
			if(review.isPresent()) {
				filmworkDetail.setReviewSum(review.get());
			}
			//総合評価
			Optional<Double> rate = this.searchReviewRepository.reviewAve(filmwork.getId());
			if(rate.isPresent()) {
				BigDecimal bd = new BigDecimal(rate.get());
				bd = bd.setScale(1,RoundingMode.HALF_UP);
				filmworkDetail.setRateAve(bd.doubleValue());
			}

			//リストに追加
			filmworkList.add(filmworkDetail);
		});

		return filmworkList;
	}

}
