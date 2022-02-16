package io.bhimsur.cartgateway.controller;

import io.bhimsur.cartgateway.model.CartRequest;
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
    public boolean addToCart(@RequestBody CartRequest request) {
        service.send(request);
        return true;
    }
}
