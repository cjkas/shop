package com.slaw.shop.service;

import com.slaw.shop.domain.Cart;
import com.slaw.shop.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CartServiceIntegrationTest {

    @Autowired
    private CartService cartService;

    @Test
    public void saveNewCart() {
        //given
        var cart = new Cart(null, List.of(new Item(null, 123456L)));
        //when
        var savedCart = cartService.save(cart);
        //then
        assertNotNull(savedCart.getId());
    }

    @Test
    public void findCartById() {
        //given
        var cart = new Cart(null, List.of(new Item(null, 123456L)));
        var savedCart = cartService.save(cart);
        //when
        var searchedCart = cartService.findByCartId(savedCart.getId());
        //then
        assertNotNull(searchedCart.getId());
    }

}