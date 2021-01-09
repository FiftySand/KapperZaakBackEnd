package testRepository;

import logic.Appointment;

import java.util.ArrayList;
import java.util.List;

public class appointmentRepository {

    List<Appointment> appointments = new ArrayList<>();

    public void createAppointment(Appointment appointment)
    {
        appointments.add(appointment);
    }

    public List<Appointment> getAllAppointments()
    {
        return appointments;
    }

    public Appointment getAppointment(int id)
    {
        for (Appointment appointment: appointments)
        {
            if(appointment.getId() == id)
            {
                return appointment;
            }
        }
        return new Appointment();
    }

    public void deleteAppointment(int id)
    {
        appointments.removeIf((Appointment appointment) -> appointment.getId() == id);
    }
}
