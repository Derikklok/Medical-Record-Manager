package com.cura.Master.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;

}
