package DAO;

import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;
import sushchnost.TotalOrdersEntity;

import java.util.List;


import static org.testng.Assert.*;

public class daoTotalOrdersTest {

    private daoTotalOrders _dao = new daoTotalOrders();


    @Test
    public void findById() {
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
        _dao = new daoTotalOrders();
        TotalOrdersEntity tmp = new TotalOrdersEntity();
        tmp.setOrderId(-1);
        tmp.setTotalCost(2.0);
        _dao.save(tmp);
        assertEquals(2.0, _dao.findById(-1).getTotalCost());
        tmp.setTotalCost(34.0);
        _dao.update(tmp);
        assertEquals(34.0, _dao.findById(-1).getTotalCost());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
        List<TotalOrdersEntity> _list = _dao.findAll();
        for (TotalOrdersEntity i: _list) {
            assertEquals(i.getTotalCost(), _dao.findById(i.getOrderId()).getTotalCost());
        }
    }

}