/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Products;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cc.ks
 */
public class ProductsSaleTableModel extends AbstractTableModel{
     List<Products> list;
    String[] cols = {"ProductID","Barcode","ProductName","Product Category","Unit Price"};
    
     public ProductsSaleTableModel() {
    }

    public ProductsSaleTableModel(List<Products> list) {
        this.list = list;
    }

    public void add(List<Products> list) {
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }
    
    public Products getProducts(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products c = getProducts(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getProductID();
            case 1:
                return c.getBarcode();
            case 2:
                return c.getProductName();
            case 3:
                return c.getCategoryID();
            case 4:
                return c.getSellPrice();
            default:
                return null;
        }
    }
}
