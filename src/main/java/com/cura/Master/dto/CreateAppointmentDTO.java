package com.cura.Master.dto;

import lombok.Data;

@Data
public class CreateAppointmentDTO {
    private String patientName;
    private String date;
    private String appointmentType;
    private String notes;
    private String assistantUsername;
    private String doctorUsername;
    private String organizationName;
    private String status;
}
