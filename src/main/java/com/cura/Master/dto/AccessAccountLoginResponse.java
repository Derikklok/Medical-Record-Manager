package com.cura.Master.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessAccountLoginResponse {
    private String username;
    private String message;
    private boolean success;
    private String organizationName;
    private String ownerName;
}
