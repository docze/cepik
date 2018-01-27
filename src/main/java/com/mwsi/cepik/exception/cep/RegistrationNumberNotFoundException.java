package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class RegistrationNumberNotFoundException extends RestRuntimeException {
    public RegistrationNumberNotFoundException(Long id) {
        super("Not found registration number with id = " + id, "Nie znaleziono numeru rejestracyjnego o id = " + id);
    }
}
