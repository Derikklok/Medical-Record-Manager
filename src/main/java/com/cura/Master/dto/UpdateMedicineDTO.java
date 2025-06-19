package com.cura.Master.dto;

import lombok.Data;

@Data
public class UpdateMedicineDTO {
    private String name;
    private String keyword;
    private String manufacturer;
    private int quantity;
    private String expiry;
    private String category;
    private String notes;
}
