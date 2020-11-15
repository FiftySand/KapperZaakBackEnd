/*

package logic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.interfaces.IAppointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import logic.Kapper;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "appointment_kapper")
    private Kapper kapper;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "appointment_account")
    private Kapper kapper;


    @NotNull
    @JsonIgnore
    private String Password;

    @Transient
    private static IAppointmentRepository _appointmentRepository;

    @Autowired
    private void SetAppointmentRepository(IAppointmentRepository appointmentRepository) {
        _accountRepository = accountRepository;
    }

    public Appointment(Account account) {
        Id = account.Id;
        Username = account.Username;
        Password = account.Password;
    }

    public Account(Account account, int id) {
        Id = id;
        Username = account.Username;
        Password = account.Password;
    }
    public void update() {
        _accountRepository.save(this);
    }

}
*/
