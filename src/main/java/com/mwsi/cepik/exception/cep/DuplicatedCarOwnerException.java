package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedCarOwnerException extends RestRuntimeException {
    public DuplicatedCarOwnerException(String pesel, String regon) {
        super("Car owner with pesel = " + pesel + " or regon = " + regon + " already exists",
                "Wlasciciel pojazdu o nr PESEL = " + pesel + " lub nr REGON = " + regon + " już istnieje");
    }
}
