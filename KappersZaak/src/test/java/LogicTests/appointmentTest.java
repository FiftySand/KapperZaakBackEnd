
package LogicTests;

import logic.Account;
import logic.Appointment;
import logic.AppointmentCollection;
import logic.Kapper;
import org.junit.jupiter.api.Test;
import testRepository.appointmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class appointmentTest {

    @Test
    public void getAppointment()
    {
        AppointmentCollection col = new AppointmentCollection(new appointmentRepository());
        //arrange
        Appointment actual1 = new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1);
        col.createAppointment(actual1);
        //act
        Appointment appointment1 = col.getAppointment(1).get();
        //assert
        assertEquals(actual1, appointment1);

    }

    @Test
    public void createAppointment()
    {
        AppointmentCollection col = new AppointmentCollection(new appointmentRepository());
        //arrange
        Appointment actual1 = new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1);
        col.createAppointment(actual1);
        //act
        Appointment appointment1 = col.getAppointment(1).get();
        //assert
        assertEquals(actual1, appointment1);
    }

    @Test
    public void getAllAppointments()
    {
        AppointmentCollection col = new AppointmentCollection(new appointmentRepository());

        //arrange
        int appointmentListSize = col.getAllAppointments().size();
        col.createAppointment(new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1));
        col.createAppointment(new Appointment(new Kapper(2,"name2", 22),new Account(2,"name2", "password2", "email2", false),2));
        col.createAppointment(new Appointment(new Kapper(3,"name3", 33),new Account(3,"name3", "password3", "email3", false),3));
        //act
        List<Appointment> appointmentList = col.getAllAppointments();
        //assert
        assertEquals(0, appointmentListSize);
        assertEquals(3, appointmentList.size());
    }

    @Test
    public void deleteAppointment()
    {
        AppointmentCollection col = new AppointmentCollection(new appointmentRepository());

        //arrange
        Appointment actual1 = new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1);
        Appointment actual2 = new Appointment(new Kapper(2,"name2", 22),new Account(2,"name2", "password2", "email2", false),2);
        col.createAppointment(actual1);
        col.createAppointment(actual2);
        int actual1Id = actual1.getId();
        //act
        col.deleteAppointment(actual1Id);
        //assert
        assertEquals(1, col.getAllAppointments().size());
        assertEquals(actual2, col.getAppointment(actual2.getId()).get());
        assertNotEquals(actual1, col.getAppointment(actual1.getId()).get());
    }
}

