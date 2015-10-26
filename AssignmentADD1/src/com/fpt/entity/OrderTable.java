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
public class OrderTable extends AbstractTableModel {

    public OrderTable(List<Product> data) {
        this.data = data;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return true;
            default:
                return false;
        }
    }

    private boolean bool;

    public boolean isBool() {
        return bool;
    }

    private List<Product> data;

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 5; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product row = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return row.getID();
            case 1:
                return row.getName();
            case 2:
                return row.getPrice();
            case 3:
                return row.isBool();
            case 4:
                return row.getQts();
            default:
                return "Not Found";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Boolean.class;
            case 4:
                return Integer.class;
            default:
                return String.class;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Product row = data.get(rowIndex);
        switch (columnIndex){
            case 0:
                row.setID((int) aValue);
                break;
            case 1:
                row.setName((String) aValue);
                break;
            case 2:
                row.setPrice((double) aValue);
                break;
            case 3:
                row.setBool((boolean) aValue);
                break;
            case 4:
                row.setQts((int) aValue);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Price";
            case 3:
                return "Order";
            case 4:
                return "Qts";
            default:
                return "";
        }
    }

    
}
