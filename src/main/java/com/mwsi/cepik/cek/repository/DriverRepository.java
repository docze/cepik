package com.mwsi.cepik.cek.repository;

import com.mwsi.cepik.cek.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByPesel(String pesel);
    Optional<Driver> findById(Long id);
}
