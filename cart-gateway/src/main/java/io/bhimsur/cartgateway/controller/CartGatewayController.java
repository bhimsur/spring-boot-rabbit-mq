package io.bhimsur.cartgateway.controller;

import io.bhimsur.cartgateway.service.CartGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartGatewayController {
    @Autowired
    private CartGatewayService service;

    @PostMapping("/addtocart")
    public boolean addToCart(@RequestBody Object request) {
        service.send(request);
        return true;
    }
}
