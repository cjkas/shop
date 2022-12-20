package com.slaw.shop.controller;

import com.slaw.shop.service.CartEntity;
import lombok.Value;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;

@Value
public class Cart {
    Long id;
    Collection<Item> items;

    public static Cart from(CartEntity cartEntity) {
        return new Cart(cartEntity.getId(), Stream.ofNullable(cartEntity.getItems())
                .flatMap(Collection::stream)
                .map(Item::from).toList());
    }
}
