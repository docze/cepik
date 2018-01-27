package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class CarOwnerNotFoundException extends RestRuntimeException {
    public CarOwnerNotFoundException(Long id) {
        super("Not found car owner with id = " + id, "Nie znaleziono wlasciciela pojazdu o id = " + id);
    }
}
