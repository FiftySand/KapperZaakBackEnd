package logic;

import logic.interfaces.IAppointmentCollection;
import org.springframework.stereotype.Service;
import repository.IAppointmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentCollection implements IAppointmentCollection {

    private static IAppointmentRepository _appointmentRepository;

    public AppointmentCollection(IAppointmentRepository appointmentRepository) {
        _appointmentRepository = appointmentRepository;
    }

    @Override
    public void createAppointment(Appointment appointment) {
        _appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return _appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointment> getAppointment(int id) {
        return _appointmentRepository.findById(id);
    }

    @Override
    public void deleteAppointment(int id) {
        _appointmentRepository.deleteById(id);
    }

}