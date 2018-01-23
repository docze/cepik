package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.repository.DrivingLicenceRepository;
import com.mwsi.cepik.exception.DrivingLicenceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DrivingLicenceService {

    private final DrivingLicenceRepository drivingLicenceRepository;

    @Transactional
    public void add(DrivingLicence drivingLicence){
        drivingLicenceRepository.save(drivingLicence);
    }

    public DrivingLicence findById(Long id) {
        return drivingLicenceRepository.findById(id).orElseThrow(() -> new DrivingLicenceNotFoundException(id));
    }

    public List<DrivingLicence> findAll() {
        return drivingLicenceRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        drivingLicenceRepository.delete(id);
    }

    @Transactional
    public void update(DrivingLicence drivingLicence, Long id) {
        DrivingLicence dbDrivingLicence = drivingLicenceRepository.getOne(id);
        dbDrivingLicence.setFrom(drivingLicence.getFrom());
        dbDrivingLicence.setTo(drivingLicence.getTo());
        dbDrivingLicence.setSequence(drivingLicence.getSequence());
        dbDrivingLicence.setDriver(drivingLicence.getDriver());
    }
}
