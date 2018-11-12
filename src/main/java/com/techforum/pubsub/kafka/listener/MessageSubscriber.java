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

import java.time.Duration;
import java.time.LocalDateTime;

@Component
@EnableAutoConfiguration
public class MessageSubscriber {
    Logger LOG = LoggerFactory.getLogger(MessageSubscriber.class);
    private LocalDateTime startTime;
    @StreamListener(TechStream.INPUT)
    public void onMessage(Message<?> message) throws InterruptedException {
        String payload = new String((byte[]) message.getPayload());
        //Thread.sleep(3000);
        if(payload.equals("PERFDATA0") || startTime == null) {
            startTime = LocalDateTime.now();
            LOG.info("Processing started >> " + startTime);
        }
        LOG.info("payload : {}", payload);
         Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        if (acknowledgment != null && !isFailed(message)) {
            LOG.info("Acknowledgment provided");
            acknowledgment.acknowledge();
        }/*else {
            throw new RuntimeException("Don't acknowledge");
        }*/
        LocalDateTime endTime = LocalDateTime.now();
        LOG.info("Processing Ended >> StartTime:" + startTime + " EndTime:" + endTime + " Difference >> " + Duration.between(startTime, endTime));
    }

    private boolean isFailed(Message message) {
        byte[] payloadByte = (byte[]) message.getPayload();
        String payload = new String(payloadByte);
//
//        if(payload.contains("12") || payload.contains("14")) {
//            return true;
//        }
        return false;
    }
}
