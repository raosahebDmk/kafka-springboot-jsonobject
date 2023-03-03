package com.example.kafkaspringbootjsonobject.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaspringbootjsonobject.dao.User;

@Service
public class KafkaConsumer {

	
	@KafkaListener(topics = "myTopic", groupId = "myGroup")
	public void consumeMessage(User user)
	{
		System.out.println("consumer message : "+user.toString());
	}
	
}
