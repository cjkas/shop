package com.slaw.shop.service;

import com.slaw.shop.domain.Cart;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<ItemEntity> items;

    public static CartEntity from(Cart newCart) {
        var cartEntity = new CartEntity(null, null);
        cartEntity.setItems(Stream.ofNullable(newCart.getItems())
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .map(newItem -> new ItemEntity(null, cartEntity, newItem.getItemId())
                ).toList());
        return cartEntity;
    }
}
