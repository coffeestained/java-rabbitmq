package com.atlanta.rabbitmq.controller;

import com.atlanta.rabbitmq.service.RabbitQueueServiceImpl;
import com.atlanta.rabbitmq.service.WebSocketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import org.springframework.web.util.HtmlUtils;

@Controller
@RequestMapping("/api/v${rabbitmq.api.version}/amqp")
public class AMQPWebsocketController {

    private WebSocketServiceImpl webSocketServiceImpl;

    public AMQPWebsocketController(WebSocketServiceImpl webSocketServiceImpl) {

        this.webSocketServiceImpl = webSocketServiceImpl;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return HtmlUtils.htmlEscape(message);
    }

}
