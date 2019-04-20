package DAO;

import org.testng.annotations.Test;
import org.junit.After;
import org.junit.Before;
import sushchnost.CharacteristicsEntity;

import java.util.List;


import static org.testng.Assert.*;

public class daoCharacteristicsTest {

    private daoCharacteristics _dao = new daoCharacteristics();

    @Before
    public void setUp() throws Exception {
        _dao = new daoCharacteristics();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByTypeId() {
//        _dao = new daoCharacteristics();
        assertEquals(_dao.findByTypeId(2).getCharacteristic1(), "кол-режимов");
        assertNull(_dao.findByTypeId(-1));
    }
//
    @Test
    public void saveUpdateDelete() {
        _dao = new daoCharacteristics();
        CharacteristicsEntity tmp = new CharacteristicsEntity();
        tmp.setTypeId(-1);
        tmp.setCharacteristic1("TEST_CHAR");
        _dao.save(tmp);
        assertEquals("TEST_CHAR", _dao.findByTypeId(-1).getCharacteristic1());
        tmp.setCharacteristic1("NEW_TEST_CHAR");
        _dao.update(tmp);
        assertEquals("NEW_TEST_CHAR", _dao.findByTypeId(-1).getCharacteristic1());
        _dao.delete(tmp);
        assertNull(_dao.findByTypeId(-1));
    }

    @Test
    public void findAll() {
//        _dao = new daoCharacteristics();
        List<CharacteristicsEntity> _list = _dao.findAll();
        for (CharacteristicsEntity i: _list) {
            assertEquals(i.getCharacteristic1(), _dao.findByTypeId(i.getTypeId()).getCharacteristic1());
        }
    }

}