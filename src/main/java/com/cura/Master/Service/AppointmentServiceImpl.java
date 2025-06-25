package com.cura.Master.Service;

import com.cura.Master.Entity.Appointment;
import com.cura.Master.Repository.AppointmentRepository;
import com.cura.Master.dto.CreateAppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService{
    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(CreateAppointmentDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setPatientName(dto.getPatientName());
        appointment.setDate(dto.getDate());
        appointment.setAppointmentType(dto.getAppointmentType());
        appointment.setNotes(dto.getNotes());
        appointment.setAssistantUsername(dto.getAssistantUsername());
        appointment.setDoctorUsername(dto.getDoctorUsername());
        appointment.setOrganizationName(dto.getOrganizationName());
        appointment.setStatus(dto.getStatus());

        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAppointmentsByOrganization(String organizationName) {
        return appointmentRepository.findByOrganizationName(organizationName);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    @Override
    public Appointment updateStatus(Long id, String newStatus) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        appointment.setStatus(newStatus);
        return appointmentRepository.save(appointment);
    }


}
