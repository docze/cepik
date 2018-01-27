package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.Authorisation;
import com.mwsi.cepik.cek.model.Driver;
import com.mwsi.cepik.cek.model.form.AuthorisationForm;
import com.mwsi.cepik.cek.repository.AuthorisationRepository;
import com.mwsi.cepik.exception.cek.AuthorisationNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class AuthorisationService {

    private final AuthorisationRepository authorisationRepository;
    private final DriverService driverService;

    @Transactional
    public Authorisation add(AuthorisationForm authorisationForm) {
        Driver driver = driverService.findById(authorisationForm.getDriverId());
        Authorisation authorisation = new Authorisation();
        authorisation.setCategory(authorisationForm.getCategory());
        authorisation.setFrom(authorisationForm.getFrom());
        authorisation.setTo(authorisationForm.getTo());
        authorisation.setDriver(driver);
        return authorisationRepository.save(authorisation);
    }

    public Authorisation findById(Long id) {
        return authorisationRepository.findById(id).orElseThrow(() -> new AuthorisationNotFoundException(id));
    }

    public List<Authorisation> findAll() {
        return authorisationRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        authorisationRepository.delete(id);
    }

    @Transactional
    public Authorisation update(AuthorisationForm authorisationForm, Long id) {
        Driver driver = driverService.findById(authorisationForm.getDriverId());
        Authorisation dbAuthorisation = findById(id);
        dbAuthorisation.setCategory(authorisationForm.getCategory());
        dbAuthorisation.setFrom(authorisationForm.getFrom());
        dbAuthorisation.setTo(authorisationForm.getTo());
        dbAuthorisation.setDriver(driver);
        return authorisationRepository.save(dbAuthorisation);
    }
}
