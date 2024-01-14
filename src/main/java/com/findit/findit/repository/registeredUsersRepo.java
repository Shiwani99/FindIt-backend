package com.findit.findit.repository;
import com.findit.findit.models.registeredUsersModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface registeredUsersRepo extends JpaRepository<registeredUsersModel, Long> {

    boolean existsByEmail(String email);
    Optional<registeredUsersModel> findByEmail(String email);
}
