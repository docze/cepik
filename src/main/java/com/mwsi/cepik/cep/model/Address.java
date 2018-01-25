package com.mwsi.cepik.cep.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Column(name = "miasto", length = 50)
    private String city;

    @Column(name = "kod_pocztowy", length = 6)
    private String zipCode;

    @Column(name = "ulica", length = 50)
    private String street;

    @Column(name = "numer_domu", length = 5)
    private String houseNumber;

    @Column(name = "numer_mieszkania", length = 5)
    private String residenceNumber;



}
