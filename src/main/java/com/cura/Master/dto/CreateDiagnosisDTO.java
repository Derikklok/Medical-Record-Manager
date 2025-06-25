package com.cura.Master.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateDiagnosisDTO {
    private String patientName;
    private String date; // "yyyy-MM-dd" format
    private String appointmentType;
    private String notes;
    private String assistantUsername;
    private String doctorUsername;
    private String organizationName;
    private String diagnosisDetails;
    private String additionalNotes;
    private List<PrescriptionDTO> prescription;
}
