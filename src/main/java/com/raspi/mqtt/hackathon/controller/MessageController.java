package com.raspi.mqtt.hackathon.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raspi.mqtt.hackathon.model.MessageEntity;
import com.raspi.mqtt.hackathon.repository.MessageRepository;

@RestController
public class MessageController {

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/message")
    public ResponseEntity<MessageEntity> getMessage() {
        MessageEntity message = messageRepository.findTopByOrderByCreatedAtDesc();
        return ResponseEntity.ok(message);
    }
}
