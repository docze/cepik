package com.mwsi.cepik.exception;

public class AuthorisationNotFoundException extends RestRuntimeException {

    public AuthorisationNotFoundException(Long id) {
        super("Not found authorisation with id = " + id, "Nie znaleziono uprawnienia o id = " + id);
    }
}
