package com.mwsi.cepik.cep.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleForm {

    @NotNull
    private Long carModelId;

    @Size(min = 4, max = 4)
    private String productionYear;

    @Size(min = 17, max = 17)
    private String vin;

    @NotEmpty
    private String engineNumber;

    @NotNull
    private int enginePower;

    @NotNull
    private double engineCapacity;

    @NotNull
    private int numberOfSeats;

    @NotNull
    private java.sql.Date firstRegistrationDate;

    @NotNull
    private int curbWeight;

    @NotNull
    private int permissibleLadenMass;

    @NotNull
    private int numberOfAxies;

    @NotNull
    private boolean privileged;

    @NotNull
    private java.sql.Date servicingDate;

}
