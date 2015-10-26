/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.controller;

import com.fpt.entity.Customer;
import com.fpt.entity.Product;
import com.fpt.model.CustomerModel;
import com.fpt.model.ProductModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anhph
 */
public class ProductController {
    ProductModel db = new ProductModel();
    public boolean addProductController(Product p){
        return db.addProduct(p);
    }
    public boolean updateProductController(Product p){
        return db.updateProduct(p);
    }
    public boolean deleteProductController(Product p){
        return db.deleteProduct(p);
    }
    public List<Product> list() throws ClassNotFoundException, SQLException{
        return db.listProduct();
    }
    
    // Customer
    CustomerModel cm = new CustomerModel();
    public boolean addCustomerController(Customer c) throws SQLException{
        return cm.addCustomer(c);
    }
}
