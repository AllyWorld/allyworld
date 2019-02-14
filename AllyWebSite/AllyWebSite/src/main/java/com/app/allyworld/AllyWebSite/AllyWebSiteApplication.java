package com.app.allyworld.AllyWebSite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableOAuth2Sso
//@EnableWebSecurity
public class AllyWebSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllyWebSiteApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

