package DAO;


import org.hibernate.query.Query;
import sushchnost.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;







public class daoCharacteristics {


    public CharacteristicsEntity findByTypeId(int type_id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CharacteristicsEntity.class, type_id);
    }

    public void save(CharacteristicsEntity CharacteristicsEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(CharacteristicsEntity);
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
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<CharacteristicsEntity> characteristicsEntities = (List<CharacteristicsEntity>) session.createQuery("From CharacteristicsEntity").list();
        session.close();
        return characteristicsEntities;
    }
}


