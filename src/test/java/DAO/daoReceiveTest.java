package DAO;

import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;
import sushchnost.ReceiveTEntity;

import java.util.List;


import static org.testng.Assert.*;

public class daoReceiveTest {

    private daoReceiveT _dao = new daoReceiveT();


    @Test
    public void findById() {
        assertEquals(_dao.findById(3).getReceivingType(), "самовывоз");
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        _dao = new daoReceiveT();
        ReceiveTEntity tmp = new ReceiveTEntity();
        tmp.setReceivingId(-1);
        tmp.setReceivingType("TEST_CHAR");
        _dao.save(tmp);
        assertEquals("TEST_CHAR", _dao.findById(-1).getReceivingType());
        tmp.setReceivingType("NEW_TEST_CHAR");
        _dao.update(tmp);
        assertEquals("NEW_TEST_CHAR", _dao.findById(-1).getReceivingType());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<ReceiveTEntity> _list = _dao.findAll();
        for (ReceiveTEntity i: _list) {
            assertEquals(i.getReceivingType(), _dao.findById(i.getReceivingId()).getReceivingType());
        }
    }

}