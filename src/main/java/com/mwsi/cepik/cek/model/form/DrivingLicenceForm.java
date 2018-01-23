package com.mwsi.cepik.cek.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DrivingLicenceForm {

    private java.sql.Date from;
    private java.sql.Date to;

    @Size(max = 50)
    private String sequence;

    @NotNull
    private Long driverId;
}
