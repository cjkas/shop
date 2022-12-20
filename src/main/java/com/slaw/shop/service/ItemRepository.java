package com.slaw.shop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {


    @Modifying
    @Query("Delete from ItemEntity e where e.itemId = :itemId and e.cart.id = :cartId")
    void deleteCartItem(Long cartId, Long itemId);
}
