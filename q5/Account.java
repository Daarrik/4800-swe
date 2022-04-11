package q5;

public class Account {
  private AccountHolder holder;
  private double balance;

  public Account(AccountHolder holder, double amt) {
    this.holder = holder;
    balance = amt;
  }

  public void deposit(double amt) {
    balance += amt;
  }

  public void withdraw(double amt) {
    balance -= amt;
  }

  public double getBalance() {
    return balance;
  }

  public AccountHolder getHolder() {
    return holder;
  }

  public void setBalance(double amt) {
    balance = amt;
  }

  public void setHolder(AccountHolder holder) {
    this.holder = holder;
  }
}
