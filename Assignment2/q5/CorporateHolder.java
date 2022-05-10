package q5;

public class CorporateHolder extends AccountHolder{
  private String contact;

  public CorporateHolder(int ID, String address, String contact) {
    super(ID, address);
    this.contact = contact;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
}
