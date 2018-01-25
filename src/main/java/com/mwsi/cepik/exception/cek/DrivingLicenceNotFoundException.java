package com.mwsi.cepik.exception.cek;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DrivingLicenceNotFoundException extends RestRuntimeException {

    public DrivingLicenceNotFoundException(Long id) {
        super("Not found driving licence with id = " + id, "Nie znaleziono prawa jazdy o id = " + id);
    }
}
