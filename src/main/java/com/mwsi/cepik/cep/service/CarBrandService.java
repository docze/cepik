package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cep.model.CarBrand;
import com.mwsi.cepik.cep.model.form.CarBrandForm;
import com.mwsi.cepik.cep.repository.CarBrandRepository;
import com.mwsi.cepik.exception.cep.CarBrandNotFoundException;
import com.mwsi.cepik.exception.cep.DuplicatedCarBrandException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CarBrandService {

    private final CarBrandRepository carBrandRepository;

    @Transactional
    public CarBrand add(CarBrandForm carBrandForm) {
        if (isDuplicated(carBrandForm)) {
            throw new DuplicatedCarBrandException(carBrandForm.getBrand());
        }
        return carBrandRepository.save(new CarBrand(carBrandForm.getBrand()));
    }

    public CarBrand findById(Long id) {
        return carBrandRepository.findById(id).orElseThrow(() -> new CarBrandNotFoundException(id));
    }

    public List<CarBrand> findAll() {
        return carBrandRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        carBrandRepository.delete(id);
    }

    @Transactional
    public CarBrand update(CarBrandForm carBrandForm, Long id) {
        CarBrand carBrand = findById(id);
        carBrand.setBrand(carBrandForm.getBrand());
        return carBrandRepository.save(carBrand);
    }

    private boolean isDuplicated(CarBrandForm carBrandForm) {
        int count = carBrandRepository.countByBrand(carBrandForm.getBrand());
        return count != 0;
    }
}
