package com.sparta.paymentcore.dto;

public record ConfirmPaymentRequest(
        Long orderId,
        String portonePaymentId
) {}