package com.cura.Master.Service;

import com.cura.Master.Entity.Patient;
import com.cura.Master.Repository.PatientRepository;
import com.cura.Master.dto.RegisterPatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient register(RegisterPatientDTO dto) {
        if (patientRepository.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (patientRepository.existsByNic(dto.getNic())) {
            throw new RuntimeException("NIC already exists");
        }
        if (patientRepository.existsByPassword(dto.getPassword())) {
            throw new RuntimeException("Password already exists");
        }

        Patient patient = new Patient();
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setFullName(dto.getFirstName() + " " + dto.getLastName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setNic(dto.getNic());
        patient.setMobile(dto.getMobile());
        patient.setUsername(dto.getUsername());
        patient.setPassword(dto.getPassword());

        return patientRepository.save(patient);
    }

    @Override
    public Patient login(String username, String password) {
        return patientRepository.findByUsername(username)
                .filter(p -> p.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    @Override
    public List<Patient> searchByQuery(String query) {
        return patientRepository.searchByQuery(query);
    }

}
