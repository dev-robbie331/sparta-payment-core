package com.sparta.paymentcore.controller;

import com.sparta.paymentcore.dto.CancelPaymentRequest;
import com.sparta.paymentcore.dto.ConfirmPaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    @PostMapping("/confirm")
    public ResponseEntity<?> confirm(@RequestBody ConfirmPaymentRequest request) {
        return null;
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable Long id,
                                    @RequestBody CancelPaymentRequest request) {
        return null;
    }
}