package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedCarBrandException extends RestRuntimeException {
    public DuplicatedCarBrandException(String name) {
        super("Car brand with name = " + name + " already exists", "Marka o nazwie = " + name + " już istnieje");

    }
}
