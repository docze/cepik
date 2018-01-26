package com.mwsi.cepik.border.guards.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);

    Optional<User> findById(Integer id);

    int countByEmail(String email);

    int countByEmailOrName(String email, String name);
}
