/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Shippers;
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

public class ShippersTableModel extends AbstractTableModel {

        List<Shippers> list;
    String[] cols = {"ShippersID", "CompanyName","Description","Email" };

    public ShippersTableModel() {
    }

    public ShippersTableModel(List<Shippers> list) {
        this.list = list;
    }

    public void add(List<Shippers> list) {
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

    public Shippers getShippers(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Shippers s = getShippers(rowIndex);
        switch (columnIndex) {
            case 0:
                return s.getShipperID();
            case 1:
                return s.getCompanyName();
            case 2:
                return s.getPhone();
            case 3:
                return s.getEmail();
           
            default:
                return null;
        }
    }

    
}

