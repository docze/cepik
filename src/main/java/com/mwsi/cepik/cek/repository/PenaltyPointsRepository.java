package com.mwsi.cepik.cek.repository;

import com.mwsi.cepik.cek.model.PenaltyPoints;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PenaltyPointsRepository extends JpaRepository<PenaltyPoints, Long> {
    Optional<PenaltyPoints> findById(Long id);
}
