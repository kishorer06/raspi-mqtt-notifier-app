package com.raspi.mqtt.hackathon.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String message = exchange.getIn().getBody(String.class);
        // do some processing
        exchange.getIn().setBody(message);
    }

}
