package com.ecommerce.library.Exceptions;

import lombok.Getter;

@Getter
public class InvalidStateException extends RuntimeException{

    String viewMessage;
    public InvalidStateException(String s, String viewMessage) {
        super(s);
        this.viewMessage = viewMessage;
    }
}
