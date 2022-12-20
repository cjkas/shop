package com.slaw.shop.service;

import com.slaw.shop.controller.CartNotFoundException;
import com.slaw.shop.controller.NewItem;
import com.slaw.shop.domain.Cart;
import com.slaw.shop.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Cart findByCartId(Long cartId) {
        return cartRepository.findById(cartId).map(Cart::from).orElseThrow(() -> new CartNotFoundException(cartId));
    }

    @Transactional
    public Cart save(Cart newCart) {
        return Cart.from(cartRepository.save(CartEntity.from(newCart)));
    }

    public void removeCartItem(Long cartId, Long itemId) {
        itemRepository.deleteCartItem(cartId, itemId);
    }

    @Transactional
    public Item addCartItem(Long cartId, NewItem newItem) {
        var cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
        var item = new ItemEntity(null, cart, newItem.getProductId());
        return Item.from(itemRepository.save(item));
    }


}
