package com.slaw.shop.controller;

import com.slaw.shop.domain.Cart;
import com.slaw.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {

    private final CartService cartService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cart")
    public Cart save(@RequestBody NewCart newCart) {
        return cartService.save(newCart.toDomain());
    }

}
