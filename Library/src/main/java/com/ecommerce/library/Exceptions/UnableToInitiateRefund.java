package com.ecommerce.library.Exceptions;

public class UnableToInitiateRefund extends RuntimeException{
    public UnableToInitiateRefund(String message) {
        super(message);
    }
}
