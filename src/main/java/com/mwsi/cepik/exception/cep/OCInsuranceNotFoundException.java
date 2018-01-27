package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class OCInsuranceNotFoundException extends RestRuntimeException {
    public OCInsuranceNotFoundException(Long id) {
        super("Not found OC insurance with id = " + id, "Nie znaleziono ubezpiecznenia OC o id = " + id);
    }
}
