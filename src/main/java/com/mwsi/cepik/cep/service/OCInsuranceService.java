package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cep.model.CarOwner;
import com.mwsi.cepik.cep.model.OCInsurance;
import com.mwsi.cepik.cep.model.Vehicle;
import com.mwsi.cepik.cep.model.form.OCInsuranceForm;
import com.mwsi.cepik.cep.repository.OCInsuranceRepository;
import com.mwsi.cepik.exception.cep.DuplicatedOCInsuranceException;
import com.mwsi.cepik.exception.cep.OCInsuranceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class OCInsuranceService {

    private final OCInsuranceRepository ocInsuranceRepository;
    private final CarOwnerService carOwnerService;
    private final VehicleService vehicleService;

    @Transactional
    public OCInsurance add(OCInsuranceForm ocInsuranceForm) {
        if (isDuplicated(ocInsuranceForm)) {
            throw new DuplicatedOCInsuranceException(ocInsuranceForm.getPolicyNumberWithPIN());
        }
        CarOwner carOwner = carOwnerService.findById(ocInsuranceForm.getCarOwnerId());
        Vehicle vehicle = vehicleService.findById(ocInsuranceForm.getVehicleId());
        OCInsurance ocInsurance = new OCInsurance();
        ocInsurance.setVehicle(vehicle);
        ocInsurance.setCarOwner(carOwner);
        ocInsurance.setPolicyNumberWithPIN(ocInsuranceForm.getPolicyNumberWithPIN());
        ocInsurance.setFrom(ocInsuranceForm.getFrom());
        ocInsurance.setTo(ocInsuranceForm.getTo());
        return ocInsuranceRepository.save(ocInsurance);
    }

    public OCInsurance findById(Long id) {
        return ocInsuranceRepository.findById(id).orElseThrow(() -> new OCInsuranceNotFoundException(id));
    }

    public List<OCInsurance> findAll() {
        return ocInsuranceRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        ocInsuranceRepository.delete(id);
    }

    @Transactional
    public OCInsurance update(OCInsuranceForm ocInsuranceForm, Long id) {
        CarOwner carOwner = carOwnerService.findById(ocInsuranceForm.getCarOwnerId());
        Vehicle vehicle = vehicleService.findById(ocInsuranceForm.getVehicleId());
        OCInsurance dbOCInsurance = findById(id);
        dbOCInsurance.setVehicle(vehicle);
        dbOCInsurance.setCarOwner(carOwner);
        dbOCInsurance.setPolicyNumberWithPIN(ocInsuranceForm.getPolicyNumberWithPIN());
        dbOCInsurance.setFrom(ocInsuranceForm.getFrom());
        dbOCInsurance.setTo(ocInsuranceForm.getTo());
        return ocInsuranceRepository.save(dbOCInsurance);
    }

    private boolean isDuplicated(OCInsuranceForm ocInsuranceForm) {
        int count = ocInsuranceRepository.countByPolicyNumberWithPIN(ocInsuranceForm.getPolicyNumberWithPIN());
        return count != 0;
    }
}
