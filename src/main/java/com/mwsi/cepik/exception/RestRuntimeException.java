package com.mwsi.cepik.exception;

import lombok.Getter;

public class RestRuntimeException extends RuntimeException {

    @Getter
    private String responseMessage;

    public RestRuntimeException(String message, String responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }
}
