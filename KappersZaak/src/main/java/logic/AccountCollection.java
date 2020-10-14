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
}
