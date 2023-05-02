package com.atlanta.rabbitmq.service;

import org.springframework.amqp.core.Message;

public interface RabbitQueueService {

    Message getMessagesFromQueue(String queueName, Integer count);

    void addMessageToQueue(String message, String queueName);

    void addNewQueue(String queueName);

    void addQueueToListener(String listenerId, String queueName);

    void removeQueueFromListener(String listenerId, String queueName);

    Boolean checkQueueExistOnListener(String listenerId, String queueName);

}
