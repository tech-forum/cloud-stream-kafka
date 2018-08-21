package com.techforum.pubsub.kafka.listener;

import com.techforum.pubsub.kafka.config.TechforumStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
    Logger LOG = LoggerFactory.getLogger(MessageSubscriber.class);

    @StreamListener(TechforumStream.INPUT)
    public void onMessage(Message message){
        byte[] payload = (byte[]) message.getPayload();
        LOG.info("payload : {}", new String(payload));
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            LOG.info("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
    }
}
