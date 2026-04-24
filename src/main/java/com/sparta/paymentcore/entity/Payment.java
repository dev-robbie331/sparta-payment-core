package com.sparta.paymentcore.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "portone_payment_id", nullable = false, unique = true, length = 200)
    private String portonePaymentId;

    @Column(nullable = false)
    private int amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private PaymentStatus status = PaymentStatus.IN_PROGRESS;

    public Payment(Long orderId, String portonePaymentId, int amount) {
        this.orderId = orderId;
        this.portonePaymentId = portonePaymentId;
        this.amount = amount;
    }

    public void markAsPaid() {
        this.status = PaymentStatus.PAID;
    }

    public void markAsCancelled() {
        this.status = PaymentStatus.CANCELLED;
    }

}
