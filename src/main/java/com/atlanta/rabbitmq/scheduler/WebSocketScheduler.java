package com.atlanta.rabbitmq.scheduler;

import com.atlanta.rabbitmq.service.WebSocketServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;

@Log4j2
public class WebSocketScheduler {

    private final WebSocketServiceImpl webSocketServiceImpl;

    WebSocketScheduler(WebSocketServiceImpl webSocketServiceImpl) {
        this.webSocketServiceImpl = webSocketServiceImpl;
    }

    @Scheduled(fixedRateString = "5000", initialDelayString = "0")
    public void heartbeatTask() {
        log.info("Heartbest messages being sent.");
        webSocketServiceImpl.sendMessages();
    }

}
