package com.slaw.shop.controller;

import com.slaw.shop.domain.Cart;
import com.slaw.shop.domain.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor
@Getter
@Setter
public class NewCart {

    @NotEmpty
    List<NewItem> items;

    public Cart toDomain() {
        var items = Stream.ofNullable(this.items).flatMap(Collection::stream).map(i -> new Item(i.getItemId())).toList();
        return new Cart(null, items);
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class NewItem {
        @NotBlank
        Long itemId;
    }


}


