package com.app.allyworld.NewsFeedService.testRestController;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestController {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	
	@Test
	public void testOfWrongURL() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/newsFeeds",String.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void testOfBadRequest() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/newsfeed/hello",String.class);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void testOfGetAllNewsFeedByProfileIdExists() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/newsfeed/1", String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test // ( expected =InvalidInputException.class )
	public void testOfGetPostByProfileIdNotExists() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/newsfeed/1000", String.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
