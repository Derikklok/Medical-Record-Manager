package com.cura.Master.Service;

import com.cura.Master.Entity.Diagnosis;
import com.cura.Master.Entity.Prescription;
import com.cura.Master.Repository.DiagnosisRepository;
import com.cura.Master.dto.CreateDiagnosisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService{

    private final DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis createDiagnosis(CreateDiagnosisDTO dto) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setPatientName(dto.getPatientName());
        diagnosis.setDate(LocalDate.parse(dto.getDate()));
        diagnosis.setAppointmentType(dto.getAppointmentType());
        diagnosis.setNotes(dto.getNotes());
        diagnosis.setAssistantUsername(dto.getAssistantUsername());
        diagnosis.setDoctorUsername(dto.getDoctorUsername());
        diagnosis.setOrganizationName(dto.getOrganizationName());
        diagnosis.setDiagnosisDetails(dto.getDiagnosisDetails());
        diagnosis.setAdditionalNotes(dto.getAdditionalNotes());

        diagnosis.setPrescription(
                dto.getPrescription().stream().map(p -> {
                    Prescription presc = new Prescription();
                    presc.setMedicineName(p.getMedicineName());
                    presc.setDosage(p.getDosage());
                    presc.setFrequency(p.getFrequency());
                    presc.setDuration(p.getDuration());
                    return presc;
                }).collect(Collectors.toList())
        );

        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public List<Diagnosis> getByOrganizationName(String organizationName) {
        return diagnosisRepository.findByOrganizationName(organizationName);
    }

}
