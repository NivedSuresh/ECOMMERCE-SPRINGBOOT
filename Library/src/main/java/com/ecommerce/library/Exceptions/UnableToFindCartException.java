package com.ecommerce.library.Exceptions;

public class UnableToFindCartException extends RuntimeException{

    public UnableToFindCartException(String message) {
        super(message);
    }
}
