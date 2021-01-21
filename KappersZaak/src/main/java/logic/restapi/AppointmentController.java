package logic.restapi;

import logic.Appointment;
import logic.interfaces.IAccountCollection;
import logic.interfaces.IAppointmentCollection;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import logic.restapi.resources.AppointmentResource;

import javax.persistence.NoResultException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/appointment", produces = "application/hal+json")
public class AppointmentController {
    private final IAppointmentCollection _appointmentCollection;
    private final IAccountCollection _accountCollection;

    public AppointmentController(IAppointmentCollection _appointmentCollection, IAccountCollection _accountCollection) {
        this._appointmentCollection = _appointmentCollection;
        this._accountCollection = _accountCollection;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResource> get(@PathVariable final int id) {
        return _appointmentCollection.getAppointment(id).map(a-> ResponseEntity.ok(new AppointmentResource(a))).orElseThrow(()-> new NoResultException());
    }

    @GetMapping
    public ResponseEntity<Resources<AppointmentResource>> all() {
        final List<AppointmentResource> collection = _appointmentCollection.getAllAppointments().stream().map(AppointmentResource::new).collect(Collectors.toList());
        final Resources <AppointmentResource> resources = new Resources < > (collection);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    public ResponseEntity<AppointmentResource> post(@RequestBody final Appointment appointmentFromRequest) {
        appointmentFromRequest.setAccount(_accountCollection.getAccountByName(appointmentFromRequest.getAccount().getName()));
        final Appointment appointment = new Appointment(appointmentFromRequest);
        _appointmentCollection.createAppointment(appointment);
        final URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(appointment.getId()).toUri();
        return ResponseEntity.created(uri).body(new AppointmentResource(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  delete(@PathVariable("id") final int id) {
        return _appointmentCollection.getAppointment(id).map(p-> {
            _appointmentCollection.deleteAppointment(id);
            return ResponseEntity.noContent().build();
        }).orElseThrow(()-> new NoResultException());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResource> put(@PathVariable("id") final int id, @RequestBody Appointment appointmentFromRequest) {
        final Appointment appointment = new Appointment(appointmentFromRequest, id);
        appointment.update();
        final AppointmentResource resource = new AppointmentResource(appointment);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(resource);
    }



}

