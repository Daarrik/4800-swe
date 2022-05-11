package Assignment5.q2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "office_number")
  private String office_number;

  @Column(name = "research_area")
  private String research_area;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public Professor(String office_number, String research_area) {
    this.office_number = office_number;
    this.research_area = research_area;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOffice_number() {
    return office_number;
  }

  public void setOffice_number(String office_number) {
    this.office_number = office_number;
  }

  public String getResearch_area() {
    return research_area;
  }

  public void setResearch_area(String research_area) {
    this.research_area = research_area;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}