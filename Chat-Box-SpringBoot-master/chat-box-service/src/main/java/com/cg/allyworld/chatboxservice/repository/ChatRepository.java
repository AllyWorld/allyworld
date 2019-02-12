package com.cg.allyworld.chatboxservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.allyworld.chatboxservice.entity.ChatMessage;


@Repository
public interface ChatRepository extends MongoRepository<ChatMessage, Integer> {

}
