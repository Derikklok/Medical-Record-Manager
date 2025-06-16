package com.cura.Master.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterPatientDTO {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate dateOfBirth;

    @NotBlank
    private String nic;

    @NotBlank
    private String mobile;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
