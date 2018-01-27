package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cep.model.RegistrationDocument;
import com.mwsi.cepik.cep.model.Vehicle;
import com.mwsi.cepik.cep.model.form.RegistrationDocumentForm;
import com.mwsi.cepik.cep.repository.RegistrationDocumentRepository;
import com.mwsi.cepik.exception.cep.DuplicatedRegistrationDocumentException;
import com.mwsi.cepik.exception.cep.RegistrationDocumentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class RegistrationDocumentService {

    private final RegistrationDocumentRepository registrationDocumentRepository;
    private final VehicleService vehicleService;

    @Transactional
    public RegistrationDocument add(RegistrationDocumentForm registrationDocumentForm) {
        if (isDuplicated(registrationDocumentForm)) {
            throw new DuplicatedRegistrationDocumentException(registrationDocumentForm.getSequence());
        }
        Vehicle vehicle = vehicleService.findById(registrationDocumentForm.getVehicleId());
        RegistrationDocument registrationDocument = new RegistrationDocument();
        registrationDocument.setSequence(registrationDocumentForm.getSequence());
        registrationDocument.setTo(registrationDocumentForm.getTo());
        registrationDocument.setVehicle(vehicle);
        return registrationDocumentRepository.save(registrationDocument);
    }

    public RegistrationDocument findById(Long id) {
        return registrationDocumentRepository.findById(id).orElseThrow(() -> new RegistrationDocumentNotFoundException(id));
    }

    public List<RegistrationDocument> findAll() {
        return registrationDocumentRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        registrationDocumentRepository.delete(id);
    }

    @Transactional
    public RegistrationDocument update(RegistrationDocumentForm registrationDocumentForm, Long id) {
        Vehicle vehicle = vehicleService.findById(registrationDocumentForm.getVehicleId());
        RegistrationDocument dbRegistrationDocument = findById(id);
        dbRegistrationDocument.setSequence(registrationDocumentForm.getSequence());
        dbRegistrationDocument.setTo(registrationDocumentForm.getTo());
        dbRegistrationDocument.setVehicle(vehicle);
        return registrationDocumentRepository.save(dbRegistrationDocument);
    }

    private boolean isDuplicated(RegistrationDocumentForm registrationDocumentForm) {
        int count = registrationDocumentRepository.countBySequence(registrationDocumentForm.getSequence());
        return count != 0;
    }
}
