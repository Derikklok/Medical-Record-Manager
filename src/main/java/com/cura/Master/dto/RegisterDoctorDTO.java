package com.cura.Master.dto;

import lombok.Data;

@Data
public class RegisterDoctorDTO {
    private String firstName;
    private String lastName;
    private String regNo;
    private String nic;
    private String dateOfBirth;
    private String mobileNo;
    private String username;
    private String password;
}
