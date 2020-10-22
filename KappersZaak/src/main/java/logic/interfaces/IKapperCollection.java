package logic.interfaces;

import logic.Account;
import logic.Kapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface IKapperCollection {
    void createKapper(Kapper kapper);
    List<Kapper> getAllKappers();
    Optional<Kapper> getKapper(int id);
    void deleteKapper(int id);
}