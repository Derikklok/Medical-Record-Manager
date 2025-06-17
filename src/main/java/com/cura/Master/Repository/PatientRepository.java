package com.cura.Master.Repository;

import com.cura.Master.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient , Long> {
    Optional<Patient> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByNic(String nic);
    boolean existsByPassword(String password);
}
