package DAO;


import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;


public class daoReceiveT {


    public ReceiveTEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(ReceiveTEntity.class, id);
    }

    public void save(ReceiveTEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void update(ReceiveTEntity ReceiveTEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(ReceiveTEntity);
        tx1.commit();
        session.close();
    }

    public void delete(ReceiveTEntity ReceiveTEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(ReceiveTEntity);
        tx1.commit();
        session.close();
    }

//    public daoTotalOrders findOrderById(int customerid) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(daoTotalOrders.class, customerid);
//    }

    public List<ReceiveTEntity> findAll() {
        List<ReceiveTEntity> users = (List<ReceiveTEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From ReceiveTEntity").list();
        return users;
    }
}


