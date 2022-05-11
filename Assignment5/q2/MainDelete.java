package Assignment5.q2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Professor.class)
        .addAnnotatedClass(Customer.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      String hql = "delete from customer where address=\"US\"";
      session.createQuery(hql).executeUpdate();
      session.getTransaction().commit();
    } finally {
      session.close();
      factory.close();
    }
  }
}