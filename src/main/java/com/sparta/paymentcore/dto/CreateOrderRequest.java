package com.sparta.paymentcore.dto;

import java.util.List;

public record CreateOrderRequest(
        List<Long> cartItemIds   // 비어 있으면 전체 장바구니
) {}