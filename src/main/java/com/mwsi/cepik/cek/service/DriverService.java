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
    public void add(Driver driver){
        driverRepository.save(driver);
    }

    public Driver findById(Long id){
        return driverRepository.findById(id).orElseThrow(() -> new DriverNotFoundException(id));
    }

    public Driver findByPesel(String pesel){
        return driverRepository.findByPesel(pesel).orElseThrow(() -> new DriverNotFoundException(pesel));
    }

    public List<Driver> findAll(){
        return driverRepository.findAll();
    }

}

