package com.mwsi.cepik.cek.service;

import com.mwsi.cepik.cek.model.Authorisation;
import com.mwsi.cepik.cek.repository.AuthorisationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class AuthorisationService {

    private final AuthorisationRepository authorisationRepository;

    @Transactional
    public void add(Authorisation authorisation) {
        authorisationRepository.save(authorisation);
    }

}
