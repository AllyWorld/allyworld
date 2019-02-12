package com.app.allyworld.PostService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.allyworld.PostService.entity.Post;
import com.app.allyworld.PostService.exceptions.InvalidInputException;

@Repository
public interface PostRepository extends MongoRepository<Post, Integer> {

	List<Post> findPostByProfileId(int profileId);

}
