package logic;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name;

    @Nullable
    private String password;

    private String email;

    private Boolean receiveEmail;

    @Transient
    private static IAccountRepository _accountRepository;

    @Autowired
    private void setAccountRepository(IAccountRepository accountRepository) {
        _accountRepository = accountRepository;
    }

    public Account(Account account) {
        Id = account.Id;
        name = account.name;
        password = account.password;
        email = account.email;
        receiveEmail = account.receiveEmail;
    }

    public Account(String name, String password, String email, Boolean receiveEmail)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.receiveEmail = receiveEmail;
    }


    public Account(Account account, int id) {
        Id = id;
        name = account.name;
        password = account.password;
    }

    public Account(@NotNull String name, @Nullable String password) {
        this.name = name;
        this.password = password;
    }

    public void update() {
        _accountRepository.save(this);
    }

    public Account(int id, @NotNull String name, @Nullable String password) {
        Id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
