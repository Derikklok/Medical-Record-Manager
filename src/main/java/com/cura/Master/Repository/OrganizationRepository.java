package com.cura.Master.Repository;

import com.cura.Master.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization , Long > {
    List<Organization> findByOwnerUsername(String ownerUsername);
    Optional<Organization> findByName(String name);
}
