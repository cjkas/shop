package com.slaw.shop.service;

import com.slaw.shop.controller.Cart;
import com.slaw.shop.controller.NewCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRespository cartRespository;
    private final ItemRepository itemRepository;


    public Optional<Cart> findByCartId(UUID cartId) {
        return cartRespository.findById(cartId).map(Cart::from);
    }

    public Cart save(NewCart newCart) {
        return Cart.from(cartRespository.save(newCart.toEntity()));
    }

    public void removeCartItem(UUID itemId) {
        itemRepository.deleteById(itemId);    }
}
