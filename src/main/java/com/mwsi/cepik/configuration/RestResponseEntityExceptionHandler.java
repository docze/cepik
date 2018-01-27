package com.mwsi.cepik.configuration;

import com.mwsi.cepik.exception.DuplicatedUserException;
import com.mwsi.cepik.exception.FormValidationException;
import com.mwsi.cepik.exception.RestRuntimeException;
import com.mwsi.cepik.exception.UserNotFoundException;
import com.mwsi.cepik.exception.cek.*;
import com.mwsi.cepik.exception.cep.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            UserNotFoundException.class, DriverNotFoundException.class,
            DrivingLicenceNotFoundException.class, AuthorisationNotFoundException.class,
            PenaltyPointsNotFoundException.class, CarBrandNotFoundException.class,
            CarModelNotFoundException.class, CarOwnerNotFoundException.class,
            OCInsuranceNotFoundException.class, RegistrationDocumentNotFoundException.class,
            RegistrationNumberNotFoundException.class, VehicleNotFoundException.class
    })
    protected ResponseEntity<String> handleNotFound(RestRuntimeException ex) {
        return new ResponseEntity<>(ex.getResponseMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {FormValidationException.class})
    protected ResponseEntity<String> handleFormValidationException(FormValidationException ex) {
        StringBuilder builder = new StringBuilder();
        List<FieldError> errors = ex.getFieldErrors();
        for (FieldError error : errors) {
            builder.append(error.getField())
                    .append(" : ")
                    .append(error.getDefaultMessage())
                    .append("\n");
        }
        return new ResponseEntity<>(builder.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            DuplicatedDriverException.class, DuplicatedDrivingLicenceException.class,
            DuplicatedUserException.class, DuplicatedCarBrandException.class,
            DuplicatedCarModelException.class, DuplicatedCarOwnerException.class,
            DuplicatedOCInsuranceException.class, DuplicatedRegistrationDocumentException.class,
            DuplicatedRegistrationNumberException.class, DuplicatedVehicleException.class
    })
    protected ResponseEntity<String> handleDuplicate(RestRuntimeException ex) {
        return new ResponseEntity<>(ex.getResponseMessage(), HttpStatus.CONFLICT);
    }
}
