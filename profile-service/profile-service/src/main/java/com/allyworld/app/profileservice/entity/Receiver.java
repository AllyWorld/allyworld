package com.allyworld.app.profileservice.entity;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.allyworld.app.profileservice.exception.ProfileNotFoundException;
import com.allyworld.app.profileservice.resource.ProfileResource;

@RabbitListener(queues = "newQ")
@Component
public class Receiver {
	
	@Autowired
	private ProfileResource resource;

	@RabbitHandler
	public void processManager(Integer friendArray[]) throws ProfileNotFoundException {
		 System.out.println(friendArray[0] + " " + friendArray[1]); 

		System.out.println("request has been accessed");
		resource.updatePendingFriendsList(friendArray[0], friendArray[1]);

		/* System.out.println(senderId + " " + receiverId); */

	}

	@RabbitHandler
	public void getFriendsList(int senderId) throws ProfileNotFoundException {
		System.out.println("request has been accessed");
		ResponseEntity<List<Integer>> friendsList = resource.getFriendsList(senderId);
		 System.out.println(friendsList.getBody()); 
//	  System.out.println(data[0] + " " + data[1]);

	}

	@RabbitHandler
	public void acceptingFriendRequest(Integer friendArray[]) {
		System.out.println("accepting request");
		resource.acceptingFriendRequest(friendArray[0], friendArray[1]);
	}

}
