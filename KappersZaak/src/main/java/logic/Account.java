package logic;

import logic.interfaces.IAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Service
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Account implements IAccount, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    private String Name;
    @Nullable
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
        Email = account.Email;
        ReceiveEmail = account.ReceiveEmail;
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

    public Account(int id, @NotNull String name, @Nullable String password) {
        Id = id;
        Name = name;
        Password = password;
    }

    public Account(@NotNull String name, @Nullable String password) {
        Name = name;
        Password = password;
    }

    public void update() {
        _accountRepository.save(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
