package com.cura.Master.Repository;

import com.cura.Master.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient , Long> {
    Optional<Patient> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByNic(String nic);
    boolean existsByPassword(String password);

    // For search functionality (case-insensitive partial match)
    @Query("SELECT p FROM Patient p WHERE LOWER(p.firstName) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(p.lastName) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(p.nic) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Patient> searchByQuery(String query);
}
