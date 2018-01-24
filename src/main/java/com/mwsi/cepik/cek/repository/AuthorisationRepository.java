package com.mwsi.cepik.cek.repository;

import com.mwsi.cepik.cek.model.Authorisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorisationRepository extends JpaRepository<Authorisation, Long> {
    Optional<Authorisation> findById(Long id);
}
