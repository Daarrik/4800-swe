package Assignment5.q1.Authentication_Assignment.src.model.business;

import java.sql.SQLException;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;

public class LoginBusiness {
  
  private static LoginBusiness instance;
  private String username;
  private String password;

  private LoginBusiness() {}

  public static LoginBusiness getInstance() {
    if (instance == null) {
      return new LoginBusiness();
    }
    return instance;
  }

  public boolean verifyCredentials() throws MessageException, ClassNotFoundException, SQLException {
    if (username.equals("")) {
      throw new MessageException("Username not informed.");
    } else if (password.equals("")) {
      throw new MessageException("Password not informed.");
    }
    return LoginDataAccess.getInstance().verifyCredentials();
  }

  /**
   * @return String return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * @return String return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

}