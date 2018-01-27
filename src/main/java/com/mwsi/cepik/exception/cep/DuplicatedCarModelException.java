package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedCarModelException extends RestRuntimeException {
    public DuplicatedCarModelException(String model) {
        super("Car model with name = " + model + " already exists", "Model samochodu o nazwie = " + model + " już istnieje");
    }
}
