package com.cura.Master.Repository;

import com.cura.Master.Entity.AccessAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessAccountRepository extends JpaRepository<AccessAccount , Long> {
    List<AccessAccount> findByOrganizationNameAndOwnerUsername(String organizationName, String ownerUsername);
}
