package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "REPLIES")
public class Reply {

	@Id
	@SequenceGenerator(name = "REPLIES_ID_GENERATOR", sequenceName = "REPLIES_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPLIES_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "CONTENT", length = 45, nullable = false)
	private String content;

	@Column(name = "POSTTIME", nullable = false)
	private LocalDateTime posttime;

	@Column(name = "REVIEW_ID", nullable = false)
	private Long reviewId;

	@Column(name = "USER_ID", nullable = false)
	private Long userId;

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

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

    @ManyToOne
    @JoinColumn(name = "review_id", insertable = false, updatable = false)
    private Review review;

    public Review getReview() {
        return this.review;
    }
}
