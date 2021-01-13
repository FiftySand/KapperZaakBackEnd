package restapi;

import logic.Account;
import logic.AccountCollection;
import logic.interfaces.IAccountCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restapi.resources.AccountResource;
import restapi.security.JwtTokenProvider;
import restapi.security.model.JwtResponse;

import javax.persistence.NoResultException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/account", produces = "application/hal+json")
public class AccountController {
    private final IAccountCollection _accountCollection;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public AccountController(IAccountCollection _accountCollection) {
        this._accountCollection = _accountCollection;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResource> get(@PathVariable final int id) {
        return _accountCollection.getAccount(id).map(a-> ResponseEntity.ok(new AccountResource(a))).orElseThrow(()-> new NoResultException());
    }

    @GetMapping
    public ResponseEntity<Resources<AccountResource>> all() {
        final List<AccountResource> collection = _accountCollection.getAllAccounts().stream().map(AccountResource::new).collect(Collectors.toList());
        final Resources <AccountResource> resources = new Resources < > (collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ResponseEntity<AccountResource> post(@RequestBody final Account accountFromRequest) {
        final Account account = new Account(accountFromRequest);
        _accountCollection.createAccount(account);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountResource(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable("id") final int id) {
            return _accountCollection.getAccount(id).map(p -> {
                _accountCollection.deleteAccount(id);
                return ResponseEntity.noContent().build();
            }).orElseThrow(() -> new NoResultException());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResource> put(@PathVariable("id") final int id, @RequestBody Account accountFromRequest) {
        final Account account = new Account(accountFromRequest, id);
        account.update();
        final AccountResource resource = new AccountResource(account);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(resource);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> authorize(@RequestBody Account account) {
        //if (_accountCollection.checkAccountPwd(account)) {
            try {
                //Authenticate user that wants to log in to application's frontend
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getName(), account.getPassword()));

                //Create token if user can be authorized (if user exists)
                JwtResponse response = new JwtResponse(jwtTokenProvider.createToken(account.getName()), _accountCollection.getAccountByName(account.getName()));

                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch (AuthenticationException e) {
                return new ResponseEntity<>("Could not authenticate", HttpStatus.BAD_REQUEST);
            }
        //}
        //return new ResponseEntity<>("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
    }

}
