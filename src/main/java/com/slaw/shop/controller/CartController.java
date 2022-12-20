package com.slaw.shop.controller;

import com.slaw.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController("/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public Cart cart(@RequestParam UUID cartId) {
        return cartService.findByCartId(cartId).orElseThrow(() -> new CartNotFoundException(cartId));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cart save(NewCart newCart) {
        return cartService.save(newCart);
    }

    @DeleteMapping
    public void removeCartItem(@RequestParam UUID itemId) {
        cartService.removeCartItem(itemId);
    }
}
