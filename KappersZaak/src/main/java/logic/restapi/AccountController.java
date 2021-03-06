package logic.restapi;

import logic.Account;
import logic.interfaces.IAccountCollection;
import logic.restapi.resources.AccountResource;
import logic.security.JwtTokenProvider;
import logic.security.model.JwtResponse;
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
import repository.IAccountRepository;

import javax.persistence.NoResultException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/account", produces = "application/hal+json")
public class AccountController {



    private static IAccountCollection _accountCollection;

    public AccountController(IAccountCollection accountCollection)
    {
        _accountCollection = accountCollection;
    }




    @GetMapping("/{id}")
    public ResponseEntity<AccountResource> get(@PathVariable final int id) {
        return _accountCollection.getAccount(id).map(a -> ResponseEntity.ok(new AccountResource(a))).orElseThrow(() -> new NoResultException());
    }

    @GetMapping
    public ResponseEntity<Resources<AccountResource>> all() {
        final List<AccountResource> collection = _accountCollection.getAllAccounts().stream().map(AccountResource::new).collect(Collectors.toList());
        final Resources<AccountResource> resources = new Resources<>(collection);
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
    public ResponseEntity<?> delete(@PathVariable("id") final int id) {
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


}



