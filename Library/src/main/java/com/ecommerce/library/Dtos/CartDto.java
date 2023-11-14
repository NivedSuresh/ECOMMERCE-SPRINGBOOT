package com.ecommerce.library.Dtos;

import com.ecommerce.library.Model.User.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter @Getter
public class CartDto {
    private Long id;
    private Customer customer;
    private double totalPrice;
    private int totalItems;
    private Map<String, CartItemDto> cartItems;
}
