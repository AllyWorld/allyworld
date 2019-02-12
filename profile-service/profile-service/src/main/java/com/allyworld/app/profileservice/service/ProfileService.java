package com.allyworld.app.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.allyworld.app.profileservice.entity.Profile;

@Service
public interface ProfileService {

	ResponseEntity<Profile> addNewProfile(Profile profile);

	Optional<Profile> getProfileById(int friendProfileId);

	void updateProfile(Profile profile);

	ResponseEntity<List<Profile>> getProfiles();

	ResponseEntity<Profile> deleteProfile(Profile profile);

	void deleteAllProfiles();

	void updatePendingFreindList(Integer senderProfileId, Integer receiverProfileId);

	List<Integer> getFriendsList(int senderId);

	void acceptingFriendList(int senderId, int receiverId);

}