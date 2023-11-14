package com.ecommerce.library.Dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data @AllArgsConstructor
public class CouponDto {
    Long id;
    @NotNull(message = "Coupon Code cannot be Null")
    private String coupon;
    @NotNull(message = "A minimum of 1% off should be provided")
    private Double offPercentage;
    @NotNull(message = "Max Discount amount cannot be Null")
    private Double maxOffAmount;
    @NotNull(message = "Usage allowed per user cannot be Null")
    private Integer usageAllowedPerCustomer;
    private String isActive;
    @NotNull(message = "Expiry Date Cannot be null")
    private LocalDateTime couponExpiryDate;

    @NotNull(message = "Minimum Spend should be mentioned")
    private Double minSpend;
}
