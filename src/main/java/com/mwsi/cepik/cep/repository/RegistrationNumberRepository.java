package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.RegistrationNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationNumberRepository extends JpaRepository<RegistrationNumber, Long> {
    Optional<RegistrationNumber> findById(Long id);

    int countByRegistrationNumber(String registrationNumber);
}
