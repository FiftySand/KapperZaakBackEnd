

package logic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.interfaces.IAppointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import logic.Kapper;
import repository.IAppointmentRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Service
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Appointment implements IAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne()
    @JoinColumn(name = "FK_account", insertable = false, updatable = false)
    private Account Account;

    @ManyToOne()
    @JoinColumn(name = "FK_kapper", insertable = false, updatable = false)
    private Kapper Kapper;

    @Transient
    private static IAppointmentRepository _appointmentRepository;

    @Autowired
    private void SetAppointmentRepository(IAppointmentRepository appointmentRepository) {
        _appointmentRepository = appointmentRepository;
    }

    public Appointment(Kapper kapper, Account account) {
        Kapper = kapper;
        Account = account;
    }
    public Appointment(Appointment appointment)
    {
        this.Id = appointment.getId();
        this.Kapper = appointment.getKapper();
        this.Account = appointment.getAccount();
    }
    public Appointment(Appointment appointment, int id)
    {
        this.Id = appointment.getId();
        this.Kapper = appointment.getKapper();
        this.Account = appointment.getAccount();
    }
    public void update() {
        _appointmentRepository.save(this);
    }

}

