package com.mwsi.cepik.exception;

public class DuplicatedUserException extends RestRuntimeException {
    public DuplicatedUserException(String email, String name) {
        super("User with email = " + email + " or name = " + name + " already exists",
                "Użytkownik o adresie email = " + email + " lub nazwie = " + name + " już istnieje");
    }
}
