package com.slaw.shop.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

@NoArgsConstructor
@Getter
@Setter
public class NewItem {
    @NotBlank
    private Long productId;
}
