package com.mwsi.cepik.cep.repository;

import com.mwsi.cepik.cep.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
