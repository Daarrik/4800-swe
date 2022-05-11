package Assignment5.q2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Order.class)
        .addAnnotatedClass(Product.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      Product product = new Product();
      session.save(product);
      session.getTransaction().commit();
    } finally {
      session.close();
      factory.close();
    }

  }
}