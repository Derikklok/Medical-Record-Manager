package com.cura.Master.dto;

import lombok.Data;

@Data
public class CreateAccessAccountDTO {
    private String username;
    private String password;
    private String organizationName;
    private String ownerUsername;
}
