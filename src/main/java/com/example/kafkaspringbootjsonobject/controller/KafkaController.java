package com.example.kafkaspringbootjsonobject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaspringbootjsonobject.dao.User;
import com.example.kafkaspringbootjsonobject.services.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer;

	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user)
	{
		kafkaProducer.sendMessage(user);
		
		return ResponseEntity.ok("json message send to kafka topic...");
	}
	
}
