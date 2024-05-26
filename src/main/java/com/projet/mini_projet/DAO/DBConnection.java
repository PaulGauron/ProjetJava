package com.projet.mini_projet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/mini_projet";
        private static final String USER = "root";
        private static final String PASSWORD = "";

    // Driver and Connection Interface Reference
    private static final String MYSQLJDBCDriver = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());

    public static Connection startConnection(){

        try{
            Class.forName(MYSQLJDBCDriver);
            connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            Logger.getLogger("errorlog.txt").log(Level.SEVERE, e.getMessage());
            logger.log(Level.SEVERE, "Error establishing connection: " + e.getMessage(), e);
        }

        return connection;

    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection(){

        try{
            connection.close();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

}



