package ch.ti8m.azubi.lod.pizzashop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Daniel Löffler
 * @since 27.02.2019
 * ConnectionFactory to connect to the DB
 */
public class ConnectionFactory {


    private static Connection createDBConnection() throws SQLException {
        return createDBConnection("localhost", 3306, "pizzashop", "root", "Danloe12");
    }

    public static Connection createDBConnection(String host, int port, String dbName, String user, String password) throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found");
        }
        String connectionURL = String.format("jdbc:mysql://%s:%d/%s?autoReconnect=true&useSSL=false", host, port, dbName);
        return DriverManager.getConnection(connectionURL, user, password);
    }

}
