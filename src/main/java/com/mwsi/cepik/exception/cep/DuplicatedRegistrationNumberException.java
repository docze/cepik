package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedRegistrationNumberException extends RestRuntimeException {
    public DuplicatedRegistrationNumberException(String registrationNumber) {
        super("Registration number = " + registrationNumber + " already exists", "Numer rejestracyjny = " + registrationNumber + " już istnieje");
    }
}
