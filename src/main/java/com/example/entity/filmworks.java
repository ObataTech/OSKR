package com.example.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FILMWORKS")
public class filmworks {

	private Long id;
	private String title;
	private LocalDate date;
	private String thumbnail;
	private String cast;
	private String director;
	private Long category1Id;
	private Long category2Id;
	private Long category3Id;
}
