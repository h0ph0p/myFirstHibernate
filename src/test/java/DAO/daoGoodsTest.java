package DAO;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import sushchnost.GoodsEntity;
import sushchnost.CharacteristicsEntity;
import sushchnost.OrdersEntity;

import java.util.List;


import static org.testng.Assert.*;

public class daoGoodsTest {

//    public daoGoods _dao;
    private daoGoods _dao = new daoGoods();

    @Before
    public void setUp() throws Exception {
        _dao = new daoGoods();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByLogin() {
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        GoodsEntity tmp = new GoodsEntity();
        tmp.setId(-1);
        tmp.setImage("TEST_ENTITY");
        _dao.save(tmp);
        assertEquals("TEST_ENTITY", _dao.findById(-1).getImage());
        tmp.setImage("NEW_TEST_ENTITY");
        _dao.update(tmp);
        assertEquals("NEW_TEST_ENTITY", _dao.findById(-1).getImage());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }



    @Test
    public void findAll() {
        List<GoodsEntity> _list = _dao.findAll();
        for (GoodsEntity i: _list) {
            assertEquals(i.getImage(), _dao.findById(i.getId()).getImage());
        }
    }
}