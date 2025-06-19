package com.cura.Master.Service;

import com.cura.Master.Entity.Medicine;
import com.cura.Master.dto.CreateMedicineDTO;
import com.cura.Master.dto.UpdateMedicineDTO;

import java.util.List;

public interface MedicineService {
    Medicine addMedicine(CreateMedicineDTO dto);
    List<Medicine> getAllByOrganization(String organizationName);
    void deleteMedicine(Long id);
    Medicine getById(Long id);
    Medicine updateMedicine(Long id, UpdateMedicineDTO dto);
}
