package com.raspi.mqtt.hackathon.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raspi.mqtt.hackathon.model.MessageEntity;
import com.raspi.mqtt.hackathon.repository.MessageRepository;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void storeMessage(String message) {
        MessageEntity entity = new MessageEntity();
        entity.setMessage(message);
        entity.setCreatedAt(LocalDateTime.now());
        messageRepository.save(entity);
    }

}
