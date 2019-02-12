package com.allyworld.app.profileservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.allyworld.app.profileservice.entity.Profile;

@Repository
public interface ProfileRepo extends MongoRepository<Profile, Object>{

}
