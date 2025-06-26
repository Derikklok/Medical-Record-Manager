package com.cura.Master.Service;

import com.cura.Master.Entity.Doctor;
import com.cura.Master.dto.DoctorResponseDTO;
import com.cura.Master.dto.RegisterDoctorDTO;

import java.util.List;

public interface DoctorService {
    Doctor register(RegisterDoctorDTO dto);
    Doctor login(String username, String password);
    List<DoctorResponseDTO> getAllDoctorSummaries();



}
