package DAO;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import sushchnost.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class daoOrdersTest {


    private daoOrders _dao = new daoOrders();

    @Test
    public void findByOrderId() {
//        assertEquals(_dao.findById(3).getQuantity(), );
        assertNull(_dao.findById(-1));
    }

    @Test
    public void saveUpdateDelete() {
//        _dao = new daoOrders();
//        OrdersEntity tmp = new OrdersEntity();
//        tmp.setId(-1);
//        tmp.setQuantity(33);
//        _dao.save(tmp);
//        assertEquals(33, (int)_dao.findById(-1).getQuantity());
//        tmp.setQuantity(111);
//        _dao.update(tmp);
//        assertEquals(111, (int)_dao.findById(-1).getQuantity());
//        _dao.delete(tmp);
//        assertNull(_dao.findById(-1));
    }



    @Test
    public void findAll() {
        List<OrdersEntity> _list = _dao.findAll();
        for (OrdersEntity i: _list) {
            assertEquals(i.getQuantity(), _dao.findById(i.getId()).getQuantity());
        }
    }
}