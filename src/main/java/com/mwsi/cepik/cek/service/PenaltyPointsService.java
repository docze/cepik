package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.PenaltyPoints;
import com.mwsi.cepik.cek.model.form.PenaltyPointsForm;
import com.mwsi.cepik.cek.repository.PenaltyPointsRepository;
import com.mwsi.cepik.exception.PenaltyPointsNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PenaltyPointsService {

    private final PenaltyPointsRepository penaltyPointsRepository;
    private final DriverService driverService;

    @Transactional
    public void add(PenaltyPointsForm penaltyPointsForm) {
        Driver driver = driverService.findById(penaltyPointsForm.getDriverId());
        PenaltyPoints penaltyPoints = new PenaltyPoints();
        penaltyPoints.setCount(penaltyPointsForm.getCount());
        penaltyPoints.setDate(penaltyPointsForm.getDate());
        penaltyPoints.setDriver(driver);
        penaltyPointsRepository.save(penaltyPoints);
    }

    public PenaltyPoints findById(Long id) {
        return penaltyPointsRepository.findById(id).orElseThrow(() -> new PenaltyPointsNotFoundException(id));
    }

    public List<PenaltyPoints> findAll() {
        return penaltyPointsRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        penaltyPointsRepository.delete(id);
    }

    @Transactional
    public void update(PenaltyPointsForm penaltyPointsForm, Long id) {
        Driver driver = driverService.findById(penaltyPointsForm.getDriverId());
        PenaltyPoints dbPenaltyPoints = findById(id);
        dbPenaltyPoints.setCount(penaltyPointsForm.getCount());
        dbPenaltyPoints.setDate(penaltyPointsForm.getDate());
        dbPenaltyPoints.setDriver(driver);
        penaltyPointsRepository.save(dbPenaltyPoints);
    }
}
