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

    private List<Product> data;

    private boolean bool = false;

    private boolean isDelete = false;

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public List<Product> getData() {
        return data;
    }

    public ProductTableModel(List<Product> data) {
        this.data = data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Product row = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                row.setID(Integer.parseInt(aValue.toString()));
                break;
            case 1:
                row.setName(aValue.toString());
                break;
            case 2:
                row.setPrice(Double.parseDouble(aValue.toString()));
                break;
            case 3:
                row.setIsDelete(Boolean.parseBoolean(aValue.toString()));
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
            default:
                return String.class;
        }
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
            case 3:
                return isDelete;
            default:
                return false;
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
            case 3:
                return "";
            default:
                return "Choise";
        }
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
                return row.isIsDelete();
            default:
                return "Choise";
        }

    }

}
