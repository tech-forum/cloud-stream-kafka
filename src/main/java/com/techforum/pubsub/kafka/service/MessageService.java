package com.techforum.pubsub.kafka.service;

import com.techforum.pubsub.kafka.config.TechforumStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

@Service
public class MessageService {

    private final TechforumStream techforumStream;

    @Autowired
    public MessageService(TechforumStream techforumStream) {
        this.techforumStream = techforumStream;
    }

    public void sendTextMessage(final String message) {
        System.out.println("Sending greetings {}"+ message);
        MessageChannel messageChannel = techforumStream.outboundMessages();
        messageChannel.send(MessageBuilder
                .withPayload(message)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }
}
