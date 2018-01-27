package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedRegistrationDocumentException extends RestRuntimeException {
    public DuplicatedRegistrationDocumentException(String sequence) {
        super("Registration document with sequence = " + sequence + " already exists",
                "Dowod rejestracyjny o numerze serii  = " + sequence + " już istnieje");
    }
}
