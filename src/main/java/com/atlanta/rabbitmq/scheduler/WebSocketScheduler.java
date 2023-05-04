package com.atlanta.rabbitmq.scheduler;

import com.atlanta.rabbitmq.service.WebSocketServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log4j2
@Configurable
@EnableScheduling
public class WebSocketScheduler {

    private final WebSocketServiceImpl webSocketServiceImpl;

    WebSocketScheduler(WebSocketServiceImpl webSocketServiceImpl) {
        log.info("INIT");
        this.webSocketServiceImpl = webSocketServiceImpl;
        heartbeatTask();
    }

    @Scheduled(fixedRate = 5000)
    public void heartbeatTask() {
        log.info("Heartbest messages being sent.");
        webSocketServiceImpl.sendMessages();
    }

}
