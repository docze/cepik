package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.DrivingLicence;
import com.mwsi.cepik.cek.model.form.DrivingLicenceForm;
import com.mwsi.cepik.cek.repository.DrivingLicenceRepository;
import com.mwsi.cepik.exception.cek.DrivingLicenceNotFoundException;
import com.mwsi.cepik.exception.cek.DuplicatedDriverException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class DrivingLicenceService {

    private final DrivingLicenceRepository drivingLicenceRepository;
    private final DriverService driverService;

    @Transactional
    public DrivingLicence add(DrivingLicenceForm drivingLicenceForm) {
        if (isDuplicated(drivingLicenceForm)) {
            throw new DuplicatedDriverException(drivingLicenceForm.getSequence());
        }

        Driver driver = driverService.findById(drivingLicenceForm.getDriverId());
        DrivingLicence drivingLicence = new DrivingLicence(
                drivingLicenceForm.getFrom(),
                drivingLicenceForm.getTo(),
                drivingLicenceForm.getSequence(),
                driver
        );
        return drivingLicenceRepository.save(drivingLicence);
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
    public DrivingLicence update(DrivingLicenceForm drivingLicenceForm, Long id) {
        Driver driver = driverService.findById(drivingLicenceForm.getDriverId());
        DrivingLicence dbDrivingLicence = drivingLicenceRepository.getOne(id);
        dbDrivingLicence.setFrom(drivingLicenceForm.getFrom());
        dbDrivingLicence.setTo(drivingLicenceForm.getTo());
        dbDrivingLicence.setSequence(drivingLicenceForm.getSequence());
        dbDrivingLicence.setDriver(driver);
        return drivingLicenceRepository.save(dbDrivingLicence);
    }

    private boolean isDuplicated(DrivingLicenceForm drivingLicenceForm) {
        int count = drivingLicenceRepository.countBySequence(drivingLicenceForm.getSequence());
        return count != 0;
    }
}
