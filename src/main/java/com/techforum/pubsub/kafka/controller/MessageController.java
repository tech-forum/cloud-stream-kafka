package com.techforum.pubsub.kafka.controller;

import com.esotericsoftware.minlog.Log;
import com.techforum.pubsub.kafka.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    Logger LOG = LoggerFactory.getLogger(MessageController.class);

    private final MessageService transactionService;

    @Autowired
    public MessageController(MessageService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/message")
    public String message(@RequestParam("content") String message,
                          @RequestParam("count") int count){

        Log.info("Starts message : {} ", message);
        try {
            transactionService.sendTextMessage(message, count);
            return "MESSAGE SENT SUCCESSFULLY:"+message;
        }catch(Exception ex){
            LOG.info("Exception occurred:",ex);
            return "MESSAGE FAILED TO SENT";
        }
    }
}
