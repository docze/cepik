package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.RegistrationDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationDocumentRepository extends JpaRepository<RegistrationDocument, Long> {
    Optional<RegistrationDocument> findById(Long id);

    int countBySequence(String sequence);
}
