package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    Optional<CarModel> findById(Long id);

    int countByModel(String model);
}
