package logic.restapi;

import logic.Account;
import logic.interfaces.IAccount;
import logic.interfaces.IAccountCollection;
import logic.restapi.resources.AccountResource;
import org.apache.coyote.Response;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import repository.IAccountRepository;
import logic.security.JwtTokenProvider;
import logic.security.model.JwtResponse;

import javax.persistence.NoResultException;


@CrossOrigin(maxAge = 3600)
@RestController

public class LoginController {

    final
    AuthenticationManager authenticationManager;

    final
    JwtTokenProvider jwtTokenProvider;

    IAccountCollection _accountCollection;

    public LoginController(IAccountCollection accountCollection, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager)
    {
        _accountCollection = accountCollection;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/login", headers = "Accept=application/json")
    public ResponseEntity<?> authorize(@RequestBody Account account) {
        try {
            //Authenticate user that wants to log in to application's frontend
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(account.getName(), _accountCollection.getAccountByName(account.getName()).getPassword());
            authenticationManager.authenticate(auth);

            //Create token if user can be authorized (if user exists)
            JwtResponse response = new JwtResponse(jwtTokenProvider.createToken(account.getName()), _accountCollection.getAccountByName(account.getName()));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Could not authenticate", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/getUser", headers = "Accept=application/json")
    public Account getUser(@RequestBody Account account) {
        Account checkAccount = _accountCollection.getAccountByEmail(account.getEmail());
            if (account.getPassword().equals(checkAccount.getPassword())) {
                return checkAccount;
            }
            return new Account();
        }
    }







