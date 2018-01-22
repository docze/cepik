package com.mwsi.cepik.configuration;

import com.mwsi.cepik.exception.RestRuntimeException;
import com.mwsi.cepik.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    protected ResponseEntity<String> handleNotFound(RestRuntimeException ex) {
        return new ResponseEntity<>(ex.getResponseMessage(), HttpStatus.NOT_FOUND);
    }
}
