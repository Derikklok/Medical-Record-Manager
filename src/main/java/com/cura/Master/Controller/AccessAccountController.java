package com.cura.Master.Controller;

import com.cura.Master.Entity.AccessAccount;
import com.cura.Master.Entity.Doctor;
import com.cura.Master.Repository.DoctorRepository;
import com.cura.Master.Service.AccessAccountService;
import com.cura.Master.dto.AccessAccountLoginRequest;
import com.cura.Master.dto.AccessAccountLoginResponse;
import com.cura.Master.dto.CreateAccessAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/access-accounts")
@RequiredArgsConstructor
public class AccessAccountController {
    private final AccessAccountService accessAccountService;
    private final DoctorRepository doctorRepository; // Add repository injection


    @PostMapping("/create")
    public ResponseEntity<AccessAccount> create(@RequestBody CreateAccessAccountDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accessAccountService.createAccessAccount(dto));
    }

    @GetMapping
    public ResponseEntity<List<AccessAccount>> getByOrganization(
            @RequestParam String organizationName,
            @RequestParam String ownerUsername
    ) {
        return ResponseEntity.ok(accessAccountService.getAccessAccounts(organizationName, ownerUsername));
    }

    @DeleteMapping("/{accessId}")
    public ResponseEntity<Void> delete(@PathVariable Long accessId) {
        accessAccountService.deleteAccessAccount(accessId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccessAccountLoginRequest request) {
        try {
            AccessAccount account = accessAccountService.login(request.getUsername(), request.getPassword());

            String organizationName = account.getOrganizationName();
            String ownerUsername = account.getOwnerUsername();

            // Fetch organization name and owner's full name (doctor)
            Optional<Doctor> doctorOpt = doctorRepository.findByUsername(ownerUsername);
            String ownerName = doctorOpt.map(Doctor::getUsername).orElse("Unknown");

            AccessAccountLoginResponse response = new AccessAccountLoginResponse(
                    account.getUsername(),
                    "Login successful",
                    true,
                    organizationName,
                    ownerName
            );

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AccessAccountLoginResponse(
                            request.getUsername(),
                            e.getMessage(),
                            false,
                            null,
                            null
                    ));
        }
    }


}
