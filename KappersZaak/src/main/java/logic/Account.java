package logic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import logic.interfaces.IAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Account implements IAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NotNull
    private String Username;
    @NotNull
    @JsonIgnore
    private String Password;

    @Transient
    private static IAccountRepository _accountRepository;

    @Autowired
    private void setAccountRepository(IAccountRepository accountRepository) {
        _accountRepository = accountRepository;
    }

    public Account(Account account) {
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
