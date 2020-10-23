package restapi;

import logic.Account;
import logic.Kapper;
import logic.interfaces.IAccountCollection;
import logic.interfaces.IKapperCollection;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restapi.resources.AccountResource;
import restapi.resources.KapperResource;

import javax.persistence.NoResultException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/kapper", produces = "application/hal+json")
public class KapperController {
    private final IKapperCollection _kapperCollection;

    public KapperController(IKapperCollection _kapperCollection) {
        this._kapperCollection = _kapperCollection;
    }

    @GetMapping("/{id}")
    public ResponseEntity<KapperResource> get(@PathVariable final int id) {
        return _kapperCollection.getKapper(id).map(a-> ResponseEntity.ok(new KapperResource(a))).orElseThrow(()-> new NoResultException());
    }

    @GetMapping
    public ResponseEntity<Resources<KapperResource>> all() {
        final List<KapperResource> collection = _kapperCollection.getAllKappers().stream().map(KapperResource::new).collect(Collectors.toList());
        final Resources <KapperResource> resources = new Resources < > (collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ResponseEntity<KapperResource> post(@RequestBody final Kapper kapperFromRequest) {
        final Kapper kapper = new Kapper(kapperFromRequest);
        _kapperCollection.createKapper(kapper);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(kapper.getId()).toUri();
        return ResponseEntity.created(uri).body(new KapperResource(kapper));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable("id") final int id) {
        return _kapperCollection.getKapper(id).map(p-> {
            _kapperCollection.deleteKapper(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(()-> new NoResultException());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KapperResource> put(@PathVariable("id") final int id, @RequestBody Kapper kapperFromRequest) {
        final Kapper kapper = new Kapper(kapperFromRequest, id);
        kapper.update();
        final KapperResource resource = new KapperResource(kapper);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(resource);
    }

}
