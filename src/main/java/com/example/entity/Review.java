package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWS")
public class Review {

	@Id
	@SequenceGenerator(name = "REVIEWS_ID_GENERATOR", sequenceName = "REVIEWS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEWS_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "CONTENT", length = 200, nullable = false)
	private String content;

	@Column(name = "RATE", nullable = false)
	private Integer rate;

	@Column(name = "SPOILER", nullable = false)
	private Long spoiler;

	@Column(name = "POSTTIME", nullable = false)
	private LocalDateTime posttime;

	@Column(name = "USER_ID", nullable = false)
	private Long user_id;

	@Column(name = "FILMWORK_ID", nullable = false)
	private Long filmwork_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Long getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Long spoiler) {
		this.spoiler = spoiler;
	}

	public LocalDateTime getPosttime() {
		return posttime;
	}

	public void setPosttime(LocalDateTime posttime) {
		this.posttime = posttime;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getFilmwork_id() {
		return filmwork_id;
	}

	public void setFilmwork_id(Long filmwork_id) {
		this.filmwork_id = filmwork_id;
	}
}
