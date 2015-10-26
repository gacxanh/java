/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpt.entity;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anhph
 */
public class ProductTableModel extends AbstractTableModel {

    private boolean bool = true;

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    private List<Product> data;

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public ProductTableModel(List<Product> data) {
        this.data = data;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return bool;
            case 2:
                return bool;
            default:
                return false;
        }
    }

    @Override
    public int getRowCount() {
        return data.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return (Integer) 3; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product row = data.get(rowIndex); //To change body of generated methods, choose Tools | Templates.
        switch (columnIndex) {
            case 0:
                return row.getID();
            case 1:
                return row.getName();
            case 2:
                return row.getPrice();
            default:
                return "Not Found";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Price";
            default:
                return "Not Found";
        }
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        super.setValueAt(o, i, i1); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
