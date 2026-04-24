package com.sparta.paymentcore.dto;

public record CreateOrderResponse(
        Long orderId,
        String portonePaymentId,
        int totalAmount,
        String orderName,
        String status
) {}