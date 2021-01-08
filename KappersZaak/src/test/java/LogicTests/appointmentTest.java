package LogicTests;

import logic.Account;
import logic.Appointment;
import logic.Kapper;
import org.junit.Test;
import testRepository.appointmentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class appointmentTest {

    @Test
    public void getAppointment()
    {
        //arrange
        appointmentRepository rep = new appointmentRepository();
        Appointment actual1 = new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1);
        Appointment actual2 = new Appointment(new Kapper(2,"name2", 22),new Account(2,"name2", "password2", "email2", false),2);
        Appointment actual3 = new Appointment(new Kapper(3,"name3", 33),new Account(3,"name3", "password3", "email3", false),3);
        Appointment actual4 = new Appointment(new Kapper(4,"name4", 44),new Account(4,"name4", "password4", "email4", false),4);
        rep.createAppointment(actual1);
        rep.createAppointment(actual2);
        rep.createAppointment(actual3);
        rep.createAppointment(actual4);
        //act
        Appointment appointment1 = rep.getAppointment(1);
        Appointment appointment2 = rep.getAppointment(2);
        Appointment appointment3 = rep.getAppointment(3);
        Appointment appointment4 = rep.getAppointment(4);
        //assert
        assertEquals(actual1, appointment1);
        assertEquals(actual2, appointment2);
        assertEquals(actual3, appointment3);
        assertEquals(actual4, appointment4);

    }

    @Test
    public void createAppointment()
    {
        //arrange
        appointmentRepository rep = new appointmentRepository();
        Appointment appointment = new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1);
        //act
        rep.createAppointment(appointment);
        //assert
        assertEquals(appointment, rep.getAppointment(1));
    }

    @Test
    public void getAllAppointments()
    {
        //arrange
        appointmentRepository rep = new appointmentRepository();
        List<Appointment> appointments = new ArrayList<>();
        List<Appointment> appointmentsEmpty = new ArrayList<>();
        //act
        rep.createAppointment(new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1));
        rep.createAppointment(new Appointment(new Kapper(2,"name2", 22),new Account(2,"name2", "password2", "email2", false),2));
        rep.createAppointment(new Appointment(new Kapper(3,"name3", 33),new Account(3,"name3", "password3", "email3", false),3));
        rep.createAppointment(new Appointment(new Kapper(4,"name4", 44),new Account(4,"name4", "password4", "email4", false),4));
        appointments = rep.getAllAppointments();
        //assert
        assertNotEquals(appointmentsEmpty.size(), rep.getAllAppointments().size());
        assertEquals(appointments.size(), rep.getAllAppointments().size());
    }

    @Test
    public void deleteAppointment()
    {
        //arrange
        appointmentRepository rep = new appointmentRepository();
        Appointment actual1 = new Appointment(new Kapper(1,"name1", 11),new Account(1,"name1", "password1", "email1", false),1);
        Appointment actual2 = new Appointment(new Kapper(2,"name2", 22),new Account(2,"name2", "password2", "email2", false),2);
        Appointment actual3 = new Appointment(new Kapper(3,"name3", 33),new Account(3,"name3", "password3", "email3", false),3);
        Appointment actual4 = new Appointment(new Kapper(4,"name4", 44),new Account(4,"name4", "password4", "email4", false),4);
        rep.createAppointment(actual1);
        rep.createAppointment(actual2);
        rep.createAppointment(actual3);
        rep.createAppointment(actual4);
        //act
        rep.deleteAppointment(1);
        rep.deleteAppointment(3);
        //assert
        assertEquals(2, rep.getAllAppointments().size());
        assertEquals(actual2, rep.getAppointment(2));
        assertEquals(actual4, rep.getAppointment(4));
        assertNotEquals(actual1, rep.getAppointment(1));
        assertNotEquals(actual3, rep.getAppointment(3));
    }
}
