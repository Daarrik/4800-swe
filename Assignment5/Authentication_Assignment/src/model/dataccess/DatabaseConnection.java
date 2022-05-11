package model.dataccess;
import java.sql.Connection;

public interface DatabaseConnection {
    Connection getDatabaseConnection();
}