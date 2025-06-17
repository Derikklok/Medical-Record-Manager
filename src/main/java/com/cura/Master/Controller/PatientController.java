package com.cura.Master.Controller;

import com.cura.Master.Entity.Patient;
import com.cura.Master.Service.PatientService;
import com.cura.Master.dto.LoginRequest;
import com.cura.Master.dto.LoginResponse;
import com.cura.Master.dto.RegisterPatientDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterPatientDTO dto) {
        try {
            Patient saved = patientService.register(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved.getUsername());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Patient patient = patientService.login(request.getUsername(), request.getPassword());
            LoginResponse response = new LoginResponse(patient.getUsername(), "Login successful", true);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(request.getUsername(), e.getMessage(), false));
        }
    }
}
