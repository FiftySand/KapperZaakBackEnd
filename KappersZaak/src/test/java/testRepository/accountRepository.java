package testRepository;

import logic.Account;
import repository.IAccountRepository;

import java.util.ArrayList;
import java.util.List;

public class accountRepository{
    //pipeline test
    public List<Account> accounts = new ArrayList<>();

    public void save(Account account)
    {
        accounts.add(account);
    }

    public List<Account> findAll()
    {
        return accounts;
    }

    public void deleteById(int id)
    {
        accounts.removeIf((Account acc) -> acc.getId() == id);
    }
}
