package com.slaw.shop.service;

import com.slaw.shop.controller.CartNotFoundException;
import com.slaw.shop.controller.NewItem;
import com.slaw.shop.domain.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public Cart findByCartId(Long cartId) {
        return cartRepository.findById(cartId).map(Cart::from).orElseThrow(() -> new CartNotFoundException(cartId));
    }

    public Cart save(Cart newCart) {
        return Cart.from(cartRepository.save(CartEntity.from(newCart)));
    }

    public void removeCartItem(Long cartId, Long itemId) {
        itemRepository.deleteCartItem(cartId, itemId);
    }

    public void addCartItem(Long cartId, NewItem newItem) {
        var cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
        var item = new ItemEntity(null, cart, newItem.getItemId());
        itemRepository.save(item);
    }


}
