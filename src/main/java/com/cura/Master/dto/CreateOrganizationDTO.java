package com.cura.Master.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrganizationDTO {
    private String name;
    private String ownerUsername; // fetched from localStorage and sent from frontend
    private List<String> workers; // optional at creation time
}
