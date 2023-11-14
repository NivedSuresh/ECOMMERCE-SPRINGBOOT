package com.ecommerce.library.Exceptions;

import lombok.Getter;

@Getter
public class UnableToMakeOrderException extends RuntimeException{
    String viewMessage;
    public UnableToMakeOrderException(String s, String viewMessage) {
        super(s);
        this.viewMessage = viewMessage;
    }
}
