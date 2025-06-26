package com.cura.Master.Repository;

import com.cura.Master.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
    // ✅ Custom finder by organization name
    List<Appointment> findByOrganizationName(String organizationName);
    List<Appointment> findByPatientName(String patientName);
    List<Appointment> findByPatientNameContainingIgnoreCase(String patientName);

}
