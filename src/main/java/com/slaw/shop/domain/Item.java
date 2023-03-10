package com.slaw.shop.domain;

import com.slaw.shop.service.ItemEntity;
import lombok.Value;

@Value
public class Item {
    Long id;
    Long productId;

    public static Item from(ItemEntity itemEntity) {
        return new Item(itemEntity.getId(), itemEntity.getProductId());
    }
}
