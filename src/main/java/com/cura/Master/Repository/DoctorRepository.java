package com.cura.Master.Repository;

import com.cura.Master.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Custom query methods can be defined here if needed
    Optional<Doctor> findByUsername(String username);
    boolean existsByUsername(String username);
}
