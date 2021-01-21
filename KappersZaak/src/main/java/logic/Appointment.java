

package logic;

import logic.interfaces.IAppointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "FK_account")
    private Account Account;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "FK_kapper")
    private Kapper Kapper;

    @NotNull
    private String date;

    @NotNull
    private String time;

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
    public Appointment(Kapper kapper, Account account, int id)
    {
        Kapper = kapper;
        Account = account;
        Id = id;
    }
    public Appointment(Appointment appointment)
    {
        this.Id = appointment.getId();
        this.Kapper = appointment.getKapper();
        this.Account = appointment.getAccount();
        this.date = appointment.getDate();
        this.time = appointment.getTime();
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

