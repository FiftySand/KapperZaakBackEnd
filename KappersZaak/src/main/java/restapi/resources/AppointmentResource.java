package restapi.resources;

import logic.Account;
import logic.Appointment;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import restapi.AccountController;
import restapi.KapperController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Getter
public class AppointmentResource extends ResourceSupport {

    private final logic.Appointment Appointment;

    public AppointmentResource(final logic.Appointment appointment){
        Appointment = appointment;
        int AccountId = appointment.getAccount().getId();
        int KapperId = appointment.getKapper().getId();

        add(linkTo(AccountController.class).withRel("appointment"));
        add(ControllerLinkBuilder.linkTo(methodOn(AccountController.class).get(AccountId)).withRel("account"));
        add(ControllerLinkBuilder.linkTo(methodOn(KapperController.class).get(KapperId)).withRel("kapper"));

    }
}
