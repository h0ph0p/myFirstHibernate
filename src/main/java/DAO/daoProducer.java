package DAO;


import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;


public class  daoProducer{


    public ProducerEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ProducerEntity.class, id);
    }

    public void save(ProducerEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void update(ProducerEntity ProducerEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(ProducerEntity);
        tx1.commit();
        session.close();
    }

    public void delete(ProducerEntity ProducerEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(ProducerEntity);
        tx1.commit();
        session.close();
    }

//    public daoTotalOrders findOrderById(int customerid) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(daoTotalOrders.class, customerid);
//    }

    public List<ProducerEntity> findAll() {
        List<ProducerEntity> users = (List<ProducerEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From ProducerEntity").list();
        return users;
    }
}


