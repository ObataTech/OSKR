package com.example.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "REVIEWS")
public class Review {

	@NotNull
	@Id
	@SequenceGenerator(name = "REVIEWS_ID_GENERATOR", sequenceName = "REVIEWS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEWS_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@NotNull
	@NotBlank(message="空白での投稿は許可されてません")
	@Size(max=200,message="200文字以内で入力してください")
	@Column(name = "CONTENT", length = 200, nullable = false)
	private String content;

	@NotNull
	@Column(name = "RATE", nullable = false)
	private Integer rate;

	@NotNull
	@Column(name = "SPOILER", nullable = false)
	private Integer spoiler;

	@NotNull
	@Column(name = "POSTTIME", nullable = false)
	private LocalDateTime posttime;

	@NotNull
	@Column(name = "USER_ID", nullable = false)
	private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    public User getUser() {
        return this.user;
    }

	@Column(name = "FILMWORK_ID", nullable = false)
	private Long filmworkId;

    @ManyToOne
    @JoinColumn(name = "filmwork_id", insertable = false, updatable = false)
    private Filmwork filmwork;

    public Filmwork getFilmwork() {
        return this.filmwork;
    }


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

	public Integer getSpoiler() {
		return spoiler;
	}

	public void setSpoiler(Integer spoiler) {
		this.spoiler = spoiler;
	}

	public LocalDateTime getPosttime() {
		return posttime;
	}

	public void setPosttime(LocalDateTime posttime) {
		this.posttime = posttime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFilmworkId() {
		return filmworkId;
	}

	public void setFilmworkId(Long filmworkId) {
		this.filmworkId = filmworkId;
	}

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reply> replies;

    public List<Reply> getRiplies() {
        return this.replies;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    public User getUser() {
        return this.user;
    }

}
