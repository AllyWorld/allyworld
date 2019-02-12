package com.cg.allyworld.chatboxservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.allyworld.chatboxservice.entity.ChatMessage;
import com.cg.allyworld.chatboxservice.service.ChatService;

@RestController
@RequestMapping("/chats")
public class ChatResource {

	@Autowired
	public ChatService service;

	@PostMapping
	public void sendMessage(@RequestBody ChatMessage chatMessage) {
		service.sendMessage(chatMessage);
	}

	/*
	 * @PutMapping public void sendMessage(@RequestBody ChatMessage chatMessage) {
	 * service.sendMessage(chatMessage); }
	 */

	@GetMapping("{chatId}")
	public ChatMessage getMessage(@PathVariable int chatId) {
		return service.receiveMessage(chatId);
	}

	@GetMapping
	public ResponseEntity<List<ChatMessage>> getAllChat() {

		List<ChatMessage> chat = service.getAllChat();
		return new ResponseEntity<List<ChatMessage>>(chat, HttpStatus.OK);

	}
}
