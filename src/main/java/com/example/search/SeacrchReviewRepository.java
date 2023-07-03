package com.example.search;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Review;

public interface SeacrchReviewRepository extends JpaRepository<Review, Long> {


	public Optional<Long> countByFilmworkId(Long id);

	/**
	 * 総合評価を取得
	 * @return 少数ありの評価平均
	 */
	@Query("SELECT avg(r.rate) FROM Review r WHERE r.filmworkId =?1 ")
	public Optional<Double> reviewAve(Long id);
}
