package com.cura.Master.Service;

import com.cura.Master.Entity.Diagnosis;
import com.cura.Master.dto.CreateDiagnosisDTO;

import java.util.List;

public interface DiagnosisService {
    Diagnosis createDiagnosis(CreateDiagnosisDTO dto);
    List<Diagnosis> getByOrganizationName(String organizationName);

}
