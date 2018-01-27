package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class CarBrandNotFoundException extends RestRuntimeException {
    public CarBrandNotFoundException(Long id) {
        super("Not found car brand with id = " + id, "Nie znaleziono marki samochodu o id = " + id);
    }
}
