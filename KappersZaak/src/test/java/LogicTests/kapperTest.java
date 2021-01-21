
package LogicTests;

import logic.Account;
import logic.Kapper;
import logic.KapperCollection;
import logic.interfaces.IKapperCollection;
import org.junit.jupiter.api.Test;
import testRepository.accountRepository;
import testRepository.kapperRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class kapperTest {

    @Test
    public void createKapper()
    {
        IKapperCollection col = new KapperCollection(new kapperRepository());
        //arrange
        Kapper actual1 = new Kapper(1, "Name1", 11);
        col.createKapper(actual1);
        //act
        Kapper returnKapper = col.getKapper(actual1.getId()).get();
        //assert
        assertEquals(actual1, returnKapper);
    }

    @Test
    public void getAllAccounts()
    {
        IKapperCollection col = new KapperCollection(new kapperRepository());
        //arrange
        int kapperListSize = col.getAllKappers().size();
        col.createKapper(new Kapper(1,"Name1",11));
        col.createKapper(new Kapper(2,"Name2",22));
        col.createKapper(new Kapper(3,"Name3",33));
        //act
        List<Kapper> kapperList = col.getAllKappers();
        //assert
        assertEquals(0, kapperListSize);
        assertEquals(3, kapperList.size());
    }

    @Test
    public void getKapper()
    {
        IKapperCollection col = new KapperCollection(new kapperRepository());
        //arrange
        Kapper actual1 = new Kapper(1, "Name1", 11);
        col.createKapper(actual1);
        //act
        Kapper returnKapper = col.getKapper(actual1.getId()).get();
        //assert
        assertEquals(actual1, returnKapper);
    }
    @Test
    public void deleteAccount()
    {
        IKapperCollection col = new KapperCollection(new kapperRepository());
        //arrange
        Kapper actual1 = new Kapper(11,"name1", 11);
        col.createKapper(actual1);
        Kapper actual2 = new Kapper(22, "name2", 22);
        col.createKapper(actual2);
        //act
        col.deleteKapper(actual1.getId());
        //assert
        assertEquals(1, col.getAllKappers().size());
        assertEquals(actual2, col.getKapper(actual2.getId()).get());
        assertNotEquals(actual1, col.getKapper(actual1.getId()).get());
    }
}
