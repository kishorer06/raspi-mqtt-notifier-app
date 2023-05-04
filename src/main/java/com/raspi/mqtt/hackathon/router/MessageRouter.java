package com.raspi.mqtt.hackathon.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raspi.mqtt.hackathon.processor.MessageProcessor;

@Component
public class MessageRouter extends RouteBuilder {

    @Autowired
    private MessageProcessor messageProcessor;

    @Override
    public void configure() throws Exception {
        // Add Camel route to subscribe message from MQTT topic
        from("mqtt:sub?subscribeTopicName=RaspiNotificationTopic").process(messageProcessor)
                .to("bean:messageService?method=storeMessage");
    }
}
