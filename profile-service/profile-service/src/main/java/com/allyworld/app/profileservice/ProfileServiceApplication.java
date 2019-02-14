package com.allyworld.app.profileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity
public class ProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

//	@Bean
//	public Queue sendRequestQ() {
//		return new Queue("newQ", false);
//	}

	

}
