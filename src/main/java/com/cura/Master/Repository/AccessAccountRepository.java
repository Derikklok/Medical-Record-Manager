package com.cura.Master.Repository;

import com.cura.Master.Entity.AccessAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccessAccountRepository extends JpaRepository<AccessAccount , Long> {
    List<AccessAccount> findByOrganizationNameAndOwnerUsername(String organizationName, String ownerUsername);
    Optional<AccessAccount> findByUsername(String username);
}
