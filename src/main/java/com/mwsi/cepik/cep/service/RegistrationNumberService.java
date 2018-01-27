package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cep.model.RegistrationNumber;
import com.mwsi.cepik.cep.model.Vehicle;
import com.mwsi.cepik.cep.model.form.RegistrationNumberForm;
import com.mwsi.cepik.cep.repository.RegistrationNumberRepository;
import com.mwsi.cepik.exception.cep.DuplicatedRegistrationNumberException;
import com.mwsi.cepik.exception.cep.RegistrationNumberNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class RegistrationNumberService {

    private final RegistrationNumberRepository registrationNumberRepository;
    private final VehicleService vehicleService;

    @Transactional
    public RegistrationNumber add(RegistrationNumberForm registrationNumberForm) {
        if (isDuplicated(registrationNumberForm)) {
            throw new DuplicatedRegistrationNumberException(registrationNumberForm.getRegistrationNumber());
        }
        Vehicle vehicle = vehicleService.findById(registrationNumberForm.getVehicleId());
        RegistrationNumber registrationNumber = new RegistrationNumber();
        registrationNumber.setRegistrationNumber(registrationNumberForm.getRegistrationNumber());
        registrationNumber.setActual(registrationNumberForm.isActual());
        registrationNumber.setVehicle(vehicle);
        return registrationNumberRepository.save(registrationNumber);
    }

    public RegistrationNumber findById(Long id) {
        return registrationNumberRepository.findById(id).orElseThrow(() -> new RegistrationNumberNotFoundException(id));
    }

    public List<RegistrationNumber> findAll() {
        return registrationNumberRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        registrationNumberRepository.delete(id);
    }

    @Transactional
    public RegistrationNumber update(RegistrationNumberForm registrationNumberForm, Long id) {
        Vehicle vehicle = vehicleService.findById(registrationNumberForm.getVehicleId());
        RegistrationNumber dbRegistrationNumber = findById(id);
        dbRegistrationNumber.setRegistrationNumber(registrationNumberForm.getRegistrationNumber());
        dbRegistrationNumber.setActual(registrationNumberForm.isActual());
        dbRegistrationNumber.setVehicle(vehicle);
        return registrationNumberRepository.save(dbRegistrationNumber);
    }

    private boolean isDuplicated(RegistrationNumberForm registrationNumberForm) {
        int count = registrationNumberRepository.countByRegistrationNumber(registrationNumberForm.getRegistrationNumber());
        return count != 0;
    }
}
