package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.repository.DrivingLicenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DrivingLicenceService {

    private final DrivingLicenceRepository drivingLicenceRepository;

    @Transactional
    public void add(DrivingLicence drivingLicence){
        drivingLicenceRepository.save(drivingLicence);
    }

}
