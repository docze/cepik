package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.OCInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OCInsuranceRepository extends JpaRepository<OCInsurance, Long> {
    Optional<OCInsurance> findById(Long id);

    int countByPolicyNumberWithPIN(String policyNumberWithPIN);
}
