package com.app.allyworld.NewsFeedService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.allyworld.NewsFeedService.service.NewsFeedService;
import com.app.allyworld.NewsFeedService.entity.Comments;
import com.app.allyworld.NewsFeedService.entity.Likes;
import com.app.allyworld.NewsFeedService.entity.Post;


@SpringBootApplication
public class NewsFeedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsFeedServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner populateData( NewsFeedService newsFeedService) {
		return (arg)->{
			List<Integer> likes=new ArrayList<>();
			likes.add(1);
			likes.add(2);
			List<Integer> comments=new ArrayList<>();
			comments.add(1);
			comments.add(2);
			comments.add(3);
			Post post=new Post(100,1,"Feeling Excited!!","http://localhost:8888.image.com",LocalDateTime.now(),new Likes(1000,likes),new Comments(comments,"wow..nice!!",LocalDateTime.now(),10));
			newsFeedService.addNewPost(post);
			
		};
	}

}

