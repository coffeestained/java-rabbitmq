package com.atlanta.rabbitmq.controller;

import com.atlanta.rabbitmq.service.RabbitQueueServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v${rabbitmq.api.version}/amqp")
public class AMQPRestController {

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    private RabbitQueueServiceImpl rabbitQueueServiceImpl;

    public AMQPRestController(RabbitQueueServiceImpl rabbitQueueServiceImpl) {
        this.rabbitQueueServiceImpl = rabbitQueueServiceImpl;
    }

    // http://localhost:8080/api/v1/amqp/addQueue?queueName=queueName
    @GetMapping("/addQueue")
    public ResponseEntity<String> addQueue(@RequestParam("queueName") String queueName) {
        this.rabbitQueueServiceImpl.addNewQueue(queueName);
        return ResponseEntity.ok("Listening to Queue ...");
    }

    // http://localhost:8080/api/v1/amqp/publish?message=hello&queueName=queueName
    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message, @RequestParam("queueName") String queueName) {
        this.rabbitQueueServiceImpl.addMessageToQueue(message, queueName);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

}
