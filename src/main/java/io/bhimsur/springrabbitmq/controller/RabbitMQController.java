package io.bhimsur.springrabbitmq.controller;

import io.bhimsur.springrabbitmq.model.Notification;
import io.bhimsur.springrabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {
    @Autowired
    private RabbitMQSender service;

    @GetMapping(value = "/send")
    public String sendQueue(@RequestParam("id") String id, @RequestParam("message") String message) {
        service.send(Notification.builder().id(id).message(message).build());
        return "Message sent to RabbitMQ successfully";
    }
}
