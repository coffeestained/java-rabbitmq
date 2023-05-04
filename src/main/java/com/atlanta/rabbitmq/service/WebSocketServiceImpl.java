package com.atlanta.rabbitmq.service;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.Date;

@Data
@Log4j2
@Service
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    private static final String WS_MESSAGE_TRANSFER_DESTINATION = "/topic/greetings";

    WebSocketServiceImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendMessages() {
        log.info("Messages being sent.");
        simpMessagingTemplate.convertAndSend(WS_MESSAGE_TRANSFER_DESTINATION,
                "Hallo " + " at " + new Date().toString());
    }

    @Scheduled(fixedRate = 5000)
    public void heartbeatTask() {
        log.info("Heartbest messages being sent.");
        sendMessages();
    }

}