package com.slaw.shop.controller;

import com.slaw.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartItemsController {

    private final CartService cartService;

    @GetMapping("/cart/{cartId}/items")
    public List<Item> cart(@PathVariable Long cartId) {
        return cartService.findByCartId(cartId).map(Cart::getItems).orElseThrow(() -> new CartNotFoundException(cartId));
    }

    @DeleteMapping("/cart/{cartId}/items/{itemId}")
    public void removeCartItem(@PathVariable Long cartId, @RequestParam Long itemId) {
        cartService.removeCartItem(cartId, itemId);
    }

}
