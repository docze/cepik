package com.mwsi.cepik.exception.cep;

import com.mwsi.cepik.exception.RestRuntimeException;

public class DuplicatedOCInsuranceException extends RestRuntimeException {
    public DuplicatedOCInsuranceException(String policyNumberWithPIN) {
        super("OC insurance with policy number and PIN = " + policyNumberWithPIN + " already exists",
                "Ubezpieczenie OC o numerze i pinie = " + policyNumberWithPIN+ " już istnieje");
    }
}
