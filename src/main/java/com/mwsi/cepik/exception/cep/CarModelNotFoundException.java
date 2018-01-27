package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class CarModelNotFoundException extends RestRuntimeException {
    public CarModelNotFoundException(Long id) {
        super("Not found car model with id = " + id, "Nie znaleziono modelu samochodu o id = " + id);
    }
}
