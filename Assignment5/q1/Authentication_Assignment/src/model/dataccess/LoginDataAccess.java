package Assignment5.q1.Authentication_Assignment.src.model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.business.LoginBusiness;
import model.dataccess.ConnectionFactory;

import model.entities.User;

public class LoginDataAccess {

	private static LoginDataAccess instance;
	private LoginDataAccess() {}

	public static LoginDataAccess getInstance() {
    return instance = instance == null ? new LoginDataAccess() : instance;
	}

	public boolean verifyCredentials() throws ClassNotFoundException,
			SQLException {
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance()
		DatabaseConnection conection = connectionFactory.getConnection("postgres");
		final PreparedStatement stmt = conection.getDatabaseConnection()
				.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
		stmt.setString(1, User.getInstance().getUserName());
		stmt.setString(2, User.getInstance().getPassword());
		ResultSet rs = stmt.executeQuery();
		return rs.next();
	}
}
