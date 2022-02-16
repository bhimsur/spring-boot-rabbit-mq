package io.bhimsur.cartgateway.service;

import io.bhimsur.cartgateway.model.CartRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartGatewayService {
    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @Value("${bhimsur.cart.exchange}")
    private String exchange;

    @Value("${bhimsur.cart.routingKey}")
    private String routingKey;

    public void send(CartRequest request) {
        log.info("send to cart service with request : {}", request);
        rabbitMqTemplate.convertAndSend(exchange, routingKey, request);
    }
}
