package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {

	private Long id;
	private String name;
	private String password;
	private String profile;
	private String icon;
}
