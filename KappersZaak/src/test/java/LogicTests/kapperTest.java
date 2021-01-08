package LogicTests;

import logic.Account;
import logic.Kapper;
import org.junit.Test;
import testRepository.accountRepository;
import testRepository.kapperRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class kapperTest {

    @Test
    public void createKapper()
    {
        //arrange
        kapperRepository rep = new kapperRepository();
        Kapper kapper1 = new Kapper(1,"name", 11);
        //act
        rep.createKapper(kapper1);
        //assert
        assertEquals(kapper1, rep.getKapper(1));
    }

    @Test
    public void getKapper()
    {
        //arrange
        kapperRepository rep = new kapperRepository();
        Kapper actual1 = new Kapper(1, "name1", 11);
        Kapper actual2 = new Kapper(2, "name2", 22);
        Kapper actual3 = new Kapper(3, "name3", 33);
        Kapper actual4 = new Kapper(4, "name4", 44);
        rep.createKapper(actual1);
        rep.createKapper(actual2);
        rep.createKapper(actual3);
        rep.createKapper(actual4);
        //act
        Kapper kapper1 = rep.getKapper(1);
        Kapper kapper2 = rep.getKapper(2);
        Kapper kapper3 = rep.getKapper(3);
        Kapper kapper4 = rep.getKapper(4);
        //assert
        assertEquals(actual1, kapper1);
        assertEquals(actual2, kapper2);
        assertEquals(actual3, kapper3);
        assertEquals(actual4, kapper4);
    }

    @Test
    public void getAllKappers()
    {
        //arrange
        kapperRepository rep = new kapperRepository();
        List<Kapper> kappersEmpty = new ArrayList<>();
        List<Kapper> kappers;
        //act
        rep.createKapper(new Kapper(1, "name1", 11));
        rep.createKapper(new Kapper(2, "name2", 22));
        rep.createKapper(new Kapper(3, "name3", 33));
        rep.createKapper(new Kapper(4, "name4", 44));
        kappers = rep.getAllKappers();
        //assert
        assertNotEquals(kappersEmpty.size(), rep.getAllKappers().size());
        assertEquals(4, kappers.size());

    }

    @Test
    public void deleteKapper()
    {
        //arrange
        kapperRepository rep = new kapperRepository();
        Kapper actual1 = new Kapper(1, "name1", 11);
        Kapper actual2 = new Kapper(2, "name2", 22);
        Kapper actual3 = new Kapper(3, "name3", 33);
        Kapper actual4 = new Kapper(4, "name4", 44);
        rep.createKapper(actual1);
        rep.createKapper(actual2);
        rep.createKapper(actual3);
        rep.createKapper(actual4);
        //act
        rep.deleteKapper(1);
        rep.deleteKapper(3);
        //assert
        assertEquals(2, rep.getAllKappers().size());
        assertEquals(actual2, rep.getKapper(2));
        assertEquals(actual4, rep.getKapper(4));
        assertNotEquals(actual1, rep.getKapper(1));
        assertNotEquals(actual3, rep.getKapper(3));
    }
}
