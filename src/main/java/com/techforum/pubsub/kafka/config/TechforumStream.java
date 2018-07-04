package com.techforum.pubsub.kafka.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TechforumStream {
    String INPUT = "techforum-in";
    String OUTPUT = "techforum-out";

    @Input(INPUT)
    SubscribableChannel inboundMessages();
    @Output(OUTPUT)
    MessageChannel outboundMessages();
}
