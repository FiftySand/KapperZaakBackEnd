package logic;

import logic.interfaces.IAccountCollection;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountCollection implements IAccountCollection {

    IAccountRepository _accountRepository;

    public AccountCollection(IAccountRepository repository) {
        _accountRepository = repository;
    }

    @Override
    public void createAccount(Account account) {
        _accountRepository.save(account);
    }
    @Override
    public List<Account> getAllAccounts() {
        return _accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccount(int id) {
        return _accountRepository.findById(id);
    }

    @Override
    public void deleteAccount(int id) {
        _accountRepository.deleteById(id);
    }

    @Override
    public Account login(String username, String password) {
        return null;
    }

    public boolean verify(Account account) {
        Account loginAttempt = _accountRepository.findById(account.getId()).get();
        if (account.getPassword().equals(loginAttempt.getPassword())) {
            return true;
        }
        return false;
    }

    public Account getAccountByName(String name){
        return _accountRepository.getAccountByName(name);
    }

    public Account getAccountByEmail(String email){
        return _accountRepository.getAccountByEmail(email);
    }




    public void update(Account account)
    {
        Account acc = _accountRepository.findById(account.getId()).get();
        acc.setEmail(account.getEmail());
        acc.setReceiveEmail(account.getReceiveEmail());
        acc.setPassword(account.getPassword());
        acc.setName(account.getName());
        _accountRepository.save(acc);

    }
}
