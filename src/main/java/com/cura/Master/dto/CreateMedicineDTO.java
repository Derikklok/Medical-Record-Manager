package com.cura.Master.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateMedicineDTO {
    private String name;
    private String keyword;
    private String manufacturer;
    private int quantity;
    private LocalDate expiry;
    private String category;
    private String notes;
    private String organizationName;
    private String createdBy;
}
