package Assignment5.q2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
  public static void main(String[] args) {
    SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Professor.class)
        .addAnnotatedClass(Customer.class)
        .buildSessionFactory();
    Session session = factory.getCurrentSession();
    try {
      session.beginTransaction();
      Customer customer = new Customer("Ruoqi Huang", "US");
      Professor professor = new Professor("1234", "3D Bioprinting");
      customer.setProfessor(professor);
      professor.setCustomer(customer);
      session.save(customer);
      session.save(professor);
      session.getTransaction().commit();
    } finally {
      session.close();
      factory.close();
    }
  }
}