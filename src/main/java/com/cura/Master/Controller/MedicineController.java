package com.cura.Master.Controller;

import com.cura.Master.Entity.Medicine;
import com.cura.Master.Service.MedicineService;
import com.cura.Master.dto.CreateMedicineDTO;
import com.cura.Master.dto.UpdateMedicineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medicines")
public class MedicineController {
    private final MedicineService medicineService;

    @PostMapping("/add")
    public ResponseEntity<Medicine> add(@RequestBody CreateMedicineDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicineService.addMedicine(dto));
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAll(@RequestParam String organizationName) {
        return ResponseEntity.ok(medicineService.getAllByOrganization(organizationName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> update(@PathVariable Long id, @RequestBody UpdateMedicineDTO dto) {
        return ResponseEntity.ok(medicineService.updateMedicine(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
        return ResponseEntity.noContent().build();
    }
}
