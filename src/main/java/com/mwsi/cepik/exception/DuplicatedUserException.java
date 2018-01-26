package com.mwsi.cepik.exception;

public class DuplicatedUserException extends RestRuntimeException {
    public DuplicatedUserException(String email) {
        super("User with email = " + email + " already exists", "Użytkownik o adresie email = " + email + " już istnieje");
    }
}
