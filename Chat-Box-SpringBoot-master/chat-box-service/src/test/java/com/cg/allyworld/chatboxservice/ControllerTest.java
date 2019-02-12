package com.cg.allyworld.chatboxservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.allyworld.chatboxservice.entity.ChatMessage;
import com.cg.allyworld.chatboxservice.resource.ChatResource;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void chatSenderTest() {

		ChatMessage chat= new ChatMessage(null,"priya","Winny","Welcome");
		ResponseEntity<ChatResource> responseEntity = testRestTemplate.postForEntity("/chats", chat, ChatResource.class);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	public void getChatByIdTest() {

		ResponseEntity<ChatResource> responseEntity = testRestTemplate.getForEntity("/chats/101", ChatResource.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	@Test
	public void getAllChat() {
		ResponseEntity<ChatResource[]> chatList = testRestTemplate.getForEntity("/chats", ChatResource[].class);
		assertThat(chatList.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertEquals(200, chatList.getStatusCodeValue());
	}
	
	@Test
	public void sendChatOrUpdateChatTest() {
		ChatMessage chat= new ChatMessage(null,"priya","Winny","Welcome");
		testRestTemplate.put("/chats", chat);
	}
	
	
}
