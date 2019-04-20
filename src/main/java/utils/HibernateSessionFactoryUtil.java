package utils;


import sushchnost.CharacteristicsEntity;
import sushchnost.CustomersEntity;
import sushchnost.GoodsEntity;
import sushchnost.OrdersEntity;
import sushchnost.ProducerEntity;
import sushchnost.ReceiveTEntity;
import sushchnost.TotalOrdersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(CharacteristicsEntity.class);
                configuration.addAnnotatedClass(CustomersEntity.class);
                configuration.addAnnotatedClass(GoodsEntity.class);
                configuration.addAnnotatedClass(OrdersEntity.class);
                configuration.addAnnotatedClass(ProducerEntity.class);
                configuration.addAnnotatedClass(ReceiveTEntity.class);
                configuration.addAnnotatedClass(TotalOrdersEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение! " + e);
            }
        }
//        assertNotNull(sessionFactory);
        return sessionFactory;
    }
}