package com.example.filmwork;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Filmwork;

@Repository
public interface FilmworkRepository extends JpaRepository<Filmwork, Long> {

}