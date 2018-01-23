package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.repository.DriverRepository;
import com.mwsi.cepik.exception.DriverNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DriverService {

    private final DriverRepository driverRepository;

    @Transactional
    public void add(Driver driver) {
        driverRepository.save(driver);
    }

    public Driver findById(Long id) {
        return driverRepository.findById(id).orElseThrow(() -> new DriverNotFoundException(id));
    }

    public Driver findByPesel(String pesel) {
        return driverRepository.findByPesel(pesel).orElseThrow(() -> new DriverNotFoundException(pesel));
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        driverRepository.delete(id);
    }

    @Transactional
    public void update(Driver driver, Long id) {
        Driver dbDriver = driverRepository.getOne(id);
        dbDriver.setAddress(driver.getAddress());
        dbDriver.setPesel(driver.getPesel());
        dbDriver.setFirstName(driver.getFirstName());
        dbDriver.setLastName(driver.getLastName());
        dbDriver.setExaminationElapseDate(driver.getExaminationElapseDate());
    }
}

