package com.sparta.paymentcore.repository;

import com.sparta.paymentcore.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // PortOne 결제 ID로 결제 조회 (결제 확정·취소 시 사용)
    Optional<Payment> findByPortonePaymentId(String portonePaymentId);
}
