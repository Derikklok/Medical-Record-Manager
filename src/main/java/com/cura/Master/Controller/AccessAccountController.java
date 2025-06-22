package com.cura.Master.Controller;

import com.cura.Master.Entity.AccessAccount;
import com.cura.Master.Service.AccessAccountService;
import com.cura.Master.dto.AccessAccountLoginRequest;
import com.cura.Master.dto.AccessAccountLoginResponse;
import com.cura.Master.dto.CreateAccessAccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/access-accounts")
@RequiredArgsConstructor
public class AccessAccountController {
    private final AccessAccountService accessAccountService;

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
            return ResponseEntity.ok(
                    new AccessAccountLoginResponse(account.getUsername(), "Login successful", true)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new AccessAccountLoginResponse(request.getUsername(), e.getMessage(), false));
        }
    }

}
