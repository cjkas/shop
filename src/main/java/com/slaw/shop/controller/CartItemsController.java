package com.slaw.shop.controller;

import com.slaw.shop.domain.Item;
import com.slaw.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CartItemsController {

    private final CartService cartService;

    @PutMapping("/cart/{cartId}/items")
    public Item addCartItem(@PathVariable Long cartId, @RequestBody NewItem newItem) {
        return cartService.addCartItem(cartId, newItem);
    }

    @GetMapping("/cart/{cartId}/items")
    public List<Item> cartItems(@PathVariable Long cartId) {
        return cartService.findByCartId(cartId).getItems();
    }

    @DeleteMapping("/cart/{cartId}/items/{itemId}")
    public void removeCartItem(@PathVariable Long cartId, @RequestParam Long itemId) {
        cartService.removeCartItem(cartId, itemId);
    }

}
