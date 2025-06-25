package com.cura.Master.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private LocalDate date;
    private String appointmentType;
    private String notes;
    private String assistantUsername;
    private String doctorUsername;
    private String organizationName;
    private String diagnosisDetails;
    private String additionalNotes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "diagnosis_id") // Foreign key in Prescription table
    private List<Prescription> prescription;
}
