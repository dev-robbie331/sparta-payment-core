package com.sparta.paymentcore.dto;

public record AddCartItemRequest(
        Long productId,
        int quantity
) {}