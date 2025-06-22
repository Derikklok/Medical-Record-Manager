package com.cura.Master.Controller;

import com.cura.Master.Entity.Appointment;
import com.cura.Master.Service.AppointmentService;
import com.cura.Master.dto.CreateAppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/organization/{organizationName}")
    public ResponseEntity<?> getAppointmentsByOrganization(@PathVariable String organizationName) {
        try {
            List<Appointment> appointments = appointmentService.getAppointmentsByOrganization(organizationName);
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch appointments.");
        }
    }


    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody CreateAppointmentDTO dto) {
        try {
            Appointment saved = appointmentService.createAppointment(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to save appointment");
        }
    }
}
