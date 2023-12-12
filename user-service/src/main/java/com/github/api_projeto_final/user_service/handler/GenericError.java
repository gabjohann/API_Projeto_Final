package com.github.api_projeto_final.user_service.handler;

public class GenericError extends RuntimeException {
    public GenericError(String message) {
        super(message);
    }
}
