package com.atlanta.rabbitmq.controller;

import com.atlanta.rabbitmq.service.RabbitQueueServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v${rabbitmq.api.version}/amqp")
public class AMQPRestController {

    private final RabbitQueueServiceImpl rabbitQueueServiceImpl;

    public AMQPRestController(RabbitQueueServiceImpl rabbitQueueServiceImpl) {
        this.rabbitQueueServiceImpl = rabbitQueueServiceImpl;
    }

    // http://localhost:8080/api/v1/amqp/ping
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Ping received ...");
    }

    // http://localhost:8080/api/v1/amqp/addQueue?queueName=queueName
    @GetMapping("/addQueue")
    public ResponseEntity<String> addQueue(@RequestParam("queueName") String queueName) {
        this.rabbitQueueServiceImpl.addNewQueue(queueName);
        return ResponseEntity.ok("Listening to Queue ...");
    }

    // http://localhost:8080/api/v1/amqp/addMessage?message=hello&queueName=queueName
    @GetMapping("/addMessage")
    public ResponseEntity<String> addMessage(@RequestParam("message") String message, @RequestParam("queueName") String queueName) {
        this.rabbitQueueServiceImpl.addMessageToQueue(message, queueName);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

    // http://localhost:8080/api/v1/amqp/getMessage?queueName=queueName
    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam("queueName") String queueName, @RequestParam("count") Optional<Integer> count) {
        var message = this.rabbitQueueServiceImpl.getMessagesFromQueue(queueName, count.orElse(1));
        byte[] body = message.getBody();
        return ResponseEntity.ok(new String(body));
    }

}
