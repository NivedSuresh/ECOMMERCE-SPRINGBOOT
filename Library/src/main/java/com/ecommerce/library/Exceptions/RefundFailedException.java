package com.ecommerce.library.Exceptions;

public class RefundFailedException extends RuntimeException{
    public RefundFailedException(String message) {
        super(message);
    }
}
