package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FILMWORKS")
public class Filmwork {
	@Id
	@SequenceGenerator(name = "FILMWORKS_ID_GENERATOR", sequenceName = "FILMWORKS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILMWORKS_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "RELEASEDATE", nullable = false)
	private Date releasedate;

	@Column(name = "THUMBNAIL", length = 45, nullable = false)
	private String thumbnail;

	@Column(name = "SUMMARY", length = 300, nullable = false)
	private String summary;

	@Column(name = "CAST", length = 45, nullable = false)
	private String cast;

	@Column(name = "DIRECTOR", length = 45, nullable = false)
	private String director;

	@Column(name = "CATEGORY1_ID", nullable = true)
	private Long category1_id;

	@Column(name = "CATEGORY2_ID", nullable = true)
	private Long category2_id;

	@Column(name = "CATEGORY3_ID", nullable = true)
	private Long category3_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCategory1_id() {
		return category1_id;
	}

	public void setCategory1_id(Long category1_id) {
		this.category1_id = category1_id;
	}

	public Long getCategory2_id() {
		return category2_id;
	}

	public void setCategory2_id(Long category2_id) {
		this.category2_id = category2_id;
	}

	public Long getCategory3_id() {
		return category3_id;
	}

	public void setCategory3_id(Long category3_id) {
		this.category3_id = category3_id;
	}
}
