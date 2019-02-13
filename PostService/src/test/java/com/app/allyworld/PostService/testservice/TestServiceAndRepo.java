package com.app.allyworld.PostService.testservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.allyworld.PostService.entity.Comments;
import com.app.allyworld.PostService.entity.Likes;
import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.exceptions.InvalidInputException;
import com.app.allyworld.PostService.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceAndRepo {

	@Autowired
	private PostService postServiceImpl;
	private Post post;

	@Before
	public void setup() {
		List<Integer> likes = new ArrayList<>();
		likes.add(1);
		likes.add(2);
		List<Integer> comments = new ArrayList<>();
		comments.add(1);
		comments.add(2);
		comments.add(3);
		post = new Post(/* 100, */1, "Feeling Excited!!", "http://localhost:8888.image.com", /* LocalDateTime.now(), */
				new Likes(1000, likes), new Comments(comments, "wow..nice!!"/* , LocalDateTime.now() */, 10));
		// postServiceImpl.addNewPost(post);
	}

	@Test
	public void testAddNewPost() throws InvalidInputException {
		postServiceImpl.addNewPost(post);
	}

	@Test(expected = InvalidInputException.class)
	public void testAddNewPostWithInvalidData() throws InvalidInputException {
		Post post = new Post();
		postServiceImpl.addNewPost(post);
	}

	@Test
	public void testGetPostByProfileId() throws InvalidInputException {
		List<Post> post = postServiceImpl.getPostByProfileId(1);
		assertTrue(!post.isEmpty());
	}

	@Test(expected = InvalidInputException.class)
	public void testGetPostByProfileIdNotExists() throws InvalidInputException {
		List<Post> post = postServiceImpl.getPostByProfileId(3);
		System.out.println("posts " + post);
	}

	@Test
	public void testGetAllPosts() throws InvalidInputException {
		List<Post> post = postServiceImpl.getAllPosts();
		assertEquals(2, post.size());
	}

	@Test
	public void testDeletePostById() {
		Optional<Post> post = postServiceImpl.getPostByPostId(100);
		assertTrue(post.isPresent());
	}

	@Test
	public void testUpdatePost() {
		List<Integer> likes = new ArrayList<>();
		likes.add(1);
		likes.add(2);
		List<Integer> comments = new ArrayList<>();
		comments.add(1);
		comments.add(2);
		comments.add(3);
		Post post = new Post(/* 100, */ 1, "feeling Happy!!", "http://localhost:8888.image.com", /* LocalDateTime.now(), */
				new Likes(1000, likes), new Comments(comments, "wow..nice!!", /* LocalDateTime.now(), */10));
		Post updatedPost = postServiceImpl.updatePost(post);
		assertEquals("feeling Happy!!", updatedPost.getStatus());
	}

}
