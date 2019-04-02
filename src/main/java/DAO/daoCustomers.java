package DAO;


import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class daoCustomers {

    public CustomersEntity findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CustomersEntity.class, id);
    }

    public void save(CustomersEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void update(CustomersEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public void delete(CustomersEntity CustomersEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(CustomersEntity);
        tx1.commit();
        session.close();
    }

    public daoTotalOrders findOrderById(int customerid) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(daoTotalOrders.class, customerid);
    }

    public List<CustomersEntity> findAll() {
        List<CustomersEntity> users = (List<CustomersEntity>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From CustomersEntity").list();
        return users;
    }

}
