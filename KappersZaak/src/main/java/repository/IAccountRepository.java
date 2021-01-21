package repository;

import logic.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account getAccountByName(String name);
    Account getAccountByEmail(String email);
}