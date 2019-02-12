package com.allyworld.app.friendservice.entity;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitMessagingTemplate template;

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void send(int senderId, int receiverId) {
		System.out.println(senderId + " " + receiverId);
		template.convertAndSend("newQ", new Integer[] { senderId, receiverId });
	}

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void getAllFriendsByProfileId(int profileId) {
		template.convertAndSend("newQ", profileId);

	}

	@Scheduled(fixedDelay = 1000, initialDelay = 500)
	public void acceptingFriendRequest(int senderId, int receiverId) {
		System.out.println(senderId + " " + receiverId);
		template.convertAndSend("newQ", new Integer[] { senderId, receiverId });
	}

}
