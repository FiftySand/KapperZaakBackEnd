package logic.restapi.resources;

import logic.Kapper;
import logic.restapi.AccountController;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Getter
public class KapperResource extends ResourceSupport {

    private final logic.Kapper Kapper;

    public KapperResource(final Kapper kapper) {
        Kapper = kapper;
        add(linkTo(AccountController.class).withRel("kapper"));
    }
}