package com.allyworld.app.profileservice.entity;

import org.springframework.stereotype.Component;

//@RabbitListener(queues = "newQ")
@Component
public class Receiver {
	
//	@Autowired
//	private ProfileResource resource;
//
//	@RabbitHandler
//	public void processManager(Integer friendArray[]) throws ProfileNotFoundException {
//		 System.out.println(friendArray[0] + " " + friendArray[1]); 
//
//		System.out.println("request has been accessed");
//		resource.updatePendingFriendsList(friendArray[0], friendArray[1]);
//
//		/* System.out.println(senderId + " " + receiverId); */
//
//	}
//
//	@RabbitHandler
//	public void getFriendsList(int senderId) throws ProfileNotFoundException {
//		System.out.println("request has been accessed");
//		ResponseEntity<List<Integer>> friendsList = resource.getFriendsList(senderId);
//		 System.out.println(friendsList.getBody()); 
////	  System.out.println(data[0] + " " + data[1]);
//
//	}
//
//	@RabbitHandler
//	public void acceptingFriendRequest(Integer friendArray[]) {
//		System.out.println("accepting request");
//		resource.acceptingFriendRequest(friendArray[0], friendArray[1]);
//	}

}
