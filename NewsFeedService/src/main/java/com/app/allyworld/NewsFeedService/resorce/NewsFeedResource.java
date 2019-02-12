package com.app.allyworld.NewsFeedService.resorce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.allyworld.NewsFeedService.entity.Post;
import com.app.allyworld.NewsFeedService.exceptions.InvalidInputException;
import com.app.allyworld.NewsFeedService.service.NewsFeedService;


@RestController
@RequestMapping("/newsfeed")
public class NewsFeedResource {
	
	@Autowired
	private NewsFeedService newsFeedService;
	
	/*
	 * @RequestMapping("/hi") public String hello() {
	 * System.out.println("Hello World!!"); return "Hello World!!"; }
	 */
	
	@PostMapping
	public ResponseEntity<String> addNewPost(@RequestBody Post post) {
		newsFeedService.addNewPost(post);
		if (post == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
	}
	@GetMapping("/{profileId}")
	public ResponseEntity<List<Post>> getAllNewsFeedByProfileId(@PathVariable Integer profileId){
		List<Post> post;
		try {
			post = newsFeedService.getAllNewsFeedByProfileId(profileId);
			return new ResponseEntity<>(post, HttpStatus.OK);
		} catch (InvalidInputException e) {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}	
	}
}
