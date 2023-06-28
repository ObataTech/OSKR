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
@Table(name = "CATEGORIES")
public class Category {

	@Id
	@SequenceGenerator(name = "CATEGORIES_ID_GENERATOR", sequenceName = "CATEGORIES_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIES_ID_GENERATOR")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME", length = 45, nullable = false)
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @OneToMany(mappedBy = "category1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Filmwork> filmworks1;

    public List<Filmwork> getFilmworks1() {
        return this.filmworks1;
    }

    @OneToMany(mappedBy = "category2", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Filmwork> filmworks2;

    public List<Filmwork> getFilmworks2() {
        return this.filmworks2;
    }

    @OneToMany(mappedBy = "category3", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Filmwork> filmworks3;

    public List<Filmwork> getFilmworks3() {
        return this.filmworks3;
    }
}
