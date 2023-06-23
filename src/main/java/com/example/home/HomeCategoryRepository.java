package com.example.home;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Category;

public interface HomeCategoryRepository extends JpaRepository<Category, Long> {

}
