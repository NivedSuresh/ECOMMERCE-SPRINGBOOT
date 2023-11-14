package com.ecommerce.library.Exceptions;

import lombok.Getter;

@Getter
public class SessionExpiredException extends RuntimeException{
    String viewMessage;
    public SessionExpiredException(String message, String viewMessage) {
        super(message);
        this.viewMessage = viewMessage;
    }
}
