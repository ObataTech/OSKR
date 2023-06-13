package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class Categories {

	private Integer id;
	private String name;
}
