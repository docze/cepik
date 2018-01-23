package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.Address;
import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.form.DriverForm;
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
    public void add(DriverForm driverForm) {
        driverRepository.save(new Driver(driverForm));
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
    public void update(DriverForm driverForm, Long id) {
        Address address = new Address(
                driverForm.getCity(), driverForm.getZipCode(),
                driverForm.getStreet(), driverForm.getHouseNumber(),
                driverForm.getResidenceNumber()
        );
        Driver dbDriver = findById(id);
        dbDriver.setAddress(address);
        dbDriver.setPesel(driverForm.getPesel());
        dbDriver.setFirstName(driverForm.getFirstName());
        dbDriver.setLastName(driverForm.getLastName());
        dbDriver.setExaminationElapseDate(driverForm.getExaminationElapseDate());
        driverRepository.save(dbDriver);
    }
}

