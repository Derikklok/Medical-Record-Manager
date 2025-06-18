package com.cura.Master.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String regNo;
    private String nic;
    private String dateOfBirth;
    private String mobileNo;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String password;
}
