package com.cura.Master.Service;

import com.cura.Master.Entity.Appointment;
import com.cura.Master.dto.CreateAppointmentDTO;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(CreateAppointmentDTO dto);
    List<Appointment> getAppointmentsByOrganization(String organizationName);

}
