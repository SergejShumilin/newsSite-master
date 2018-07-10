package by.shumilin.example.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false";
    private static final String NAME = "root";
    private static final String PASSWORD_TO_DATA_BASE = "12345";



    private Connection connection;

    public Connection getConnection() {
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD_TO_DATA_BASE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

