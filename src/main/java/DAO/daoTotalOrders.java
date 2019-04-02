package DAO;


import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;


public class daoTotalOrders {


    public TotalOrdersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TotalOrdersEntity.class, id);
    }

    public void save(TotalOrdersEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void update(TotalOrdersEntity TotalOrdersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(TotalOrdersEntity);
        tx1.commit();
        session.close();
    }

    public void delete(TotalOrdersEntity TotalOrdersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(TotalOrdersEntity);
        tx1.commit();
        session.close();
    }

//    public daoTotalOrders findOrderById(int customerid) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(daoTotalOrders.class, customerid);
//    }

    public List<TotalOrdersEntity> findAll() {
        List<TotalOrdersEntity> users = (List<TotalOrdersEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From TotalOrdersEntity").list();
        return users;
    }
}


