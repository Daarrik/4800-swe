package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnection implements DatabaseConnection {
  
  private static PostgresConnection instance;
  private PostgresConnection() {}

  public static PostgresConnection getInstance() {
    return instance = instance == null ? new PostgresConnection() : instance;
  }

  @Override
  public Connection getDatabaseConnection() {
    final String URL = "jdbc:postgresql://localhost:5432/authentication";
    final String USER = "postgres";
    final String PWD = "123";

    try {
      Class.forName("org.postgresql.Driver");
      return DriverManager.getConnection(URL, USER, PWD);
    } catch (Exception e) {
      return null;
    }
  }

}