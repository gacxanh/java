/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.model;

import com.fpt.entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhph
 */
public class CustomerModel {
    private Connection con;
    DataConnect db = new DataConnect();
    
    public boolean addCustomer(Customer c) throws SQLException{
        try {
            con = db.Connect();
            String sqlQuery = "insert into Customer(name,tel,email) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, c.getName());
            pst.setString(2, c.getTel());
            pst.setString(3, c.getEmail());
            pst.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
