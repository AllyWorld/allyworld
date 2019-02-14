package com.allyworld.app.profileservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.allyworld.app.profileservice.entity.LoginCredentials;
import com.allyworld.app.profileservice.entity.Profile;

@Repository
public interface ProfileRepo extends MongoRepository<Profile, Object>{
	
	//Profile findProfileBylogin(String email);
	Profile findProfileBylogin(LoginCredentials loginCredentials);
	
	List<Profile> findProfileByFullName(String name);

}
