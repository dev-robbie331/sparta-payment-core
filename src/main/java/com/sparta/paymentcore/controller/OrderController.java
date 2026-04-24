package com.sparta.paymentcore.controller;

import com.sparta.paymentcore.dto.CreateOrderRequest;
import com.sparta.paymentcore.dto.CreateOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    @PostMapping("/checkout")
    public ResponseEntity<CreateOrderResponse> checkout(@RequestBody CreateOrderRequest request) {
        return null;
    }

}
