package com.ecommerce.library.Exceptions;

public class CannotDeleteCategoryException extends RuntimeException{
    public CannotDeleteCategoryException(String message) {
        super(message);
    }
}
