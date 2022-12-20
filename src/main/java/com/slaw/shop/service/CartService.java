package com.slaw.shop.service;

import com.slaw.shop.controller.Cart;
import com.slaw.shop.controller.NewCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;


    public Optional<Cart> findByCartId(Long cartId) {
        return cartRepository.findById(cartId).map(Cart::from);
    }

    public Cart save(NewCart newCart) {
        return Cart.from(cartRepository.save(newCart.toEntity()));
    }

    public void removeCartItem(Long cartId, Long itemId) {
        itemRepository.deleteCartItem(cartId, itemId);
    }
}
