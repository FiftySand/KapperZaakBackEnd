package logic.interfaces;

import logic.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountCollection {
    void createAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccount(int id);
    void deleteAccount(int id);
    Account login(String username, String password);
    Account getAccountByName(String username);
}