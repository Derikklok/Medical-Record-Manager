package com.cura.Master.Service;

import com.cura.Master.Entity.Patient;
import com.cura.Master.dto.RegisterPatientDTO;

import java.util.List;

public interface PatientService {
    Patient register(RegisterPatientDTO dto);
    Patient login(String username, String password);
    List<Patient> searchByQuery(String query);

}
