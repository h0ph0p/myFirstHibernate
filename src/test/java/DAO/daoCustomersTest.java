package DAO;

import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;
import sushchnost.CustomersEntity;

import java.util.List;


import static org.testng.Assert.*;

public class daoCustomersTest {

    private daoCustomers _dao = new daoCustomers();

    @Before
    public void setUp() throws Exception {
        _dao = new daoCustomers();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
//        _dao = new daoCustomers();
        assertEquals(_dao.findById(3).getFio(), "Сапаев Дилшод");
        assertNull(_dao.findById(-1));
    }
    //
    @Test
    public void saveUpdateDelete() {
        _dao = new daoCustomers();
        CustomersEntity tmp = new CustomersEntity();
        tmp.setCustomerId(-1);
        tmp.setFio("TEST_CHAR");
        _dao.save(tmp);
        assertEquals("TEST_CHAR", _dao.findById(-1).getFio());
        tmp.setFio("NEW_TEST_CHAR");
        _dao.update(tmp);
        assertEquals("NEW_TEST_CHAR", _dao.findById(-1).getFio());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
//        _dao = new daoCustomers();
        List<CustomersEntity> _list = _dao.findAll();
        for (CustomersEntity i: _list) {
            assertEquals(i.getFio(), _dao.findById(i.getCustomerId()).getFio());
        }
    }

}