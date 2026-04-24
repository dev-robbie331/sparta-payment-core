package com.sparta.paymentcore.repository;

import com.sparta.paymentcore.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // 회원 + 상품으로 기존 장바구니 항목 조회 (중복 담기 판별용)
    Optional<CartItem> findByMemberIdAndProductId(Long memberId, Long productId);

    // 회원의 전체 장바구니 목록 조회
    List<CartItem> findByMemberId(Long memberId);

}
