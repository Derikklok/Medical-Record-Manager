package com.cura.Master.Service;

import com.cura.Master.Entity.Organization;
import com.cura.Master.dto.CreateOrganizationDTO;

import java.util.List;

public interface OrganizationService {
    Organization createOrganization(CreateOrganizationDTO dto);
    List<Organization> getOrganizationsByDoctor(String doctorUsername);
}
