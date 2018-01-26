package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.RegistrationNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationNumberRepository extends JpaRepository<RegistrationNumber, Long> {
}
