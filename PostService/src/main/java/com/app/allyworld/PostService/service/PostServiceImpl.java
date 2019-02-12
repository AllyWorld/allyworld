package com.app.allyworld.PostService.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.exceptions.InvalidInputException;
import com.app.allyworld.PostService.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public void addNewPost(Post post) throws InvalidInputException {

		try {
			post.setDate(LocalDateTime.now());
			post.getComments().setCommentTime(LocalDateTime.now());
			postRepository.save(post);
		} catch (Exception e) {
			throw new InvalidInputException("Post Not Found");
		}
	}

	@Override
	public List<Post> getAllPosts() throws InvalidInputException {

		List<Post> posts = postRepository.findAll();
		if (posts.isEmpty()) {
			throw new InvalidInputException("Post Not Found");
		}
		return posts;
	}

	@Override
	public List<Post> getPostByProfileId(int profileId) throws InvalidInputException {

		List<Post> profilePost = postRepository.findPostByProfileId(profileId);
		System.out.println("in service " + profilePost);
		if (profilePost.isEmpty()) {
			throw new InvalidInputException("Post Not Found");
		}
		// System.out.println("in wrong id =" +profilePost);
		return profilePost;

	}

	@Override
	public void deletePostById(int postId) {
		postRepository.deleteById(postId);
	}

	@Override
	public void deletePost() {
		postRepository.deleteAll();
	}

	@Override
	public Post updatePost(Post post) {
		post.setStatus(post.getStatus());
		post.setUrl(post.getUrl());
		post.getLikes().setLikes(post.getLikes().getLikes());
		post.getLikes().setLikesProfileId(post.getLikes().getLikesProfileId());
		post.getComments().setCommentProfileId(post.getComments().getCommentProfileId());
		post.getComments().setComment(post.getComments().getComment());
		post.setDate(LocalDateTime.now());
		post.getComments().setCommentTime(LocalDateTime.now());
		return postRepository.save(post);
	}

	@Override
	public Optional<Post> getPostByPostId(Integer postId) {
		return postRepository.findById(postId);
	}

}
