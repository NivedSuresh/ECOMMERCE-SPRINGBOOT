package com.ecommerce.library.Exceptions;

public class CannotApplyCouponException extends RuntimeException{
    public CannotApplyCouponException(String message) {
        super(message);
    }
}
