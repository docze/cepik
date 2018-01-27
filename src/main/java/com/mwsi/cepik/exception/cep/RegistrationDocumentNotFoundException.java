package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class RegistrationDocumentNotFoundException extends RestRuntimeException {
    public RegistrationDocumentNotFoundException(Long id) {
        super("Not found registration document with id = " + id, "Nie znaleziono dowodu rejestracyjnego o id = " + id);
    }
}
