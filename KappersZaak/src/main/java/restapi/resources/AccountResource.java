package restapi.resources;

import logic.Account;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import restapi.AccountController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Getter
public class AccountResource extends ResourceSupport {
    private final logic.Account Account;

    public AccountResource(final Account account) {
        Account = account;
        final int id = account.getId();

        add(linkTo(AccountController.class).withRel("account"));
    }
}
