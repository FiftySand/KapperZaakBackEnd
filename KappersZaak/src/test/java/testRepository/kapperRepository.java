package testRepository;

import logic.Kapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import repository.IKapperRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class kapperRepository implements IKapperRepository {

    public List<Kapper> kappers = new ArrayList<>();

    @Override
    public Kapper save(Kapper kapper) {
        kappers.add(kapper);
        return kapper;
    }
    @Override
    public List<Kapper> findAll() {
        return kappers;
    }
    @Override
    public Optional<Kapper> findById(Integer id) {
        for (Kapper kapper: kappers)
        {
            if(kapper.getId() == id)
            {
                return Optional.of(kapper);
            }
        }

        return Optional.of(new Kapper());
    }
    @Override
    public void deleteById(Integer id) {
        kappers.removeIf((Kapper kapper) -> kapper.getId() == id);

    }




    @Override
    public List<Kapper> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Kapper> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Kapper> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }


    @Override
    public void delete(Kapper entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Kapper> entities) {

    }

    @Override
    public void deleteAll() {

    }


    @Override
    public <S extends Kapper> List<S> saveAll(Iterable<S> entities) {
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
    public <S extends Kapper> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Kapper> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Kapper getOne(Integer integer) {
        return null;
    }

    @Override
    public <S extends Kapper> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Kapper> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Kapper> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Kapper> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Kapper> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Kapper> boolean exists(Example<S> example) {
        return false;
    }
}
