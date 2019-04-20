package DAO;

import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;
import sushchnost.ProducerEntity;

import java.util.List;


import static org.testng.Assert.*;

public class daoProducerTest {

    private daoProducer _dao = new daoProducer();


    @Test
    public void findById() {
//        _dao = new daoProducer();
        assertEquals(_dao.findById(3).getProducerName(), "BORK");
        assertNull(_dao.findById(-1));
    }
    //
    @Test
    public void saveUpdateDelete() {
        _dao = new daoProducer();
        ProducerEntity tmp = new ProducerEntity();
        tmp.setProducerId(-1);
        tmp.setProducerName("TEST_CHAR");
        _dao.save(tmp);
        assertEquals("TEST_CHAR", _dao.findById(-1).getProducerName());
        tmp.setProducerName("NEW_TEST_CHAR");
        _dao.update(tmp);
        assertEquals("NEW_TEST_CHAR", _dao.findById(-1).getProducerName());
        _dao.delete(tmp);
        assertNull(_dao.findById(-1));
    }

    @Test
    public void findAll() {
//        _dao = new daoProducer();
        List<ProducerEntity> _list = _dao.findAll();
        for (ProducerEntity i: _list) {
            assertEquals(i.getProducerName(), _dao.findById(i.getProducerId()).getProducerName());
        }
    }

}