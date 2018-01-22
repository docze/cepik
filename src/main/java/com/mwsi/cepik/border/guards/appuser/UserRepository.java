package com.mwsi.cepik.border.guards.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}