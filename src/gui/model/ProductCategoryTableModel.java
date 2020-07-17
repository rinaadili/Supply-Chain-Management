/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.ProductCategory;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RA
 */

public class ProductCategoryTableModel extends AbstractTableModel {

        List<ProductCategory> list;
    String[] cols = {"ProductCategoryID", "ProductCategory Name","Description", };

    public ProductCategoryTableModel() {
    }

    public ProductCategoryTableModel(List<ProductCategory> list) {
        this.list = list;
    }

    public void add(List<ProductCategory> list) {
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

    public ProductCategory getProductCategory(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductCategory p = getProductCategory(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getCategoryID();
            case 1:
                return p.getCategoryName();
            case 2:
                return p.getDescription();
            default:
                return null;
        }
    }

    
}
