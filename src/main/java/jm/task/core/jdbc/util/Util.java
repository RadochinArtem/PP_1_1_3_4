package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    private static String URL = "jdbc:mysql://localhost:3306/PP";
    private static String USER = "root";
    private static String PASSWORD = "4778a0809a";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
