package com.example.utility;

import java.util.Date;

public class FilmworkDetail {

//	作品ID
	private Long id;
//	作品タイトル
	private String title;
//	作品公開
	private Date releasedate;
//	作品サムネイル
	private String thumbnail;
//	作品あらすじ
	private String summary;
//	作品キャスト
	private String cast;
//	作品監督
	private String director;
//	作品カテゴリ
	private Integer category1Id;
	private Integer category2Id;
	private Integer category3Id;
//	合計レビュー数
	private Long reviewSum;
//	総合評価
	private Double rateAve;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
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
	public Long getReviewSum() {
		return reviewSum;
	}
	public void setReviewSum(Long reviewSum) {
		this.reviewSum = reviewSum;
	}
	public Double getRateAve() {
		return rateAve;
	}
	public void setRateAve(Double rateAve) {
		this.rateAve = rateAve;
	}


}
