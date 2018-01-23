package com.mwsi.cepik.cek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DriverForm {

    @Size(min = 3, max = 50)
    private String city;

    @Size(min = 6, max = 6)
    private String zipCode;

    @Size(min = 3, max = 50)
    private String street;

    @Size(min = 1, max = 5)
    private String houseNumber;

    @Size(max = 5)
    private String residenceNumber;

    @Size(min = 11, max = 11)
    private String pesel;

    @Size(min = 3, max = 50)
    private String firstName;

    @Size(min = 3, max = 50)
    private String lastName;

    private java.sql.Date examinationElapseDate;
}
