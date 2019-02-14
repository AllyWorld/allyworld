package com.allyworld.app.profileservice.resource;

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

import com.allyworld.app.profileservice.entity.LoginCredentials;
import com.allyworld.app.profileservice.entity.Profile;
import com.allyworld.app.profileservice.exception.ProfileNotFoundException;
import com.allyworld.app.profileservice.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileResource {

	@Autowired
	private ProfileService service;

	@RequestMapping("/")
	public String indexPage() {
		return "home";
	}

	@PostMapping
	public ResponseEntity<Profile> addProfile(@RequestBody Profile profile) {
		System.out.println(profile);
		service.addNewProfile(profile);
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getProfileById(@PathVariable int profileId) {
		Optional<Profile> entity = service.getProfileById(profileId);
		Profile profile = entity.get();
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}

	
	@GetMapping
	public ResponseEntity<Profile> getProfileByEmail(@RequestParam String email, @RequestParam String password) {
		System.out.println(email); // String email = login.getEmail();
		LoginCredentials loginCredentials= new LoginCredentials(email, password);
		Profile profile = service.getProfileByLogin(loginCredentials);
		System.out.println(profile);
		return new ResponseEntity<Profile>(profile, HttpStatus.OK);
	}
	 
	

	@PutMapping
	public void updateProfile(@RequestBody Profile profile) {
		System.out.println("put Mapping");
		service.updateProfile(profile);
	}

	@PutMapping("{profileId}")
	public ResponseEntity<Profile> updateProfileById(@PathVariable Integer profileId) {
		Optional<Profile> profile = service.getProfileById(profileId);
		Profile friendProfile = profile.get();
		service.updateProfile(friendProfile);
		return new ResponseEntity<Profile>(HttpStatus.OK);
	}

	/*
	 * @GetMapping public ResponseEntity<List<Profile>> getProfiles() {
	 * ResponseEntity<List<Profile>> profilesList = service.getProfiles();
	 * List<Profile> list = profilesList.getBody(); return new
	 * ResponseEntity<List<Profile>>(list, HttpStatus.OK); }
	 */
	

	@DeleteMapping("/{profileId}")
	public ResponseEntity<Profile> deleteProfile(@PathVariable int profileId) {
		Optional<Profile> entity = service.getProfileById(profileId);
		Profile profile = entity.get();
		service.deleteProfile(profile);
		if (!entity.isPresent())
			return new ResponseEntity<Profile>(HttpStatus.OK);

		return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping
	public void deleteAllProfiles() {
		service.deleteAllProfiles();
	}

	public void updatePendingFriendsList(Integer senderProfileId, Integer receiverProfileId)
			throws ProfileNotFoundException {

		/*
		 * Integer sendersProfileId =
		 * service.getProfileById(senderProfileId).get().getProfileId();
		 * System.out.println(sendersProfileId); Integer receiversProfileId =
		 * service.getProfileById(receiverProfileId).get().getProfileId();
		 */
		if (senderProfileId == null || receiverProfileId == null) {
			throw new ProfileNotFoundException("Profile does not exists");
		} else
			service.updatePendingFreindList(senderProfileId, receiverProfileId);
		System.out.println(senderProfileId + " " + receiverProfileId);

	}

	/* @GetMapping("/{senderId}/friends") */
	public ResponseEntity<List<Integer>> getFriendsList(Integer senderId) {
		List<Integer> friendsList = service.getFriendsList(senderId);
		if (senderId == null) {
			return new ResponseEntity<List<Integer>>(HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<List<Integer>>(friendsList, HttpStatus.OK);

	}

	public ResponseEntity<String> acceptingFriendRequest(int senderId, int receiverId) {
		service.acceptingFriendList(senderId, receiverId);
		service.getFriendsList(senderId);
		return new ResponseEntity<String>(HttpStatus.OK);

	}

}
