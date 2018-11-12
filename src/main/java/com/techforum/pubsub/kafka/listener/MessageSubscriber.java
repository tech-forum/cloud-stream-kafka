//package com.techforum.pubsub.kafka.listener;
//
//import com.techforum.pubsub.kafka.config.TechforumStream;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.Message;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//@Component
//public class MessageSubscriber {
//    Logger LOG = LoggerFactory.getLogger(MessageSubscriber.class);
//
//    @StreamListener(TechforumStream.INPUT)
//    public void onMessage(Message message){
//        byte[] payload = (byte[]) message.getPayload();
//        LOG.info("payload : {}", new String(payload));
//        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
//        if (acknowledgment != null) {
//            LOG.info("Acknowledgment provided");
//            acknowledgment.acknowledge();
//        }
//    }
//
//    public void temp(){
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "techforum-group-two");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("session.timeout.ms", "30000");
//        props.put("key.deserializer",
//                "org.apache.kafka.common.serializa-tion.StringDeserializer");
//        props.put("value.deserializer",
//                "org.apache.kafka.common.serializa-tion.StringDeserializer");
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//
//        consumer.subscribe(Arrays.asList("techforum-topic"));
//        System.out.println("Subscribed to topic " + topic);
//        int i = 0;
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records)
//                System.out.printf("offset = %d, key = %s, value = %s\n",
//                        record.offset(), record.key(), record.value());
//        }
//    }
//}
//
