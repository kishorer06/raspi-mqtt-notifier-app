package com.raspi.mqtt.hackathon.config;

import org.apache.camel.component.mqtt.MQTTComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Bean(name = "mqtt")
    public MQTTComponent mqttConfig() {
        MQTTComponent mqttComponent = new MQTTComponent();
        mqttComponent.setHost("ssl://8e8a8817d77b4f53a5eb9322c248e028.s2.eu.hivemq.cloud:8883");
        mqttComponent.setUserName("admin");
        mqttComponent.setPassword("admin123");
        return mqttComponent;
    }
}