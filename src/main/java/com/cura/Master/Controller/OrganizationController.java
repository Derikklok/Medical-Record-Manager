package com.cura.Master.Controller;

import com.cura.Master.Entity.Organization;
import com.cura.Master.Service.OrganizationService;
import com.cura.Master.dto.CreateOrganizationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrganization(@RequestBody CreateOrganizationDTO dto) {
        try {
            Organization created = organizationService.createOrganization(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/by-owner/{username}")
    public ResponseEntity<List<Organization>> getDoctorOrganizations(@PathVariable String username) {
        return ResponseEntity.ok(organizationService.getOrganizationsByDoctor(username));
    }
}
