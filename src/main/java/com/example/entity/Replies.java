package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="REPLIES")
public class Replies {

	private Long id;
	private String content;
	private LocalDateTime posttime;
	private Long reviewId;
	private Long userId;
}
