package com.sparta.paymentcore.infra;

import com.sparta.paymentcore.dto.PortOneCancelRequest;
import com.sparta.paymentcore.dto.PortOnePaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Slf4j
@Component
public class PortOneClient {

    private final RestClient restClient;
    private final PortOneProperties portOneProperties;

    public PortOneClient(PortOneProperties portOneProperties) {
        this.restClient = RestClient.builder()
                .baseUrl(portOneProperties.getBaseUrl())
                .defaultHeader("Authorization", "PortOne " + portOneProperties.getApiSecret())
                .defaultHeader("Content-Type", "application/json")
                .build();
        this.portOneProperties = portOneProperties;
    }

    // PortOne에서 실제 결제 정보 조회 (금액 검증용)
    public PortOnePaymentResponse getPayment(String paymentId) {
        // https://api.portone.io/payments/{paymnetId}?storeId={storeId}
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/payments/{paymentId}")
                        .queryParam("storeId", portOneProperties.getStoreId())
                        .build(paymentId))
                .retrieve()
                .body(PortOnePaymentResponse.class);
    }

    // PortOne에 결제 취소 요청
    public void cancelPayment(String paymentId, String reason) {
        // https://api.portone.io/payments/{paymnetId}/cancel body: {reason, storeId}
        restClient.post()
                .uri("/payments/{paymentId}/cancel", paymentId)
                .body(new PortOneCancelRequest(reason, portOneProperties.getStoreId()))
                .retrieve()
                .toBodilessEntity();
    }

}
