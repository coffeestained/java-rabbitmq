package com.atlanta.rabbitmq.controller;

import com.atlanta.rabbitmq.producer.AMQPProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v${rabbitmq.api.version}/amqp")
public class AMQPController {

    private AMQPProducer producer;

    public AMQPController(AMQPProducer producer) {
        this.producer = producer;
    }

    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

}