package com.cura.Master.Controller;

import com.cura.Master.Entity.Doctor;
import com.cura.Master.Service.DoctorService;
import com.cura.Master.dto.DoctorResponseDTO;
import com.cura.Master.dto.LoginRequest;
import com.cura.Master.dto.LoginResponse;
import com.cura.Master.dto.RegisterDoctorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDoctorDTO dto) {
        try {
            Doctor saved = doctorService.register(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Doctor doctor = doctorService.login(request.getUsername(), request.getPassword());
            LoginResponse response = new LoginResponse(doctor.getUsername(), "Login successful", true);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(request.getUsername(), e.getMessage(), false));
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        List<DoctorResponseDTO> doctors = doctorService.getAllDoctorSummaries();
        return ResponseEntity.ok(doctors);
    }

}
