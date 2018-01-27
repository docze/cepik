package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class VehicleNotFoundException extends RestRuntimeException {
    public VehicleNotFoundException(Long id) {
        super("Not found vehicle with id = " + id, "Nie znaleziono samochodu o id = " + id);
    }
}
