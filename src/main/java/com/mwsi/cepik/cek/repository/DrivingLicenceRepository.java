package com.mwsi.cepik.cek.repository;

import com.mwsi.cepik.cek.model.DrivingLicence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DrivingLicenceRepository extends JpaRepository<DrivingLicence, Long> {

    Optional<DrivingLicence> findById(Long id);
}
