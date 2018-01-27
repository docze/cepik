package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedVehicleException extends RestRuntimeException {
    public DuplicatedVehicleException(String vin, String engineNumber) {
        super("Vehicle with VIN = " + vin + " or engine number = " + engineNumber + " already exists",
                "Pojazd o nr VIN = " + vin + " lub nr silnika = " + engineNumber + " już istnieje");
    }
}
