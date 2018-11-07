package com.techforum.pubsub.kafka.listener;

import com.techforum.pubsub.kafka.config.TechStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
public class MessageSubscriber {
    Logger LOG = LoggerFactory.getLogger(MessageSubscriber.class);

    @StreamListener(TechStream.INPUT)
    public void onMessage(Message<?> message) {
        LOG.info("payload : {}", message);
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        if (acknowledgment != null && !isFailed(message)) {
            LOG.info("Acknowledgment provided");
            acknowledgment.acknowledge();
        }/*else {
            throw new RuntimeException("Dont acknowlede");
        }*/
    }

    private boolean isFailed(Message message) {
        byte[] payloadByte = (byte[]) message.getPayload();
        String payload = new String(payloadByte);

        if(payload.contains("2") || payload.contains("4")) {
            return true;
        }
        return false;
    }
}
