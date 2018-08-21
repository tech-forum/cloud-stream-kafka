package com.techforum.pubsub.kafka.listener;

import org.springframework.integration.support.AcknowledgmentCallback;

public class SubscriberCallback implements AcknowledgmentCallback {
    @Override
    public void acknowledge(Status status) {
        System.out.println(status);
    }

    @Override
    public boolean isAcknowledged() {
        return false;
    }

    @Override
    public void noAutoAck() {

    }

    @Override
    public boolean isAutoAck() {
        return false;
    }
}
