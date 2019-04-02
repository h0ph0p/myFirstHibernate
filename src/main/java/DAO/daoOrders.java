package DAO;


import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;


public class daoOrders {


    public OrdersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(OrdersEntity.class, id);
    }

    public void save(OrdersEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void update(OrdersEntity OrdersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(OrdersEntity);
        tx1.commit();
        session.close();
    }

    public void delete(OrdersEntity OrdersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(OrdersEntity);
        tx1.commit();
        session.close();
    }

//    public daoTotalOrders findOrderById(int customerid) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(daoTotalOrders.class, customerid);
//    }

    public List<OrdersEntity> findAll() {
        List<OrdersEntity> users = (List<OrdersEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From OrdersEntity").list();
        return users;
    }
}


