package com.sparta.paymentcore.service;

import com.sparta.paymentcore.dto.AddCartItemResponse;
import com.sparta.paymentcore.entity.CartItem;
import com.sparta.paymentcore.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartItemRepository cartItemRepository;

    @Transactional
    public AddCartItemResponse addItem(Long memberId, Long productId, int quantity) {
        Optional<CartItem> existing = cartItemRepository.findByMemberIdAndProductId(memberId, productId);

        if (existing.isPresent()) {
            CartItem item = existing.get();
            item.addQuantity(quantity);
            CartItem savedCartItem = cartItemRepository.save(item);
            return new AddCartItemResponse(savedCartItem.getId());
        }

        CartItem item = new CartItem(memberId, productId, quantity);
        cartItemRepository.save(item);
        return new AddCartItemResponse(item.getId());
    }

}
