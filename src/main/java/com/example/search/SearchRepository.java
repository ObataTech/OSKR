package com.example.search;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Filmwork;

public interface SearchRepository extends JpaRepository<Filmwork, Long> {

    /**
     * 作品情報キーワード検索クエリ
     *
     * @param keyword 検索キーワード
     * @return 作品情報のリスト
     */
	@Query("SELECT f FROM Filmwork f WHERE f.title LIKE %?1% ORDER BY f.releasedate DESC")
	public List<Filmwork> searchKeyword(String keyword);


	/**
	 * 製作年検索
	 */
	@Query ("SELECT f FROM Filmwork f WHERE f.releasedate BETWEEN ?1 AND ?2 ORDER BY f.releasedate DESC")
	public List<Filmwork> searchYear(Date start,Date end);

	/**
	 * ジャンル検索
	 */
	@Query("SELECT f FROM Filmwork f "
			+ "LEFT JOIN Category c1 ON f.category1Id = c1.id "
			+ "LEFT JOIN Category c2 ON f.category2Id = c2.id "
			+ "LEFT JOIN Category c3 ON f.category3Id = c3.id "
			+ "WHERE c1.name = ?1 OR c2.name = ?1 OR c3.name = ?1")
	public List<Filmwork> searchCategory(String category);

}
