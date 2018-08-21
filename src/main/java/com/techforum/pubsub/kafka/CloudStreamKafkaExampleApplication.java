package com.techforum.pubsub.kafka;

import com.techforum.pubsub.kafka.config.EnableConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableConfig
@SpringBootApplication
public class CloudStreamKafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamKafkaExampleApplication.class, args);
	}
}
