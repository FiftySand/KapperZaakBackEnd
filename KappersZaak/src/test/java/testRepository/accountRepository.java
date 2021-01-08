package testRepository;

import logic.Account;

import java.util.ArrayList;
import java.util.List;

public class accountRepository {

    public List<Account> accounts = new ArrayList<>();

    public void createAccount(Account account)
    {
        accounts.add(account);
    }

    public List<Account> getAllAccounts()
    {
        return accounts;
    }

    public Account getAccount(int id)
    {
        for(Account acc : accounts)
        {
            if(acc.getId() == id)
            {
                return acc;
            }
        }
        return new Account();
    }

    public void deleteAccount(int id)
    {
        accounts.removeIf((Account acc) -> acc.getId() == id);
    }
}
