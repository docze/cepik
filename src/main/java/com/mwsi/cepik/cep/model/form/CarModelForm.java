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
public class CarModelForm {

    @NotEmpty
    @Size(max = 50)
    private String model;

    @NotNull
    private Long carBrandId;
}
