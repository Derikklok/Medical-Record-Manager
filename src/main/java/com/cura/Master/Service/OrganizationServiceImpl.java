package com.cura.Master.Service;

import com.cura.Master.Entity.Organization;
import com.cura.Master.Repository.OrganizationRepository;
import com.cura.Master.dto.CreateOrganizationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public Organization createOrganization(CreateOrganizationDTO dto) {
        Organization org = new Organization();
        org.setName(dto.getName());
        org.setOwnerUsername(dto.getOwnerUsername());
//        org.setWorkers(dto.getWorkers()); // can be empty or null
        return organizationRepository.save(org);
    }

    @Override
    public List<Organization> getOrganizationsByDoctor(String doctorUsername) {
        return organizationRepository.findByOwnerUsername(doctorUsername);
    }

}
