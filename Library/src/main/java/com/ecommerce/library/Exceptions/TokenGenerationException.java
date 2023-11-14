package com.ecommerce.library.Exceptions;

import lombok.Getter;

@Getter
public class TokenGenerationException extends RuntimeException{
    String viewMessage;
    public TokenGenerationException(String message, String viewMessage) {
        super(message); this.viewMessage = viewMessage;}
}
