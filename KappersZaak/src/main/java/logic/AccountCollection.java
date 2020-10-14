package logic;

import logic.interfaces.IAccountCollection;
import org.springframework.stereotype.Service;
import repository.IAccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountCollection implements IAccountCollection {

    private static IAccountRepository _accountRepository;

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
        List<Account> accounts = _accountRepository.findAll();

        Account account = accounts.stream().findAny().filter(a -> a.getUsername().equals(username) && a.getPassword().equals(password)).get();

        return account;
    }
}
