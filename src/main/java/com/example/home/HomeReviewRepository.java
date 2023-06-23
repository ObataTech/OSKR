package com.example.home;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Review;

public interface HomeReviewRepository extends JpaRepository<Review, Long> {

	/**
	 * レビューを作品で絞って取得
	 * @param filmworkId　作品ID
	 * @return　作品のレビューリスト
	 */
	@Query("SELECT r FROM Review r WHERE r.filmworkId = ?1")
	public List<Review> getFindAllById(Long filmworkId);

	/**
	 * 該当する作品のレコード数をカウント
	 * @param id 作品ID
	 * @return レコード数合計
	 */
	public Optional<Long> countByFilmworkId(Long id);

	/**
	 * レビューの平均
	 * @param id 作品ID
	 * @return レビューの平均値
	 */
	@Query("SELECT avg(r.rate) FROM Review r WHERE r.filmworkId =?1 ")
	public Optional<Double> reviewAve(Long id);
}
