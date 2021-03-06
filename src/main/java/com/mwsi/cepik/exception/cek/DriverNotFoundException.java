package com.mwsi.cepik.exception.cek;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DriverNotFoundException extends RestRuntimeException {

    public DriverNotFoundException(Long driverId) {
        super("Not found driver with id = " + driverId, "Nie znaleziono kierowcy o id = " + driverId);
    }

    public DriverNotFoundException(String driverPESEL) {
        super("Not found driver with PESEL = " + driverPESEL, "Nie znaleziono kierowcy o PESEL = " + driverPESEL);
    }
}
