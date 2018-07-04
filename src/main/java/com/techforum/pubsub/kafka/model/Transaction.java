package com.techforum.pubsub.kafka.model;

import lombok.Data;

@Data
public class Transaction {

    private String type;

    private String payload;

}
