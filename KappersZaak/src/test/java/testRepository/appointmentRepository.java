package testRepository;

import logic.Appointment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import repository.IAppointmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class appointmentRepository implements IAppointmentRepository {

    List<Appointment> appointments = new ArrayList<>();

    public Appointment save(Appointment appointment)
    {
        appointments.add(appointment);
        return appointment;
    }

    public List<Appointment> findAll()
    {
        return appointments;
    }

    public Optional<Appointment> findById(Integer id)
    {
        for (Appointment appointment: appointments)
        {
            if(appointment.getId() == id)
            {
                return Optional.of(appointment);
            }
        }
        return Optional.of(new Appointment());
    }

    @Override
    public void deleteById(Integer id) {
        appointments.removeIf((Appointment app) -> app.getId() == id);
    }










    @Override
    public List<Appointment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Appointment> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }



    @Override
    public void delete(Appointment entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Appointment> entities) {

    }

    @Override
    public void deleteAll() {

    }


    @Override
    public <S extends Appointment> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Appointment> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Appointment> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Appointment getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Appointment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Appointment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Appointment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Appointment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Appointment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Appointment> boolean exists(Example<S> example) {
        return false;
    }
}
