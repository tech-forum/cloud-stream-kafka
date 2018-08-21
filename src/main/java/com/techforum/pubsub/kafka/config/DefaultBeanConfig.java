//package com.techforum.pubsub.kafka.config;
//
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
//import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Consumer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//
//@Configuration
//public class DefaultBeanConfig {
//    KafkaProperties kafkaProperties;
//
//    @PostConstruct
//    public void setkafkaStreamProperties(){
//        //System.setProperty("", "");
//    }
//
//    @PostConstruct
//    @Bean
//    public Consumer setKafkaConsumerConfig() {
//        Consumer consumer = this.kafkaProperties.getConsumer();
//        consumer.setEnableAutoCommit(false);
//        return consumer;
//    }
//}
