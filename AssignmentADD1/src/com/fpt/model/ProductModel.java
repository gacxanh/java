/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.model;

import com.fpt.entity.Product;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhph
 */
public class ProductModel {
    private Connection con;
    DataConnect db = new DataConnect();
    List<Product> list = new ArrayList<>();
    
    public boolean addProduct(Product p){
        try {
            con = db.Connect();
            String sqlQuery = "insert into Product(name,price) values (?,?)";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, p.getName());
            pst.setDouble(2, p.getPrice());
            pst.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateProduct(Product p){
        try {
            con = db.Connect();
            String sqlQuery = "update Product set name = ?, price = ? where id = ?";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setString(1, p.getName());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getID());
            pst.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean deleteProduct(Product p){
        try {
            con = db.Connect();
            String sqlQuery = "delete Product where id = ?";
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            pst.setInt(1, p.getID());
            pst.executeUpdate();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public List<Product> listProduct() throws ClassNotFoundException, SQLException{
        con = db.Connect();
        String sqlQuery = "select * from Product";
        PreparedStatement pst = con.prepareStatement(sqlQuery);
        ResultSet rs = pst.executeQuery();
        list.clear();
        while(rs.next()){
            Product a = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            list.add(a);
        }
        return list;
    }
};

