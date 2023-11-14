package com.ecommerce.library.ProductsService;

import com.ecommerce.library.Dtos.CouponDto;
import com.ecommerce.library.Model.User.Cart;
import com.ecommerce.library.Model.User.Coupon;

import java.util.List;

public interface CouponService {
    List<Coupon> findAll();

    void save(Coupon coupon);

    Coupon dtoToEntity(CouponDto coupon, Long id);
    boolean existsById(Long id);
    Coupon findById(Long id);
    CouponDto entityToDto(Coupon byId);
    void applyCoupon(String email, String couponCode);
    void removeCoupon(String email);
    List<Coupon> findAvailableForCustomer(Cart cart);
}
