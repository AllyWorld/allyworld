package com.app.allyworld.PostService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.allyworld.PostService.entity.Comments;
import com.app.allyworld.PostService.entity.Likes;
import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.service.PostService;

@SpringBootApplication
public class PostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner populateData(PostService postService) {
		return (arg) -> {
			List<Integer> likes = new ArrayList<>();
			likes.add(1);
			likes.add(2);
			List<Integer> comments = new ArrayList<>();
			comments.add(1);
			comments.add(2);
			comments.add(3);
			postService.addNewPost(
					new Post(100, 1, "Feeling Excited!!", "http://localhost:8888.image.com", LocalDateTime.now(),
							new Likes(1000, likes), new Comments(comments, "wow..nice!!", LocalDateTime.now(), 10)));
			// Post newppost = postServiceImpl.addNewPost(post);
			// System.out.println(newppost);
		};
	}

}