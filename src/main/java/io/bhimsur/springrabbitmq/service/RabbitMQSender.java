package io.bhimsur.springrabbitmq.service;

import io.bhimsur.springrabbitmq.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @Value("${bhimsur.rabbitmq.exchange}")
    private String exchange;

    @Value("${bhimsur.rabbitmq.routingKey}")
    private String routingKey;

    public void send(Notification request) {
        rabbitMqTemplate.convertAndSend(exchange, routingKey, request);
        System.out.println("Send message : " + request);
    }
}
