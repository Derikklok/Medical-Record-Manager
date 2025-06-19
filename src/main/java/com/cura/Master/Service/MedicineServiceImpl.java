package com.cura.Master.Service;

import com.cura.Master.Entity.Medicine;
import com.cura.Master.Repository.MedicineRepository;
import com.cura.Master.dto.CreateMedicineDTO;
import com.cura.Master.dto.UpdateMedicineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService{

    private final MedicineRepository medicineRepository;

    @Override
    public Medicine addMedicine(CreateMedicineDTO dto) {
        Medicine medicine = new Medicine();
        medicine.setName(dto.getName());
        medicine.setKeyword(dto.getKeyword());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setQuantity(dto.getQuantity());
        medicine.setExpiry(dto.getExpiry()); // Simply set the LocalDate directly
        medicine.setCategory(dto.getCategory());
        medicine.setNotes(dto.getNotes());
        medicine.setOrganizationName(dto.getOrganizationName());
        medicine.setCreatedBy(dto.getCreatedBy());
        return medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> getAllByOrganization(String organizationName) {
        return medicineRepository.findByOrganizationName(organizationName);
    }

    @Override
    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
    @Override
    public Medicine getById(Long id) {
        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine not found"));
    }

    @Override
    public Medicine updateMedicine(Long id, UpdateMedicineDTO dto) {
        Medicine medicine = getById(id);
        medicine.setName(dto.getName());
        medicine.setKeyword(dto.getKeyword());
        medicine.setManufacturer(dto.getManufacturer());
        medicine.setQuantity(dto.getQuantity());
        medicine.setExpiry(LocalDate.parse(dto.getExpiry())); // Convert String to LocalDate
        medicine.setCategory(dto.getCategory());
        medicine.setNotes(dto.getNotes());
        return medicineRepository.save(medicine);
    }
}
