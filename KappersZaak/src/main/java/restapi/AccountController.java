package restapi;

import logic.Account;
import logic.interfaces.IAccountCollection;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restapi.resources.AccountResource;

import javax.persistence.NoResultException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/account", produces = "application/hal+json")
public class AccountController {
    private final IAccountCollection _accountCollection;

    public AccountController(IAccountCollection _accountCollection) {
        this._accountCollection = _accountCollection;
    }

    @GetMapping
    public ResponseEntity<AccountResource> get() {
        final Account account = new Account(0,"Henk", "Vijftig");
        _accountCollection.createAccount(account);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(uri).body(new AccountResource(account));
    }

}
