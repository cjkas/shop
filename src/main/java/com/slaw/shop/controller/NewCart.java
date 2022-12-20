package com.slaw.shop.controller;

import com.slaw.shop.service.CartEntity;
import com.slaw.shop.service.ItemEntity;
import lombok.Value;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Value
public class NewCart {

    List<NewItem> items;

    public CartEntity toEntity() {
        return new CartEntity(null, Stream.ofNullable(items)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .map(newItem -> new ItemEntity(null, newItem.getItemId())
                ).toList());
    }

    @Value
    public static class NewItem {
        Long itemId;
    }


}


