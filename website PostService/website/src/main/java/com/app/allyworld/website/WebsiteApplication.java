package com.app.allyworld.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/* @EnableOAuth2Sso */ 
public class WebsiteApplication /* extends WebSecurityConfigurerAdapter */{

	public static void main(String[] args) {
		SpringApplication.run(WebsiteApplication.class, args);
	}
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**",
	 * "/webjars/**", "/error**").permitAll() .anyRequest().authenticated(); }
	 */

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

