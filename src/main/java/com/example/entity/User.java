package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@SequenceGenerator(name = "USERS_ID_GENERATOR", sequenceName = "USERS_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", length = 45, nullable = false)
	private String name;

	@Column(name = "PASSWORD", length = 45, nullable = false)
	private String password;

	@Column(name = "PROFILE", length = 200, nullable = true)
	private String profile;

	@Column(name = "ICON", length = 45, nullable = false)
	private String icon;

	// 追加
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    public List<Review> getReviews() {
        return this.reviews;
    }

	// 追加
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reply> replies;

    public List<Reply> getReplies() {
        return this.replies;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
