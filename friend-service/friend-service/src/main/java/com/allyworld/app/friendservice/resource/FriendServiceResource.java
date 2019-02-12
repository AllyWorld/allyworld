package com.allyworld.app.friendservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allyworld.app.friendservice.entity.Sender;

@RestController
@RequestMapping("/friends")
public class FriendServiceResource {

	@Autowired
	private Sender sender;

	@PostMapping
	public ResponseEntity<String> sendFriendRequest(@RequestParam int senderId, @RequestParam int receiverId) {
		sender.send(senderId, receiverId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping("/{senderId}")
	public ResponseEntity<String> getFriendsList(@PathVariable int senderId) {
		sender.getAllFriendsByProfileId(senderId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> acceptingRequest(@RequestParam int senderId , @RequestParam int receiverId){
		sender.acceptingFriendRequest(senderId, receiverId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
