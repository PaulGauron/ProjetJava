package com.projet.mini_projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBQuery {
    private static PreparedStatement preparedStatement;

    // Create Prepared Statement Object
    public static PreparedStatement setPreparedStatement(String sqlStatement) throws SQLException {
        Connection connection = DBConnection.getConnection();
        preparedStatement = connection.prepareStatement(sqlStatement);
        return preparedStatement;
    }

    // Return Prepared Statement Object
    public static PreparedStatement getPreparedStatement(){
        return preparedStatement;
    }
}

