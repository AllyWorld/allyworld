package com.app.allyworld.NewsFeedService.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.allyworld.NewsFeedService.entity.Post;
import com.app.allyworld.NewsFeedService.repository.NewsFeedRepository;
import com.app.allyworld.NewsFeedService.exceptions.InvalidInputException;

@Service
public class NewsFeedServiceImpl implements NewsFeedService{
	
	@Autowired
	private NewsFeedRepository newsFeedRepository;

	@Override
	public List<Post> getAllNewsFeedByProfileId(Integer profileId) throws InvalidInputException   {
		 List<Post> profilePost = newsFeedRepository.findPostByProfileId(profileId);
		 if(profilePost.isEmpty()) {
			 throw new InvalidInputException("Post Not Found");
		 }else
		return profilePost;
	}

	@Override
	public void addNewPost(Post post) {
		post.setDate(LocalDateTime.now());
		post.getComments().setCommentTime(LocalDateTime.now());
		newsFeedRepository.save(post);
		
	}

}
