package com.mwsi.cepik.cep.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarOwnerForm {

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

    @Size(max = 11)
    private String pesel;

    @Size(max = 9)
    private String regon;

    @Size(min = 3, max = 50)
    private String firstName;

    @Size(min = 3, max = 50)
    private String lastName;

    @Size(max = 50)
    private String institution;

    private List<Long> registrationDocumentIdsList;

}
