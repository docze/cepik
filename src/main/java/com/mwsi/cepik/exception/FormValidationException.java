package com.mwsi.cepik.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

public class FormValidationException extends RuntimeException {

    @Getter
    private List<FieldError> fieldErrors;

    public FormValidationException(List<FieldError> fieldErrors) {
        super("Form validation error");
        this.fieldErrors = fieldErrors;
    }
}
