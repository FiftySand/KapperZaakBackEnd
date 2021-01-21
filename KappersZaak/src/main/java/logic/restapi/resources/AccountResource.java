package logic.restapi.resources;

import logic.Account;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import logic.restapi.AccountController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Getter
public class AccountResource extends ResourceSupport {

    private final logic.Account Account;

    public AccountResource(final Account account) {
        Account = account;
        add(linkTo(AccountController.class).withRel("account"));
    }
}
