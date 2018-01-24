package com.mwsi.cepik.cek.model.form;

import com.mwsi.cepik.cek.model.Authorisation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorisationForm {

    private Authorisation.Category category;
    private java.sql.Date from;
    private java.sql.Date to;

    @NotNull
    private Long driverId;
}
