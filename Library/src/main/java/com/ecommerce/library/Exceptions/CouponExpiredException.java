package com.ecommerce.library.Exceptions;

public class CouponExpiredException  extends RuntimeException{
    public CouponExpiredException(String message) {
        super(message);
    }
}
