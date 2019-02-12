package com.allyworld.app.friendservice;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FriendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendServiceApplication.class, args);
	}
	
	@Bean
	public Queue sendRequestQ() {
		return new Queue("newQ", false);
	}
	

}
