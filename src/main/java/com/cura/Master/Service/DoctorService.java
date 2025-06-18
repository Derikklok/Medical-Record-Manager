package com.cura.Master.Service;

import com.cura.Master.Entity.Doctor;
import com.cura.Master.dto.RegisterDoctorDTO;

public interface DoctorService {
    Doctor register(RegisterDoctorDTO dto);
    Doctor login(String username, String password);
}
