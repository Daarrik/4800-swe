package Assignment5.q2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Order.class)
        .addAnnotatedClass(Product.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      Order order = session.get(Order.class, 1);
      session.delete(order);
      session.getTransaction().commit();
    } finally {
      session.close();
      factory.close();
    }

  }
}