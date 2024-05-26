package com.projet.mini_projet.DAO;

import static com.projet.mini_projet.DAO.DBQuery.setPreparedStatement;
import static sun.jvm.hotspot.ci.ciObjectFactory.getMetadata;

import com.projet.mini_projet.modele.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.jvm.hotspot.debugger.Address;

public class ClientDAO {
    // Retrieve customer from DB with customerId
    public static Client getCustomer(int id_client) throws SQLException {

        Client customerResult;
            String sqlStatement = "SELECT * FROM client WHERE id_client = ?";
        PreparedStatement ps = setPreparedStatement(sqlStatement);
        ps.setInt(1, id_client);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while(rs.next()){
            String nom_cli = rs.getString("nom_cli");
            String prenom_cli = rs.getString("prenom_cli");
            String adresse_liv_cli = rs.getString("adresse_livraison");
            String adresse_fact_cli = rs.getString("adresse_facturation");
            customerResult = new Client(id_client, nom_cli, prenom_cli,adresse_liv_cli,adresse_fact_cli );
            return customerResult;
        }

        return null;
    }

/*
    // Retrieve customer from DB with customerName and addressId
    public static Client getCustomer(String customerName, int addressId) throws SQLException {

        Client customerResult;
        String sqlStatement = "SELECT * FROM customer WHERE LOWER(customerName) = LOWER(?) AND addressId = ?";
        PreparedStatement ps = setPreparedStatement(sqlStatement);
        ps.setString(1, customerName);
        ps.setInt(2, addressId);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while(rs.next()){
            int customerId = rs.getInt("customerId");
            Boolean active = rs.getBoolean("active");
            getMetadata(rs);
            customerResult = new Client(customerId, customerName, addressId, active, createDateLdt, createdBy, lastUpdateLdt, lastUpdateBy);
            return customerResult;
        }

        return null;
    }

    // Get a list of all active customers
    public static ObservableList<Client> getAllActiveCustomers() throws SQLException {
        ObservableList<Client> allCustomers=FXCollections.observableArrayList();

        String selectStatement="SELECT * FROM customer WHERE active = true ORDER by customerId";
        PreparedStatement ps = setPreparedStatement(selectStatement);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while(rs.next()){
            int customerId = rs.getInt("customerId");
            String customerName = rs.getString("customerName");
            int addressId = rs.getInt("addressId");
            Boolean active = rs.getBoolean("active");
            getMetadata(rs);
            Customer customerResult = new Customer(customerId, customerName, addressId, active, createDateLdt, createdBy, lastUpdateLdt, lastUpdateBy);
            customerResult.setAddressObj();
            allCustomers.add(customerResult);
        }

        return allCustomers;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="data setting">

    // Insert customer into DB
    public static Client insertCustomer(String customerName, int addressId) throws SQLException {

        String createStatement = "INSERT INTO customer (customerName, addressId, active, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = setPreparedStatement(createStatement);


        ps.setString(1, customerName);
        ps.setInt(2, addressId);
        ps.setBoolean(3, true);
        ps.setString(4, time);
        ps.setString(5, userName);
        ps.setString(6, time);
        ps.setString(7, userName);
        ps.execute();

        return getCustomer(customerName, addressId);
    }

    // Delete customer and linked appointments
    public static int deleteCustomer(int customerId) throws SQLException {
        String deleteStatement = "DELETE FROM appointment WHERE customerId = ?";
        PreparedStatement ps = setPreparedStatement(deleteStatement);

        ps.setInt(1, customerId);
        ps.execute();

        deleteStatement = "DELETE FROM customer WHERE customerId = ?";
        ps = setPreparedStatement(deleteStatement);
        ps.setInt(1, customerId);
        ps.execute();

        return ps.getUpdateCount();
    }

    // Update customer
    public static int updateCustomer(String customerName, int addressId, int customerId) throws SQLException {
        String updateStatement = "UPDATE customer SET customerName = ?, addressId = ? WHERE customerId = ?";
        PreparedStatement ps = setPreparedStatement(updateStatement);
        ps.setString(1, customerName);
        ps.setInt(2, addressId);
        ps.setInt(3, customerId);
        ps.execute();
        return ps.getUpdateCount();
    }*/

}
