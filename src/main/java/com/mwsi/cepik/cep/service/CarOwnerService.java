package com.mwsi.cepik.cep.service;

import com.mwsi.cepik.cek.model.Address;
import com.mwsi.cepik.cep.model.CarOwner;
import com.mwsi.cepik.cep.model.RegistrationDocument;
import com.mwsi.cepik.cep.model.form.CarOwnerForm;
import com.mwsi.cepik.cep.repository.CarOwnerRepository;
import com.mwsi.cepik.exception.cep.CarOwnerNotFoundException;
import com.mwsi.cepik.exception.cep.DuplicatedCarOwnerException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CarOwnerService {

    private final CarOwnerRepository carOwnerRepository;
    private final RegistrationDocumentService registrationDocumentService;

    @Transactional
    public CarOwner add(CarOwnerForm carOwnerForm) {
        if (isDuplicated(carOwnerForm)) {
            throw new DuplicatedCarOwnerException(carOwnerForm.getPesel(), carOwnerForm.getRegon());
        }
        Address address = new Address(
                carOwnerForm.getCity(), carOwnerForm.getZipCode(),
                carOwnerForm.getStreet(), carOwnerForm.getHouseNumber(),
                carOwnerForm.getResidenceNumber()
        );
        CarOwner carOwner = new CarOwner();
        carOwner.setAddress(address);
        carOwner.setFirstName(carOwnerForm.getFirstName());
        carOwner.setLastName(carOwnerForm.getLastName());
        carOwner.setInstitution(carOwnerForm.getInstitution());
        carOwner.setPesel(carOwnerForm.getPesel());
        carOwner.setRegon(carOwnerForm.getRegon());
        List<RegistrationDocument> registrationDocumentList = carOwnerForm.getRegistrationDocumentIdsList().stream()
                .map(registrationDocumentService::findById)
                .collect(Collectors.toList());
        carOwner.setRegistrationDocumentList(registrationDocumentList);
        return carOwnerRepository.save(carOwner);
    }

    public CarOwner findById(Long id) {
        return carOwnerRepository.findById(id).orElseThrow(() -> new CarOwnerNotFoundException(id));
    }

    public List<CarOwner> findAll() {
        return carOwnerRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        carOwnerRepository.delete(id);
    }

    @Transactional
    public CarOwner update(CarOwnerForm carOwnerForm, Long id) {
        Address address = new Address(
                carOwnerForm.getCity(), carOwnerForm.getZipCode(),
                carOwnerForm.getStreet(), carOwnerForm.getHouseNumber(),
                carOwnerForm.getResidenceNumber()
        );
        CarOwner dbCarOwner = findById(id);
        dbCarOwner.setAddress(address);
        dbCarOwner.setFirstName(carOwnerForm.getFirstName());
        dbCarOwner.setLastName(carOwnerForm.getLastName());
        dbCarOwner.setInstitution(carOwnerForm.getInstitution());
        dbCarOwner.setPesel(carOwnerForm.getPesel());
        dbCarOwner.setRegon(carOwnerForm.getRegon());
        List<RegistrationDocument> registrationDocumentList = carOwnerForm.getRegistrationDocumentIdsList().stream()
                .map(registrationDocumentService::findById)
                .collect(Collectors.toList());
        dbCarOwner.setRegistrationDocumentList(registrationDocumentList);
        return carOwnerRepository.save(dbCarOwner);
    }

    private boolean isDuplicated(CarOwnerForm carOwnerForm) {
        if (carOwnerForm.getPesel() == null) {
            return 0 != carOwnerRepository.countByRegon(carOwnerForm.getRegon());
        } else {
            return 0 != carOwnerRepository.countByPesel(carOwnerForm.getPesel());
        }
    }
}
