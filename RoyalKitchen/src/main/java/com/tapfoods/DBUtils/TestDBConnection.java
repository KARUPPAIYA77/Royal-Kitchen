package com.tapfoods.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tapfood"; // Replace 'tapfood' with your database name
        String user = "root"; // Your MySQL username
        String password = "root"; // Your MySQL password

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                System.out.println("Database Connected Successfully!");
            } else {
                System.out.println("Database Connection Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
