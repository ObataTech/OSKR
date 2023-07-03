package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // TODO 一時的にSpringSecurityによる認証を無効化
@SpringBootApplication
public class OskrApplication {

	public static void main(String[] args) {
		SpringApplication.run(OskrApplication.class, args);
	}
}
