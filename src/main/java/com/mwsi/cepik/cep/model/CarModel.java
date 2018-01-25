package com.mwsi.cepik.cep.model;

import static com.mwsi.cepik.cep.model.CarBrand.AUDI;

public enum CarModel {
    A5(AUDI), A4(AUDI);

    CarModel(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    private CarBrand carBrand;

    @Override
    public String toString() {
        return this.name();
    }
}
