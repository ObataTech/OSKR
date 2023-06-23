package com.example.home;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Filmwork;

@Repository
public interface HomeFilmworkRepository extends JpaRepository<Filmwork, Long> {

//	@Query("SELECT f FROM Filmwok f WHERE f.id = ?1 ORDER BY f.releasedate DESC")
//	public Optional<Filmwork> findAllById(Long id);
	/**
	 * ３件分取得
	 */
	@Query("SELECT f FROM Filmwork f ORDER BY f.releasedate DESC")
	public List<Filmwork> getLatestThreetList();
}
