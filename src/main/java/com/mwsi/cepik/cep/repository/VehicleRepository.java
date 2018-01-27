package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findById(Long id);

    int countByVinOrEngineNumber(String vin, String engineNumber);
}
