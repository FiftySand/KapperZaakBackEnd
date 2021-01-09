package testRepository;

import logic.Kapper;

import java.util.ArrayList;
import java.util.List;

public class kapperRepository {

    List<Kapper> kappers = new ArrayList<>();

    public void createKapper(Kapper kapper)
    {
        kappers.add(kapper);
    }

    public List<Kapper> getAllKappers()
    {
        return kappers;
    }

    public Kapper getKapper(int id)
    {
        for (Kapper kapper: kappers)
        {
            if(kapper.getId() == id)
            {
                return kapper;
            }
        }
        return new Kapper();
    }

    public void deleteKapper(int id)
    {
        kappers.removeIf((Kapper kapper) -> kapper.getId() == id);
    }
}
