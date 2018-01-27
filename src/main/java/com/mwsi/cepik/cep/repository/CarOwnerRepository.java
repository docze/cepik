package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.CarOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
    Optional<CarOwner> findById(Long id);

    int countByPeselOrRegon(String pesel, String regon);
}
