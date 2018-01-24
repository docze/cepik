package com.mwsi.cepik.cek.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PenaltyPointsForm {

    @NotNull
    @Min(1)
    private int count;

    private java.sql.Date date;

    @NotNull
    private Long driverId;
}
