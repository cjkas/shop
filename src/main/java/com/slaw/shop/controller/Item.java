package com.slaw.shop.controller;

import com.slaw.shop.service.ItemEntity;
import lombok.Value;

import java.util.UUID;

@Value
public class Item {
    Long itemId;

    public static Item from(ItemEntity itemEntity) {
        return new Item(itemEntity.getItemId());
    }
}
