package com.app.allyworld.PostService.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.exceptions.InvalidInputException;
import com.app.allyworld.PostService.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostSeviceResource {

	@Autowired
	private PostService postService;

	@PostMapping
	public ResponseEntity<Post> addNewPost(@RequestBody Post post) throws InvalidInputException {
		postService.addNewPost(post);
		if (post == null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Post>(post,HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<Post>> getAllPosts() {
		List<Post> posts = null;
		try {
			posts = postService.getAllPosts();
			//System.out.println(posts);
			return new ResponseEntity<>(posts,HttpStatus.OK);
		} catch (InvalidInputException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{profileId}")
	public ResponseEntity<List<Post>> getPostByProfileId(@PathVariable Integer profileId) {

		List<Post> post = null;
		try {
			post = postService.getPostByProfileId(profileId);
			return new ResponseEntity<>(post, HttpStatus.OK);
		} catch (InvalidInputException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/")
	public ResponseEntity<Post> getPostByPostId(@RequestParam("postId") Integer postId) {
		Optional<Post> post = postService.getPostByPostId(postId);
		// System.out.println("Deepika in profile " + post);
		if (post.isPresent()) {
			return new ResponseEntity<>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable int postId) {
		postService.deletePostById(postId);

	}

	@PutMapping
	public Post updatePost(@RequestBody Post post) {
		return postService.updatePost(post);
	}

}
