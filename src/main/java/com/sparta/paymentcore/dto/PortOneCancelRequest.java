package com.sparta.paymentcore.dto;

public record PortOneCancelRequest(
        String reason,
        String storeId
) {}