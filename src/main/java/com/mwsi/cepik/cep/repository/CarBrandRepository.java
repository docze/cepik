package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarBrandRepository extends JpaRepository<CarBrand, Long> {
    Optional<CarBrand> findById(Long id);

    int countByBrand(String brand);
}
