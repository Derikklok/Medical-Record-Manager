package com.cura.Master.Service;

import com.cura.Master.Entity.Doctor;
import com.cura.Master.Repository.DoctorRepository;
import com.cura.Master.dto.RegisterDoctorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor register(RegisterDoctorDTO dto) {
        if (doctorRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        Doctor doctor = new Doctor();
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setRegNo(dto.getRegNo());
        doctor.setNic(dto.getNic());
        doctor.setDateOfBirth(dto.getDateOfBirth());
        doctor.setMobileNo(dto.getMobileNo());
        doctor.setUsername(dto.getUsername());
        doctor.setPassword(dto.getPassword());

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor login(String username, String password) {
        return doctorRepository.findByUsername(username)
                .filter(d -> d.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }
}
