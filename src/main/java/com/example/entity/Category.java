package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGOLIES")
public class Category {

	@Id
	@SequenceGenerator(name = "CATEGOLIES_ID_GENERATOR", sequenceName = "CATEGOLIES_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGOLIES_ID_GENERATOR")
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
}
