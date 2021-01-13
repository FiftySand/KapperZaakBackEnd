package LogicTests;

import logic.Account;
import logic.AccountCollection;
import org.junit.jupiter.api.Test;
import repository.IAccountRepository;
import testRepository.accountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class accountTest {

    AccountCollection col = new AccountCollection((IAccountRepository) new accountRepository());

    @Test
    public void getAccount()
    {
        //arrange
        Account actual1 = new Account(1,"name1", "password1", "email1", false);

        col.createAccount(actual1);
        //act
        Account account1 =  col.getAccount(actual1.getId());
        //assert
        assertEquals(actual1, account1);

    }

//    @Test
//    public void createAccount()
//    {
//        //arrange
//        accountRepository rep = new accountRepository();
//        Account account = new Account(1,"name1", "password1", "email1", false);
//        ///act
//        rep.createAccount(account);
//        //assert
//        assertEquals(account, rep.getAccount(1));
//    }
//
//    @Test
//    public void getAllAccounts()
//    {
//        //arrange
//        accountRepository rep = new accountRepository();
//        List<Account> accounts;
//        List<Account> accountsEmpty = new ArrayList<>();
//        rep.createAccount(new Account(1,"name1", "password1", "email1", false));
//        rep.createAccount(new Account(2,"name2", "password2", "email2", false));
//        rep.createAccount(new Account(3,"name3", "password3", "email3", false));
//        rep.createAccount(new Account(4,"name4", "password4", "email4", false));
//        //act
//
//        accounts = rep.getAllAccounts();
//        //assert
//        assertNotEquals(accountsEmpty.size(), accounts.size());
//        assertEquals(4, accounts.size());
//
//    }
//
//    @Test
//    public void deleteAccount()
//    {
//        //arrange
//        accountRepository rep = new accountRepository();
//        Account actual1 = new Account(1,"name1", "password1", "email1", false);
//        Account actual2 = new Account(2,"name2", "password2", "email2", false);
//        Account actual3 = new Account(3,"name3", "password3", "email3", false);
//        Account actual4 = new Account(4,"name4", "password4", "email4", false);
//        rep.createAccount(actual1);
//        rep.createAccount(actual2);
//        rep.createAccount(actual3);
//        rep.createAccount(actual4);
//        //act
//        rep.deleteAccount(1);
//        rep.deleteAccount(3);
//        //assert
//        assertEquals(2, rep.getAllAccounts().size());
//        assertEquals(actual2, rep.getAccount(2));
//        assertEquals(actual4, rep.getAccount(4));
//        assertNotEquals(actual1, rep.getAccount(1));
//        assertNotEquals(actual3, rep.getAccount(3));
//    }
}
