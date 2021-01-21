package logic.interfaces;

import logic.Account;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface IAccountCollection {
    void createAccount(Account account);
    List<Account> getAllAccounts();
    Optional<Account> getAccount(int id);
    void deleteAccount(int id);
    Account getAccountByName(String name);
    Account getAccountByEmail(String email);
    Account login(String username, String password);
    boolean verify(Account account);
    void update(Account account);
}