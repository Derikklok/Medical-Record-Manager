package com.cura.Master.Repository;

import com.cura.Master.Entity.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    List<Diagnosis> findByOrganizationName(String organizationName);

}
