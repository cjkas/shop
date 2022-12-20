package com.slaw.shop.controller;

import com.slaw.shop.domain.Item;
import com.slaw.shop.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartItemsController.class)
class CartItemsControllerTest {

    @MockBean
    CartService cartService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void addCartItem() throws Exception {
        when(cartService.addCartItem(eq(123L), any())).thenReturn(new Item(1L, 223L));
        this.mockMvc.perform(put("/cart/123/items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                        {
                                        "productId": 567
                                        }
                                        """
                        )).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.productId").value("223"));

    }
}