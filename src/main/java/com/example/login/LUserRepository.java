package com.example.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface LUserRepository extends JpaRepository<User, Long> {
	public User findByName(String name);
}
