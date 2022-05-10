package q5;

public class AccountHolder {
  protected int ID;
  protected String address;

  public AccountHolder(int ID, String address) {
    this.ID = ID;
    this.address = address;
  }
  
  public static int getNextID() {
    int max = 1000000;
    int nextID = (int)(Math.random() * max + 1);
    return nextID;
  }
}