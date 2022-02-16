package io.bhimsur.cartservice.mqlistener;

import io.bhimsur.cartservice.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQListener {

    @Autowired
    private CartService service;

    @RabbitListener(queues = "${bhimsur.cart.queue}")
    public void receive(Object request) {
        log.info("receive cart queue");
        service.addToCart(request);
    }
}
