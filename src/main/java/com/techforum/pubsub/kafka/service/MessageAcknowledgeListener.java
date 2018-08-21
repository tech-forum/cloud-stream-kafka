package com.techforum.pubsub.kafka.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;

public class MessageAcknowledgeListener implements AcknowledgingConsumerAwareMessageListener {

    @Override
    public void onMessage(ConsumerRecord data, Acknowledgment acknowledgment, Consumer consumer) {
        System.out.println("###Ack 1");
    }

    @Override
    public void onMessage(Object data) {
        System.out.println("###Ack 2");
    }

    @Override
    public void onMessage(ConsumerRecord data) {
        System.out.println("###Ack 3");
    }
}
