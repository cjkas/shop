package com.slaw.shop.service;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ItemEntity {
    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private CartEntity cart;

    private Long itemId;

}
