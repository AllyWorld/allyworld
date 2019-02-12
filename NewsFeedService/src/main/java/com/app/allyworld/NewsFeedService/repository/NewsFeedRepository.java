package com.app.allyworld.NewsFeedService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.allyworld.NewsFeedService.entity.Post;

@Repository
public interface NewsFeedRepository extends MongoRepository<Post, Integer> {

	List<Post> findPostByProfileId(Integer profileId);

}
