/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Suppliers;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cc.ks
 */
public class SupplierTableModel extends AbstractTableModel{
    List<Suppliers> list;
    String[] cols = {"CustomerID", "CompanyName","City","Phone","Email"};
    
     public SupplierTableModel() {
    }

    public SupplierTableModel(List<Suppliers> list) {
        this.list = list;
    }

    public void add(List<Suppliers> list) {
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
    
    public Suppliers getSupplier(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Suppliers c = getSupplier(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getSupplierID();
            case 1:
                return c.getCompanyName();
            case 2:
                return c.getCityID();
            case 3:
                return c.getPhone();
            case 4:
                return c.getEmail();
            default:
                return null;
        }
    }
}
