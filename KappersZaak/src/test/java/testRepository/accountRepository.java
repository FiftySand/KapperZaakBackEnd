package testRepository;

import logic.Account;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import repository.IAccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public  class accountRepository implements IAccountRepository {
    //pipeline test
    public List<Account> accounts = new ArrayList<>();

    public Account save(Account account)
    {
        accounts.add(account);
        return account;
    }

    public List<Account> findAll()
    {
        return accounts;
    }

    public Optional<Account> findById(Integer id) {

        for (Account acc: accounts)
        {
            if(acc.getId() == id)
            {
                return Optional.of(acc);
            }
        }

        return Optional.of(new Account());
    }

    public void deleteById(Integer id) {
        accounts.removeIf((Account acc) -> acc.getId() == id);
    }

    @Override
    public Account getAccountByEmail(String email) {
        for (Account acc: accounts)
        {
            if(acc.getEmail() == email)
            {
                return acc;
            }
        }
        return null;
    }

    @Override
    public Account getAccountByName(String name) {
        for (Account acc: accounts)
        {
            if(acc.getName() == name)
            {
                return acc;
            }
        }
        return null;
    }









    @Override
    public void delete(Account entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Account> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> entities) {
        return null;
    }




    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Account> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Account> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Account getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public List<Account> findAll(Sort sort) {

        return accounts;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Account> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }




}
