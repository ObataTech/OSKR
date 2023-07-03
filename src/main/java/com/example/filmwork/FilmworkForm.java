package com.example.filmwork;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.example.entity.Category;
import com.example.entity.Filmwork;
import com.example.entity.Reply;
import com.example.entity.Review;


public class FilmworkForm {

	// 作品エンティティから取得

	private Long id;

	private String title;

	private String releasedate;

	private String thumbnail;

	private String summary;

	private String cast;

	private String director;

	private String category;

	private Integer category1Id;

    private Category category1;

	private Integer category2Id;

    private Category category2;

	private Integer category3Id;

    private Category category3;

	private String name;

	private String reviewContent;

	private Integer rate;

	private Integer spoiler;

	private LocalDateTime reviewPosttime;

	private Long filmworkId;

    private Filmwork filmwork;

//    private Integer reviewCnt;

    private String reviewCnt;

//    private Float rateAvg;
//    private BigDecimal rateAvg;

    private String rateAvg;

	private String replyContent;

	private LocalDateTime replyPosttime;

	private Long reviewId;

	private Long userId;

    private Review review;

    private List<Review> reviews;

    private List<Filmwork> filmworks1;

    private List<Filmwork> filmworks2;

    private List<Filmwork> filmworks3;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

    public Category getCategory1() {
        return this.category1;
    }

    public Category getCategory2() {
        return this.category2;
    }

    public Category getCategory3() {
        return this.category3;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getCategory1Id() {
		return category1Id;
	}

	public void setCategory1Id(Integer category1Id) {
		this.category1Id = category1Id;
	}

	public Integer getCategory2Id() {
		return category2Id;
	}

	public void setCategory2Id(Integer category2Id) {
		this.category2Id = category2Id;
	}

	public Integer getCategory3Id() {
		return category3Id;
	}

	public void setCategory3Id(Integer category3Id) {
		this.category3Id = category3Id;
	}

    public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
        return this.reviews;
    }

    private List<Review> nospoilerreviews;

    public void setNoSpoilerReviews(List<Review> nospoilerreviews) {
		this.nospoilerreviews = nospoilerreviews;
	}

	public List<Review> getNospoilerreviews() {
		return nospoilerreviews;
	}

	public void setNospoilerreviews(List<Review> nospoilerreviews) {
		this.nospoilerreviews = nospoilerreviews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<Filmwork> getFilmworks1() {
        return this.filmworks1;
    }

    public List<Filmwork> getFilmworks2() {
        return this.filmworks2;
    }

    public List<Filmwork> getFilmworks3() {
        return this.filmworks3;
    }

//    public Float getRateAvg() {
//		return rateAvg;
//	}

 //   public BigDecimal getRateAvg() {
//		return rateAvg;
//	}

    public String getRateAvg() {
		return rateAvg;
	}

//	public void setRateAvg(Float rateAvg) {
//		this.rateAvg = rateAvg;
//	}

//	public void setRateAvg(BigDecimal rateAvg) {
//		this.rateAvg = rateAvg;
//	}

	public void setRateAvg(String rateAvg) {
		this.rateAvg = rateAvg;
	}

//	public Integer getReviewCnt() {
//		return reviewCnt;
//	}

	public String getReviewCnt() {
		return reviewCnt;
	}

//	public void setReviewCnt(Integer reviewCnt) {
//		this.reviewCnt = reviewCnt;
//	}

	public void setReviewCnt(String reviewCnt) {
	this.reviewCnt = reviewCnt;
}

	public Filmwork getFilmwork() {
        return this.filmwork;
    }

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
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

	public LocalDateTime getReviewPosttime() {
		return reviewPosttime;
	}

	public void setReviewPosttime(LocalDateTime reviewPosttime) {
		this.reviewPosttime = reviewPosttime;
	}

	public Long getFilmworkId() {
		return filmworkId;
	}

	public void setFilmworkId(Long filmworkId) {
		this.filmworkId = filmworkId;
	}

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reply> replies;

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public List<Reply> getRiplies() {
        return this.replies;
    }

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public LocalDateTime getReplyPosttime() {
		return replyPosttime;
	}

	public void setReplyPosttime(LocalDateTime replyPosttime) {
		this.replyPosttime = replyPosttime;
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

    public Review getReview() {
        return this.review;
    }
}
