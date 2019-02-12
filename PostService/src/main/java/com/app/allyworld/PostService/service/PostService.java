package com.app.allyworld.PostService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.exceptions.InvalidInputException;

public interface PostService {

	void addNewPost(Post post) throws InvalidInputException;

	List<Post> getAllPosts() throws InvalidInputException;

	List<Post> getPostByProfileId(int profileId) throws InvalidInputException;

	void deletePostById(int postId);

	void deletePost();

	Post updatePost(Post post);

	Optional<Post> getPostByPostId(Integer postId);
}
