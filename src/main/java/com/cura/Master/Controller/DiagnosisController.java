package com.cura.Master.Controller;

import com.cura.Master.Entity.Diagnosis;
import com.cura.Master.Service.DiagnosisService;
import com.cura.Master.dto.CreateDiagnosisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnoses")
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @PostMapping
    public ResponseEntity<?> createDiagnosis(@RequestBody CreateDiagnosisDTO dto) {
        try {
            Diagnosis diagnosis = diagnosisService.createDiagnosis(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(diagnosis);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/by-organization")
    public ResponseEntity<?> getByOrganization(@RequestParam String organizationName) {
        List<Diagnosis> list = diagnosisService.getByOrganizationName(organizationName);
        return ResponseEntity.ok(list);
    }

}
