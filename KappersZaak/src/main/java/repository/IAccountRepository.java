package repository;

import logic.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where a.Name = ?1")
    Account getAccountByName(String username);
}
