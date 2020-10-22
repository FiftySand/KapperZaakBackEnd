package restapi;

import logic.Account;
import logic.interfaces.IAccountCollection;
import logic.interfaces.IKapperCollection;
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
public class KapperController {
    private final IKapperCollection _kapperCollection;

    public KapperController(IKapperCollection _kapperCollection) {
        this._kapperCollection = _kapperCollection;
    }

}
