package model.dataccess;

public class ConnectionFactory {

  private static ConnectionFactory instance;
  private ConnectionFactory() {}

  public static ConnectionFactory getInstance() {
    return instance = instance == null ? new ConnectionFactory() : instance;
  }

  public DatabaseConnection getConnection(String database) {
    if (database.equals("postgres")) {
      return PostgresConnection.getInstance();
    }
    return null;
  }

}