package com.cura.Master.Repository;

import com.cura.Master.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine , Long> {
    List<Medicine> findByOrganizationName(String organizationName);

}
