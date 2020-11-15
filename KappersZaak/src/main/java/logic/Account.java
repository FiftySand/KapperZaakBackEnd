package logic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.interfaces.IAppointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Service
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Account implements IAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String Name;
    @NotNull
    private String Password;

    private String Email;

    private Boolean ReceiveEmail;

    @Transient
    private static IAccountRepository _accountRepository;

    @Autowired
    private void setAccountRepository(IAccountRepository accountRepository) {
        _accountRepository = accountRepository;
    }

    public Account(Account account) {
        Id = account.Id;
        Name = account.Name;
        Password = account.Password;
    }

    public Account(String name, String password, String email, Boolean receiveEmail)
    {
        this.Name = name;
        this.Password = password;
        this.Email = email;
        this.ReceiveEmail = receiveEmail;
    }

    public Account(Account account, int id) {
        Id = id;
        Name = account.Name;
        Password = account.Password;
    }
    public void update() {
        _accountRepository.save(this);
    }

}
