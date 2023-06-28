package com.example.mypage;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;


@Repository
public interface MypageUserRepository extends JpaRepository<User, Long> {
    // ユーザー名と一致するユーザを取得する
    public Optional<User> findById(Long id);
}