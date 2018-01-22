package com.mwsi.cepik.exception;

public class UserNotFoundException extends RestRuntimeException {

    public UserNotFoundException(Integer userId) {
        super("Not found user with id = " + userId, "Nie znaleziono użytkownika o id = " + userId);
    }
}
