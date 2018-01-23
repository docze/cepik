package com.mwsi.cepik.cek.repository;

import com.mwsi.cepik.cek.model.Authorisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorisationRepository extends JpaRepository<Authorisation, Long> {
}
