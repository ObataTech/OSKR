package com.example.entity;

import java.util.Date;
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

@Entity
@Table(name = "FILMWORKS")
public class Filmwork {
	@Id
	@SequenceGenerator(name = "FILMWORKS_ID_GENERATOR", sequenceName = "FILMWORKS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILMWORKS_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITLE", length = 45, nullable = false)

	private String title;

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
	private Integer category1Id;

    @ManyToOne
    @JoinColumn(name = "category1_id", insertable = false, updatable = false)
    private Category category1;

    public Category getCategory1() {
        return this.category1;
    }

	@Column(name = "CATEGORY2_ID", nullable = true)
	private Integer category2Id;

    @ManyToOne
    @JoinColumn(name = "category2_id", insertable = false, updatable = false)
    private Category category2;

    public Category getCategory2() {
        return this.category2;
    }

	@Column(name = "CATEGORY3_ID", nullable = true)
	private Integer category3Id;

    @ManyToOne
    @JoinColumn(name = "category3_id", insertable = false, updatable = false)
    private Category category3;

    public Category getCategory3() {
        return this.category3;
    }

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

    @OneToMany(mappedBy = "filmwork", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return this.reviews;
    }

    @OneToMany(mappedBy = "filmwork", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> nospoilerreviews;

    public List<Review> getNoSpoilerReviews() {
        return this.nospoilerreviews;
    }


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
