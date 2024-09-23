package org.example.lk.ijse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnetion {
    private static DBconnetion dbConnection;
    private final static String URL = "jdbc:mysql://localhost:3306/hibernate_layerd";
    private final static Properties props =new Properties();
    private Connection connection;
    static {
        props.setProperty("user","root");
        props.setProperty("password","1234");
    }

    private DBconnetion() throws SQLException {
        connection = DriverManager.getConnection(URL,props);

    }
    public static DBconnetion getInstance() throws SQLException {
        return(dbConnection == null) ? dbConnection = new DBconnetion() :dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
