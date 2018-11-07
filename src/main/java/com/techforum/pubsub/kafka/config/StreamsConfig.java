package com.techforum.pubsub.kafka.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TechStream.class)
@EnableAutoConfiguration
public class StreamsConfig {
}
