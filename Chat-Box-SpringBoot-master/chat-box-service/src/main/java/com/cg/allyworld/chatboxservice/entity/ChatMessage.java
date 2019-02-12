package com.cg.allyworld.chatboxservice.entity;

import java.awt.TrayIcon.MessageType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ChatMessage {
	
	@Id
	private int chatId;
	private static int chatCounter=100;
	private MessageType type;
	private String sender;
	private String receiver;
	private String messageContent;
	static {
		chatCounter=100;
	}
	{
		chatId=chatCounter++;
	}
	
	public ChatMessage() {
		super();
		
	}

	public ChatMessage( MessageType type, String sender, String receiver, String messageContent) {
		super();
		
		this.type = type;
		this.sender = sender;
		this.receiver = receiver;
		this.messageContent = messageContent;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	@Override
	public String toString() {
		return "ChatMessage [chatId=" + chatId + ", type=" + type + ", sender=" + sender + ", receiver=" + receiver
				+ ", messageContent=" + messageContent + "]";
	}
	
	
	
}

	