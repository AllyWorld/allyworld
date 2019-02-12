package com.app.allyworld.NewsFeedService.testService;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.allyworld.NewsFeedService.service.NewsFeedService;
import com.app.allyworld.NewsFeedService.exceptions.InvalidInputException;
import com.app.allyworld.NewsFeedService.entity.Comments;
import com.app.allyworld.NewsFeedService.entity.Likes;
import com.app.allyworld.NewsFeedService.entity.Post;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
	
	@Autowired
	private NewsFeedService newsFeedServiceImpl;
	
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
		post = new Post(100, 1, "Feeling Excited!!", "http://localhost:8888.image.com", LocalDateTime.now(),
				new Likes(1000, likes), new Comments(comments, "wow..nice!!", LocalDateTime.now(), 10));
	}
	
	@Test
	public void testGetAllNewsFeedByProfileId() throws InvalidInputException {
		List<Post> post = newsFeedServiceImpl.getAllNewsFeedByProfileId(1);
		assertEquals(4, post.size());
	}
	
	@Test(expected = InvalidInputException.class)
	public void testGetAllNewsFeedByProfileIdNotExists() throws InvalidInputException {
		List<Post> post = newsFeedServiceImpl.getAllNewsFeedByProfileId(3);
	}

}
