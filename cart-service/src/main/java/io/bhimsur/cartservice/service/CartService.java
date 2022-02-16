package io.bhimsur.cartservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartService {

    public void addToCart(Object request) {
        log.info("adding to cart, request : {}", request);
    }
}
