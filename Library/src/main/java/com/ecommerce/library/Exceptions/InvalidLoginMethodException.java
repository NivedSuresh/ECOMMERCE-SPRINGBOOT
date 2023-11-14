package com.ecommerce.library.Exceptions;

public class InvalidLoginMethodException extends RuntimeException{
    public InvalidLoginMethodException(String message) {
        super(message);
    }
}
