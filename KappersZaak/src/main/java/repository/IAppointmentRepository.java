package repository;

import logic.Account;
import logic.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}