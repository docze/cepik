package com.mwsi.cepik.exception.cek;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedDriverException extends RestRuntimeException {

    public DuplicatedDriverException(String pesel) {
        super("Driver with PESEL = " + pesel + " already exists", "Kierowca o numerze PESEL = " + pesel + " już istnieje");
    }
}
