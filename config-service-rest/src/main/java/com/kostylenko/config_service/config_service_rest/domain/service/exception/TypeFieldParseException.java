package com.kostylenko.config_service.config_service_rest.domain.service.exception;

public class TypeFieldParseException extends Exception {

    private String message;

    public TypeFieldParseException(String message) {
        super(message);
    }
}
