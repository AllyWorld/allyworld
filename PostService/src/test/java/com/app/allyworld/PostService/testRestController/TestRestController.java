package com.app.allyworld.PostService.testRestController;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.allyworld.PostService.entity.Comments;
import com.app.allyworld.PostService.entity.Likes;
import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.exceptions.InvalidInputException;
import com.app.allyworld.PostService.resource.PostSeviceResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestController {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testOfWrongURL() throws Exception {
		ResponseEntity<PostSeviceResource> responseEntity = testRestTemplate.getForEntity("/post",
				PostSeviceResource.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void testOfBadRequest() throws Exception {
		ResponseEntity<PostSeviceResource> responseEntity = testRestTemplate.getForEntity("/posts/deep",
				PostSeviceResource.class);
		assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
	}

	@Test
	public void testOfGetPostByProfileIdExists() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/posts/1", String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test // ( expected =InvalidInputException.class )
	public void testOfGetPostByProfileIdNotExists() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/posts/1000", String.class);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}

	@Test
	public void testOfaddNewPost() throws Exception {
		List<Integer> likes = new ArrayList<>();
		likes.add(1);
		likes.add(2);
		List<Integer> comments = new ArrayList<>();
		comments.add(1);
		comments.add(2);
		comments.add(3);
		Post post = new Post(/* 100, */ 1, "Feeling Excited!!", "http://localhost:8888.image.com", /* LocalDateTime.now(), */
				new Likes(1000, likes), new Comments(comments, "wow..nice!!"/* , LocalDateTime.now() */, 10));
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/posts", post, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void testOfUpdatePost() throws Exception {
		List<Integer> likes = new ArrayList<>();
		likes.add(1);
		likes.add(2);
		List<Integer> comments = new ArrayList<>();
		comments.add(1);
		comments.add(2);
		comments.add(3);
		Post post = new Post(/* 100, */ 1, "Feeling Happy!!", "http://localhost:8888.image.com", /* LocalDateTime.now(), */
				new Likes(1000, likes), new Comments(comments, "wow..nice!!", /* LocalDateTime.now(), */ 10));
		testRestTemplate.put("/posts", post);
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/posts", post, String.class);
		assertEquals("Feeling Happy!!", post.getStatus());
	}

	@Test
	public void testOfGetAllPostsExists() throws Exception {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/posts", String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
