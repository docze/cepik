package com.mwsi.cepik.cep.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationNumberForm {

    @NotNull
    private Long vehicleId;

    @NotNull
    @Size(min = 7, max = 7)
    private String registrationNumber;

    @NotNull
    private boolean actual;
}
