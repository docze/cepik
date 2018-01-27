package com.mwsi.cepik.cep.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OCInsuranceForm {

    @NotNull
    private java.sql.Date from;

    @NotNull
    private java.sql.Date to;

    @NotEmpty
    private String policyNumberWithPIN;

    @NotNull
    private Long carOwnerId;

    @NotNull
    private Long vehicleId;
}
