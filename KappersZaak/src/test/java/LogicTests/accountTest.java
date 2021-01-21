
package LogicTests;

import logic.Account;
import logic.AccountCollection;
import logic.interfaces.IAccountCollection;
import org.junit.jupiter.api.Test;
import repository.IAccountRepository;
import testRepository.accountRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class accountTest {


    @Test
    public void createAccount()
    {
        IAccountCollection col = new AccountCollection(new accountRepository());

        //arrange
        Account actual1 = new Account(1, "Name1", "Password1");
        col.createAccount(actual1);
        //act
        Optional<Account> returnAcc = col.getAccount(actual1.getId());
        //assert
        assertEquals(actual1, returnAcc.get());
    }

    @Test
    public void getAccount()
    {
        IAccountCollection col = new AccountCollection((IAccountRepository)new accountRepository());
        //arrange
        Account actual1 = new Account(1, "Name1", "Password1");
        col.createAccount(actual1);
        //act
        Account returnAcc = col.getAccount(actual1.getId()).get();
        //assert
        assertEquals(actual1, returnAcc);
    }

    @Test
    public void getAllAccounts()
    {
        IAccountCollection col = new AccountCollection((IAccountRepository)new accountRepository());
        //arrange
        int accountListSize = col.getAllAccounts().size();
        col.createAccount(new Account(1, "Name1", "Password1"));
        col.createAccount(new Account(2, "Name2", "Password2"));
        col.createAccount(new Account(3, "Name3", "Password3"));
        //act
        List<Account> accountList = col.getAllAccounts();
        //assert
        assertEquals(0, accountListSize);
        assertEquals(3, accountList.size());

    }

    @Test
    public void deleteAccount()
    {
        IAccountCollection col = new AccountCollection((IAccountRepository)new accountRepository());
        //arrange
        Account actual1 = new Account(1, "Name1", "Password1");
        col.createAccount(actual1);
        Account actual2 = new Account(2, "Name2", "Password2");
        col.createAccount(actual2);
        //act
        col.deleteAccount(actual1.getId());
        //assert
        assertEquals(1, col.getAllAccounts().size());
        assertEquals(actual2, col.getAccount(actual2.getId()).get());
        assertNotEquals(actual1, col.getAccount(actual1.getId()).get());

    }
}

