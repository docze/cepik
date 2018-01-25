package com.mwsi.cepik.exception.cek;

import com.mwsi.cepik.exception.RestRuntimeException;

public class PenaltyPointsNotFoundException extends RestRuntimeException {

    public PenaltyPointsNotFoundException(Long id) {
        super("Not found penalty points with id = " + id, "Nie znaleziono punktów karnych o id = " + id);
    }
}
