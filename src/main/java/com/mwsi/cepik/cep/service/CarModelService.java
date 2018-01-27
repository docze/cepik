package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cep.model.CarBrand;
import com.mwsi.cepik.cep.model.CarModel;
import com.mwsi.cepik.cep.model.form.CarModelForm;
import com.mwsi.cepik.cep.repository.CarModelRepository;
import com.mwsi.cepik.exception.cep.CarModelNotFoundException;
import com.mwsi.cepik.exception.cep.DuplicatedCarModelException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CarModelService {

    private final CarModelRepository carModelRepository;
    private final CarBrandService carBrandService;

    @Transactional
    public CarModel add(CarModelForm carModelForm) {
        if (isDuplicated(carModelForm)) {
            throw new DuplicatedCarModelException(carModelForm.getModel());
        }
        CarBrand carBrand = carBrandService.findById(carModelForm.getCarBrandId());
        CarModel carModel = new CarModel();
        carModel.setModel(carModelForm.getModel());
        carModel.setBrand(carBrand);
        return carModelRepository.save(carModel);
    }

    public CarModel findById(Long id) {
        return carModelRepository.findById(id).orElseThrow(() -> new CarModelNotFoundException(id));
    }

    public List<CarModel> findAll() {
        return carModelRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        carModelRepository.delete(id);
    }

    @Transactional
    public CarModel update(CarModelForm carModelForm, Long id) {
        CarBrand carBrand = carBrandService.findById(carModelForm.getCarBrandId());
        CarModel dbCarModel = findById(id);
        dbCarModel.setModel(carModelForm.getModel());
        dbCarModel.setBrand(carBrand);
        return carModelRepository.save(dbCarModel);
    }

    private boolean isDuplicated(CarModelForm carModelForm) {
        int count = carModelRepository.countByModel(carModelForm.getModel());
        return count != 0;
    }
}
