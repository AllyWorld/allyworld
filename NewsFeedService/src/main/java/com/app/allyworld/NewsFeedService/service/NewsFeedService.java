package com.app.allyworld.NewsFeedService.service;

import java.util.List;

import com.app.allyworld.NewsFeedService.entity.Post;
import com.app.allyworld.NewsFeedService.exceptions.InvalidInputException;

public interface NewsFeedService {

	List<Post> getAllNewsFeedByProfileId(Integer profileId) throws InvalidInputException;

	void addNewPost(Post post);

	

}
