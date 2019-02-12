package com.cg.allyworld.chatboxservice.service;

import java.util.List;

import com.cg.allyworld.chatboxservice.entity.ChatMessage;

public interface ChatService {

	void sendMessage(ChatMessage chatMessage);

	ChatMessage receiveMessage(int chatId);

	List<ChatMessage> getAllChat();

}
