package com.raspi.mqtt.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raspi.mqtt.hackathon.model.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    MessageEntity findTopByOrderByCreatedAtDesc();
}
