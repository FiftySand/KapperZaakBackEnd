package logic;

import logic.interfaces.IKapperCollection;
import org.springframework.stereotype.Service;
import repository.IKapperRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KapperCollection implements IKapperCollection {

    private static IKapperRepository _kapperRepository;

    public KapperCollection(IKapperRepository repository) {
        _kapperRepository = repository;
    }

    @Override
    public void createKapper(Kapper kapper) {
        _kapperRepository.save(kapper);
    }

    @Override
    public List<Kapper> getAllKappers() {
        return _kapperRepository.findAll();
    }

    @Override
    public Optional<Kapper> getKapper(int id) {
        return _kapperRepository.findById(id);
    }

    @Override
    public void deleteKapper(int id) {
        _kapperRepository.deleteById(id);
    }

}
