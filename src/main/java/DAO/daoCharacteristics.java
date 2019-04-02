package DAO;


import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;


public class daoCharacteristics {


    public CharacteristicsEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CharacteristicsEntity.class, id);
    }

    public void save(CharacteristicsEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void update(CharacteristicsEntity CharacteristicsEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(CharacteristicsEntity);
        tx1.commit();
        session.close();
    }

    public void delete(CharacteristicsEntity CharacteristicsEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(CharacteristicsEntity);
        tx1.commit();
        session.close();
    }

    public GoodsEntity findCharacteristicByType(int type_id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(GoodsEntity.class, type_id);
    }

    public List<CharacteristicsEntity> findAll() {
        List<CharacteristicsEntity> users = (List<CharacteristicsEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From CharacteristicsEntity").list();
        return users;
    }
}


