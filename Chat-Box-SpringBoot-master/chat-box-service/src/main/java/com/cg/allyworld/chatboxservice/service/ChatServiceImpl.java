package com.cg.allyworld.chatboxservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.allyworld.chatboxservice.entity.ChatMessage;
import com.cg.allyworld.chatboxservice.repository.ChatRepository;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	ChatRepository chatRepository;
	
	@Override
	public void sendMessage(ChatMessage chatMessage) {
		 chatRepository.save(chatMessage);
	}

	@Override
	public ChatMessage receiveMessage(int chatId) {
		return chatRepository.findById(chatId).get();
	}

	@Override
	public List<ChatMessage> getAllChat() {
		return chatRepository.findAll();
	}
}
