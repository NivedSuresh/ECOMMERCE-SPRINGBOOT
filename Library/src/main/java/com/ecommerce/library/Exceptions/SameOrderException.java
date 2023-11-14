package com.ecommerce.library.Exceptions;

public class SameOrderException extends RuntimeException{

    public SameOrderException(String message) {
        super(message);
    }
}
