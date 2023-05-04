package com.raspi.mqtt.hackathon.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raspi.mqtt.hackathon.model.MessageEntity;
import com.raspi.mqtt.hackathon.repository.MessageRepository;

@RestController
@RequestMapping("/message")
public class MessageController {

    private ProducerTemplate  producerTemplate;

    private MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository, ProducerTemplate producerTemplate) {
        this.messageRepository = messageRepository;
        this.producerTemplate = producerTemplate;
    }

    @GetMapping
    public ResponseEntity<MessageEntity> getMessage() {
        MessageEntity message = messageRepository.findTopByOrderByCreatedAtDesc();
        return ResponseEntity.ok(message);
    }

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        producerTemplate.sendBody("mqtt:pub?publishTopicName=" + "AddDeviceTopic", message);
    }

    @PostMapping("/ignoreDevice")
    public void ignoreDeviceMessage(@RequestBody String message) {
        producerTemplate.sendBody("mqtt:pub?publishTopicName=" + "IgnoreDeviceTopic", message);
    }
}
