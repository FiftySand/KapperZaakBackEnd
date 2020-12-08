package logic.interfaces;

import logic.Account;
import logic.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface IAppointmentCollection {
    void createAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Optional<Appointment> getAppointment(int id);
    void deleteAppointment(int id);
}