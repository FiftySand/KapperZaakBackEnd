package ControllerTests;

import logic.Account;
import logic.AccountCollection;
import logic.SpringServer;
import logic.interfaces.IAccountCollection;
import logic.restapi.LoginController;
import logic.security.JwtTokenProvider;
import logic.security.model.JwtResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;
import testRepository.accountRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;

import javax.inject.Inject;

public class loginTest {

    @Mock
    AuthenticationManager authenticationManager;

    @Mock
    JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    LoginController controller;


    @Test
    public void getUser(){
        //arrange
        accountRepository repo = new accountRepository();
        Account actual1 = new Account(1, "name1", "password1", "email1@hotmail.com", false);
        repo.save(actual1);
        IAccountCollection coll = new AccountCollection(repo);
        LoginController controller = new LoginController(coll, new JwtTokenProvider(), authenticationManager);
        //act
        Account returnAccount = controller.getUser(actual1);
        //assert
        assertEquals(actual1.getId(), returnAccount.getId());
        assertEquals(actual1.getName(),returnAccount.getName());
        assertEquals(actual1.getEmail(), returnAccount.getEmail());
        assertEquals(actual1.getPassword(), returnAccount.getPassword());
        assertEquals(actual1.getReceiveEmail(), returnAccount.getReceiveEmail());
    }

    @Test
    public void Login(){
        //arrange
        MockitoAnnotations.initMocks(this);
        accountRepository repo = new accountRepository();
        Account actual1 = new Account(1, "name1", "password1", "email1@hotmail.com", false);
        repo.save(actual1);
        IAccountCollection coll = new AccountCollection(repo);
        controller = new LoginController(coll, new JwtTokenProvider(), authenticationManager);
        //act
        ResponseEntity<?> response = controller.authorize(actual1);
        //assert
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        JwtResponse responseBody = (JwtResponse) response.getBody();
        assertTrue(responseBody.getToken() != null);
        assertEquals(responseBody.getAccount().getId(), actual1.getId());
        assertEquals(responseBody.getAccount().getName(), actual1.getName());
        assertEquals(responseBody.getAccount().getEmail(), actual1.getEmail());
        assertEquals(responseBody.getAccount().getReceiveEmail(), actual1.getReceiveEmail());
        assertEquals(responseBody.getAccount().getPassword(), actual1.getPassword());
    }
}
