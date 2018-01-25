package com.mwsi.cepik.exception.cek;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedDrivingLicenceException extends RestRuntimeException {

    public DuplicatedDrivingLicenceException(String sequence) {
        super("Driving licence with sequence = " + sequence + " already exists", "Prawo jazdy o numerze serii = " + sequence + " już istnieje");
    }
}
