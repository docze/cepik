package com.mwsi.cepik.cep.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarBrandForm {

    @NotEmpty
    @Size(max = 100)
    private String brand;

}
