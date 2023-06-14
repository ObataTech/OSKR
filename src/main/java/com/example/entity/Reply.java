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
@Table(name = "RIPLIES")
public class Reply {

	@Id
	@SequenceGenerator(name = "RIPLIES_ID_GENERATOR", sequenceName = "RIPLIES_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RIPLIES_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "CONTENT", length = 45, nullable = false)
	private String content;

	@Column(name = "POSTTIME", nullable = false)
	private LocalDateTime posttime;

	@Column(name = "REVIEW_ID", nullable = false)
	private Long review_id;

	@Column(name = "USER_ID", nullable = false)
	private Long user_id;

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

	public LocalDateTime getPosttime() {
		return posttime;
	}

	public void setPosttime(LocalDateTime posttime) {
		this.posttime = posttime;
	}

	public Long getReview_id() {
		return review_id;
	}

	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
