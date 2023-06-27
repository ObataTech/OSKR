package com.example.filmwork;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Filmwork;

@Service
public class FilmworkService {

    private final FilmworkRepository filmworkRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public FilmworkService(FilmworkRepository filmworkRepository, CategoryRepository categoryRepository) {
        this.filmworkRepository = filmworkRepository;
        this.categoryRepository = categoryRepository;
    }

    public Filmwork findById(Long id) {
        Optional<Filmwork> optionalFilmwork = this.filmworkRepository.findById(id);
        Filmwork filmwork  = optionalFilmwork.get();
        return filmwork;
    }
}
