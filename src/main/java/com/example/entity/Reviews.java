package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="REVIEWS")
public class Reviews {

	private Long id;
	private String content;
	private Integer rate;
	private boolean spoiler;
	private LocalDateTime posttime;
	private Long userId;
	private Long filmworkId;

}
